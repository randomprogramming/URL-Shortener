package com.randomprogramming.url_shortener.controller;

import com.randomprogramming.url_shortener.entity.UrlShort;
import com.randomprogramming.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/getall")
    public List<UrlShort> getAll(){
        return urlService.getAll();
    }

    //When a user enters a shortened url, redirect them to the long one
    @GetMapping("/{shortUrl}")
    public ModelAndView redirect(@PathVariable String shortUrl, ModelMap model){
        UrlShort url = urlService.findByShortUrl(shortUrl);
        if(url != null){
            return new ModelAndView("redirect:/" + url.getLongUrl(), model);
        }
        else{
            return new ModelAndView("redirect:/notFound", model);
        }
    }

    //When a user makes a shorten request with a body that contains a link
    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String longUrl){
        if(urlService.shortenUrl(longUrl)){
            return "Url shortened to: " + urlService.findByLongUrl(longUrl).getShortUrl();
        }
        return "Url already exists in database";
    }

    @GetMapping("/notFound")
    public String notFound(){
        return "That link wasn't found!";
    }

    //test pages
    @GetMapping("/thisisaverylonglinkpage")
    public String testPage(){
        return "Long link page";
    }
    @GetMapping("/thisisanotherverylonglinkpage")
    public String testPage2(){
        return "Another long link page";
    }
    @GetMapping("/thisisyetanotherverylonglinkpage")
    public String testPage3(){
        return "Yet another long link page";
    }
}
