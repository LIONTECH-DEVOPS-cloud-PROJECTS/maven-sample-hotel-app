<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Rooms</title></head>
<body>
<h2>Rooms</h2>
<table border="1" cellpadding="6">
  <tr><th>ID</th><th>No.</th><th>Type</th><th>Price</th><th>Available</th></tr>
  <c:forEach items="${rooms}" var="r">
    <tr>
      <td>${r.id}</td>
      <td>${r.number}</td>
      <td>${r.type}</td>
      <td>${r.pricePerNight}</td>
      <td>${r.available}</td>
    </tr>
  </c:forEach>
</table>

<h3>Add Room</h3>
<form method="post">
  <label>Number <input name="number" required></label>
  <label>Type <input name="type" required></label>
  <label>Price <input name="price" type="number" step="0.01" required></label>
  <button type="submit">Create</button>
</form>

<p><a href="<c:url value='/'/>">Home</a></p>
</body>
</html>
