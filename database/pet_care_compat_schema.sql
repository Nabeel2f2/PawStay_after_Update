-- Compatibility schema for the original NetBeans Customer/Pet forms.
-- Run this file in MySQL/phpMyAdmin before using the legacy form CRUD operations.
CREATE DATABASE IF NOT EXISTS pet_care
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE pet_care;

CREATE TABLE IF NOT EXISTS customers (
  ID VARCHAR(12) PRIMARY KEY,
  Full_Name VARCHAR(100) NOT NULL,
  Phone VARCHAR(30),
  Email VARCHAR(120),
  Address VARCHAR(255),
  Emergency_Contact VARCHAR(100),
  Emergency_Number VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS pets_info (
  Pet_ID VARCHAR(12) PRIMARY KEY,
  Name VARCHAR(80) NOT NULL,
  Owner VARCHAR(100),
  Species VARCHAR(40),
  Breed VARCHAR(80),
  Sex VARCHAR(20),
  Age INT DEFAULT 0,
  Vaccination_Expiry DATE NULL,
  Feeding_Instructions VARCHAR(255),
  Allergies VARCHAR(255),
  Special_Care_Instructions VARCHAR(255)
);

INSERT IGNORE INTO customers (ID, Full_Name, Phone, Email, Address, Emergency_Contact, Emergency_Number) VALUES
('CUS001','Kasun Fernando','077 123 4567','kasun@gmail.com','123 Galle Road, Colombo 06','Nimali Fernando','071 987 6543'),
('CUS002','Nadee Perera','071 234 5678','nadee.p@gmail.com','Colombo 05','', ''),
('CUS003','Amaya Fernando','077 998 1122','amayaf@gmail.com','Colombo 05','', ''),
('CUS004','Dilshan Perera','076 445 6677','dilshanp@gmail.com','Nugegoda','', ''),
('CUS005','Tharushi Wickrama','071 778 8899','tharushi.w@gmail.com','Dehiwala','', '');

INSERT IGNORE INTO pets_info (Pet_ID, Name, Owner, Species, Breed, Sex, Age, Feeding_Instructions, Allergies, Special_Care_Instructions) VALUES
('PET001','Max','Kasun Fernando','Dog','Labrador Retriever','Male',3,'2 cups dry food, twice daily','None','Gets anxious with loud noises. Keep in a quiet area.'),
('PET002','Bella','Amaya Fernando','Dog','Beagle','Female',2,'One cup twice daily','None',''),
('PET003','Rocky','Dilshan Perera','Dog','Golden Retriever','Male',4,'Standard meals','None',''),
('PET004','Coco','Tharushi Wickrama','Dog','Shih Tzu','Female',2,'Small portions','None',''),
('PET005','Milo','Hasini Jayasekara','Cat','Persian','Male',3,'Wet food morning and evening','None','');
