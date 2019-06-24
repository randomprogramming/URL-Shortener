package com.randomprogramming.url_shortener.service;

import com.randomprogramming.url_shortener.entity.UrlShort;
import com.randomprogramming.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public List<UrlShort> getAll() {
        List<UrlShort> all = new ArrayList<>();
        urlRepository.findAll().forEach(all::add);
        return all;
    }

    //If not already in database, shorten the url
    public boolean shortenUrl(String longUrl){
        if(!urlRepository.existsById(longUrl)){
            UrlShort url = new UrlShort(longUrl);
            urlRepository.save(url);
            UrlShort.incrementCounter();
            return true;
        }
        return false;
    }

    public UrlShort findByShortUrl(String shortUrl){
        List<UrlShort> url = urlRepository.findByShortUrl(shortUrl);

        if(!url.isEmpty()){
            return url.get(0);
        }
        else{
            return null;
        }
    }

    public UrlShort findByLongUrl(String longUrl){
        return urlRepository.existsById(longUrl) ? urlRepository.findById(longUrl).get() : null;
    }
}
