-- 
 -- Create DATABASE egyptair;
-- 
-- -- Drop Tables
-- DROP TABLE IF EXISTS flight;
-- DROP TABLE IF EXISTS aircraft;
-- DROP TABLE IF EXISTS user;
-- DROP TABLE IF EXISTS system;

CREATE TABLE aircraft (
  aircraftID   char(9) not null,
  model varchar(15), 
  country varchar(15), 
  name  varchar(15),
  weight varchar(15), 
  seatsNum    varchar(15) not null,
  clases char(1),
  primary key (aircraftID)
);

CREATE TABLE flight (
  src    varchar(15) not null, 
  dest    varchar(1) not null,
  aircraftID    char(9) not null,
  fdate    date,
  flightPlace  varchar(50),
  cost   numeric(10,2),
  flightID char(9),
  superssn char(9),
  primary key (flightID),
  foreign key (aircraftId) references aircraft(aircraftID)
);

CREATE TABLE user (
  name        		 varchar(25) not null,
  password      	 varchar(25) not null,
  email              varchar(25) not null,
  creditcardNum      numeric(10) not null,
  phone      	     numeric(10) ,
  authority          char(1) not null,
  userID             char(9),
  flightId 		     char(9),
  primary key (email),
  unique (creditcardNum,userID),
  foreign key (flightId) references flight(flightID)
  -- foreign key (mgrssn) references employee(ssn)
);


CREATE TABLE system (
  cleintEmail      varchar(25) not null,
  confiramtion    numeric(1),
  
 
   primary key (cleintEmail),
   unique (cleintEmail),
   foreign key (cleintEmail) references user(email)
);
							
INSERT INTO aircraft VALUES ('1210na','215','russia','KIDA','5000','300','2');
INSERT INTO aircraft VALUES ('1220mq','215','america','mqar','4500','250','2');
INSERT INTO aircraft VALUES ('1354aq','300','UK','aqra','4500','250','2');
INSERT INTO aircraft VALUES ('1765kl','567','egyot','klman','5000','300','3');
INSERT INTO aircraft VALUES ('1765ol','500','UAE','olly','5000','300','3');
INSERT INTO aircraft VALUES ('1833pq','250','UAE','pqla','4000','200','2');
INSERT INTO aircraft VALUES ('1836pl','112','russia','play','3000','150','1');
