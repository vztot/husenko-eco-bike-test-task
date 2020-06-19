# husenko-eco-bike-test-task [![Build Status](https://travis-ci.com/vztot/husenko-eco-bike-test-task.svg?branch=master)](https://travis-ci.com/vztot/husenko-eco-bike-test-task)

## Project purpose

This project is my solution of an [EcoBike](doc/TASK.md) test task.
It implements typical functions of a CRUD application (except for delete). After reading of a text
file program records data into my simple implementation of a binary tree data structure that was
made in education and binary search purposes. After this user can view, add and save new bikes
using console interface. Also, project has dao, service and view layers, IoC (implemented by
the custom injector), unit tests, travis and sonar qube code testing tools. Also, in practice
I prefer use lombok but in these project equals, getters and setters implemented manually.

## Project structure

* Java 11
* Maven
* Log4j
* Maven Checkstyle Plugin
* JUnit
* Travis CI
* SonarQube

## For developer

To run this project:
* Open the project in your IDE (add it as maven project)
* Add SDK 11 or above in project structure
* Run Main class

## Author

[Oleksandr Husenko](https://www.linkedin.com/in/oleksandr-husenko-6a63a2b3/)
