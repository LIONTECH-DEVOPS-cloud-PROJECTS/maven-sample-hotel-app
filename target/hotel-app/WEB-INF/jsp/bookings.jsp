<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Bookings</title></head>
<body>
<h2>Bookings</h2>
<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Room ID</th><th>Guest ID</th><th>Check-in</th><th>Check-out</th></tr>
  <c:forEach items="${bookings}" var="b">
    <tr>
      <td>${b.id}</td>
      <td>${b.roomId}</td>
      <td>${b.guestId}</td>
      <td>${b.checkIn}</td>
      <td>${b.checkOut}</td>
    </tr>
  </c:forEach>
</table>

<h3>Create Booking</h3>
<form method="post">
  <label>Room
    <select name="roomId">
      <c:forEach items="${rooms}" var="r">
        <option value="${r.id}">#${r.id} - ${r.number} (${r.type})</option>
      </c:forEach>
    </select>
  </label>
  <label>Guest
    <select name="guestId">
      <c:forEach items="${guests}" var="g">
        <option value="${g.id}">${g.name}</option>
      </c:forEach>
    </select>
  </label>
  <label>Check-in <input name="checkIn" type="date" required></label>
  <label>Check-out <input name="checkOut" type="date" required></label>
  <button type="submit">Create</button>
</form>

<p><a href="<c:url value='/'/>">Home</a></p>
</body>
</html>
