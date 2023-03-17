package org.exercises.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Event event = new Event("Opera", LocalDate.of(2023,3,22),200);
        System.out.println(event);
    }
}
