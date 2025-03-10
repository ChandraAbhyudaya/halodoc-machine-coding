package dto;

import java.util.Set;

public class NotificationConfig {
    private LogType logType;
    private long frequency;
    private long durationSeconds;
    private long waitTimeSeconds;
    private Set<CommunicationMode> communicationModes;

    public NotificationConfig(LogType logType, long frequency, long durationSeconds, long waitTimeSeconds){
        this.logType = logType;
        this.frequency = frequency;
        this.durationSeconds = durationSeconds;
        this.waitTimeSeconds = waitTimeSeconds;
    }

    public LogType getLogType() {
        return logType;
    }

    public long getFrequency() {
        return frequency;
    }

    public long getDurationSeconds() {
        return durationSeconds;
    }

    public long getWaitTimeSeconds() {
        return waitTimeSeconds;
    }

    public Set<CommunicationMode> getCommunicationModes() {
        return Set.of(CommunicationMode.PHONE, CommunicationMode.SMS, CommunicationMode.EMAIL);
    }
}
