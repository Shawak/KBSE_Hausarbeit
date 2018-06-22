## Docker

#### Chrome Problem

Because chrome does not allow saving cookies to http://localhost and java EE not changing the cookie's path, be sure to use http://127.0.0.1 instead or you won't be able to login!

Alternativly you can also pass the jsessionid after the url like `http://localhost[/..];jsessionid=<token>`

#### Requirements

- docker
- docker-compose


#### How-To

Be sure to build the projet first, the container can't build the .war itself right now.

Deploy to container and run: `docker-compose up --build`

Attach to docker container: `docker exec -it supercar_app_1 /bin/sh`

The website will be aviable under http://localhost/supercar

## Links

- [Java SE JDK 1.8.0_172](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [NetBeans IDE](https://netbeans.org/downloads/start.html?platform=windows&lang=en&option=javaee)
- [Java EE 8](http://www.oracle.com/technetwork/java/javaee/downloads/java-ee-sdk-downloads-3908423.html)