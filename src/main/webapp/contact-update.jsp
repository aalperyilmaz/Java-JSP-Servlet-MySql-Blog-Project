<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="props.Admin" %>
<jsp:useBean id="dBUtil" class="utils.DBUtil"></jsp:useBean>
<jsp:useBean id="util" class="utils.Util"></jsp:useBean>
<% Admin adm = util.isLogin(request, response); %>

<html>
<head>
    <title>Şifre Düzenleme</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">


    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Profile</a></li>
                            <li><a class="dropdown-item" href="logout">Logout</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"><%=adm.getName()%></a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <br>
            <hr>

            <div class="col-sm-12">
                <h2>İletişim Listesi</h2>

                <table class="table table-hover">
                    <thead>
                    <tr>

                        <th scope="col"></th>

                        <th scope="col">Contact Name</th>
                        <th scope="col">Contact Email</th>
                        <th scope="col">Düzenle</th>

                    </tr>
                    </thead>
                    <tbody>

                    <%
                        int aid = adm.getAid();
                    %>

                    <c:if test="${ dBUtil.adminList(aid).size() == 0 }">
                        <tr>Blog Yok</tr>
                    </c:if>


                    <c:if test="${ dBUtil.contactList(aid).size() > 0 }">
                        <c:forEach items="${ dBUtil.contactList(aid) }" var="item" >


                            <tr>
                                <th scope="row"></th>

                                <td> <c:out value="${item.name}"></c:out>  </td>
                                <td> <c:out value="${item.email}"></c:out> </td>
                                <td>
                                    <a href="contact-update?cidx=${item.aid}" class="btn btn-warning btn-sm">Düzenle</a>

                                </td>
                            </tr>

                        </c:forEach>
                    </c:if>



                    </tbody>
                </table>

            </div>
        </div>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</div>
</body>
</html>
