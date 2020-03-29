# Simple Book Store Web App

This project is a simple Book Store Web App.

You can:
* List all available Books
* See details of a specific Book

Technically, this done with:
* Jetty Embedded Server
* Jersey framework to provide the two REST end points
* Jackson for JSON handling
* Two html pages with javascript(JQuery) for the UI

## To run the application
You need to have installed:
- A Java JVM

And run:
- ./gradlew build run
(gradle.bat if you are on windows)

And in your browser access:

```
http://localhost:8080
```

## Installation
The build.gradle has been adapted so if you run execute below command, the jar will be installed in your local maven repository, so you can later on add it as dependency to your projects.

`gradle test install`

## Tests
Spock and Groovy have been used for the tests, please expect some tests to fail if you don't provide your 1Forge API key(test/groovy/resources/config.properties)

## References
https://www.eclipse.org/jetty/documentation/current/
https://eclipse-ee4j.github.io/jersey/