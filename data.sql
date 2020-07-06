-- **********************  Employee Data ********************** 

INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('101','Ankith','43','CHENNAI','56000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('102','Priya','32','BANGALORE','30000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('103','Kunal','22','CHENNAI','25000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('104','Ram','43','CHENNAI','40000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('105','Valar','57','MUMBAI','56000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('106','Mani','66','BANGALORE','58000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('107','Ranjith','25','DELHI','26000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('108','Preethi','34','KOLKATA','32000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('109','Veena','32','BANGALORE','40000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('110','Inica','55','CHENNAI','30000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('111','Inica','55','Chennai','30000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('112','Inica','55','Chennai','30000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('113',null,'55','Chennai','30000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('114','Inica','0','Chennai','30000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('115','Inica','55',null,'30000');
INSERT INTO EMPLOYEE (ID,NAME,AGE,CITY,SALARY) VALUES ('116','Inica','55','Chennai','0');

-- ********************** Address Data ********************** 
INSERT INTO ADDRESS (AID,ADDRESS_TYPE,ADDRESS_LINE,CITY,STATE,COUNTRY,POSTAL_CODE,EMP_ID) VALUES
('201','Home','3\, SOUTH STREET','CH','TN','IN','620100','105');
INSERT INTO ADDRESS (AID,ADDRESS_TYPE,ADDRESS_LINE,CITY,STATE,COUNTRY,POSTAL_CODE,EMP_ID) VALUES
('202','Work','53\, NORTH STREET','BNGLR','KA','IN','560100','105');
INSERT INTO ADDRESS (AID,ADDRESS_TYPE,ADDRESS_LINE,CITY,STATE,COUNTRY,POSTAL_CODE,EMP_ID) VALUES
('203','Home','73\, WEST STREET','KOL','WB','IN','220100','103');
INSERT INTO ADDRESS (AID,ADDRESS_TYPE,ADDRESS_LINE,CITY,STATE,COUNTRY,POSTAL_CODE,EMP_ID) VALUES
('204','Work','373\, EAST STREET','BNGLR','KA','IN','560177','103');
INSERT INTO ADDRESS (AID,ADDRESS_TYPE,ADDRESS_LINE,CITY,STATE,COUNTRY,POSTAL_CODE,EMP_ID) VALUES
('205','Work','53\, ECITY STREET','BNGLR','KA','IN','560100','107');
INSERT INTO ADDRESS (AID,ADDRESS_TYPE,ADDRESS_LINE,CITY,STATE,COUNTRY,POSTAL_CODE,EMP_ID) VALUES
('206','Home','73\, HUBLI STREET','KOL','WB','IN','220100','101');

-- ********************** Country ********************** 
INSERT INTO Country (country_Id, country_code, country_desc) VALUES
('1001', 'IN', 'India'),
('1002', 'US', 'United States');

-- **********************  State ********************** 
INSERT INTO State (state_Id, state_desc, country_Id) VALUES
('2001', 'Delhi', '1001'),
('2002', 'Karnataka', '1001'),
('2003', 'Kerala', '1001'),
('2004', 'Tamil Nadu', '1001'),
('2005', 'Telangana', '1001'),
('2006', 'Maharashtra', '1001'),
('2007', 'West Bengal', '1001'),

('2008', 'California', '1002'),
('2009', 'New York', '1002');

-- **********************  City ********************** 
INSERT INTO City (city_Id, city_desc, state_Id) VALUES
('3001', 'Delhi', '2001'),
('3002', 'New Delhi', '2001'),
('3003',  'Bangalore', '2002'),
('3004',  'Mangalore', '2002'),
('3005',  'Mysore', '2002'),
('3006',  'Alappuzha', '2003'),
('3007',  'Trivandrum', '2003'),
('3008',  'Cochin', '2003'),
('3009',  'Coimbatore', '2004'),
('3010',  'Chennai', '2004'),
('3011',  'Madurai', '2004'),
('3012',  'Hyderabad', '2005'),
('3013',  'Secunderabad', '2005'),
('3014',  'Nizamabad', '2005'),
      
('3015',  'Mumbai', '2006'),
('3016',  'Navi Mumbai', '2006'),
('3017',  'Pune', '2006'),
     
('3018',  'Kolkata', '2007'),
('3019',  'Konardihi', '2007'),
      
('3020',  'Alpine', '2008'),
('3021',  'Alta Loma', '2008'),
      
('3022',  'Brunswick', '2009'),
('3023',  'Buffalo', '2009'),
('3024',  'Camillus', '2009');

COMMIT;
