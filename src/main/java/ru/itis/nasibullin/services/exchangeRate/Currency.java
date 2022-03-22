package ru.itis.nasibullin.services.exchangeRate;

public class Currency {
    private String from;
    private String to;
    private double count;
    private double price;

    public Currency() {
    }

    public Currency(String from, String to, double count, double price) {
        this.from = from;
        this.to = to;
        this.count = count;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
