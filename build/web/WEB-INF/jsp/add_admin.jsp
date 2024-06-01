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
                <h6 class="mb-0">Add Admin</h6>
                <h1>${error}</h1>
            </div>
            
                <form action="${pageContext.request.contextPath}/admin/addAdmins.htm" method="post" enctype="multipart/form-data">
                    <div class="form-group row">
                        <label for="adminID" class="col-sm-2 col-form-label">Admin ID:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="adminID" name="adminID" placeholder="Enter Admin ID">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="adminName" class="col-sm-2 col-form-label">Admin Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="adminName" name="adminName" placeholder="Enter Admin Name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="email" class="col-sm-2 col-form-label">Email:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label">Password:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="phone" class="col-sm-2 col-form-label">Phone:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter Phone Number">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Gender:</label>
                        <div class="col-sm-10 d-flex align-items-center">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="gender" name="gender" value="1" checked>
                                <label class="form-check-label" for="gender">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="gender" name="gender" value="2">
                                <label class="form-check-label" for="gender">Female</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="address" class="col-sm-2 col-form-label">Address:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="address" name="address" placeholder="Enter Address"></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="avatar" class="col-sm-2 col-form-label">Avatar:</label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control-file" id="image" name="image" accept="image/*" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Role:</label>
                        <div class="col-sm-10 d-flex align-items-center">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="roleID1" name="roleID" value="2">
                                <label class="form-check-label" for="roleID1">Ch?</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="roleID2" name="roleID" value="3" checked>
                                <label class="form-check-label" for="roleID2">Bán</label>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Admin</button>
                </form>
            
        </div>
    </div>
    <!-- Recent Sales End -->
</div>
</body>
</html>
