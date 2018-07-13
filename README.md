#Train Reservation Simulation

## Guide
https://github.com/pratapsatya/trainreserve.git
## Prerequisites
- JDK 1.7 or later
- Maven 3 or later

## Stack
- Spring Security
- Spring Boot
- Spring Data JPA
- Maven
- JSP
- MYSQL

## Run
"http://localhost:8090/login" is the starting url

The user should have MySQL database and a “trains” table with data in it.
-Give the database credentials in application.properties file.
-run the program.
-localhost :{ port}/login is the only accessible URL.
-localhost :{ port}/welcome is the page to add source, destination and date of journey.
-localhost :{ port}/trains displays the list of trains.
-localhost:{port}/payment displays form to enter user details.
-localhost:{port}/ticketconfirmation displays the ticket.
-localhost :{ port}/history displays the list of tickets booked by the user before. 

