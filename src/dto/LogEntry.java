package dto;

public class LogEntry {
    private LogType type;
    private long timeStamp;
    private String data;

    public LogEntry(LogType type, long timeStamp, String data){
        this.type = type;
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public LogType getType(){
        return type;
    }

    public long getTimeStamp(){
        return timeStamp;
    }
}
