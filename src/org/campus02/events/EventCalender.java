package org.campus02.events;

import java.util.ArrayList;
import java.util.HashMap;

public class EventCalender {

    private ArrayList<Event> events = new ArrayList<>();

    public EventCalender() {
    }

    public void add(Event e) {
        events.add(e);
    }

    public Event getByTitle(String title) {
        for (int i = 0; i < events.size(); i++) {

            Event e = events.get(i);
            if (e.getTitle().equalsIgnoreCase(title)) {
                return e; // return, verlässt die Methode an dieser Stelle
            }
        }
        // ooops, jetzt haben wir nichts gefunden
        return null;
    }

    public Event getByTitle1(String title) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getTitle().equalsIgnoreCase(title)) {
                return events.get(i); // return, verlässt die Methode an dieser Stelle
            }
        }
        // ooops, jetzt haben wir nichts gefunden
        return null;
    }

    public Event getByTitle2(String title) {
        for (Event e: events ) { // for Event e in events
            if (e.getTitle().equalsIgnoreCase(title))
                return e;
        }
        return null;
    }

    public Event getByTitle3(String title) {
        Event temp = null;
        for (Event e: events ) { // for Event e in events
            if (e.getTitle().equalsIgnoreCase(title)) {
                temp = e;
                break; // bricht die for-Schleife ab
            }
        }
        return temp;
    }

    public ArrayList<Event> getByCity(String city) {

        ArrayList<Event> result = new ArrayList<>();

        for (Event e : events) {
            if (e.getCity().equals(city)) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<Event> getByPrice(double min, double max) {
        ArrayList<Event> result = new ArrayList<>();

        for (Event e : events) {

            if (e.getPrice() >= min && e.getPrice() <= max) {
                result.add(e);
            }
        }
        return result;
    }

    public Event getMostExpensive() {
        double mostExpensivePrice = Double.MIN_VALUE;

        for (Event e: events) {
            if (e.getPrice() > mostExpensivePrice) {
                mostExpensivePrice = e.getPrice();
            }
        }
        // haben wir höchsten Preis gefunden
        for (Event e : events) {
            if (e.getPrice() == mostExpensivePrice)
                return e;
        }
        return null;
    }

    public Event getMostExpensive2() {
        if (events.size() == 0) // wenn in Event-Liste nichts enthalten, dann null retournieren
            return null;

        Event mostExpensiveEvent = events.get(0);

        // haben wir höchsten Preis gefunden
        for (Event e : events) {
            if (e.getPrice() > mostExpensiveEvent.getPrice())
                mostExpensiveEvent = e;
        }
        return mostExpensiveEvent;
    }

    public Event getMostExpensive(String city) {
        double mostExpensivePrice = Double.MIN_VALUE;

        ArrayList<Event> eventsFiltered = getByCity(city);

        for (Event e: eventsFiltered) {
            if (e.getPrice() > mostExpensivePrice) {
                mostExpensivePrice = e.getPrice();
            }
        }
        // haben wir höchsten Preis gefunden
        for (Event e : eventsFiltered) {
            if (e.getPrice() == mostExpensivePrice)
                return e;
        }
        return null;
    }

    public Event getMostExpensive2(String city) {
        double mostExpensivePrice = Double.MIN_VALUE;

        for (Event e: events) {
            if (e.getCity().equals(city) && e.getPrice() > mostExpensivePrice) {
                mostExpensivePrice = e.getPrice();
            }
        }
        // haben wir höchsten Preis gefunden
        for (Event e : events) {
            if (e.getCity().equals(city) && e.getPrice() == mostExpensivePrice)
                return e;
        }
        return null;
    }

    public double getAvgPriceByCity(String city) {
        double sum = 0;

        ArrayList<Event> liste = getByCity(city);
        for (Event e : liste) {
            sum = sum + e.getPrice();
        }

        double average = sum / (liste.size() * 1.0);
        return average;
    }

    public double getAvgPriceByCity2(String city) {
        double sum = 0;
        int counter =0;

        for (Event e : events) {
            if (e.getCity().equals(city))
            {
                sum = sum + e.getPrice();
                counter++;
            }
        }

        double average = sum / (counter * 1.0);
        return average;
    }

    public HashMap<String, Integer> getCountOfEventsPerCity() {
        // key .... city
        // value ... Anzahl der Events je City
        /*
            Graz: 3
            Wien: 1
         */

        /*
            - Map als Hilfswert anlegen
            - Ausgangsliste durchgehen
            - je Element
                => ist der Key in der Map vorhanden?
                    wenn ja: Wert (Value) aus Map auslesen, verändern, wieder ablegen
                    wenn nein: Key+Startwert ablegen
         */
        HashMap<String, Integer> result = new HashMap<>();
        for (Event e : events) {

            if (result.containsKey(e.getCity())) {
                // wenn ja: Wert (Value) aus Map auslesen, verändern, wieder ablegen
                int value = result.get(e.getCity());
                value++;
                result.put(e.getCity(), value); // put überschreibt immer!
            }
            else {
                // wenn nein: Key+Startwert ablegen
                result.put(e.getCity(), 1);
            }
        }
        return result;
    }

}
