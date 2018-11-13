# Booking rooms in the hotel

About
-------
  This project was build with the next technology Spring Boot, Spring Data, Hibernate, H2, maven. The main 
idea of the project is possibility to booking hotel rooms. This application allow to view list avaliable rooms by specific 
categories such as:

* *Room capacity;*
* *Price of the room;*

  To make an book, guest can creat user. User can book the room for specified days, also view his booking and get the 
total price of booking. (Price consist all additional options which was picked while ordering by user). Additionaly  
user can view all booking for the hotel.

Instruction to launch the application
--------
  To run this application you need to have installed required software (for Linux) type in terminal:
  ``` 
  mvn --version
  ```
  
  If you get nothing. Try to install it. Installation procedure depends from your OS.
  Then check if on your machine preinstalled java:
  ``` 
  java -version
  ```
  If you get nothing. Try to install it.
  Clone the project. At the folder "hotel" of the cloned project type next:
  ``` 
  mvn package
  ```
  Then move to directory called 'target' and execute next command:
  ``` 
  java -jar hotel-1.0-SNAPSHOT.jar
  ```
  After that open your browser and follow the link:
  ``` 
  http://localhost:8080 
  ```
  SQL-scripts 
  ---------------
  Laying at next folder: root/src/main/resource 
    | scheme-h2.sql | data-h2.sql |   
  
  UML main blocks
  --------
  Price drafted by decorator pattern.
  
  <img width="471" alt="screen shot 2018-11-13 at 3 05 41 pm" src="https://user-images.githubusercontent.com/33597605/48415789-0b25d580-e757-11e8-9546-8300177b2589.png">
  
  <img width="984" alt="screen shot 2018-11-13 at 3 05 15 pm" src="https://user-images.githubusercontent.com/33597605/48415346-ce0d1380-e755-11e8-965f-63416f3dba2f.png">
