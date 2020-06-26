# husenko-eco-bike-test-task [![Build Status](https://travis-ci.com/vztot/husenko-eco-bike-test-task.svg?branch=master)](https://travis-ci.com/vztot/husenko-eco-bike-test-task)

## Project purpose

This project is my solution of an [EcoBike](doc/TASK.md) test task.
It implements some typical functions of a CRUD application. After reading a text
file program records data into H2 sql in-memory db using Hibernate. After this user can view, add
 and save new bikes using JPA. Also, project has dao, service and view layers, DI (custom injector),
  unit tests, travis code testing tools. Also, in
   practice I prefer use lombok but in these project equals, hashcode, getters and setters
    implemented manually.

## Project structure

* Java 11
* Maven
* Log4j
* H2 (in memory database)
* Hibernate
* Maven Checkstyle Plugin
* JUnit
* Travis CI

## For developer

To run this project:
* Open the project in your IDE (add it as maven project)
* Add SDK 11 or above in project structure
* Change log4j.properties file for your system
* Run Main class

## Author

[Oleksandr Husenko](https://www.linkedin.com/in/oleksandr-husenko-6a63a2b3/)
