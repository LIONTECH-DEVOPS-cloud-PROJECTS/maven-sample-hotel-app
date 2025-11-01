package com.example.hotel.web;

import com.example.hotel.dao.BookingDao;
import com.example.hotel.dao.RoomDao;
import com.example.hotel.dao.GuestDao;
import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;
import com.example.hotel.model.Guest;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class BookingServlet extends HttpServlet {
    private final BookingDao bookingDao = new BookingDao();
    private final RoomDao roomDao = new RoomDao();
    private final GuestDao guestDao = new GuestDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookings", bookingDao.findAll());
        req.setAttribute("rooms", roomDao.findAll());
        req.setAttribute("guests", guestDao.findAll());
        req.getRequestDispatcher("/WEB-INF/jsp/bookings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        int guestId = Integer.parseInt(req.getParameter("guestId"));
        LocalDate checkIn = LocalDate.parse(req.getParameter("checkIn"));
        LocalDate checkOut = LocalDate.parse(req.getParameter("checkOut"));
        bookingDao.create(roomId, guestId, checkIn, checkOut);
        resp.sendRedirect(req.getContextPath() + "/bookings");
    }
}
