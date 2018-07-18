#Train Reservation Simulation

## Guide
https://github.com/pratapsatya/trainreserve.git
## Prerequisites
- JDK 1.8 or later
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



Run in MySQL

create a database and grant permissions on that:

create database db_example;
create user 'testuser'@'localhost' identified by 'password';
grant all on db_example.* to 'testuser'@'localhost';


Give these details in "application.proprties" file





use db_example;

CREATE TABLE `trains` (
`trains_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
`trainnumber` varchar(20) DEFAULT NULL,
`source` varchar(20) DEFAULT NULL,
`destination` varchar(20) DEFAULT NULL,
`timings` varchar(20) DEFAULT NULL,
`trainname` varchar(40) DEFAULT NULL,
`day` varchar(20) DEFAULT NULL,
`available`varchar(20) DEFAULT NULL,
PRIMARY KEY (`trains_id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


INSERT INTO `trains` (`trainnumber`,`source`,`destination`,`timings`,`trainname`,`day`,`available`)
VALUES
('762128','vijayawada','tirupathi','09.00pm-20.15pm','vijayawadaExpress','0','9');
INSERT INTO `trains` (`trainnumber` ,`source`,`destination`,`timings`,`trainname`,`day`,`available`)
VALUES
('762525','vijayawada','tirupathi','10.00am-14.15pm','tirupathipassenger','1','9');
INSERT INTO `trains` (`trainnumber`,`source`,`destination`,`timings`,`trainname`,`day`,`available`)
VALUES
('762523','vijayawada','tirupathi','13.00pm-18.15pm','tirupathibejawadasuperfast','2','9');
INSERT INTO `trains` (`trainnumber` ,`source`,`destination`,`timings`,`trainname`,`day`,`available`)
VALUES
('762529','vijayawada','tirupathi','21.00pm-3.15am','vijayawadatirupathisuperfast','3','9');
INSERT INTO `trains` (`trainnumber` ,`source`,`destination`,`timings`,`trainname`,`day`,`available`)
VALUES
('762328','vijayawada','tirupathi','17.50pm-2.35am','bejawadatirupathi','4','9');
INSERT INTO `trains` (`trainnumber` ,`source`,`destination`,`timings`,`trainname`,`day`,`available`)
VALUES
('768328','vijayawada','tirupathi','14.50pm-5.35am','hyderabadtirupathi','5','9');
INSERT INTO `trains` (`trainnumber` ,`source`,`destination`,`timings`,`trainname`,`day`,`available`)
VALUES
('269328','vijayawada','tirupathi','17.50pm-12.35am','tirupathisuperfast','6','9');





To make it more realistic add more trains
