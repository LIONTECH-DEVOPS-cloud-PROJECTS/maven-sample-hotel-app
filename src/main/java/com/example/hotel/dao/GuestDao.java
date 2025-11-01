package com.example.hotel.dao;

import com.example.hotel.model.Guest;
import java.sql.*;
import java.util.*;

public class GuestDao {
    public List<Guest> findAll() {
        List<Guest> list = new ArrayList<>();
        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement("SELECT id, name, email FROM guests ORDER BY id")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Guest(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
        return list;
    }

    public void create(String name, String email) {
        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement("INSERT INTO guests(name, email) VALUES (?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }
}
