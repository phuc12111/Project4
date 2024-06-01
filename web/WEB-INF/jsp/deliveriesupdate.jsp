<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Deliveries</title>
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
        <!-- Update Deliveries Form Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-secondary text-center rounded p-4">
                <div class="d-flex align-items-center justify-content-between mb-4">
                    <h6 class="mb-0">Update Deliveries</h6>
                    <h1>${error}</h1>
                </div>

                <form action="${pageContext.request.contextPath}/ship/edit/${delivery.deliveryID}.htm" method="post">
                    <div class="form-group row">
                        <label for="deliveryID" class="col-sm-2 col-form-label">Delivery ID:</label>
                        <div class="col-sm-10">
                            <label for="deliveryID" name="deliveryID" class="col-sm-2 col-form-label">${delivery.deliveryID}</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="deliveryName" class="col-sm-2 col-form-label">Delivery Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="deliveryName" name="deliveryName" value="${delivery.deliveryName}" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="price" class="col-sm-2 col-form-label">Price:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="price" name="price" value="${delivery.price}" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="shipperName" class="col-sm-2 col-form-label">Shipper Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="shipperName" name="shipperName" value="${delivery.shipperName}" required>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Update Deliveries</button>
                </form>

            </div>
        </div>
        
    </div>
</body>
</html>
