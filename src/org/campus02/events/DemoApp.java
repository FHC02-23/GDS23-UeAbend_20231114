package org.campus02.events;

import java.util.ArrayList;

public class DemoApp {

    public static void main(String[] args) {
        
        Event event = new Event("Weihnachtskonzert", "Graz", 19.0);
        
        System.out.println("event.toString() = " + event.toString());
        System.out.println("event.toString() = " + event);


        EventCalender ec = new EventCalender();
        ec.add(event);
        
        Event event1 = new Event("Laternenfest", "Wien", 9.0);
        ec.add(event1);
        
        ec.add(new Event("Bundesligaspiel Sturm - Salzburg", "Graz", 59.0));
        ec.add(new Event("Konzert xyz", "Graz", 99.9));

        System.out.println("ec.getByTitle(\"Konzert xyz\") = " + ec.getByTitle("Konzert xyz"));
        System.out.println("ec.getByTitle(\"Christmas Concert\") = " + ec.getByTitle("Christmas Concert"));

        ArrayList<Event> filteredEventsInGraz = ec.getByCity("Graz");
        System.out.println("filteredEventsInGraz = " + filteredEventsInGraz);

        System.out.println("ec.getByCity(\"Wien\") = " + ec.getByCity("Wien"));
        System.out.println("ec.getByCity(\"Klagenfurt\") = " + ec.getByCity("Klagenfurt"));
    }
}
