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
                        <h1>Cart page</h1>
                    </div>
                    <!-- /page_header -->
                    <table class="table table-striped cart-list">
                        <thead>
                            <tr>
                                <th>
                                    Product
                                </th>
                                <th>
                                    Price
                                </th>
                                <th>
                                    Quantity
                                </th>
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
                                    <td>
                                        <div class="numbers-row"><input type="text" value="${map.value.quantity}" id="quantity_1" class="qty2" name="quantity_1">
                                            <div class="inc button_inc"><a href="${pageContext.request.contextPath}/cart/addcart/${map.key}.htm">+</a></div><div class="dec button_inc"><a href="${pageContext.request.contextPath}/cart/deletecart/${map.key}.htm">-</a></div></div>
                                    </td>
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

                    <div class="row add_top_30 flex-sm-row-reverse cart_actions">

                        <div class="col-sm-4 text-end">
                            <form action="${pageContext.request.contextPath}/cart/clearCart.htm" method="post">
                                <button type="button" class="btn_1 gray">clean cart</button> 
                            </form>
                        </div>

                        <div class="col-sm-8">
                            <div class="apply-coupon">
                                <div class="form-group">
                                    <div class="row g-2">
                                        <div class="col-md-6"><input type="text" name="coupon-code" value="" placeholder="Promo code" class="form-control"></div>
                                        <div class="col-md-4"><button type="button" class="btn_1 outline">Apply Coupon</button></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /cart_actions -->

                </div>
                <!-- /container -->

                <div class="box_cart">
                    <div class="container">
                        <div class="row justify-content-end">
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <ul>
                                    <li>
                                        <span>Subtotal</span> ${sessionScope.myCartTotal}
                                    </li>
                                    <li>
                                        <span>Shipping</span> $7.00
                                    </li>
                                    <li>
                                        <span>Total</span> ${sessionScope.myCartTotal + 7} 
                                    </li>
                                </ul>
                                <a href="cart-2.html" class="btn_1 full-width cart">Proceed to Checkout</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /box_cart -->

            </main>
            <!--/main-->

            <%@include file="footer.jsp" %>
            <!--/footer-->
        </div>
        <!-- page -->

        <div id="toTop"></div><!-- Back to top button -->

        <!-- COMMON SCRIPTS -->
        <script src="js/common_scripts.min.js"></script>
        <script src="js/main.js"></script>


    </body>
</html>