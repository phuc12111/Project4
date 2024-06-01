<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
        <link href="${pageContext.request.contextPath}/css/home_1.css" rel="stylesheet">

        <!-- YOUR CUSTOM CSS -->
        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
        <style>
            /* Popup form styling */
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                padding-top: 100px;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.4);
            }

            .modal-content {
                background-color: #FFF;
                margin-bottom: 0px;
                padding: 20px;
                border: 1px solid #555;
                width: 50%;
                color: black;
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: white;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <div id="page">

            <%@include file="header.jsp" %>s

            <main>
                <div id="carousel-home">
                    <div class="owl-carousel owl-theme">
                        <div class="owl-slide cover" style="background-image: url(img/slides/slide_home_2.jpg);">
                            <div class="opacity-mask d-flex align-items-center" data-opacity-mask="rgba(0, 0, 0, 0.5)">
                                <div class="container">
                                    <div class="row justify-content-center justify-content-md-end">
                                        <div class="col-lg-6 static">
                                            <div class="slide-text text-end white">
                                                <h2 class="owl-slide-animated owl-slide-title">Attack Air<br>Max 720 Sage Low</h2>
                                                <p class="owl-slide-animated owl-slide-subtitle">
                                                    Limited items available at this price
                                                </p>
                                                <div class="owl-slide-animated owl-slide-cta"><a class="btn_1" href="listing-grid-1-full.html" role="button">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--/owl-slide-->
                        <div class="owl-slide cover" style="background-image: url(img/slides/slide_home_1.jpg);">
                            <div class="opacity-mask d-flex align-items-center" data-opacity-mask="rgba(0, 0, 0, 0.5)">
                                <div class="container">
                                    <div class="row justify-content-center justify-content-md-start">
                                        <div class="col-lg-6 static">
                                            <div class="slide-text white">
                                                <h2 class="owl-slide-animated owl-slide-title">Attack Air<br>VaporMax Flyknit 3</h2>
                                                <p class="owl-slide-animated owl-slide-subtitle">
                                                    Limited items available at this price
                                                </p>
                                                <div class="owl-slide-animated owl-slide-cta"><a class="btn_1" href="listing-grid-1-full.html" role="button">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--/owl-slide-->
                        <div class="owl-slide cover" style="background-image: url(img/slides/slide_home_3.jpg);">
                            <div class="opacity-mask d-flex align-items-center" data-opacity-mask="rgba(255, 255, 255, 0.5)">
                                <div class="container">
                                    <div class="row justify-content-center justify-content-md-start">
                                        <div class="col-lg-12 static">
                                            <div class="slide-text text-center black">
                                                <h2 class="owl-slide-animated owl-slide-title">Attack Air<br>Monarch IV SE</h2>
                                                <p class="owl-slide-animated owl-slide-subtitle">
                                                    Lightweight cushioning and durable support with a Phylon midsole
                                                </p>
                                                <div class="owl-slide-animated owl-slide-cta"><a class="btn_1" href="listing-grid-1-full.html" role="button">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--/owl-slide-->
                        </div>
                    </div>
                    <div id="icon_drag_mobile"></div>
                </div>
                <!--/carousel-->

                <ul id="banners_grid" class="clearfix">
                    <li>
                        <a href="#0" class="img_container">
                            <img src="img/banners_cat_placeholder.jpg" data-src="img/banner_1.jpg" alt="" class="lazy">
                            <div class="short_info opacity-mask" data-opacity-mask="rgba(0, 0, 0, 0.5)">
                                <h3>Men's Collection</h3>
                                <div><span class="btn_1">Shop Now</span></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#0" class="img_container">
                            <img src="img/banners_cat_placeholder.jpg" data-src="img/banner_2.jpg" alt="" class="lazy">
                            <div class="short_info opacity-mask" data-opacity-mask="rgba(0, 0, 0, 0.5)">
                                <h3>Womens's Collection</h3>
                                <div><span class="btn_1">Shop Now</span></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#0" class="img_container">
                            <img src="img/banners_cat_placeholder.jpg" data-src="img/banner_3.jpg" alt="" class="lazy">
                            <div class="short_info opacity-mask" data-opacity-mask="rgba(0, 0, 0, 0.5)">
                                <h3>Kids's Collection</h3>
                                <div><span class="btn_1">Shop Now</span></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!--/banners_grid -->

                <div class="container margin_60_35">
                    <div class="main_title">
                        <h2>Top Selling</h2>
                        <span>Products</span>
                        <p>Cum doctus civibus efficiantur in imperdiet deterruisset</p>
                    </div>
                    <div class="row small-gutters">
                        <c:forEach var="pro" items="${listPro}" varStatus="status">
                            <div class="col-6 col-md-4 col-xl-3">
                                <div class="grid_item">
                                    <figure>
                                        <span class="ribbon off">-30%</span>
                                        <a href="product-detail-1.html">
                                            <img class="img-fluid lazy" src="${pageContext.request.contextPath}/${pro.picture}" data-src="${pageContext.request.contextPath}/${pro.picture}" alt="">
                                        </a>
                                        <div data-countdown="2019/05/15" class="countdown"></div>
                                    </figure>
                                    <div class="rating">
                                        <i class="icon-star voted"></i>
                                        <i class="icon-star voted"></i>
                                        <i class="icon-star voted"></i>
                                        <i class="icon-star voted"></i>
                                        <i class="icon-star"></i>
                                    </div>
                                    <a href="product-detail-1.html">
                                        <h3>${pro.productName}</h3>
                                    </a>
                                    <div class="price_box">
                                        <span class="new_price">${pro.price}</span>
                                        <span class="old_price">$60.00</span>
                                    </div>
                                    <ul>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/favourites/add/${pro.productID}/${login.phone}.htm"  class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favorites">
                                                <i class="ti-heart" style="justify-content: center; align-items: center;"></i><span>Add to favorites</span>
                                            </a>
                                        </li>
                                        <li>
                                            <form id="favouritesForm" action="/favourites/add" method="post" style="display:none;">
                                                <input type="hidden" name="productID" value="${pro.productID}" />
                                                <input type="hidden" name="phone" value="${login.phone}" />
                                            </form>
                                            <a onclick="showAddAlbumForm(${pro.productID})" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favourites" onclick="document.getElementById('favouritesForm').submit();">
                                                <i class="ti-control-shuffle"></i><span>Add to favourites</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/cart/add/${pro.productID}.htm" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to cart">
                                                <i class="ti-shopping-cart"></i><span>Add to cart</span>
                                            </a>
                                        </li>
                                    </ul>
                                    <!-- Hidden input field to store the productID -->
                                    <input type="hidden" id="productID_${pro.productID}" name="productID" value="${pro.productID}">
                                </div>
                                <!-- /grid_item -->
                            </div>
                        </c:forEach>
                        <!-- /col -->
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->

                <div class="featured lazy" data-bg="url(img/featured_home.jpg)">
                    <div class="opacity-mask d-flex align-items-center" data-opacity-mask="rgba(0, 0, 0, 0.5)">
                        <div class="container margin_60">
                            <div class="row justify-content-center justify-content-md-start">
                                <div class="col-lg-6 wow" data-wow-offset="150">
                                    <h3>Armor<br>Air Color 720</h3>
                                    <p>Lightweight cushioning and durable support with a Phylon midsole</p>
                                    <div class="feat_text_block">
                                        <div class="price_box">
                                            <span class="new_price">$90.00</span>
                                            <span class="old_price">$170.00</span>
                                        </div>
                                        <a class="btn_1" href="listing-grid-1-full.html" role="button">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /featured -->

                <div class="container margin_60_35">
                    <div class="main_title">
                        <h2>Featured</h2>
                        <span>Products</span>
                        <p>Cum doctus civibus efficiantur in imperdiet deterruisset</p>
                    </div>
                    <div class="owl-carousel owl-theme products_carousel">
                        <div class="item">
                            <div class="grid_item">
                                <span class="ribbon new">New</span>
                                <figure>
                                    <a href="product-detail-1.html">
                                        <img class="owl-lazy" src="img/products/product_placeholder_square_medium.jpg" data-src="img/products/shoes/4.jpg" alt="">
                                    </a>
                                </figure>
                                <div class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star"></i></div>
                                <a href="product-detail-1.html">
                                    <h3>ACG React Terra</h3>
                                </a>
                                <div class="price_box">
                                    <span class="new_price">$110.00</span>
                                </div>
                                <ul>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favorites"><i class="ti-heart"></i><span>Add to favorites</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to compare"><i class="ti-control-shuffle"></i><span>Add to compare</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to cart"><i class="ti-shopping-cart"></i><span>Add to cart</span></a></li>
                                </ul>
                            </div>
                            <!-- /grid_item -->
                        </div>
                        <!-- /item -->
                        <div class="item">
                            <div class="grid_item">
                                <span class="ribbon new">New</span>
                                <figure>
                                    <a href="product-detail-1.html">
                                        <img class="owl-lazy" src="img/products/product_placeholder_square_medium.jpg" data-src="img/products/shoes/5.jpg" alt="">
                                    </a>
                                </figure>
                                <div class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star"></i></div>
                                <a href="product-detail-1.html">
                                    <h3>Air Zoom Alpha</h3>
                                </a>
                                <div class="price_box">
                                    <span class="new_price">$140.00</span>
                                </div>
                                <ul>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favorites"><i class="ti-heart"></i><span>Add to favorites</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to compare"><i class="ti-control-shuffle"></i><span>Add to compare</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to cart"><i class="ti-shopping-cart"></i><span>Add to cart</span></a></li>
                                </ul>
                            </div>
                            <!-- /grid_item -->
                        </div>
                        <!-- /item -->
                        <div class="item">
                            <div class="grid_item">
                                <span class="ribbon hot">Hot</span>
                                <figure>
                                    <a href="product-detail-1.html">
                                        <img class="owl-lazy" src="img/products/product_placeholder_square_medium.jpg" data-src="img/products/shoes/8.jpg" alt="">
                                    </a>
                                </figure>
                                <div class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star"></i></div>
                                <a href="product-detail-1.html">
                                    <h3>Air Color 720</h3>
                                </a>
                                <div class="price_box">
                                    <span class="new_price">$120.00</span>
                                </div>
                                <ul>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favorites"><i class="ti-heart"></i><span>Add to favorites</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to compare"><i class="ti-control-shuffle"></i><span>Add to compare</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to cart"><i class="ti-shopping-cart"></i><span>Add to cart</span></a></li>
                                </ul>
                            </div>
                            <!-- /grid_item -->
                        </div>
                        <!-- /item -->
                        <div class="item">
                            <div class="grid_item">
                                <span class="ribbon off">-30%</span>
                                <figure>
                                    <a href="product-detail-1.html">
                                        <img class="owl-lazy" src="img/products/product_placeholder_square_medium.jpg" data-src="img/products/shoes/2.jpg" alt="">
                                    </a>
                                </figure>
                                <div class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star"></i></div>
                                <a href="product-detail-1.html">
                                    <h3>Okwahn II</h3>
                                </a>
                                <div class="price_box">
                                    <span class="new_price">$90.00</span>
                                    <span class="old_price">$170.00</span>
                                </div>
                                <ul>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favorites"><i class="ti-heart"></i><span>Add to favorites</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to compare"><i class="ti-control-shuffle"></i><span>Add to compare</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to cart"><i class="ti-shopping-cart"></i><span>Add to cart</span></a></li>
                                </ul>
                            </div>
                            <!-- /grid_item -->
                        </div>
                        <!-- /item -->
                        <div class="item">
                            <div class="grid_item">
                                <span class="ribbon off">-50%</span>
                                <figure>
                                    <a href="product-detail-1.html">
                                        <img class="owl-lazy" src="img/products/product_placeholder_square_medium.jpg" data-src="img/products/shoes/3.jpg" alt="">
                                    </a>
                                </figure>
                                <div class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star"></i></div>
                                <a href="product-detail-1.html">
                                    <h3>Air Wildwood ACG</h3>
                                </a>
                                <div class="price_box">
                                    <span class="new_price">$75.00</span>
                                    <span class="old_price">$155.00</span>
                                </div>
                                <ul>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favorites"><i class="ti-heart"></i><span>Add to favorites</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to compare"><i class="ti-control-shuffle"></i><span>Add to compare</span></a></li>
                                    <li><a href="#0" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to cart"><i class="ti-shopping-cart"></i><span>Add to cart</span></a></li>
                                </ul>
                            </div>
                            <!-- /grid_item -->
                        </div>
                        <!-- /item -->
                    </div>
                    <!-- /products_carousel -->
                </div>
                <!-- /container -->

                <div class="bg_gray">
                    <div class="container margin_30">
                        <div id="brands" class="owl-carousel owl-theme">
                            <c:forEach var="sup" items="${listSupplier}" varStatus="status">
                                <div class="item">
                                    <a href="#0"><img src="${pageContext.request.contextPath}/${sup.picture}" data-src="${pageContext.request.contextPath}/${sup.picture}" alt="" class="owl-lazy"></a>
                                </div><!-- /item -->
                            </c:forEach>

                        </div><!-- /carousel -->
                    </div><!-- /container -->
                </div>
                <!-- /bg_gray -->

                <div class="container margin_60_35">
                    <div class="main_title">
                        <h2>Latest News</h2>
                        <span>Blog</span>
                        <p>Cum doctus civibus efficiantur in imperdiet deterruisset</p>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <a class="box_news" href="blog.html">
                                <figure>
                                    <img src="img/blog-thumb-placeholder.jpg" data-src="img/blog-thumb-1.jpg" alt="" width="400" height="266" class="lazy">
                                    <figcaption><strong>28</strong>Dec</figcaption>
                                </figure>
                                <ul>
                                    <li>by Mark Twain</li>
                                    <li>20.11.2017</li>
                                </ul>
                                <h4>Pri oportere scribentur eu</h4>
                                <p>Cu eum alia elit, usu in eius appareat, deleniti sapientem honestatis eos ex. In ius esse ullum vidisse....</p>
                            </a>
                        </div>
                        <!-- /box_news -->
                        <div class="col-lg-6">
                            <a class="box_news" href="blog.html">
                                <figure>
                                    <img src="img/blog-thumb-placeholder.jpg" data-src="img/blog-thumb-2.jpg" alt="" width="400" height="266" class="lazy">
                                    <figcaption><strong>28</strong>Dec</figcaption>
                                </figure>
                                <ul>
                                    <li>By Jhon Doe</li>
                                    <li>20.11.2017</li>
                                </ul>
                                <h4>Duo eius postea suscipit ad</h4>
                                <p>Cu eum alia elit, usu in eius appareat, deleniti sapientem honestatis eos ex. In ius esse ullum vidisse....</p>
                            </a>
                        </div>
                        <!-- /box_news -->
                        <div class="col-lg-6">
                            <a class="box_news" href="blog.html">
                                <figure>
                                    <img src="img/blog-thumb-placeholder.jpg" data-src="img/blog-thumb-3.jpg" alt="" width="400" height="266" class="lazy">
                                    <figcaption><strong>28</strong>Dec</figcaption>
                                </figure>
                                <ul>
                                    <li>By Luca Robinson</li>
                                    <li>20.11.2017</li>
                                </ul>
                                <h4>Elitr mandamus cu has</h4>
                                <p>Cu eum alia elit, usu in eius appareat, deleniti sapientem honestatis eos ex. In ius esse ullum vidisse....</p>
                            </a>
                        </div>
                        <!-- /box_news -->
                        <div class="col-lg-6">
                            <a class="box_news" href="blog.html">
                                <figure>
                                    <img src="img/blog-thumb-placeholder.jpg" data-src="img/blog-thumb-4.jpg" alt="" width="400" height="266" class="lazy">
                                    <figcaption><strong>28</strong>Dec</figcaption>
                                </figure>
                                <ul>
                                    <li>By Paula Rodrigez</li>
                                    <li>20.11.2017</li>
                                </ul>
                                <h4>Id est adhuc ignota delenit</h4>
                                <p>Cu eum alia elit, usu in eius appareat, deleniti sapientem honestatis eos ex. In ius esse ullum vidisse....</p>
                            </a>
                        </div>
                        <!-- /box_news -->
                    </div>
                    <!-- /row -->
                </div>
                <!-- Popup form -->
                <div id="addAlbumModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="closeAddAlbumForm()">&times;</span>
                        <h6 class="mb-0">Add Album</h6>
                        <form id="addAlbumForm" action="${pageContext.request.contextPath}/albums/adddetail.htm" method="post">
                            <!-- Hidden input fields to store the selected album and product IDs -->
                            <input type="hidden" id="selectedAlbumID" name="albumID" value="">
                            <input type="hidden" id="selectedProductID" name="productID" value="">
                            <table class="table table-striped cart-list">
                                <thead>
                                    <tr>
                                        <th>Album Name</th>
                                        <th>Product ID</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="alb" items="${albums}">
                                        <tr>
                                            <td>
                                                <label class="container_radio" style="display: inline-block; margin-right: 15px;">
                                                    <input type="radio" name="albumID" value="${alb.albumID}" onchange="updateSelectedAlbum(this)">
                                                    <span class="">${alb.albumName}</span>
                                                    <span class="checkmark"></span>
                                                </label>
                                            </td>
                                            <td>
                                                <span id="displayedProductID"></span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <button type="submit" class="btn btn-primary">Add Album</button>
                        </form>
                    </div>
                </div>
                <!-- /container -->
            </main>
            <!-- /main -->

            <%@include file="footer.jsp" %>
        </div>
        <!-- page -->
        <!--	<div class="popup_wrapper">
                        <div class="popup_content">
                                <span class="popup_close">Close</span>
                                <a href="listing-grid-1-full.html"><img class="img-fluid" src="img/banner_popup.png" alt="" width="500" height="500"></a>
                        </div>
                </div>-->
        <div id="toTop"></div><!-- Back to top button -->

    </div>

    <!-- COMMON SCRIPTS -->
    <script src="${pageContext.request.contextPath}/js/common_scripts.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>

    <!-- SPECIFIC SCRIPTS -->
    <script src="${pageContext.request.contextPath}/js/carousel-home.min.js"></script>
    <script>
                                                        // Update the selected album ID when a radio button is clicked
                                                        function updateSelectedAlbum(radio) {
                                                            document.getElementById('selectedAlbumID').value = radio.value;
                                                        }

                                                        // Show the add album form
                                                        function showAddAlbumForm(productID) {
                                                            document.getElementById('addAlbumModal').style.display = "block";
                                                            // Set the product ID in the hidden input field
                                                            document.getElementById('selectedProductID').value = productID;
                                                        }

                                                        // Close the add album form
                                                        function closeAddAlbumForm() {
                                                            document.getElementById('addAlbumModal').style.display = "none";
                                                        }
    </script>
</body>
</html>
