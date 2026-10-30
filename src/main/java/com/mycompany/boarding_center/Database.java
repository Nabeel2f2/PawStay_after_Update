package com.mycompany.boarding_center;

import java.sql.*;
import javax.swing.JOptionPane;

/** Central JDBC connection and schema bootstrap. Change credentials in this class if required. */
public final class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/pawstay?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Database() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initialize() throws SQLException {
        try (Connection c = getConnection(); Statement s = c.createStatement()) {
            s.executeUpdate("CREATE TABLE IF NOT EXISTS customers (customer_id INT AUTO_INCREMENT PRIMARY KEY, full_name VARCHAR(100) NOT NULL, phone VARCHAR(30), email VARCHAR(120), address VARCHAR(255), emergency_contact VARCHAR(100), emergency_phone VARCHAR(30))");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS pets (pet_id INT AUTO_INCREMENT PRIMARY KEY, customer_id INT NOT NULL, pet_name VARCHAR(80) NOT NULL, species VARCHAR(40), breed VARCHAR(80), sex VARCHAR(20), age_years INT DEFAULT 0, vaccination_expiry DATE NULL, feeding_instructions VARCHAR(255), allergies VARCHAR(255), special_care VARCHAR(255), FOREIGN KEY (customer_id) REFERENCES customers(customer_id))");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS staff (staff_id INT AUTO_INCREMENT PRIMARY KEY, full_name VARCHAR(100) NOT NULL, role_name VARCHAR(50), phone VARCHAR(30), username VARCHAR(50) UNIQUE, password_hash VARCHAR(255), status VARCHAR(20) DEFAULT 'Active')");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS reservations (reservation_id INT AUTO_INCREMENT PRIMARY KEY, pet_id INT NOT NULL, customer_id INT NOT NULL, kennel_code VARCHAR(20), accommodation_type VARCHAR(50), check_in DATE NOT NULL, check_out DATE NOT NULL, status VARCHAR(25) DEFAULT 'Reserved', amount DECIMAL(10,2) DEFAULT 0, FOREIGN KEY (pet_id) REFERENCES pets(pet_id), FOREIGN KEY (customer_id) REFERENCES customers(customer_id))");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS payments (payment_id INT AUTO_INCREMENT PRIMARY KEY, reservation_id INT, payment_date DATE NOT NULL, amount DECIMAL(10,2) NOT NULL, method VARCHAR(30), status VARCHAR(20), FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id) ON DELETE SET NULL)");
            try (ResultSet rs=s.executeQuery("SELECT COUNT(*) FROM customers")) { rs.next(); if(rs.getInt(1)==0) seed(c); }
        }
    }

    private static void seed(Connection c) throws SQLException {
        try (PreparedStatement p=c.prepareStatement("INSERT INTO customers(full_name,phone,email,address,emergency_contact,emergency_phone) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            p.setString(1,"Kasun Fernando"); p.setString(2,"077 123 4567"); p.setString(3,"kasun@gmail.com"); p.setString(4,"123 Galle Road, Colombo"); p.setString(5,"Nimali Fernando"); p.setString(6,"071 987 6543"); p.executeUpdate();
        }
        try (Statement s=c.createStatement()) {
            s.executeUpdate("INSERT INTO customers(full_name,phone,email,address) VALUES('Amaya Fernando','077 998 1122','amaya@gmail.com','Colombo 05'),('Dilshan Perera','076 445 6677','dilshan@gmail.com','Nugegoda'),('Tharushi Wickrama','071 778 8899','tharushi@gmail.com','Dehiwala')");
            s.executeUpdate("INSERT INTO pets(customer_id,pet_name,species,breed,sex,age_years,feeding_instructions,allergies) VALUES(1,'Max','Dog','Labrador Retriever','Male',3,'2 cups dry food, twice daily','None'),(2,'Bella','Dog','Beagle','Female',2,'One cup twice daily','None'),(3,'Rocky','Dog','Golden Retriever','Male',4,'Standard meals','None'),(4,'Coco','Dog','Shih Tzu','Female',2,'Small portions','None')");
            s.executeUpdate("INSERT INTO staff(full_name,role_name,phone,username,password_hash,status) VALUES('Nimal Perera','Receptionist','077 555 1234','staff01','staff01','Active')");
            s.executeUpdate("INSERT INTO reservations(pet_id,customer_id,kennel_code,accommodation_type,check_in,check_out,status,amount) VALUES(1,1,'K01','Standard','2026-10-28','2026-10-31','Checked In',7500.00),(2,2,'K03','Deluxe','2026-10-29','2026-11-01','Reserved',12000.00)");
            s.executeUpdate("INSERT INTO payments(reservation_id,payment_date,amount,method,status) VALUES(1,CURDATE(),2500,'Cash','Paid')");
        }
    }
}
