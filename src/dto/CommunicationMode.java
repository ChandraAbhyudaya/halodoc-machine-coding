package dto;

import java.util.EnumSet;
import java.util.Set;

public enum CommunicationMode {
    SMS(EnumSet.of(LogType.INFO, LogType.CRITICAL)),
    PHONE(EnumSet.of(LogType.CRITICAL)),
    EMAIL(EnumSet.of(LogType.CRITICAL));

    private final Set<LogType> applicableEvents;
    CommunicationMode(Set<LogType> applicableEvents){
        this.applicableEvents = applicableEvents;
    }

    public boolean isApplicable(LogType logType){
        return applicableEvents.contains(logType);
    }
}
