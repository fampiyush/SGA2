<%--
  Created by IntelliJ IDEA.
  User: piyus
  Date: 11-10-2024
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books Form</title>
</head>
<body>
  <form action="addBook">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>
    <label for="author">Authors:</label>
    <input type="text" id="author" name="author" required>
    <span>(separate authors name by comma)</span>
    <br><br>
    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required><br><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
