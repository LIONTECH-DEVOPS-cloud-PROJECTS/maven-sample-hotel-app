package com.example.hotel.dao;

import com.example.hotel.model.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {

    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>();
        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, room_id, guest_id, check_in, check_out FROM bookings ORDER BY id")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getInt("guest_id"),
                        rs.getDate("check_in").toLocalDate(),
                        rs.getDate("check_out").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void create(int roomId, int guestId, LocalDate checkIn, LocalDate checkOut) {
        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(
                     "INSERT INTO bookings(room_id, guest_id, check_in, check_out) VALUES (?, ?, ?, ?)")) {

            ps.setInt(1, roomId);
            ps.setInt(2, guestId);
            ps.setDate(3, java.sql.Date.valueOf(checkIn));
            ps.setDate(4, java.sql.Date.valueOf(checkOut));

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
