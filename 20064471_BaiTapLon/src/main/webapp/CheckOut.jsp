<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <style>
        body {
            margin-top: 20px;
        }
        .container {
            margin-left: auto;
            margin-right: auto;
        }
        .panel {
            margin-bottom: 20px;
        }
        .qr-code {
            text-align: center;
            margin-bottom: 20px;
        }
        .qr-code img {
            display: inline-block;
            max-width: 150px; /* Điều chỉnh kích thước ảnh QR code */
            height: auto; /* Giữ tỷ lệ khung hình */
        }
        .user-info, .cart-content {
            margin-bottom: 20px;
        }
        .cart-content table {
            width: 100%;
            margin-bottom: 20px;
        }
        .cart-content th, .cart-content td {
            text-align: left;
            padding: 8px;
        }
        .cart-content th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <!-- QR Code Section -->
            <div class="col-xs-12 qr-code">
                <h3>Payment QR Code</h3>
                <img src="images/QRcode.jpeg" alt="QR Code">
            </div>

            <!-- Checkout Form Section -->
            <div class="col-xs-12">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h4 class="panel-title">Checkout Information</h4>
                    </div>
                    <div class="panel-body">
                        <form action="checkoutServlet" method="post">
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" id="name" name="name" value="${user.name}" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
                            </div>
                            <div class="form-group">
                                <label for="address">Address:</label>
                                <input type="text" class="form-control" id="address" name="address" value="${user.address}" required>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone:</label>
                                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" required>
                            </div>

                            <!-- Cart Content Section -->
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Cart Contents</h4>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Product Name</th>
                                                <th>Quantity</th>
                                                <th>Unit Price</th>
                                                <th>Total Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${cart.cartDetails}">
                                                <tr>
                                                    <td>${item.productName}</td>
                                                    <td>${item.quantity}</td>
                                                    <td><fmt:formatNumber value="${item.unitPrice}" type="number" groupingUsed="true"/> VND</td>
                                                    <td><fmt:formatNumber value="${item.totalPrice}" type="number" groupingUsed="true"/> VND</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <h4 class="text-right">Total Price: <strong><fmt:formatNumber value="${cart.totalAll}" type="number" groupingUsed="true"/> VND</strong></h4>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-success btn-block">Confirm Order</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
