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
        
        .btn-primary {
            background-color: red;
            border-color: red;
        }
        .form-control {
            background-color: #333;
            color: black;
            border: 1px solid #555;
        }
        .form-control::placeholder {
            color: #aaa;
        }
        .form-control:focus {
            background-color: #555;
            border-color: #777;
            color: black;
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
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        /* Custom styles for artist table */
        .artist-row {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }
        .artist-img {
            flex: 0 0 auto;
            width: 100px;
            height: 100px;
            margin-right: 20px;
        }
        .artist-details {
            flex: 1 1 auto;
        }
        .artist-name {
            text-align: right;
            font-size: 1.5em;
            margin-bottom: 10px;
        }
        .artist-description {
            margin-top: 10px;
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
                            <h1>Artist Page</h1>
                        </c:when>
                        <c:otherwise>
                            <h1>LIST ARTIST</h1>
                        </c:otherwise>
                    </c:choose>
                </div>
                <h1>${successfully}</h1>
                <c:choose>
                    <c:when test="${not empty message}">
                        <h1>${message}</h1>
                    </c:when>

                    <c:otherwise>
                        <div class="artist-list">
                            <c:forEach var="artist" items="${artists}">
                                <div class="artist-row">
                                    <div class="artist-img">
                                        <img src="${artist.picture}" alt="${artist.artistName}" width="100">
                                    </div>
                                    <div class="artist-details">
                                        <div class="artist-name">${artist.artistName}</div>
                                        <div class="artist-description">${artist.description}</div>
                                        <div class="artist-contact">
                                            <p>Email: ${artist.email}</p>
                                            <p>Phone: ${artist.phone}</p>
                                            <a href="${pageContext.request.contextPath}/artists/artists/${artist.artistID}.htm" class="btn btn-primary">Details</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
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
</body>
</html>
