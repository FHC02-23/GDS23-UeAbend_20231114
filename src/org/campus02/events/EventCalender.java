package org.campus02.events;

import java.util.ArrayList;

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
}
