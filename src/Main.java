import dto.LogEntry;
import dto.LogType;
import dto.NotificationConfig;
import dto.Subscriber;
import service.LogMonitoringService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LogMonitoringService monitoringService = new LogMonitoringService();


        Subscriber user1 = new Subscriber("sha");
        Subscriber user2 = new Subscriber("ahs");

        monitoringService.addSubscriber(LogType.CRITICAL, user1);
        monitoringService.addSubscriber(LogType.CRITICAL, user2);
        monitoringService.addSubscriber(LogType.WARNING, user1);
        monitoringService.addSubscriber(LogType.WARNING, user2);


        NotificationConfig criticalConfig = new NotificationConfig(LogType.CRITICAL, 3, 10000, 5000);
        NotificationConfig warningConfig = new NotificationConfig(LogType.WARNING, 3, 10000, 5000);
        monitoringService.setNotificationConfig(criticalConfig);
        monitoringService.setNotificationConfig(warningConfig);


        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));


        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));


        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));


        monitoringService.addLogEntry(new LogEntry(LogType.WARNING, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.WARNING, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.WARNING, System.currentTimeMillis() + 5000, "Critical Data"));

        Thread.sleep(10000);

        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis(), "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 2000, "Critical Data"));
        monitoringService.addLogEntry(new LogEntry(LogType.CRITICAL, System.currentTimeMillis() + 5000, "Critical Data"));


        try{
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitoringService.shutdown();


    }
}

/*

 */