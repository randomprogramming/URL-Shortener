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
        if(!urlRepository.existsByLongUrl(longUrl)){
            UrlShort url = new UrlShort(longUrl);
            url.shortenUrl();
            //keep generating new URL until we find one that is not taken
            //not a good long term solution
            while(urlRepository.existsByShortUrl(url.getShortUrl())){
                url.shortenUrl();
            }
            urlRepository.save(url);
            return true;
        }
        return false;
    }

    public UrlShort findByShortUrl(String shortUrl){
        if (urlRepository.existsByShortUrl(shortUrl)){
            return urlRepository.findFirstByShortUrl(shortUrl);
        }
        return null;
    }

    public UrlShort findByLongUrl(String longUrl){
        return urlRepository.existsByLongUrl(longUrl) ? urlRepository.findFirstByLongUrl(longUrl) : null;
    }
}
