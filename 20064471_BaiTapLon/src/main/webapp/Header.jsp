<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <div class="top-bar">

        <div class="container">

            <div class="row">

                <div class="col-md-6">

                    <div class="social pull-left">

                        <ul>
                         <li><a href="#"></a>&nbsp;   </li>
						<c:if test="${sessionScope.acc.isAdmin == 1}">
			                <li><a href="#"><i class="fa fa-key"></i>&nbsp;Manager Account</a></li>
			               
			            </c:if>
                           <c:if test="${sessionScope.acc.isSell == 1}">
							    <li><a href="manager"><i class="fa fa-calculator"></i>&nbsp;Manager Product</a></li>
							</c:if>
                           

                        </ul>

                    </div>

                </div>

               <div class="col-md-6">
			    <div class="action pull-right">
			        <ul>
			            <c:if test="${sessionScope.acc != null}">
			                <li><a href="#"><i class="fa fa-hand-peace-o"></i> Hello ${sessionScope.acc.user}</a></li>
			                <li><a href="hello"><i class="fa fa-user"></i> Logout</a></li>
			            </c:if>
			            <c:if test="${sessionScope.acc == null}">
			                <li><a href="Login&Register.jsp"><i class="fa fa-user"></i> Login</a></li>
			            </c:if>
			        </ul>
			    </div>
			</div>
               

            </div>

        </div>

    </div>
     <div class="header">

        <div class="container">

            <div class="row">

                <div class="col-md-3 col-sm-4">

                    <div class="logo">

                        <a href="http://localhost:8080/20064471_BaiTapLon/HomeControl">

                            <img src="images/logo.png" alt="Orani E-shop">

                        </a>

                    </div>

                </div>

                <div class="col-md-7 col-sm-5">

                    <div class="search-form">

                        <form action="search" method="post" class="navbar-form" role="search">

                            <div class="form-group">

                              <input type="text" value="${txtS}" name="txt" class="form-control" placeholder="What do you need...">

                            </div>

                            <button type="submit" class="btn"><i class="fa fa-search"></i></button>

                        </form>

                    </div>

                </div>

                <div class="col-md-2 col-sm-3">
                
                
                <c:if test="${sessionScope.acc != null}">
			                
			               <div class="cart">

                        <div class="cart-icon">
                        

                            <a href="cart"><i class="fa fa-shopping-cart"></i></a>

                        </div>

                        <div class="cart-text">

                            SHOPPING CART

                            <br>

                       

                        </div>

                    </div>
			     </c:if>
			            <c:if test="${sessionScope.acc == null}">
			                <div class="cart">

                        <div class="cart-icon">
                        

                            <a href="Login&Register.jsp"><i class="fa fa-shopping-cart"></i></a>

                        </div>

                        <div class="cart-text">

                            SHOPPING CART

                            <br>

                       

                        </div>

                    </div>
			            </c:if>

                    

                </div>

            </div>

        </div>

    </div>