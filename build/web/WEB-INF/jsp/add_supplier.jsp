<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Admin</title>
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
    <!-- Recent Sales Start -->
    <div class="container-fluid pt-4 px-4">
        <div class="bg-secondary text-center rounded p-4">
            <div class="d-flex align-items-center justify-content-between mb-4">
                <h6 class="mb-0">Add Supplier</h6>
                <h1>${error}</h1>
            </div>
            
                <form action="${pageContext.request.contextPath}/supplier/addSupplier.htm" method="post" enctype="multipart/form-data">
                    <div class="form-group row">
                        <label for="supplierName" class="col-sm-2 col-form-label">Supplier Name:</label>
                        <div class="col-sm-10">
                            <input required type="text" class="form-control" id="supplierName" name="supplierName" placeholder="Enter Supplier Name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="email" class="col-sm-2 col-form-label">Email:</label>
                        <div class="col-sm-10">
                            <input required type="email" class="form-control" id="email" name="email" placeholder="Enter Email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="phone" class="col-sm-2 col-form-label">Phone:</label>
                        <div class="col-sm-10">
                            <input required type="text" class="form-control" id="phone" name="phone" placeholder="Enter Phone">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="description" class="col-sm-2 col-form-label">Description:</label>
                        <div class="col-sm-10">
                            <input required type="text" class="form-control" id="description" name="description" placeholder="Enter Phone Number">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="picture" class="col-sm-2 col-form-label">Picture:</label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control-file" id="picture" name="picture" accept="image/*" required>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Supplier</button>
                </form>
            
        </div>
    </div>
    <!-- Recent Sales End -->
</div>
</body>
</html>
