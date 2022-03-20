<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
          crossorigin="anonymous">

    <title>Save Customer</title>
</head>

<body>

<div class="container">
    <h3 class="bg-success">Customer Relationship Management</h3>
    <hr>

    <p class="h4 mb-4 bg-primary">Save Customer</p>

    <form action="/cmsapp/customers/save" method="POST">

        <!-- Add hidden form field to handle update -->
        <input type="hidden" name="id" value="${Customer.id}"/>
        <div class="form-inline">
            <label for="fname" class="mb-4 col-4" style="color: green">First Name: </label>
            <input type="text" id="fname" name="fname" value="${Customer.fname}"
                   class="form-control mb-4 col-4" placeholder="First Name">
        </div>
        <div class="form-inline">
            <label for="lname" class="mb-4 col-4" style="color: green">Last Name: </label>
            <input type="text" id="lname" name="lname" value="${Customer.lname}"
                   class="form-control mb-4 col-4" placeholder="Last Name">
        </div>

        <div class="form-inline">
            <label for="email" class="mb-4 col-4" style="color: green">E-mail: </label>
            <input type="email" id="email" name="email" value="${Customer.email}"
                   class="form-control mb-4 col-4" placeholder="E-Mail">
        </div>

        <button type="submit" class="btn btn-success col-2">Save</button>

    </form>

    <hr>
    <a href="/cmsapp/customers/list">Back to List</a>

</div>
</body>

</html>