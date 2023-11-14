package org.campus02.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        System.out.println("ec.getByPrice(5, 20) = " + ec.getByPrice(5, 20));

        System.out.println("ec.getMostExpensive() = " + ec.getMostExpensive());
        System.out.println("ec.getMostExpensive() = " + ec.getMostExpensive2("Wien"));


        System.out.println("ec.getAvgPriceByCity(\"Graz\") = " + ec.getAvgPriceByCity("Graz"));
        System.out.println("ec.getAvgPriceByCity(\"Wien\") = " + ec.getAvgPriceByCity("Wien"));
        System.out.println("ec.getAvgPriceByCity2(\"Graz\") = " + ec.getAvgPriceByCity2("Graz"));

        ec.add(new Event("Grazer Weihnachtsmarkt", "Graz-Hauptplatz", 0));

        System.out.println("ec.getCountOfEventsPerCity() = " + ec.getCountOfEventsPerCity());

        HashMap<String, Integer> map = ec.getCountOfEventsPerCity();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
