<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <style>
            body {
                background-color: black;
                color: white;
                overflow-x: hidden;
            }
            .btn-primary {
                background-color: red;
                border-color: red;
            }
            .form-control {
                background-color: #333;
                color: white;
                border: 1px solid #555;
            }
            .form-control::placeholder {
                color: #aaa;
            }
            .form-control:focus {
                background-color: #555;
                border-color: #777;
                color: white;
            }
            .form-control {
                color: white;
            }
            .form-group.row {
                margin-bottom: 15px;
            }
            .form-control {
                width: 75%;
            }
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
                background-color: rgba(0,0,0,0.4);
            }
            .modal-content {
                background-color: #FFF;
                margin: auto;
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
            <%@include file="header.jsp" %>
            <!-- /header -->

            <main class="bg_gray">
                <div class="container margin_30">
                    <div class="page_header">
                        <div class="breadcrumbs">
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Category</a></li>
                                <li>Albums</li>
                            </ul>
                        </div>
                        <c:choose>
                            <c:when test="${empty login}">
                                <h1>Album page</h1>
                            </c:when>
                            <c:otherwise>
                                <h1>Album page of ${login.memberName}</h1>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <h1>${successfully}</h1>
                    <c:choose>
                        <c:when test="${not empty message}">
                            <h1>${message}</h1>
                        </c:when>

                        <c:otherwise>
                            <table class="table table-striped cart-list">
                                <thead>
                                    <tr>
                                        <th>Album Name</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="alb" items="${albumsList}">

                                        <tr>
                                            <td>

                                                <span class="item_cart">${alb.albumName}</span>
                                            </td>   
                                            <td> 
                                                <a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/albums/viewProducts/${alb.albumID}.htm">Details</a>
                                            </td>
                                            <td>
                                                <a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/albums/delete/${login.phone}/${alb.albumID}.htm">Delete</a>
                                            </td>    
                                        </tr>  

                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>

                    <div class="d-flex align-items-center justify-content-between mb-4">

                        <button class="btn btn-primary" onclick="showAddAlbumForm()">Add Album</button>
                    </div>

                    <div id="addAlbumModal" class="modal">
                        <div class="modal-content">
                            <span class="close" onclick="closeAddAlbumForm()">&times;</span>
                            <h6 class="mb-0">Add Album</h6>
                            <form id="addAlbumForm" action="${pageContext.request.contextPath}/albums/add.htm" method="post">


                                <div class="form-group row">
                                    <label for="albumName" class="col-sm-2 col-form-label">Album Name:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="albumName" name="albumName" required>
                                    </div>
                                </div>
                                <div class="form-group row">

                                    <div class="col-sm-10">

                                        <input type="hidden" class="form-control" id="phone" value="${login.phone}" name="phone" required>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Add Album</button>

                            </form>
                        </div>
                    </div>
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
        <script>
                                // Show the add album form
                                function showAddAlbumForm() {
                                    document.getElementById('addAlbumModal').style.display = "block";
                                }
                                function closeAddAlbumForm() {
                                    document.getElementById('addAlbumModal').style.display = "none";
                                }

        </script>

    </body>
</html>
