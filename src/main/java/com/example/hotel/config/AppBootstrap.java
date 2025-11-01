package com.example.hotel.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.Statement;
import com.example.hotel.dao.Db;

@WebListener
public class AppBootstrap implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try (Connection c = Db.get(); Statement st = c.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS rooms (id IDENTITY PRIMARY KEY, number VARCHAR(10), type VARCHAR(30), price_per_night DOUBLE, available BOOLEAN)");
            st.execute("CREATE TABLE IF NOT EXISTS guests (id IDENTITY PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))");
            st.execute("CREATE TABLE IF NOT EXISTS bookings (id IDENTITY PRIMARY KEY, room_id INT, guest_id INT, check_in DATE, check_out DATE)");

            // Seed data (plain Java 11 strings)
            st.execute("INSERT INTO rooms(number, type, price_per_night, available) VALUES ('101','Single',79.99,true),('102','Double',99.99,true),('201','Suite',149.99,true)");
            st.execute("INSERT INTO guests(name, email) VALUES ('Alice Smith','alice@example.com'),('Bob Jones','bob@example.com')");
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}
