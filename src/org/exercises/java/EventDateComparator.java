package org.exercises.java;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;

public class EventDateComparator  implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        return ChronoLocalDate.timeLineOrder().compare(o1.getDate(),o2.getDate());
    }
}
