<%@ page import="java.util.List" %>
<%@ page import="com.in28Min.springboot.myfurstwebapp.todo.Todo" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="stylesheet">

    <title>List todos Page</title>
<style>

  .button {
        display: inline-block;
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        text-decoration: none;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
      }

      .button:hover {
        background-color: #0056b3;
      }
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
            background-image: url('https://abrakadabra.fun/uploads/posts/2021-12/thumbs/1639039095_25-abrakadabra-fun-p-fon-dlya-khedera-33.png');
      background-size: cover; /* Cover the entire background */
      background-position: center; /* Center the background image */
    }

    .container {
      max-width: 800px;
      margin: 20px auto;
      padding: 20px;
      background-color: rgba(255, 255, 255, 0.8); /* Add a semi-transparent white background for better readability */
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
      font-size: 24px;
      margin-bottom: 20px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }

    /* Added CSS for hover effect */
    tr:hover {
      background-color: #e0e0e0;
    }

    /* Added CSS for scrolling */
    .scrollable-table {
      max-height: 300px; /* Set the max height as desired */
      overflow-y: auto; /* Enable vertical scrolling */
    }

  </style>
</head>
<body>