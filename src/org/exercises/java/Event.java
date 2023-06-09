package org.exercises.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event  implements Comparable<Event>{
    //ATTRIBUTES
    private String title;
    private LocalDate date;
    private final int totalPlaces;
    private int reservedPlaces;

    //CONSTRUCTOR
    public Event(String title, LocalDate date, int totalPlaces) throws EventException {

        //gestitsco l'eccezione in cui la data inserita è anteriore alla data di oggi
        if (beforeToday(date)){
            throw new EventException("The date cannot be earlier than the current date");
        }

        //gestisco l'eccezione nel caso in cui venga inserito un numero negativo o uguale a zero per il totale dei posti
        if(totalPlaces <= 0){
            throw new EventException("Total seats must be greater than 0");
        }

        this.title = title;
        this.date = date;
        this.totalPlaces = totalPlaces;
        reservedPlaces = 0;
    }

    //GETTER AND SETTER
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFormatDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public void setDate(LocalDate date) {
        if (beforeToday(date)){
            throw new EventException("The date cannot be earlier than the current date");
        }
        this.date = date;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public int getReservedPlaces() {
        return reservedPlaces;
    }

    //METHODS
    public boolean beforeToday(LocalDate date){
        LocalDate today = LocalDate.now();
        return date.isBefore(today);
    }



    public void reserve() throws EventException{
        if (beforeToday(date)){
            throw new EventException("the event is not avaiable");
        }else if(reservedPlaces < totalPlaces){
            reservedPlaces++;
        } else {
            throw new EventException("the places are finished");
        }

    }

    public void cancelReservation() throws EventException{
        if(beforeToday(date)){
            throw new EventException("You can't cancel your booking for a past event");
        }else if(reservedPlaces == 0){
            throw new EventException("there are no reservations");
        }
        reservedPlaces--;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", date=" + getFormatDate() +
                ", totalPlaces=" + totalPlaces +
                ", reservedPlaces=" + reservedPlaces +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (getTotalPlaces() != event.getTotalPlaces()) return false;
        if (getReservedPlaces() != event.getReservedPlaces()) return false;
        if (getTitle() != null ? !getTitle().equals(event.getTitle()) : event.getTitle() != null) return false;
        return getDate().equals(event.getDate());
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getTotalPlaces();
        result = 31 * result + getReservedPlaces();
        return result;
    }

    @Override
    public int compareTo(Event o) {
        return getDate().compareTo(o.getDate());
    }
}
