<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books Management</title>
    <style>
        body {
            background-color: #121212;
            color: #ffffff;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        #container {
            height: 16%;
            background-color: #393b3b;
            border-radius: 8px;
            box-shadow: #ffffff 0 0 10px;
            padding: 16px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            font-size: 20px;
        }
        #container a {
            text-decoration: none;
            color: #ffffff;
            padding: 8px;
            border-radius: 8px;
            background-color: #007bff;
            text-align: center;
        }
        #container a:hover {
            transform: scale(1.1);
            transition: transform 0.3s ease;
        }
    </style>
</head>
<body>
    <h1>Books Management System</h1><br>
    <div id="container">
        <a href="form">Add a Book</a>
        <a href="query/books">Query/Update Entries</a>
    </div>
</body>
</html>