package com.example.hotel.web;

import com.example.hotel.dao.GuestDao;
import com.example.hotel.model.Guest;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class GuestServlet extends HttpServlet {
    private final GuestDao dao = new GuestDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Guest> guests = dao.findAll();
        req.setAttribute("guests", guests);
        req.getRequestDispatcher("/WEB-INF/jsp/guests.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        dao.create(req.getParameter("name"), req.getParameter("email"));
        resp.sendRedirect(req.getContextPath() + "/guests");
    }
}
