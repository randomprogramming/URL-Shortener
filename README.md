# Getting Started

Very simple program for shortening URL's using Spring Boot.

The URL has to exist for it to be shortened, see "test pages" in UrlController.java to see examples

# How it works

![PIC1](https://user-images.githubusercontent.com/48063901/60012879-5739e080-967d-11e9-8ece-87d5e8a67109.PNG)

Whenever we make a PUSH request to /shorten with a body, the link in the body will get shortened, and we will receive a response with the shortened URL.

![PIC2](https://user-images.githubusercontent.com/48063901/60012877-56a14a00-967d-11e9-90af-c4c233135bb6.PNG)

We can now use the generated short URL in our browser to access the page with the long URL.

![PIC33](https://user-images.githubusercontent.com/48063901/60012878-56a14a00-967d-11e9-9f1d-90f700d6748b.PNG)

Upon pressing Enter, we get redirected to the long url page, which we shortened.
