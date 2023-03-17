package org.exercises.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LIstEvent {
    //ATTRIBUTES
    private String title;
    private List<Event> listEvent;

    //CONSTRUCTOR
    public LIstEvent(String title, List<Event> listEvent) {
        this.title = title;
        this.listEvent = listEvent;
    }

    //GETTER AND SETTER
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Event> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<Event> listEvent) {
        this.listEvent = listEvent;
    }

    //METHODS
    public void addEvent(Event event){
        listEvent.add(event);
    }

    public List<Event> listByDate(LocalDate date){
        List<Event> listByDate = new ArrayList<>();
        for (Event event : listEvent){
            if(event.getDate() == date){
                listByDate.add(event);
            }
        }
        return  listByDate;
    }

    public int countEvent(){
        int count = 0;
        for (Event event : listEvent){
            count++;
        }
        return count;
    }

    public void removeAllEvent(){

        while(listEvent.size() > 0){
            listEvent.remove(0);
        }

    }


}
