<%-- 
    Document   : newjsp
    Created on : Feb 20, 2022, 4:30:41 PM
    Author     : 84337
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="controller.Product"%>
<%@page import="controller.Product"%>
<%@page import="controller.Account"%>
<%@page import="model.DAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    DAO aDAL = new DAO();
    Account currAcc = aDAL.getAccountByUsername((String) session.getAttribute("user"));
    request.setAttribute("currAcc", currAcc);
    List<Product> listTotal = (List<Product>) session.getAttribute("listCart");
    float total = 0;
    for (Product p : listTotal) {
        total += p.getTotal();
    }
    request.setAttribute("total", total);
%>  

<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Thanh toán</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->
        <!--    <link rel="stylesheet" href="css/bootstrap.min.css">-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
              integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <!-- Start Main Top -->

        <!-- End Main Top -->

        <!-- Start Main Top -->
        <header class="main-header">
            <!-- Start Navigation -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
                <div class="container">
                    <!-- Start Header Navigation -->
                    <div class="navbar-header">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="index.html"><img src="https://picresize.com/images/rsz_12logo.png" class="logo" alt=""></a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="nav-item"><a class="nav-link" href="home">Trang chủ</a></li>
                                <c:choose>
                                    <c:when test="${sessionScope.user == null || sessionScope.pass == null}">
                                        ${'<li class="nav-item"><a class="nav-link" href="signin">Sign In <i class="fas fa-sign-in-alt"></i></a></li>'}
                                    </c:when>
                                    <c:otherwise>
                                        ${'<li class="nav-item"><a class="nav-link" href="account.jsp">Tài khoản <i class="fas fa-user-circle"></i></a></li>'}
                                    </c:otherwise>
                                </c:choose>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->

                    <!-- Start Atribute Navigation -->
                    <div class="attr-nav">
                        <ul>

                            <li class="side-menu"><a href="cart">
                                    <i class="fa fa-shopping-bag"></i>
                                    <span class="badge"></span>
                                    <p>Giỏ hàng</p>
                                </a></li>
                        </ul>
                    </div>
                    <!-- End Atribute Navigation -->
                </div>
                <!-- Start Side Menu -->

                <!-- End Side Menu -->
            </nav>
            <!-- End Navigation -->
        </header>
        <!-- End Main Top -->

        <!-- Start Top Search -->
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                </div>
            </div>
        </div>
        <!-- End Top Search -->

        <!-- Start All Title Box -->
        <div class="all-title-box">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Thanh toán</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Thanh toán</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start Cart  -->
        <div class="cart-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="checkout-address">
                            <div class="title-left">
                                <h3>Địa chỉ nhận hàng</h3>
                            </div>
                            <form class="needs-validation" novalidate>
                                <div class="mb-3">
                                    <label for="firstName">Họ và Tên *</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" value="<c:out value="${currAcc.fullname}"/>"readonly="">
                                    <div class="invalid-feedback"> Tên không hợp lệ. </div>
                                </div>
                                <div class="mb-3">
                                    <label for="address">Địa chỉ *</label>
                                    <input type="text" class="form-control" id="address" placeholder="" value="<c:out value="${currAcc.address}"/>" readonly="">
                                    <div class="invalid-feedback"> Vui lòng nhập địa chỉ nhận hàng. </div>
                                </div>
                                <div class="mb-3">
                                    <label for="phone">Số điện thoại *</label>
                                    <input type="text" class="form-control" id="phone" placeholder="" value="<c:out value="${currAcc.phone}"/>" readonly="">
                                    <div class="invalid-feedback"> Vui lòng nhập số điện thoại. </div>
                                </div>
                                <div class="mb-3">
                                    <label for="email">Email *</label>
                                    <input type="email" class="form-control" id="email" placeholder="" value="<c:out value="${currAcc.email}"/>" readonly="">
                                    <div class="invalid-feedback"> Vui lonhf nhập email để cập nhật tình hình sản phẩm </div>
                                </div>


                                <hr class="mb-4">
                                <div class="title"> <span>Hình thức thanh toán</span> </div>
                                <div class="d-block my-3">
                                    <div class="custom-control custom-radio">
                                        <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                                        <label class="custom-control-label" for="credit">Tiền mặt</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                                        <label class="custom-control-label" for="debit">Quẹt thẻ</label>
                                    </div>
                                </div>
                                <hr class="mb-1"> </form>
                        </div>
                        <div class="shipping-method-box">
                            <div class="title-left">
                                <h3>Đơn vị vận chuyển</h3>
                            </div>
                            <div class="mb-4">
                                <div class="custom-control custom-radio">
                                    <input id="shippingOption1" name="shipping-option" class="custom-control-input" checked="checked" type="radio">
                                    <label class="custom-control-label" for="shippingOption1">Giao Hàng Tiết Kiệm</label> <span class="float-right font-weight-bold">MIỄN PHÍ</span> 
                                </div>
                                <div class="ml-4 mb-2 small">(3-7 ngày làm việc)</div>
                                <div class="custom-control custom-radio">
                                    <input id="shippingOption2" name="shipping-option" class="custom-control-input" type="radio">
                                    <label class="custom-control-label" for="shippingOption2">BEST Express</label> <span class="float-right font-weight-bold">MIỄN PHÍ</span> 
                                </div>
                                <div class="ml-4 mb-2 small">(2-4 ngày làm việc)</div>
                                <div class="custom-control custom-radio">
                                    <input id="shippingOption3" name="shipping-option" class="custom-control-input" type="radio">
                                    <label class="custom-control-label" for="shippingOption3">Ninja Van</label> <span class="float-right font-weight-bold">MIỄN PHÍ</span> 
                                </div>
                                <div class="ml-4 mb-2 small">(3-5 ngày làm việc)</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="row">

                            <div class="col-md-12 col-lg-12">
                                <div class="odr-box">
                                    <div class="title-left">
                                        <h3>Chi tiết thanh toán</h3>
                                    </div>
                                    <c:forEach items="${listCart}" var="cart">
                                        <div class="rounded p-2 bg-light">
                                            <div class="media mb-2 border-bottom">
                                                <div class="media-body"> <a href="detail?pid=${cart.pid}"> ${cart.name}</a>
                                                    <div class="small text-muted">Giá: $${cart.price} <span class="mx-2">|</span> S.lượng: ${cart.quantity} <span class="mx-2">|</span> Tổng: $${cart.getTotal()}</div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-12">
                                <div class="order-box">
                                    <div class="title-left">
                                        <h3>Đơn hàng của bạn</h3>
                                    </div>
                                    <div class="d-flex">
                                        <div class="font-weight-bold">Sản Phẩm</div>
                                        <div class="ml-auto font-weight-bold">Thành tiền</div>
                                    </div>

                                    <div class="d-flex">
                                        <h4>Thuế</h4>
                                        <div class="ml-auto font-weight-bold"> $ 0 </div>
                                    </div>
                                    <div class="d-flex">
                                        <h4>Tiền Ship</h4>
                                        <div class="ml-auto font-weight-bold"> Miễn Phí </div>
                                    </div>
                                    <hr>
                                    <div class="d-flex gr-total">
                                        <h5>Tổng cộng</h5>
                                        <div class="ml-auto h5"> $ <c:out value="${total}"/> </div>
                                    </div>
                                    <hr> </div>
                            </div>
                            <div class="col-12 d-flex shopping-box"> 
                                <div class="col-12 d-flex shopping-box"> 
                                    <a href="pay" class="ml-auto btn hvr-hover">Đặt Hàngr</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- End Cart -->

        


        <!-- Start Footer  -->
        <footer>
            <div class="footer-main">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-12 col-sm-12">
                            <div class="footer-top-box">
                                <h3>Office Address</h3>
                                <ul class="list-time">
                                    <li>Trường Đại học FPT Hà Nội</li><li>Km29 - Đại lộ Thăng Long</li> <li>Khu CNC Hòa Lạc</li> <li>xã Thạch Hòa, huyện Thạch Thất</li> <li>Thành phố Hà Nội</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-12 col-sm-12">
                            <div class="footer-top-box">
                                <h3>News</h3>
                                <form class="newsletter-box">
                                    <div class="form-group">
                                        <input class="" type="email" name="Email" placeholder="Email Address*" />
                                        <i class="fa fa-envelope"></i>
                                    </div>
                                    <button class="btn hvr-hover" type="submit">Submit</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-12 col-sm-12">
                            <div class="footer-top-box">
                                <h3>Social Media</h3>
                                <p></p>
                                <ul>
                                    <li><a href="#"><i class="fab fa-facebook" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-twitter" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-linkedin" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-google-plus" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-pinterest-p" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-whatsapp" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
        </footer>
        <!-- End Footer  -->

        <!-- Start copyright  -->
<!--        <div class="footer-copyright">
            <p class="footer-company">2021 &copy; by <a href="https://www.facebook.com/HoangHung.Trijnh/" target="_blank">Trinh Hoang Hung</a> - PRJ321 Summer 2021
        </div>-->
        <!-- End copyright  -->

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- ALL PLUGINS -->
        <script src="js/jquery.superslides.min.js"></script>
        <script src="js/bootstrap-select.js"></script>
        <script src="js/inewsticker.js"></script>
        <script src="js/bootsnav.js."></script>
        <script src="js/images-loded.min.js"></script>
        <script src="js/isotope.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/baguetteBox.min.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>
        <script src="https://kit.fontawesome.com/228aa84c51.js" crossorigin="anonymous"></script>
    </body>

</html>