<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="shop-category nav navbar-nav navbar-left">

                <!-- Single button -->

                <div class="btn-group">

                  <button type="button" class="btn btn-shop-category dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                     Category <span class="caret"></span>

                  </button>

                  <ul class="dropdown-menu">
                   <c:forEach items="${categoryList}" var="category">
        <li><a href="category?cid=${category.cid}">${category.cname}</a></li>
    </c:forEach>
                  


                  </ul>

                </div>

            </div>

<div class="collapse navbar-collapse" id="navbar">

              <ul class="nav navbar-nav navbar-right">

                <li><a href="#">Home</a></li>

                <li><a href="#">Blog</a></li>

                <li><a href="#">Shortcode</a></li>

                <li><a href="#">Features</a></li>

                <li><a href="#">Media</a></li>

                <li><a href="#">About Us</a></li>

                <li><a href="#">Contact Us</a></li>

              </ul>

            </div>