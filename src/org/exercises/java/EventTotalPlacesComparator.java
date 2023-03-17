package org.exercises.java;

import java.util.Comparator;

public class EventTotalPlacesComparator implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        return Integer.compare(o1.getTotalPlaces(), o2.getTotalPlaces());
    }
}
