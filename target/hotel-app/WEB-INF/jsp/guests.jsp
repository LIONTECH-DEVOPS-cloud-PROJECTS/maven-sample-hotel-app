<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Guests</title></head>
<body>
<h2>Guests</h2>
<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Name</th><th>Email</th></tr>
  <c:forEach items="${guests}" var="g">
    <tr>
      <td>${g.id}</td>
      <td>${g.name}</td>
      <td>${g.email}</td>
    </tr>
  </c:forEach>
</table>

<h3>Add Guest</h3>
<form method="post">
  <label>Name <input name="name" required></label>
  <label>Email <input name="email" type="email" required></label>
  <button type="submit">Create</button>
</form>

<p><a href="<c:url value='/'/>">Home</a></p>
</body>
</html>
