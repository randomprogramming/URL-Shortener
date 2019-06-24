package com.randomprogramming.url_shortener.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlShort {

    private static int counter = 0;
    @Id
    private String longUrl;
    private String shortUrl;

    public UrlShort(){

    }

    public UrlShort(String longUrl){
        this.longUrl = longUrl;
        this.shortUrl = shorten(longUrl);
    }

    //This is where the url is actually shortened, it currently only uses a simple counter,
    //but it can be easily changed if needed later
    private String shorten(String longUrl){
        return "short" + counter;
    }

    public static void incrementCounter(){
        counter++;
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
