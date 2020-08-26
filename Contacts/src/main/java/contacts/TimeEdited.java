package contacts;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class TimeEdited {
    private LocalDateTime timeEdited;

    TimeEdited() {
        timeEdited = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public LocalDateTime getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(LocalDateTime timeEdited) {
        this.timeEdited = timeEdited;
    }

    @Override
    public String toString() {
        return timeEdited.toString();
    }
}