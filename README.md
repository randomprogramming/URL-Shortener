# Getting Started

Very simple program for shortening URL's using Spring Boot.

The URL has to exist for it to be shortened, see "test pages" in UrlController.java to see examples

# How it works

pic 1

Whenever we make a PUSH request to /shorten with a body, the link in the body will get shortened, and we will receive a response with the shortened URL.

pic 2

We can now use the generated short URL in our browser to access the page with the long URL.

pic3

Upon pressing Enter, we get redirected to the long url page, which we shortened.
