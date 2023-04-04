<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

</head>
<body class="bg-info">
<!-- <iframe src="nav.html" style="width: 100%;"></iframe> -->

<%@ taglib prefix="loan" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fd" uri="http://java.sun.com/jsp/jstl/sql" %>
<fd:setDataSource var="connection" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="AISHWARYA" password="aishu6783"/>
<fd:query var="qry" dataSource="${connection}" sql="select * from student" />
<div class="container rounded-4 p-3" style="box-shadow: 5px 5px 20px red;">
    <div class="col-lg-12 col-sm-12">
        <div class="table-responsive">
            <table class="table table-striped p-2 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
                <thead>
                <tr>

                    <th>Register_Number</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>E-mail</th>

                </tr>
                </thead>
                <tbody>
                <loan:forEach var="record" items="${qry.rows}">
                    <tr>
                        <td>${record.reg_num}</td>
                        <td>${record.stu_name}</td>
                        <td>${record.Age}</td>
                        <td>${record.Email}</td>
                        <td><a href="IndividualAddress.jsp?id=${record.reg_num}"> <button type="submit">Address</button></a></td>
                    </tr>
                </loan:forEach>
                </tbody>

            </table>
            <a href="Address.jsp"> <button type="submit" >Addresses</button></a>
        </div>
    </div>
</div>
</body>
</html>
 

