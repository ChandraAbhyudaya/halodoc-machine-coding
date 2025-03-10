package dto;

public class Subscriber {
    private final String name;

    public Subscriber(String name){
        this.name = name;
    }
    public void notify(LogEntry logEntry, CommunicationMode communicationMode){
        System.out.println("Notifying " + name + " of " + logEntry.getType() + " of " + communicationMode);
    }
}
