# Car Service management application

![Fiksavimas](https://user-images.githubusercontent.com/110820706/189049749-a0bee8b4-5f26-4f3b-b66d-16744f093c5c.JPG)

This application is created to provide tracking of car repair processes inside a car service and to give an opportunity for a client to see status and progress of repair of his car.

## Technologies

This application is done with Spring Boot with the following options:
+ [Java 17.0.2](https://www.oracle.com/java/technologies/javase/17-0-2-relnotes.html)
+ [Spring Boot 2.7.2](https://spring.io/projects/spring-boot#overview)
+ Spring JPA and MySQL for data persistence
+ Thymeleaf template for the rendering

## Installation

To build and run the application from a fresh clone of this repository:

### Build and run the application

1. Create a database in your MySQL instance.
2. Configure `users` table:

```
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);
INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('technician',
'$2a$10$zpsd4APXNx04gsEKrTEEj.Ky278ozb3D.xndBON4tcg0RlEbBvZa2',
'ROLE_USER', 1);
 
INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('advisor',
'$2a$10$PaBXSikoybj66VhjT3ro8uVjlRFHB/X8ZYWIwuaiTMFH8t4rLxpBC',
'ROLE_ADMIN', 1);
```

3. Import downloaded project archive file to your IDE (e.g. Eclipse): `File -> Import... -> Projects from Folder or Archive` and go to directory, where you downloaded the archive file.
4. Update the application.properties file in the `src/main/resources` folder with the URL, username and password for your MySQL instance. The table schema for Car and Task objects will be created for you in the database.
5. Run the imported project `Run as... -> Spring Boot Application`.
6. Go to `localhost:8080` in your browser.

To use application as ADMIN:
+ Username: advisor
+ Password: Advisor2022

To use application as USER:
+ Username: technician
+ Password: Technician2022

