<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Admin Login</title>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h1> Admin Login </h1>

            <%
                Object loginObj = request.getAttribute("loginError");
                if ( loginObj != null ) {
                    String errorMessage = ""+loginObj;
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Hata!</strong> <%=errorMessage %>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <% } %>

            <form action="login-servlet" method="post">
                <div class="mb-3">
                    <input type="email" class="form-control" name="email" placeholder="E-Mail" required />
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" placeholder="Şifre" required />
                </div>
                <div class="mb-3 form-check">
                    <input name="remember" type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Remember</label>
                </div>
                <input class="btn btn-danger" type="submit" value="Gönder" />
            </form>
        </div>
        <div class="col-sm-4"></div>
    </div>



    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</div>
</body>
</html>