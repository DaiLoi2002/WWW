<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Edit Product</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
    color: #566787;
    background: #f5f5f5;
    font-family: 'Varela Round', sans-serif;
    font-size: 13px;
}
.modal .modal-dialog {
    max-width: 400px;
}
.modal .modal-header, .modal .modal-body, .modal .modal-footer {
    padding: 20px 30px;
}
.modal .modal-content {
    border-radius: 3px;
    font-size: 14px;
}
.modal .modal-footer {
    background: #ecf0f1;
    border-radius: 0 0 3px 3px;
}
.modal .modal-title {
    display: inline-block;
}
.modal .form-control {
    border-radius: 2px;
    box-shadow: none;
    border-color: #dddddd;
}
.modal textarea.form-control {
    resize: vertical;
}
.modal .btn {
    border-radius: 2px;
    min-width: 100px;
}    
.modal form label {
    font-weight: normal;
}    
</style>
</head>
<body>
<div class="container">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="edit" method="post">
                <div class="modal-header">                        
                    <h4 class="modal-title">Edit Product</h4>
                   <button type="button" class="close" aria-hidden="true" onclick="redirectToManager()">&times;</button>
                   
                </div>
                <div class="modal-body">       
                <div class="form-group">
                        <label>ID</label>
                        <input name="id" type="text" class="form-control" value="${detail.id}" readonly required>
                    </div>             
                    <div class="form-group">
                        <label>Name</label>
                        <input name="name" type="text" class="form-control" value="${detail.name}" required>
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input name="image" type="text" class="form-control" value="${detail.image}" required>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" type="text" class="form-control" value="${detail.price}" required>
                    </div>   
                    <div class="form-group">
                        <label>Title</label>
                        <input name="title" type="text" class="form-control" value="${detail.title}" required>
                    </div>
                    <div  class="form-group">
                        <label>Description</label>
                        <input name="description" type="text" class="form-control" value="${detail.description}" required>
                    </div>
                    <div class="form-group">
				        <label>Category</label>
				        <select name="category" class="form-control" required>
				        <c:forEach  items="${categoryList}" var="o">
				          <option value="${o.cid}">${o.cname}</option>
				        </c:forEach>
				        </select>
				    </div>                    
                </div>
                
                <div class="modal-footer">
               
                 
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
function redirectToManager() {
    // Đóng modal
    $('.modal').modal('hide');
    
    // Thực hiện chuyển hướng
    window.location.href = 'manager';
}
</script>
</html>


