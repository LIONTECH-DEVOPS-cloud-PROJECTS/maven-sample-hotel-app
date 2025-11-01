package com.example.hotel.web;

import com.example.hotel.dao.RoomDao;
import com.example.hotel.model.Room;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class RoomServlet extends HttpServlet {
    private final RoomDao dao = new RoomDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> rooms = dao.findAll();
        req.setAttribute("rooms", rooms);
        req.getRequestDispatcher("/WEB-INF/jsp/rooms.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String number = req.getParameter("number");
        String type = req.getParameter("type");
        double price = Double.parseDouble(req.getParameter("price"));
        dao.create(number, type, price);
        resp.sendRedirect(req.getContextPath() + "/rooms");
    }
}
