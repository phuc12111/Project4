<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="version_2">
    <div class="layer"></div><!-- Mobile menu overlay mask -->
    <div class="main_header">
        <div class="container">
            <div class="row small-gutters">
                <div class="col-xl-3 col-lg-3 d-lg-flex align-items-center">
                    <div id="logo">
                        <a href="index.html"><img src="img/logo_black.svg" alt="" width="100" height="35"></a>
                    </div>
                </div>
                <nav class="col-xl-6 col-lg-7">
                    <a class="open_close" href="javascript:void(0);">
                        <div class="hamburger hamburger--spin">
                            <div class="hamburger-box">
                                <div class="hamburger-inner"></div>
                            </div>
                        </div>
                    </a>
                    <!-- Mobile menu button -->
                    <div class="main-menu">
                        <div id="header_menu">
                            <a href="index.html"><img src="img/logo_black.svg" alt="" width="100" height="35"></a>
                            <a href="#" class="open_close" id="close_in"><i class="ti-close"></i></a>
                        </div>
                        <ul>
                            <li class="submenu">
                                <a href="${pageContext.request.contextPath}/index.htm" class="show-submenu">Home</a>
                                <ul>
                                    <li><a href="index.html">Slider</a></li>
                                    <li><a href="index-2.html">Video Background</a></li>
                                    <li><a href="index-3.html">Vertical Slider</a></li>
                                    <li><a href="index-4.html">GDPR Cookie Bar</a></li>
                                </ul>
                            </li>
                            <li class="megamenu submenu">
                                <a href="javascript:void(0);" class="show-submenu-mega">Pages</a>
                                <div class="menu-wrapper">
                                    <div class="row small-gutters">
                                        <div class="col-lg-3">
                                            <h3>Listing grid</h3>
                                            <ul>
                                                <li><a href="listing-grid-1-full.html">Grid Full Width</a></li>
                                                <li><a href="listing-grid-2-full.html">Grid Full Width 2</a></li>
                                                <li><a href="listing-grid-3.html">Grid Boxed</a></li>
                                                <li><a href="listing-grid-4-sidebar-left.html">Grid Sidebar Left</a></li>
                                                <li><a href="listing-grid-5-sidebar-right.html">Grid Sidebar Right</a></li>
                                                <li><a href="listing-grid-6-sidebar-left.html">Grid Sidebar Left 2</a></li>
                                                <li><a href="listing-grid-7-sidebar-right.html">Grid Sidebar Right 2</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-lg-3">
                                            <h3>Listing row &amp; Product</h3>
                                            <ul>
                                                <li><a href="listing-row-1-sidebar-left.html">Row Sidebar Left</a></li>
                                                <li><a href="listing-row-2-sidebar-right.html">Row Sidebar Right</a></li>
                                                <li><a href="listing-row-3-sidebar-left.html">Row Sidebar Left 2</a></li>
                                                <li><a href="listing-row-4-sidebar-extended.html">Row Sidebar Extended</a></li>
                                                <li><a href="product-detail-1.html">Product Large Image</a></li>
                                                <li><a href="product-detail-2.html">Product Carousel</a></li>
                                                <li><a href="product-detail-3.html">Product Sticky Info</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-lg-3">
                                            <h3>Other pages</h3>
                                            <ul>
                                                <li><a href="cart.html">Cart Page</a></li>
                                                <li><a href="checkout.html">Check Out Page</a></li>
                                                <li><a href="confirm.html">Confirm Purchase Page</a></li>
                                                <li><a href="account.html">Create Account Page</a></li>
                                                <li><a href="track-order.html">Track Order</a></li>
                                                <li><a href="help.html">Help Page</a></li>
                                                <li><a href="help-2.html">Help Page 2</a></li>
                                                <li><a href="leave-review.html">Leave a Review</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-lg-3 d-xl-block d-lg-block d-md-none d-sm-none d-none">
                                            <div class="banner_menu">
                                                <a href="#0">
                                                    <img src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==" data-src="img/banner_menu.jpg" width="400" height="550" alt="" class="img-fluid lazy">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /row -->
                                </div>
                                <!-- /menu-wrapper -->
                            </li>
                            <li class="submenu">
                                <a href="javascript:void(0);" class="show-submenu">Extra Pages</a>
                                <ul>
                                    <li><a href="header-2.html">Header Style 2</a></li>
                                    <li><a href="header-3.html">Header Style 3</a></li>
                                    <li><a href="header-4.html">Header Style 4</a></li>
                                    <li><a href="header-5.html">Header Style 5</a></li>
                                    <li><a href="404.html">404 Page</a></li>
                                    <li><a href="sign-in-modal.html">Sign In Modal</a></li>
                                    <li><a href="contacts.html">Contact Us</a></li>
                                    <li><a href="about.html">About 1</a></li>
                                    <li><a href="about-2.html">About 2</a></li>
                                    <li><a href="modal-advertise.html">Modal Advertise</a></li>
                                    <li><a href="modal-newsletter.html">Modal Newsletter</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="blog.html">Blog</a>
                            </li>
                            <li>
                                <a href="#0">Buy Template</a>
                            </li>
                        </ul>
                    </div>
                    <!--/main-menu -->
                </nav>
                <div class="col-xl-3 col-lg-2 d-lg-flex align-items-center justify-content-end text-end">
                    <a class="phone_top" href="tel://9438843343"><strong><span>Need Help?</span>+94 423-23-221</strong></a>
                </div>
            </div>
            <!-- /row -->
        </div>
    </div>
    <!-- /main_header -->

    <div class="main_nav Sticky">
        <div class="container">
            <div class="row small-gutters">
                <div class="col-xl-3 col-lg-3 col-md-3">
                    <nav class="categories">
                        <ul class="clearfix">
                            <li><span>
                                    <a href="#">
                                        <span class="hamburger hamburger--spin">
                                            <span class="hamburger-box">
                                                <span class="hamburger-inner"></span>
                                            </span>
                                        </span>
                                        Categories
                                    </a>
                                </span>
                                <div id="menu">
                                    <ul>
                                        <li><span><a href="#0">Game DVD</a></span>
                                            <ul>
                                                <li><a href="listing-grid-1-full.html">Trending</a></li>
                                                <li><a href="listing-grid-2-full.html">Life style</a></li>
                                                <li><a href="listing-grid-3.html">Running</a></li>
                                                <li><a href="listing-grid-4-sidebar-left.html">Training</a></li>
                                                <li><a href="listing-grid-5-sidebar-right.html">View all Collections</a></li>
                                            </ul>
                                        </li>
                                        <li><span><a href="#">Music DVD</a></span>
                                            <ul>
                                                <li><a href="listing-grid-6-sidebar-left.html">Offers</a></li>
                                                <li><a href="listing-grid-7-sidebar-right.html">Shoes</a></li>
                                                <li><a href="listing-row-1-sidebar-left.html">Clothing</a></li>
                                                <li><a href="listing-row-3-sidebar-left.html">Accessories</a></li>
                                                <li><a href="listing-row-4-sidebar-extended.html">Equipment</a></li>
                                            </ul>
                                        </li>
                                        <li><span><a href="#">Film DVD</a></span>
                                            <ul>
                                                <li><a href="listing-grid-1-full.html">Best Sellers</a></li>
                                                <li><a href="listing-grid-2-full.html">Clothing</a></li>
                                                <li><a href="listing-grid-3.html">Accessories</a></li>
                                                <li><a href="listing-grid-4-sidebar-left.html">Shoes</a></li>
                                            </ul>
                                        </li>
                                        
                                        
                                       
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="col-xl-6 col-lg-7 col-md-6 d-none d-md-block">
                    <div class="custom-search-input">
                        <input type="text" placeholder="Search over 10.000 products">
                        <button type="submit"><i class="header-icon_search_custom"></i></button>
                    </div>
                </div>
                <div class="col-xl-3 col-lg-2 col-md-3">
                    <ul class="top_tools">
                        <li>
                            <div class="dropdown dropdown-cart">
                                <a href="${pageContext.request.contextPath}/cart/cart.htm" class="cart_bt"><strong>${sessionScope.myCartNum}</strong></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <c:forEach var="map" items="${sessionScope.myCartItems}">
                                            <li>
                                                <a href="product-detail-1.html">
                                                    <figure><img src="${pageContext.request.contextPath}/${map.value.product.picture}" data-src="${pageContext.request.contextPath}/${map.value.product.picture}" alt="" width="50" height="50" class="lazy"></figure>
                                                    <strong><span>${map.value.product.productName}</span>${map.value.product.price}</strong>
                                                </a>

                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <div class="total_drop">
                                        <div class="clearfix"><strong>Total</strong><span>${sessionScope.myCartTotal}</span></div>
                                        <a href="${pageContext.request.contextPath}/cart/cart.htm" class="btn_1 outline">View Cart</a><a href="checkout.html" class="btn_1">Checkout</a>
                                    </div>
                                </div>
                            </div>
                            <!-- /dropdown-cart-->
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/favourites/viewfavourites/${login.phone}.htm" class="wishlist"><span>Wishlist</span></a>
                        </li>
                        <li>
                            <div class="dropdown dropdown-access">
                                <a href="${pageContext.request.contextPath}/login/login.htm" class="access_link"><span>Account</span></a>
                                <div class="dropdown-menu">
                                    <c:choose>
                                        <c:when test="${empty login}">
                                            <a href="${pageContext.request.contextPath}/login/login.htm" class="btn_1">Sign In or Sign Up</a>
                                        </c:when>
                                        <c:otherwise>  
                                            <strong><span>${login.memberName}</span>${login.phone}</strong>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                    <ul>
                                        <li>
                                            <a href="track-order.html"><i class="ti-truck"></i>Track your Order</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/order/detail/${login.phone}.htm"><i class="ti-package"></i>My Orders</a>
                                        </li>
                                        <li>
                                            <a href="account.html"><i class="ti-user"></i>My Profile</a>
                                        </li>
                                        <li>
                                            <a href="help.html"><i class="ti-help-alt"></i>Help and Faq</a>
                                        </li>
                                        <c:choose>
                                        <c:when test="${empty login}">
                                            
                                        </c:when>
                                        <c:otherwise>  
                                            <li>
                                                <a href="help.html"><i class="ti-shift-right"></i>Out accout</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                        
                                    </ul>
                                </div>
                            </div>
                            <!-- /dropdown-access-->
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="btn_search_mob"><span>Search</span></a>
                        </li>
                        <li>
                            <a href="#menu" class="btn_cat_mob">
                                <div class="hamburger hamburger--spin" id="hamburger">
                                    <div class="hamburger-box">
                                        <div class="hamburger-inner"></div>
                                    </div>
                                </div>
                                Categories
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /row -->
        </div>
        <div class="search_mob_wp">
            <input type="text" class="form-control" placeholder="Search over 10.000 products">
            <input type="submit" class="btn_1 full-width" value="Search">
        </div>
        <!-- /search_mobile -->
    </div>
    <!-- /main_nav -->
</header>
