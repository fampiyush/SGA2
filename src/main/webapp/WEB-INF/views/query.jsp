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
            left: 49%;
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
        #menu a {
            text-decoration: none;
            color: #ffffff;
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
        .edit {
            background-color: #1bbf35;
            cursor: pointer;
            border-radius: 8px;
            padding: 2px;
            text-align: center;
        }
        .edit:hover {
            transform: scale(1.1);
            transition: transform 0.3s ease;
        }
        td a {
            text-decoration: none;
            color: #ffffff;
        }
    </style>
</head>
<body>
    <h1>Query Books/Authors</h1>
    <ul id="menu">
        <a href="books">
            <li style="background-color: ${path == 'books' ? '#007bff' : ''}">List Books</li>
        </a>
        <a href="authors">
            <li style="background-color: ${path == 'authors' ? '#007bff' : ''}">List Authors</li>
        </a>
    </ul>
    <div>
        <table style="display: ${path == 'books' ? 'block' : 'none'}">
            <tr>
                <th>Book Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Year</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author.name}</td>
                    <td>${book.year}</td>
                    <td>
                        <a href="/books/edit/${book.id}">
                            <div class="edit">
                                Edit
                            </div>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <table style="display: ${path == 'authors' ? 'block' : 'none'}">
            <tr>
                <th>Author Id</th>
                <th>Name</th>
                <th>Books</th>
            </tr>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td>${author.id}</td>
                    <td>${author.name}</td>
                    <td>
                        <c:forEach var="book" items="${author.books}">
                            ${book.title}<br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
    </div>
<div id="link">
    <a href="/">Home</a>
</div>
</body>
</html>
