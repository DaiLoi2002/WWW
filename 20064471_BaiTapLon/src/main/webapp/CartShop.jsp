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
        .input-group {
            display: flex;
            flex-direction: column;
            width: 100%;
        }
        .input-group .form-control {
            border-radius: 0;
        }
        .input-group .btn {
            border: none;
            border-radius: 0;
            padding: 0.5rem;
        }
        .input-group .input-group-btn {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        .input-group .input-group-btn .btn {
            border-radius: 0;
            border: 1px solid #ccc;
            border-left: none;
        }
        .input-group .input-group-btn .btn:first-child {
            border-right: 1px solid #ccc;
        }
        .input-group .input-group-btn .btn:last-child {
            border-left: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-8">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">
                            <div class="row">
                                <div class="col-xs-6">
                                    <h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
                                </div>
                                <div class="col-xs-6">
                                    <a href="HomeControl" class="btn btn-primary btn-sm btn-block">
                                        <span class="glyphicon glyphicon-share-alt"></span> Continue shopping
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <c:if test="${not empty cart.cartDetails}">
                            <c:forEach var="detail" items="${cart.cartDetails}">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <img class="img-responsive" src="${detail.imgURL}" alt="Product Image">
                                    </div>
                                    <div class="col-xs-4">
                                        <h4 class="product-name"><strong>${detail.productName}</strong></h4>
                                        <h4 class="product-name"><strong>Cart Detail ID:${detail.cartDetail_Id}</strong></h4>
                                        <h4><small>Product Code:${detail.productId}</small></h4>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="col-xs-6 text-right">
                                            <h6><strong><fmt:formatNumber value="${detail.unitPrice}" type="number" groupingUsed="true" />VND</strong></h6>
                                            <h6><strong><fmt:formatNumber value="${detail.totalPrice}" type="number" groupingUsed="true" />VND</strong></h6>
                                        </div>
                                        <div class="col-xs-4">
                                            <div class="input-group">
                                                <input type="text" class="form-control input-sm" value="${detail.quantity}" id="quantityInput-${detail.cartDetail_Id}">
                                                <div class="input-group-btn">
                                                    <button class="btn btn-outline-secondary" type="button" id="increment-${detail.cartDetail_Id}" data-id="${detail.cartDetail_Id}">+</button>
                                                    <button class="btn btn-outline-secondary" type="button" id="decrement-${detail.cartDetail_Id}" data-id="${detail.cartDetail_Id}">-</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-2">
                                            <form action="deleteServlet" method="post" style="display:inline;">
                                                <input type="hidden" name="productId" value="${detail.cartDetail_Id}">
                                                <button type="submit" class="btn btn-link btn-xs">
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </c:forEach>
                            <div class="row">
                                <div class="text-center">
                                    <div class="col-xs-9">
                                        <h6 class="text-right">Added items?</h6>
                                    </div>
                                    <div class="col-xs-3">
                                        <button type="button" class="btn btn-default btn-sm btn-block" onclick="updateCart()">Update cart</button>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${empty cart.cartDetails}">
                            <p>Your cart is empty.</p>
                        </c:if>
                    </div>
                    <div class="panel-footer">
                        <div class="row text-center">
                            <div class="col-xs-9">
                                <h4 class="text-right">Total <strong><fmt:formatNumber value="${cart.totalAll}" type="number" groupingUsed="true" />VND</strong></h4>
                            </div>
                            <div class="col-xs-3">
                                <button type="button" class="btn btn-success btn-block">
                                    Checkout
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var quantityInputs = document.querySelectorAll('input[id^="quantityInput"]');
            quantityInputs.forEach(function(input) {
                var id = input.id.replace('quantityInput-', '');
                var incrementButton = document.getElementById('increment-' + id);
                var decrementButton = document.getElementById('decrement-' + id);
                
                if (incrementButton && decrementButton) {
                    incrementButton.addEventListener('click', function() {
                        var newValue = parseInt(input.value) + 1;
                        input.value = newValue;
                        sendUpdateRequest(id, newValue);
                    });

                    decrementButton.addEventListener('click', function() {
                        var newValue = Math.max(0, parseInt(input.value) - 1);
                        input.value = newValue;
                        sendUpdateRequest(id, newValue);
                    });
                }
            });
        });

        function sendUpdateRequest(id, quantity) {
            $.ajax({
                url: 'updateQuantityServlet',
                type: 'POST',
                data: {
                    cartDetailId: id,
                    quantity: quantity
                },
                success: function(response) {
                    // Cập nhật tổng số lượng hoặc làm mới trang để hiển thị thông tin mới
                    window.location.reload(); // Làm mới trang để cập nhật tổng số lượng
                },
                error: function(xhr, status, error) {
                    alert('Error updating quantity');
                }
            });
        }
    </script>
</body>
</html>
