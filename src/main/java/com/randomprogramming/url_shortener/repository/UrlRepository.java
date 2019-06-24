package com.randomprogramming.url_shortener.repository;

import com.randomprogramming.url_shortener.entity.UrlShort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UrlRepository extends CrudRepository<UrlShort, String> {
    List<UrlShort> findByShortUrl(String shortUrl);
}
