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

    <style>
        body {
            background-color: #121212;
            color: #ffffff;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        form {
            background-color: #393b3b;
            border-radius: 8px;
            box-shadow: #ffffff 0 0 10px;
            padding: 16px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            font-size: 20px;
        }
        input[type="text"], input[type="number"] {
            padding: 8px;
            width: 250px;
            border-radius: 8px;
            border: none;
            margin-bottom: 8px;
            margin-top: 4px;
        }
        input[type="submit"] {
            padding: 8px;
            border-radius: 8px;
            border: none;
            background-color: #007bff;
            color: #ffffff;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            transform: scale(1.1);
            transition: transform 0.3s ease;
        }
        #link {
            position: absolute;
            bottom: 16px;
        }
    </style>
</head>
<body>
  <form action="addBook">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" required><br><br>
    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required><br><br>
    <input type="submit" value="Submit">
  </form>
  <div id="link">
    <a href="home.jsp">Home</a>
  </div>
</body>
</html>
