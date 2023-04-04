
<%--
Created by IntelliJ IDEA.
User: xxnlnnns
Date: 27-03-2023
Time: 10:56
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

</head>

<body>

<%@ taglib prefix="loan" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fd" uri="http://java.sun.com/jsp/jstl/sql" %>
<fd:setDataSource var="connection" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="AISHWARYA" password="aishu6783"/>
<fd:query var="qry" dataSource="${connection}" sql="select * from addressofstudent,mapper where mapper.register_num=? and mapper.address_id=addressofstudent.add_id" >
    <fd:param value="${param['id']}"/>
</fd:query>
<%--<fd:query var="qry2" dataSource="${connection}" sql="select * from address1,addmap where type='Permanent' and addmap.registerno=? and addmap.add_id=address1.add_id" />--%>

<div class="container rounded-4 p-3" style="box-shadow: 5px 5px 20px ;">
    <div class="col-lg-12 col-sm-12">
        <div class="table-responsive">
            <table class="table table-striped p-2 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
                <thead>
                <h3>Address details</h3>
                <tr>
                    <th>Door_num</th>
                    <th>town</th>
                    <th>City</th>
                    <th>Pincode</th>
                    <th>Type</th>
                </tr>

                </thead>
                <tbody>
                <loan:forEach var="record" items="${qry.rows}">

                    <tr >
                        <td>${record.Door_num}</td>
                        <td>${record.town}</td>
                        <td>${record.city}</td>
                        <td>${record.Pincode}</td>
                        <td>${record.Type}</td>

                    </tr>
                </loan:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>