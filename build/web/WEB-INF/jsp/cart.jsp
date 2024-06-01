<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Ansonika">
        <title>Allaia | Bootstrap eCommerce Template - ThemeForest</title>

        <!-- Favicons-->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" type="image/x-icon" href="img/apple-touch-icon-57x57-precomposed.png">
        <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="img/apple-touch-icon-72x72-precomposed.png">
        <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="img/apple-touch-icon-114x114-precomposed.png">
        <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="img/apple-touch-icon-144x144-precomposed.png">

        <!-- GOOGLE WEB FONT -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">

        <!-- BASE CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

        <!-- SPECIFIC CSS -->
        <link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet">

        <!-- YOUR CUSTOM CSS -->
        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

    </head>

    <body>

        <div id="page">

            <%@include file="header.jsp" %>
            <!-- /header -->

            <main class="bg_gray">
                <div class="container margin_30">
                    <div class="page_header">
                        <div class="breadcrumbs">
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Category</a></li>
                                <li>Page active</li>
                            </ul>
                        </div>
                        
                        <c:choose>
                            <c:when test="${empty login}">
                                <h1>Cart page</h1>
                            </c:when>
                            <c:otherwise>  
                                <h1>Cart page of ${login.memberName} </h1>

                            </c:otherwise>
                        </c:choose>
                    </div>

                    <c:choose>
                        <c:when test="${empty sessionScope.myCartItems}">
                            <h1>Vui lòng trở về trang chủ mua hàng</h1>
                            <form action="${pageContext.request.contextPath}/index.htm" method="get">
                                <div class="col-sm-4 text-end">
                                    <button type="submit">Go Home</button>
                                </div>
                            </form>
                        </c:when>
                        <c:otherwise>  
                            <table class="table table-striped cart-list">
                                <thead>
                                    <tr>
                                        <th>
                                            Product
                                        </th>
                                        <th>
                                            Price
                                        </th>
                                        <th></th>
                                        <th></th>
                                        <th>
                                            Quantity
                                        </th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th>
                                            Subtotal
                                        </th>
                                        <th>

                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="map" items="${sessionScope.myCartItems}">
                                        <tr>
                                            <td>
                                                <div class="thumb_cart">
                                                    <img src="${pageContext.request.contextPath}/${map.value.product.picture}" data-src="${pageContext.request.contextPath}/${map.value.product.picture}" class="lazy" alt="Image">
                                                </div>
                                                <span class="item_cart">${map.value.product.productName}</span>
                                            </td>
                                            <td>
                                                <strong>${map.value.product.price}</strong>
                                            </td>
                                            <td></td>
                                            <td><div class="button-cart" ><a href="${pageContext.request.contextPath}/cart/deletecart/${map.key}.htm" >-</a></div></td>
                                            <td>
                                                <div class="numbers-list">
                                                    <input type="text" value="${map.value.quantity}" id="quantity_2" class="qty2" name="quantity_2">
                                                </div>
                                            </td>
                                            <td><div class="button-cart"><a href="${pageContext.request.contextPath}/cart/addcart/${map.key}.htm">+</a></div></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>
                                                <strong>${map.value.product.price * map.value.quantity}</strong>
                                            </td>
                                            <td class="options">
                                                <a href="${pageContext.request.contextPath}/cart/remove/${map.key}.htm"><i class="ti-trash"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>




                    <div class="row add_top_30 flex-sm-row-reverse cart_actions">
                        <div class="col-sm-4 text-end">
                            <button type="button" class="btn_1 gray"><a href="${pageContext.request.contextPath}/cart/clearCart.htm">Clean cart</a></button> 
                        </div>
                        <div class="col-sm-8">
                            <div class="apply-coupon">
                                <div class="form-group">
                                    <div class="row g-2">
                                        <form action="${pageContext.request.contextPath}/cart/cartship.htm" method="post">
                                            <label for="shipperName">Chọn đối tác vận chuyển:</label>
                                            <select id="shipperName" name="shipperName" onchange="updateShippingCost()">
                                                <c:forEach var="de" items="${listde}">
                                                    <option value="${de.getShipperName()}">${de.getShipperName()}</option>
                                                </c:forEach>
                                            </select>
                                            <input type="submit" value="Submit">
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="box_cart">
                        <div class="container">
                            <div class="row justify-content-end">
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <ul>
                                        <li>
                                            <span>Subtotal</span> ${sessionScope.myCartTotal}
                                        </li>
                                        <li>
                                            <span>Shipping</span> ${deliveries.getPrice() +0}
                                        </li>
                                        <li>
                                            <span>Total</span> ${sessionScope.myCartTotal + deliveries.getPrice()} 
                                        </li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- /box_cart -->



                    <form action="${pageContext.request.contextPath}/check/checkout.htm" method="post">
                        <c:forEach var="pay" items="${pay}">
                            <label class="container_radio" style="display: inline-block; margin-right: 15px;">
                            ${pay.paymentName}
                            <input type="radio" name="status" value="${pay.paymentID}" checked>
                            <span class="checkmark"></span>
                        </label>
                        </c:forEach>
                        
                        <input type="hidden" name="deliveryID" value="${deliveries.getDeliveryID()}">
                        <div>Địa chỉ nhận hàng</div>
                        <div class="col-md-6">
                            <input type="text" name="shipAddress" value="${login.address}" class="form-control">
                            <input type="hidden" name="phone" value="${login.phone}" class="form-control">
                            <input type="hidden" name="total" value="${sessionScope.myCartTotal + deliveries.getPrice()}" class="form-control">
                        </div>
                        
                        <br>
                        <button type="submit" class="btn_1 full-width cart">check out </button>

                    </form>


                </div>
                <!-- /container -->



            </main>
            <!--/main-->

            <%@include file="footer.jsp" %>
            <!--/footer-->
        </div>
        <!-- page -->

        <div id="toTop"></div><!-- Back to top button -->

        <!-- COMMON SCRIPTS -->
        <script src="${pageContext.request.contextPath}/js/common_scripts.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>

        <!-- SPECIFIC SCRIPTS -->
        <script src="${pageContext.request.contextPath}/js/sticky_sidebar.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/specific_listing.js"></script>


    </body>
</html>