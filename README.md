![]{https://github.com/eglekaz/my-git-test/blob/main/Fiksavimas.JPG}

# Car Service management application

This application is created to provide tracking of car repair processes inside car service and to give an opportunity for a client to see status and progress of repair of his car.

## Technologies

This application is done with Spring Boot with the following options:
+ Java 17.0.2
+ Spring Boot 2.7.2
+ Spring JPA and MySQL for data persistence
+ Thymeleaf template for the rendering

## Installation

To build and run the application from a fresh clone of this repository:

### Configure MySQL

1. Create a database in your MySQL instance.
2. Update the application.properties file in the `src/main/resources` folder with the URL, username and password for your MySQL instance. The table schema for Car and Task objects will be created for you in the database.


### Build and run the application

+ Import downloaded project archive file to your IDE (e.g. Eclipse): `File -> Import... -> Projects from Folder or Archive` and go to directory, where you downloaded the archive file.
+ Run the imported project `Run as... -> Spring Boot Application`.
+ Go to `localhost:8080` in your browser.
