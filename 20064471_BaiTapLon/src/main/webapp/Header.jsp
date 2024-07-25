<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="top-bar">

        <div class="container">

            <div class="row">

                <div class="col-md-6">

                    <div class="social pull-left">

                        <ul>

                            <li><a href=""><i class="fa fa-facebook"></i></a></li>

                            <li><a href=""><i class="fa fa-twitter"></i></a></li>

                            <li><a href=""><i class="fa fa-google-plus"></i></a></li>

                            <li><a href=""><i class="fa fa-linkedin"></i></a></li>

                        </ul>

                    </div>

                </div>

                <div class="col-md-6">

                    <div class="action pull-right">

                        <ul>

                            <li><a href="Login&Register.jsp"><i class="fa fa-user"></i> Login</a></li>

                            

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

                    <div class="cart">

                        <div class="cart-icon">

                            <a href=""><i class="fa fa-shopping-cart"></i></a>

                        </div>

                        <div class="cart-text">

                            SHOPPING CART

                            <br>

                            0 items - $0.00

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>