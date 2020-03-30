# Simple Book Store Web App

This project is a simple Book Store Web App.

You can:
* List all available Books
* See details of a specific Book

Technically, this is done with:
* Jetty Embedded Server
* Jersey framework to provide the two REST end points
* Jackson for JSON handling
* Two html pages with javascript(JQuery) for the UI

## Installation and Use
You need to have installed:
- A Java JVM, 8 or more.

Run:
```
./gradlew build run
```
This will download gradle if not present and build the sources.
(gradle.bat if you are on windows)

In your browser, access:
```
http://localhost:8080
```

## References
- https://www.eclipse.org/jetty/documentation/current/
- https://eclipse-ee4j.github.io/jersey/
