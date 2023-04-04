<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Database </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <style>
        span{
            color:black;
        }
    </style>
</head>
<div class="container bg-primary">
    <h1 class=" start d-flex justify-content-center">Student Details</h1>
</div>
<body style="background-color: white;">
<div class="container ">
    <div class="container bg-secondary">
        <form method="post" action="insert">
            <div class="form-grp">
                <label class="form-label">Register Number</label>
                <input type="text" name="reg_num" required>
            </div>
            <div class="form-grp">
                <label class="form-label">Age</label>
                <input type="number" name="age" required>
            </div>
            <div class="form-grp">
                <label class="form-label">Name</label>
                <input type="text" name="stu_name" required>
            </div>

            <div class="form-grp">
                <label class="form-label">E-mail</label>
                <input type="email" name="email" required>
            </div>


            <div class="container bg-primary">
                <h1 class=" start d-flex justify-content-center">PERMANENT ADDRESS</h1>
            </div>

            <div class="form-grp">
                <label class="form-label">Door_no</label>
                <input type="number" name="p_door_num" required>
            </div>
            <div class="form-grp">
                <label class="form-label">town</label>
                <input type="text" name="p_town" required>
            </div>
            <div class="form-grp">
                <label class="form-label">City</label>
                <input type="text" name="p_City" required>
            </div>
            <div class="mt-3">
                <label class="form-grp">Pincode</label>
                <input type="number" name="p_Pincode" required>
            </div>
            <div class="container bg-primary">
                <h1 class=" start d-flex justify-content-center">CURRENT ADDRESS</h1>
            </div>

            <div class="form-grp">
                <label class="form-label">Door_no</label>
                <input type="number" name="c_door_num" required>
            </div>
            <div class="form-grp">
                <label class="form-label">town</label>
                <input type="text" name="c_town" required>
            </div>
            <div class="form-grp">
                <label class="form-label">City</label>
                <input type="text" name="c_City" required>
            </div>
            <div class="form-grp">
                <label class="form-grp">Pincode</label>
                <input type="number" name="c_Pincode" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
</body>
</html>


