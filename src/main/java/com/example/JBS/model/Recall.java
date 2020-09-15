package com.example.JBS.model;

public class Recall {

    private String brand;
    private String company;
    private String reason;
    private String pd;
    private String url;
    private String date;

    public Recall(String brand, String company, String reason, String pd, String url, String date) {
        this.brand = brand;
        this.company = company;
        this.reason = reason;
        this.pd = pd;
        this.url = url;
        this.date = date;
    }

    public Recall() {

    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getPd() {
        return pd;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
