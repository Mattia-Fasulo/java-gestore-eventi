package org.exercises.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Event event = null;
        try {
            event = new Event("Opera", LocalDate.of(2023,3,22),-200);
            System.out.println(event);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
