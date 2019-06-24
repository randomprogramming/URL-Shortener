package com.randomprogramming.url_shortener.repository;

import com.randomprogramming.url_shortener.entity.UrlShort;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<UrlShort, String> {
    UrlShort findFirstByShortUrl(String shortUrl);

    UrlShort findFirstByLongUrl(String longUrl);

    boolean existsByLongUrl(String longUrl);

    boolean existsByShortUrl(String shortUrl);
}
