package com.example.hotel.dao;

import com.example.hotel.model.Room;
import java.sql.*;
import java.util.*;

public class RoomDao {
    public List<Room> findAll() {
        List<Room> list = new ArrayList<>();
        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement("SELECT id, number, type, price_per_night, available FROM rooms ORDER BY id")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getBoolean(5)
                ));
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
        return list;
    }

    public void create(String number, String type, double price) {
        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement("INSERT INTO rooms(number, type, price_per_night, available) VALUES (?, ?, ?, true)")) {
            ps.setString(1, number);
            ps.setString(2, type);
            ps.setDouble(3, price);
            ps.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }
}
