<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>DarkPan - Bootstrap 5 Admin Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="${pageContext.request.contextPath}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.minad.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="${pageContext.request.contextPath}/css/stylead.css" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
            <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
            </a>
            <a href="#" class="sidebar-toggler flex-shrink-0">
                <i class="fa fa-bars"></i>
            </a>
            <form action="${pageContext.request.contextPath}/admin/findAdmins.htm" method="get" class="d-none d-md-flex ms-4">
                <input class="form-control bg-dark border-0" type="search" placeholder="Search name admin" name="keyword">
                <button type="submit" class="btn btn-sm btn-primary" style="margin-left: 20px">Search</button>
            </form>
            <div class="navbar-nav align-items-center ms-auto">
                <div class="nav-item dropdown">
                    <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/admin/showAddAdminsForm.htm">Add Admin</a>



                </div>
            </div>

            <c:choose>
                <c:when test="${empty admin}">
                    <div class="nav-item dropdown">
                        <img class="rounded-circle me-lg-2" src="${pageContext.request.contextPath}/img/products/Bad.jpg" width="50" height="50">
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="${pageContext.request.contextPath}/${admin.avatar}" width="50" height="50">
                            <span class="d-none d-lg-inline-flex">${admin.adminName}</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="${pageContext.request.contextPath}/admin/logout.htm" class="dropdown-item" style="color: #FFF">Log Out</a>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>


        </div>
    </nav>         

    <div class="container-fluid position-relative d-flex p-0">



        <!-- Recent Sales Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-secondary text-center rounded p-4">
                <div class="d-flex align-items-center justify-content-between mb-4">
                    <h6 class="mb-0">Manage Admin </h6>
                    <h1>${error}</h1>
                </div>
                <div class="table-responsive">
                    <table class="table text-start align-middle table-bordered table-hover mb-0">
                        <thead>
                            <tr class="text-white">
                                <th scope="col">Admin ID</th>
                                <th scope="col">Name admin</th>
                                <th scope="col">Email</th>
                                <th scope="col">Pasword</th>
                                <th scope="col">Phone</th>
                                <th scope="col">gender</th>
                                <th scope="col">Addderss</th>
                                <th scope="col">Avatar</th>
                                <th scope="col">Date create</th>
                                <th scope="col">Role</th>
                                <th scope="col">Delete</th>
                                <th scope="col">Update</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${adminList}" var="admin"><tr>
                                    <td>${admin.adminID}</td>
                                    <td>${admin.adminName}</td>
                                    <td>${admin.email}</td>
                                    <td>${admin.password}</td>
                                    <td>${admin.phone}</td>
                                    <td>${admin.gender}</td>
                                    <td>${admin.address}</td>
                                    <td><img src="${pageContext.request.contextPath}/${admin.avatar}" width="50" height="50"></td>
                                    <td>${admin.createdAt}</td>
                                    <td>${admin.roleID}</td>
                                    <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/admin/deleteAdmins.htm?adminID=<c:out value="${admin.adminID}"/>">Delete</a></td>
                                    <td>
                                        <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/admin/showUpdate.htm?id=${admin.adminID}">Update</a>
                                    </td>

                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>

                </div>
            </div>
        </div>
        <!-- Recent Sales End -->



        <!-- Footer End -->
    </div>
    <!-- Content End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
</div>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/chart/chart.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/easing/easing.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/waypoints/waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/tempusdominus/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="${pageContext.request.contextPath}/js/mainad.js"></script>
</body>

</html>