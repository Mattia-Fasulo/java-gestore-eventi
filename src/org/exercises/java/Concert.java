package org.exercises.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert  extends Event{
    //ATTRIBUTES
    private LocalTime time;
    private BigDecimal price;

    //CONSTRUCTOR
    public Concert(String title, LocalDate date, int totalPlaces, LocalTime time, BigDecimal price) {
        super(title, date, totalPlaces);
        this.time = time;
        this.price = price;
    }

    //GETTER AND SETTER
    public LocalTime getTime() {
        return time;
    }

    public String getFormatTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return dtf.format(time);
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFormatPrice(){
        DecimalFormat df = new DecimalFormat("#.00 €");
        return df.format(price);
    }

    //METHODS


    @Override
    public String toString() {
        return "{title: " + super.getTitle() + ", date: " + getFormatDate() + ", schedule: " + getFormatTime() + "}";
    }
}
