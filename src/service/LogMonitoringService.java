package service;

import dto.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LogMonitoringService {
    private final int NUMBER_OF_THREADS = 4;
    private final Map<LogType, List<Subscriber>> subscriberMap = new HashMap<>();
    private final Map<LogType, NotificationConfig> configMap = new HashMap<>();
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
    private final Map<LogType, List<LogEntry>> logBuffer = new ConcurrentHashMap<>();
    private final Map<LogType, AtomicBoolean> notificationLock = new ConcurrentHashMap<>();

    public LogMonitoringService(){
        for (LogType type: LogType.values()){
            logBuffer.put(type, new ArrayList<>());
            notificationLock.put(type, new AtomicBoolean(false));
        }
    }
    public void addSubscriber(LogType logType, Subscriber subscriber){
        subscriberMap.computeIfAbsent(logType, k -> new ArrayList<>()).add(subscriber);
    }

    public void setNotificationConfig(NotificationConfig config){
        configMap.put(config.getLogType(), config);
    }

    public void addLogEntry(LogEntry entry){
        List<LogEntry> entries = logBuffer.get(entry.getType());
        synchronized (entries){
            entries.add(entry);
        }
        checkAndNotify(entry.getType());
    }

    private void checkAndNotify(LogType type){
        NotificationConfig config = configMap.get(type);
        if(isNull(config) || notificationLock.get(type).get()) return;

        List<LogEntry> entries = logBuffer.get(type);
        synchronized (entries){
            long now = System.currentTimeMillis();
            entries.removeIf(entry -> (now - entry.getTimeStamp()) > config.getDurationSeconds());

            if(entries.size() >= config.getFrequency()){
                notificationLock.get(type).set(true);
                List<Subscriber> subscribers = subscriberMap.get(type);

                if (nonNull(subscribers)){
                    for (Subscriber subscriber : subscribers){
                        for(CommunicationMode mode : config.getCommunicationModes()){

                            executorService.submit(() -> subscriber.notify(entries.get(entries.size() - 1), mode));
                        }
                    }
                }
                executorService.schedule(() -> notificationLock.get(type).set(false), config.getWaitTimeSeconds(), TimeUnit.MILLISECONDS);
                entries.clear();
            }
        }
    }
    public void shutdown(){
        executorService.shutdown();
    }

}
