-- 
drop DATABASE egyptair;
Create DATABASE egyptair;
use egyptair;
-- 
-- -- Drop Tables
DROP TABLE IF EXISTS flight;
DROP TABLE IF EXISTS aircraft;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS system;

CREATE TABLE egyptair.aircraft (
  aircraftID   char(9) not null,
  model varchar(15), 
  country varchar(15),
  name char(9)not null,
  weight varchar(15), 
  setasNum    varchar(15) not null,
  clases char(1),
  primary key (aircraftID)
);

CREATE TABLE egyptair.flight (
  flightID char(9),
  name char(9),
  src    varchar(15) not null, 
  dest    varchar(15) not null,
  fdate    date,
  flightPlace  varchar(50),
  cost   numeric(10,2),
  aircraftID    char(9) not null,
  primary key (flightID),
  foreign key (aircraftId) references aircraft(aircraftID)
);

CREATE TABLE egyptair.user (
  name        		 varchar(25) not null,
  password      	 varchar(25) not null,
  email              varchar(25) not null,
  creditcardNum      numeric(10) not null,
  phone      	     numeric(10) ,
  primary key (email),
  unique (creditcardNum)
);

CREATE TABLE egyptair.admin (
  name        		 varchar(25) not null,
  password      	 varchar(25) not null,
  email               varchar(25) not null,

  primary key (email),
  unique (email)
);
CREATE TABLE egyptair.reserved (
  email    varchar(25) not null, 
  flightID    varchar(9) not null,
  foreign key (email) references user(email),
  foreign key (flightID) references flight(flightID)
);
CREATE TABLE egyptair.system (
  cleintEmail      varchar(25) not null,
  confiramtion    numeric(1),
   primary key (cleintEmail),
   unique (cleintEmail),
   foreign key (cleintEmail) references user(email)
);

INSERT INTO admin VALUES ('mido','123','mido@example.com');
INSERT INTO user VALUES ('eseaa','123','m.a@y.com','123456','01222');
INSERT INTO user VALUES ('leila','123','l.a@y.com','1234567','011122');

						
INSERT INTO aircraft VALUES ('1210na','215','russia','KIDA','5000','300','2');
INSERT INTO aircraft VALUES ('1220mq','215','america','mqar','4500','250','2');
INSERT INTO aircraft VALUES ('1354aq','300','UK','aqra','4500','250','2');
INSERT INTO aircraft VALUES ('1765kl','567','egypt','klman','5000','300','3');
INSERT INTO aircraft VALUES ('1765ol','500','UAE','olly','5000','300','3');
INSERT INTO aircraft VALUES ('1833pq','250','UAE','pqla','4000','200','2');
INSERT INTO aircraft VALUES ('1836pl','112','russia','play','3000','150','1');

INSERT INTO flight VALUES ('20ml','CSA','egypt','italy',STR_TO_DATE('1-01-2016', '%d-%m-%Y') ,'Hall A','500','1210na');
INSERT INTO flight VALUES ('25aa','lol','france','ita',STR_TO_DATE('3-01-2016', '%d-%m-%Y'),'Hall A','500','1210na');
INSERT INTO flight VALUES ('25af','KIO','italy','france',STR_TO_DATE('5-01-2016', '%d-%m-%Y'),'Hall B','500','1210na');
INSERT INTO flight VALUES ('26qq','TOTY','italy','egypt',STR_TO_DATE('10-01-2016', '%d-%m-%Y'),'Hall B','500','1210na');
