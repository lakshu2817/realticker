package real_ticker.analysis.model;

import java.util.List;

public class Stock {
    private String ticker;
    private String company;
    private double price;
    private double changePercent;
    private long volume;
    private List<Double> history;

    public Stock() {}

    public Stock(String ticker, String company, double price, double changePercent, long volume, List<Double> history) {
        this.ticker = ticker;
        this.company = company;
        this.price = price;
        this.changePercent = changePercent;
        this.volume = volume;
        this.history = history;
    }


    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Double> getHistory() {
        return history;
    }

    public void setHistory(List<Double> history) {
        this.history = history;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

}