<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Payment</title>
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
        <!-- Update Payment Form Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-secondary text-center rounded p-4">
                <div class="d-flex align-items-center justify-content-between mb-4">
                    <h6 class="mb-0">Update Payment</h6>
                    <h1>${error}</h1>
                </div>

                <form action="${pageContext.request.contextPath}/pay/update/${payment.paymentID}.htm" method="post">
                    <div class="form-group row">
                        <label for="paymentID" class="col-sm-2 col-form-label">Payment ID:</label>
                        <div class="col-sm-10">
                            <label for="paymentID" name="paymentID" class="col-sm-2 col-form-label">${payment.paymentID}</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="paymentName" class="col-sm-2 col-form-label">Payment Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="paymentName" name="paymentName" value="${payment.paymentName}" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="description" class="col-sm-2 col-form-label">Description:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="description" name="description" required>${payment.description}</textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Update Payment</button>
                </form>

            </div>
        </div>
        <!-- Update Payment Form End -->
    </div>
</body>
</html>
