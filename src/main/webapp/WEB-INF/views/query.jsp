<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Query Books/Authors</title>

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
        #menu {
            list-style-type: none;
            padding: 0;
            display: flex;
            flex-direction: row;
            align-items: center;
            border: #ffffff 1px solid;
            border-radius: 8px;
        }
        #menu li {
            margin: 0 8px;
            padding: 8px;
            border-radius: 8px;
        }
        #menu li:hover {
            background-color: #007bff;
            opacity: 0.8;
            cursor: pointer;
        }
        table {
            text-align: start;
            margin-top: 8px;
        }
        table, th, td {
            border: 1px solid #ffffff;
        }
        th, td {
            padding: 8px;
        }
    </style>
</head>
<body>
    <h1>Query Books/Authors</h1>
    <ul id="menu">
        <li style="background-color: ${path == 'books' ? '#007bff' : ''}">List Books</li>
        <li>List Authors</li>
        <li>List Books by Author</li>
    </ul>
    <div>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Year</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author.name}</td>
                    <td>${book.year}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
<div id="link">
    <a href="/">Home</a>
</div>
</body>
</html>