<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>

<html lang="en-US">

<head>

	<meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Orani E-Shop</title>

	<!-- Latest compiled and minified CSS -->

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

	<!-- Google Font -->

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700|Raleway:400,300,500,700,600' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" type="text/css">

    <!-- Theme Stylesheet -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet" href="css/responsive.css">

</head>

<body>

  <jsp:include page="Header.jsp"></jsp:include>

   

    <div class="navigation">

        <nav class="navbar navbar-theme">

          <div class="container">

            <!-- Brand and toggle get grouped for better mobile display -->

            <div class="navbar-header">

              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">

                <span class="sr-only">Menu</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

              </button>

            </div>

            

           <jsp:include page="Menu.jsp"></jsp:include>

          </div><!-- /.container-fluid -->

        </nav>

    </div>

   
    
   

    <div class="featured-items">

        <div class="container">

            <div class="row">

                <ul class="nav nav-tabs nav-product-tabs">

                    <li class="active"><a href="#trending" data-toggle="tab">ALL MOTOBIKE</a></li>

                    <li><a href="#best-seller" data-toggle="tab">NEW PRODUCTS</a></li>

                    

                    <li class="pull-right collection-url"><a href="http://localhost:8080/20064471_BaiTapLon/HomeControl">View All <i class="fa fa-long-arrow-right"></i></a></li>

                </ul>

                <div class="tab-content">

                    <div class="tab-pane active" id="trending">
						<c:forEach items="${productList}" var="o">
						    <div class="col-md-3 col-sm-4">
						        <div class="single-product">
						            <div class="product-block">
						                <img src="${o.image}" alt="" class="thumbnail">
						                <div class="product-description text-center">
						                   <p class="title">${o.title}</p>
						                    <p class="name"><a href="detail?pid=${o.id}">${o.name}</a></p>
						                   
						                    <p class="price"><fmt:formatNumber value="${o.price}" type="number"  groupingUsed="true" /> VND</p>
						                </div>
						                <div class="product-hover">
						                    <ul>
						                        <li><a href=" "><i class="fa fa-info-circle" aria-hidden="true"></i></a></li>
						                 
						                    </ul>
						                </div>
						            </div>
						        </div>
						    </div>
						</c:forEach>
						
						
						
						 <div>
       <%--  <c:if test="${not empty productList}">
            <p>productList has data!</p>
            <div>
                <c:forEach items="${productList}" var="o">
                    <p>${o.title}</p>
                    <!-- Display other properties as needed -->
                </c:forEach>
            </div>
        </c:if>
        <c:if test="${empty productList}">
            <p>productList is empty or not initialized.</p>
        </c:if> --%>
    </div>

                      

                      
                       

                  

                     

                       <!--  <div class="col-md-3 col-sm-4">

                            <div class="single-product">

                                <div class="product-block">

                                    <img src="images/product-8.jpg" alt="" class="thumbnail">

                                    <div class="product-description text-center">

                                        <p class="title">Date Tiffany Torchiere</p>

                                        <p class="price">$ 55.00</p>

                                    </div>

                                    <div class="product-hover">

                                        <ul>

                                            <li><a href=""><i class="fa fa-cart-arrow-down"></i></a></li>

                                            <li><a href=""><i class="fa fa-arrows-h"></i></a></li>

                                            <li><a href=""><i class="fa fa-heart-o"></i></a></li>

                                        </ul>

                                    </div>

                                </div>

                            </div>

                        </div> -->

                    </div>

                    <div class="tab-pane fade" id="best-seller">
                   <c:forEach items="${productListnew}" var="o">
						    <div class="col-md-3 col-sm-4">
						        <div class="single-product">
						            <div class="product-block">
						                <img src="${o.image}" alt="" class="thumbnail">
						                <div class="product-description text-center">
						                   <p class="title">${o.title}</p>
						                    <p class="name">${o.name}</p>
						                     <p class="description">${o.description}</p>
						                    <p class="price"><fmt:formatNumber value="${o.price}" type="number"  groupingUsed="true" />đ</p>
						                </div>
						                <div class="product-hover">
						                    <ul>
						                        <li><a href=""><i class="fa fa-cart-arrow-down"></i></a></li>
						                        <li><a href=""><i class="fa fa-arrows-h"></i></a></li>
						                        <li><a href=""><i class="fa fa-heart-o"></i></a></li>
						                    </ul>
						                </div>
						            </div>
						        </div>
						    </div>
						</c:forEach>
                    
                       

                    </div>

                </div>

            </div>

        </div>

    </div>
