CREATE TABLE airport (
  id varchar(36) NOT NULL,
  code varchar(45)  NULL,
  name varchar(255)  NULL,
  created_by_user varchar(45)  NULL,
  created_date timestamp  NULL,
  last_updated_by_user varchar(45)  NULL,
  last_updated_date timestamp  NULL,
  version_no bit(1),
  deleted bit(1) ,
  PRIMARY KEY (id)
);

INSERT INTO airport VALUES ('1','DAN','Da Nang Airport','SYSTEM','2015-04-03 17:00:00','SYSTEM','2015-04-03 17:00:00',b'0',b'0'),('2','HCM','Ho Chi Minh Airport','SYSTEM','2015-04-03 17:00:00','SYSTEM','2015-04-03 17:00:00',b'0',b'0'),('3','HAN','Ha Noi Airport','SYSTEM','2015-04-03 17:00:00','SYSTEM','2015-04-03 17:00:00',b'0',b'0');
CREATE TABLE special_deal (
  id varchar(36) NOT NULL,
  flight_no varchar(45)  NULL,
  airport_from varchar(36)  NULL,
  airport_to varchar(36)  NULL,
  cost decimal(15,5)  NULL,
  depart timestamp NULL  ,
  arrive timestamp NULL ,
  created_by_user varchar(45) NULL,
  created_date timestamp  NULL,
  last_updated_by_user varchar(45) NULL,
  last_updated_date timestamp  NULL,
  version_no bit(1) ,
  deleted bit(1),
  PRIMARY KEY (id),
  CONSTRAINT pk_special_table_airport_from FOREIGN KEY (airport_from) REFERENCES airport (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT pk_special_table_airport_to FOREIGN KEY (airport_to) REFERENCES airport (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO special_deal VALUES ('1','VNA-100','1','2',1500000.00000,'2015-04-05 03:00:00','2015-04-05 04:45:00','SYSTEM','2015-04-03 17:00:00','SYSTEM','2015-04-03 17:00:00',b'0',b'0'),('2','VNA-101','1','3',2500000.00000,'2015-05-05 03:00:00','2015-05-05 04:45:00','SYSTEM','2015-04-03 17:00:00','SYSTEM','2015-04-03 17:00:00',b'0',b'0'),('3','VNA-102','2','3',1700000.00000,'2015-04-06 03:00:00','2015-04-06 05:45:00','SYSTEM','2015-04-03 17:00:00','SYSTEM','2015-04-03 17:00:00',b'0',b'0'),('8342bfdf-02fa-4bdc-86c1-b9a3025685f8','VNA-202','3','1',350000.00000,'2015-04-05 04:41:00','2015-04-05 06:41:00',NULL,'2015-04-05 04:41:44',NULL,NULL,b'0',b'0'),('8ae05098-6e93-4690-ba3b-a401669ca615','VNA-203','2','1',100000.00000,'2015-04-05 04:46:00','2015-04-05 07:46:00',NULL,'2015-04-05 04:46:30',NULL,NULL,b'0',b'0'),('f6f07912-6074-4e21-ab7a-f01ab7cfc275','VNA-202','1','3',200000.00000,'2015-04-06 04:37:00','2015-04-06 08:38:00',NULL,'2015-04-05 04:39:13',NULL,NULL,b'0',b'0');

