# Recipe REST Web-service
Save your favorite Recipes, and have them with you in easy way.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [UML Diagram](#uml-diagram)
* [Features](#features)
* [Sources](#sources)

## General info
This is a learning-purpose project. It's goal is to train and show gained skills is Spring, Maven, Hibernate, Docker, and many others.
Web-service is made in REST architecture, but because of Thymeleaf limitations (it uses HTML instead of HTTP) I was not able to use @DeleteMapping, @PutMapping, etc.
Service, enable to add new Recipes, edit them, delete, add images. 
	
## Technologies
#### Backend:
Project is created with:
* Java 14.0.1
* Spring Boot 2.4.2
* Maven 3.6.3
* Hibernate Core 5.4.27.Final
* Spring Data JPA 2.4.3
* Spring Web MVC 5.3.3
* Project Lombok 1.18.16

#### Tests:
* jUnit-jupiter 5.7.0
* Hamcrest 2.2
* Mockito 3.6.28

#### Databases:
* H2 database 1.4.200
* MySQL

#### Frontend:
* Thymeleaf-spring5:3.0.12.RELEASE
* Bootstrap 4.6.0

## UML Diagram
![UML Diagram](./jhipster-jdl.png)

## Features:
* Add, edit, remove your favorite recipes!
* Add images to your recipes to better recognise them!

### TO DO:
* Add Accounts, loging, creation.
* Refactor categories: add, edit, remove.

## Sources:
This web-service is inspired by John Tompson's course project „Spring Framework 5: Beginner to Guru”.