<jsp:include page="shopping-process.jsp"></jsp:include>
    <div class="popular-items">

        <div class="container">

            <div class="row">

                <ul class="nav nav-tabs nav-product-tabs">

                    <li class="active"><a href="#popular" data-toggle="tab">Popular</a></li>

                    <li><a href="#special" data-toggle="tab">Special</a></li>

                    <li class="pull-right collection-url"><a href="">View All <i class="fa fa-long-arrow-right"></i></a></li>

                </ul>

                <div class="tab-content">

                    <div class="tab-pane active" id="popular">

                        <div class="col-md-3 col-sm-4">

                            <div class="single-product">

                                <div class="product-block">

                                    <img src="images/product-16.jpg" alt="" class="thumbnail">

                                    <div class="product-description text-center">

                                        <p class="title">Date Tiffany Torchiere</p>

                                        <p class="price">$ 55.00</p>

                                    </div>

                                    <div class="product-hover">

                                        <ul>

                                            <li><a href=""><i class="fa fa-cart-arrow-down"></i></a></li>

                                            <li><a href=""><i class="fa fa-arrows-h"></i></a></li>

                                            <li><a href=""><i class="fa fa-heart-o"></i></a></li>

                                        </ul>

                                    </div>

                                </div>

                            </div>

                        </div>


                        

                    </div>

                    <div class="tab-pane fade" id="special">

                        

                        <div class="col-md-3 col-sm-4">

                            <div class="single-product">

                                <div class="product-block">

                                    <img src="images/product-7.jpg" alt="" class="thumbnail">

                                    <div class="product-description text-center">

                                        <p class="title">Date Tiffany Torchiere</p>

                                        <p class="price">$ 55.00</p>

                                    </div>

                                    <div class="product-hover">

                                        <ul>

                                            <li><a href=""><i class="fa fa-cart-arrow-down"></i></a></li>

                                            <li><a href=""><i class="fa fa-arrows-h"></i></a></li>

                                            <li><a href=""><i class="fa fa-heart-o"></i></a></li>

                                        </ul>

                                    </div>

                                </div>

                            </div>

                        </div>

                        <div class="col-md-3 col-sm-4">

                            <div class="single-product">

                                <div class="product-block">

                                    <img src="images/product-6.jpg" alt="" class="thumbnail">

                                    <div class="product-description text-center">

                                        <p class="title">Date Tiffany Torchiere</p>

                                        <p class="price">$ 55.00</p>

                                    </div>

                                    <div class="product-hover">

                                        <ul>

                                            <li><a href=""><i class="fa fa-cart-arrow-down"></i></a></li>

                                            <li><a href=""><i class="fa fa-arrows-h"></i></a></li>

                                            <li><a href=""><i class="fa fa-heart-o"></i></a></li>

                                        </ul>

                                    </div>

                                </div>

                            </div>

                        </div>

                      

                        

                        <div class="col-md-3 col-sm-4">

                            <div class="single-product">

                                <div class="product-block">

                                    <img src="images/product-1.jpg" alt="" class="thumbnail">

                                    <div class="product-description text-center">

                                        <p class="title">Date Tiffany Torchiere</p>

                                        <p class="price">$ 55.00</p>

                                    </div>

                                    <div class="product-hover">

                                        <ul>

                                            <li><a href=""><i class="fa fa-cart-arrow-down"></i></a></li>

                                            <li><a href=""><i class="fa fa-arrows-h"></i></a></li>

                                            <li><a href=""><i class="fa fa-heart-o"></i></a></li>

                                        </ul>

                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>

  

<jsp:include page="Footer.jsp"></jsp:include>

	<!-- jQuery Library -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	<!-- Script -->

	<script src="js/script.js"></script>

</body>

