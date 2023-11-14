package org.campus02.events;

public class Event {
    private String title;
    private String city;
    private double price;

    public Event(String title, String city, double price) {
        this.title = title;
        this.city = city;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            System.out.println("price needs to be greater than 0!");
    }

    public String toString() {
        String result =  "Event {" +
                "title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                '}';

        return result;
    }
}
