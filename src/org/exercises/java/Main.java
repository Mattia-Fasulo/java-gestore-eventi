package org.exercises.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        System.out.println();
        System.out.println("******************************************");
        System.out.println("     Welcome to your event handler");
        System.out.println("******************************************\n");

        System.out.println("Want to create an event? (y/n)");
        boolean start = false;
        start = scan.nextLine().equalsIgnoreCase("y");

        System.out.println();

        if(start){
            Event event = null;
            String name;
            LocalDate date;
            int totalPlaces;

            System.out.print("Event name: ");
            name = scan.nextLine();

            System.out.println();

            int day;
            int month;
            int year;
            System.out.println("Date of the event");
            System.out.print("day: ");
            day = Integer.parseInt(scan.nextLine());
            System.out.print("month: ");
            month = Integer.parseInt(scan.nextLine());
            System.out.print("year: ");
            year = Integer.parseInt(scan.nextLine());

            date = LocalDate.of(year,month,day);

            System.out.println();

            System.out.print("Total seats of the event: ");
            totalPlaces = Integer.parseInt(scan.nextLine());

            System.out.println();


            try {
                event = new Event(name, date, totalPlaces);
                System.out.println(event);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println();

            boolean play = true;
            int count = 0;

            while (play) {


                System.out.println("Select an option? (1-new reservation / 2-Cancel reservation / 3-Exit");
                String option = scan.nextLine();

                System.out.println();

                switch (option){
                    case "1":
                        int numReservation;


                        System.out.print("how many reservations do you want to make? ");
                        numReservation = Integer.parseInt(scan.nextLine());


                        for (int i = 0; i < numReservation; i++){

                            try{
                                if (event != null){
                                    event.reserve();
                                    count++;
                                }

                            } catch (EventException e) {
                                System.out.println();
                                System.out.println(e.getMessage());
                                if (event.getReservedPlaces() == event.getTotalPlaces()){
                                    System.out.println();
                                    if(i > 1){
                                        boolean choice;
                                        System.out.println("you have booked " + i + " places");
                                        System.out.println("do you want to cancel these reservations? (y/n)");
                                        choice = scan.nextLine().equalsIgnoreCase("y");

                                        System.out.println();

                                        if(choice){
                                            for (int x = 0; x < i; x++){
                                                event.cancelReservation();
                                                count--;
                                            }
                                            System.out.println("cancelled reservations");


                                        } else {
                                            System.out.println("you have booked " + i + " places");
                                            System.out.println();
                                        }
                                    }
                                }
                            }



                        }

                        System.out.println();

                        System.out.println("you have booked " + count + " places");

                        if(event != null){
                            System.out.println("remain: " + (event.getTotalPlaces() - event.getReservedPlaces()) + " places");
                        }

                        System.out.println();

                        break;

                    case "2":
                        int numCancellations;
                        int numDelete = 0;

                        System.out.print("how many reservations do you want to cancel? ");
                        numReservation = Integer.parseInt(scan.nextLine());

                        for (int i = 0; i < numReservation; i++){


                            try{
                                if (event != null){
                                    event.cancelReservation();
                                    count--;
                                    numDelete++;
                                }
                            } catch (EventException e){
                                System.out.println();
                                System.out.println("yuo have cancelled " + numDelete + " reservation");
                                System.out.println();
                                System.out.println(e.getMessage());
                                break;
                            }

                        }

                        System.out.println();

                        System.out.println("you have booked " + count + " places");

                        if(event != null){
                            System.out.println("remain: " + (event.getTotalPlaces() - event.getReservedPlaces()) + " places");
                        }

                        System.out.println();

                        break;
                    case "3":
                        System.out.println("bye");
                        play = false;

                }
            }

        } else {
            System.out.println("Bye");
        }







    scan.close();
    }
}
