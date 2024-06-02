<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="${pageContext.request.contextPath}/css/listing.css" rel="stylesheet">

        <!-- YOUR CUSTOM CSS -->
        <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
        
       <Style>
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
        <%@include file="header.jsp" %>
        <div id="page">


            <!-- /header -->

            <main>
                <div class="top_banner">
                    <div class="opacity-mask d-flex align-items-center" data-opacity-mask="rgba(0, 0, 0, 0.3)">
                        <div class="container">
                            <div class="breadcrumbs">
                                <ul>
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">Category</a></li>
                                    <li>Page active</li>
                                </ul>
                            </div>
                            <h1>Shoes - Grid listing</h1>
                        </div>
                    </div>
                    <img src="img/bg_cat_shoes.jpg" class="img-fluid" alt="">
                </div>
                <!-- /top_banner -->

                <div id="stick_here"></div>		
                <div class="toolbox elemento_stick">
                    <div class="container">
                        <ul class="clearfix">
                            <li>
                                <div class="sort_select">
                                    <select name="sort" id="sort">
                                        <option value="popularity" selected="selected">Sort by popularity</option>
                                        <option value="rating">Sort by average rating</option>
                                        <option value="date">Sort by newness</option>
                                        <option value="price">Sort by price: low to high</option>
                                        <option value="price-desc">Sort by price: high to 
                                    </select>
                                </div>
                            </li>
                            <li>
                                <a href="#0"><i class="ti-view-grid"></i></a>
                                <a href="listing-row-1-sidebar-left.html"><i class="ti-view-list"></i></a>
                            </li>
                            <li>
                                <a data-bs-toggle="collapse" href="#filters" role="button" aria-expanded="false" aria-controls="filters">
                                    <i class="ti-filter"></i><span>Filters</span>
                                </a>
                            </li>
                        </ul>
                        <div class="collapse" id="filters"><div class="row small-gutters filters_listing_1">
                                <div class="col-lg-3 col-md-6 col-sm-6">
                                    <div class="dropdown">
                                        <a href="#" data-bs-toggle="dropdown" class="drop">Categories</a>
                                        <div class="dropdown-menu">
                                            <div class="filter_type">
                                                <ul>
                                                    <li>
                                                        <label class="container_check">Men <small>12</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Women <small>24</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Running <small>23</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Training <small>11</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                </ul>
                                                <a href="#0" class="apply_filter">Apply</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /dropdown -->
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6">
                                    <div class="dropdown">
                                        <a href="#" data-bs-toggle="dropdown" class="drop">Color</a>
                                        <div class="dropdown-menu">
                                            <div class="filter_type">
                                                <ul>
                                                    <li>
                                                        <label class="container_check">Blue <small>06</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Red <small>12</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Orange <small>17</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Black <small>43</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                </ul>
                                                <a href="#0" class="apply_filter">Apply</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /dropdown -->
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6">
                                    <div class="dropdown">
                                        <a href="#" data-bs-toggle="dropdown" class="drop">Brand</a>
                                        <div class="dropdown-menu">
                                            <div class="filter_type">
                                                <ul>
                                                    <li>
                                                        <label class="container_check">Adidas <small>11</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Nike <small>08</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Vans <small>05</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">Puma <small>18</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                </ul>
                                                <a href="#0" class="apply_filter">Apply</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /dropdown -->
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6">
                                    <div class="dropdown">
                                        <a href="#" data-bs-toggle="dropdown" class="drop">Price</a>
                                        <div class="dropdown-menu">
                                            <div class="filter_type">
                                                <ul>
                                                    <li>
                                                        <label class="container_check">$0 â $50<small>11</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">$50 â $100<small>08</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">$100 â $150<small>05</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <label class="container_check">$150 â $200<small>18</small>
                                                            <input type="checkbox">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </li>
                                                </ul>
                                                <a href="#0" class="apply_filter">Apply</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /dropdown -->

                                </div></div></div>
                    </div>
                </div>
                <!-- /toolbox -->

                <div class="container margin_30">
                    <div class="row small-gutters">
                        <c:forEach var="pro" items="${pro}" varStatus="status">
                            <div class="col-6 col-md-4 col-xl-3">
                                <div class="grid_item">
                                    <figure>
                                        <span class="ribbon off">-30%</span>
                                        <a href="product-detail-1.html">
                                            <img class="img-fluid lazy" src="${pageContext.request.contextPath}/${pro.picture}" data-src="${pageContext.request.contextPath}/${pro.picture}" alt="">
                                        </a>
                                        <div data-countdown="2019/05/15" class="countdown"></div>
                                    </figure>
                                    <a href="product-detail-1.html">
                                        <h3>${pro.productName}</h3>
                                    </a>
                                    <div class="price_box">
                                        <span class="new_price">${pro.price}</span>
                                        <span class="old_price">$60.00</span>
                                    </div>
                                    <ul>

                                        <li>
                                            <a href="${pageContext.request.contextPath}/favourites/addcate/${pro.productID}/${login.phone}/${catedal.categoryID}.htm"  class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to favorites">
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
                                            <a href="${pageContext.request.contextPath}/cart/addcate/${catedal.categoryID}/${pro.productID}.htm" class="tooltip-1" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to cart">
                                                <i class="ti-shopping-cart"></i><span>Add to cart</span>
                                            </a>
                                        </li>

                                    </ul>
                                </div>
                                <!-- /grid_item -->
                            </div>
                        </c:forEach>

                        <!-- /col -->				
                    </div>
                    <!-- /row -->

                    <div class="pagination__wrapper">
                        <ul class="pagination">
                            <li><a href="#0" class="prev" title="previous page">&#10094;</a></li>
                            <li>
                                <a href="#0" class="active">1</a>
                            </li>
                            <li>
                                <a href="#0">2</a>
                            </li>
                            <li>
                                <a href="#0">3</a>
                            </li>
                            <li>
                                <a href="#0">4</a>
                            </li>
                            <li><a href="#0" class="next" title="next page">&#10095;</a></li>
                        </ul>
                    </div>

                </div>
                 <!-- Popup form -->
                <div id="addAlbumModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="closeAddAlbumForm()">&times;</span>
                        <h6 class="mb-0">Add Album</h6>
                        <form id="addAlbumForm" action="${pageContext.request.contextPath}/albums/adddetailcate.htm" method="post">
                            <!-- Hidden input fields to store the selected album and product IDs -->
                            <input type="hidden" id="selectedAlbumID" name="albumID" value="">
                            <input type="hidden" name="categoryID" value="${catedal.categoryID}">
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
                
                <!-- /container -->
            </main>
            <!-- /main -->

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