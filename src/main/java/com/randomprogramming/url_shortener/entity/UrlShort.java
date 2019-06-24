package com.randomprogramming.url_shortener.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class UrlShort {

    @Id @GeneratedValue private int counter;
    private String longUrl;
    private String shortUrl;

    private Random rand = new Random();

    public UrlShort(){

    }

    public UrlShort(String longUrl){
        this.longUrl = longUrl;
    }

    //This is where the url is actually shortened, it currently only uses a simple counter,
    //but it can be easily changed if needed later
    public void shortenUrl(){
        this.shortUrl = "short" + rand.nextInt(100);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
