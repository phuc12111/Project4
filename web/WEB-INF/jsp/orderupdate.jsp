<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Update Order</title>
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
        </style>
    </head>
    <body>
        <div class="container-fluid position-relative d-flex p-0">
            <!-- Update Order Form Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Update Order</h6>
                        <h1>${error}</h1>
                    </div>

                    <form action="${pageContext.request.contextPath}/order/update/${orderDetail.orderID}.htm" method="post">
                        <div class="form-group row">
                            <label for="orderID" class="col-sm-2 col-form-label">Order ID:</label>
                            <div class="col-sm-10">
                                <label for="orderID" name="orderID" class="col-sm-2 col-form-label">${orderDetail.orderID}</label>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="shipAddress" class="col-sm-2 col-form-label">Ship Address:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="shipAddress" name="shipAddress" value="${orderDetail.shipAddress}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="quantity" class="col-sm-2 col-form-label">Quantity:</label>
                            <div class="col-sm-10">
                                <input type="hidden" class="form-control" id="productID" name="productID" value="${orderDetail.productID}" required>
                                <input type="text" class="form-control" id="quantity" name="quantity" value="${orderDetail.quantity}" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Update Order</button>
                    </form>

                </div>
            </div>
            <!-- Update Order Form End -->
        </div>
    </body>
</html>
