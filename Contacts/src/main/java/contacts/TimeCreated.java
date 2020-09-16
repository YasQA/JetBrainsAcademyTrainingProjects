package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class TimeCreated implements Serializable {
    private final LocalDateTime timeCreated;

    TimeCreated() {
        timeCreated = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    @Override
    public String toString() {
        return timeCreated.toString();
    }
}