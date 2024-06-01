<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Favourite</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
            .form-control, .form-control-file {
                background-color: #333;
                color: white;
                border: 1px solid #555;
            }
            .form-control::placeholder, .form-control-file::placeholder {
                color: #aaa; /* Placeholder color */
            }
            .form-control:focus, .form-control-file:focus {
                background-color: #555;
                border-color: #777;
                color: white; /* Ensures text color is white when focused */
            }
            .form-control {
                color: white; /* Ensures text color is white */
            }
            .form-group.row {
                margin-bottom: 15px;
            }
            .form-control {
                width: 75%;
            }
            #image {
                width: 50%;
            }
            .form-check-inline {
                display: inline-flex;
                align-items: center;
                margin-right: 10px;
            }
            .form-check-label {
                margin-left: 5px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid position-relative d-flex p-0">
            <!-- Edit Favourite Form Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Edit Favourite</h6>
                        <h1>${error}</h1>
                    </div>

                    <form action="${pageContext.request.contextPath}/favourites/updateFavourite.htm" method="post" enctype="multipart/form-data">
                        <input type="hidden" class="form-control" id="favouriteID" name="favouriteID" value="${favourite.favouriteID}" required>
                        <div class="form-group row">
                            <label for="productName" class="col-sm-2 col-form-label">Product Name :</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="productName" name="productName" value="${favourite.productName}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="phone" class="col-sm-2 col-form-label">Phone:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" name="phone" value="${favourite.phone}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="phone" class="col-sm-2 col-form-label">Price :</label>
                            <div class="col-sm-10" >
                                <label for="phone" class="col-sm-2 col-form-label" name="price" >${favourite.price}</label>
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <label for="phone" class="col-sm-2 col-form-label">Image :</label>
                            <img src="${pageContext.request.contextPath}/${favourite.picture}" width="80px" height="80px" style="margin-left: 15px" />
                        </div>
                        <button type="submit" class="btn btn-primary">Update Favourite</button>
                    </form>


                </div>
            </div>
            <!-- Edit Favourite Form End -->
        </div>
    </body>
</html>
