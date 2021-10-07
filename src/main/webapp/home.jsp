
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="props.Admin" %>
<%@ page import="props.Content" %>
<jsp:useBean id="dBUtil" class="utils.DBUtil"></jsp:useBean>
<jsp:useBean id="util" class="utils.Util"></jsp:useBean>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <style>
        .blog-header{
            line-height: 1;
            border-bottom: 1px solid #cecece;
        }


        .blog-header-logo{
            font-family: 'Playfair Display', serif;
            font-size: 2.25rem;
        }

    </style>

    <title>BlogHome</title>
</head>
<body>
<div class="container"></div>
<header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
        <div class="col-4">
            <a href="#" class="link-secondary">Takip et</a>
        </div>
        <div class="col-4 text-center">
            <a href="#" class="blog-header-logo text-dark">BLOG</a>
        </div>
        <div class="col-4 d-flex justify-content-end">
            <a href="#" class="btn btn-sm btn-outline-secondary">BLOG</a>
        </div>
    </div>
</header>
<div class="nav-scroller py-1 mb-2">
    <nav class="nav d-flex justify-content-between">
        <a href="#" class="p-2 link-secondary">Home</a>
        <a href="details.jsp" class="p-2 link-secondary">Detail</a>
        <a href="contact.jsp" class="p-2 link-secondary">Contact</a>

    </nav>
</div>

<main>

    <div class="py-4 p-md-5 mb-4 text-white rounded bg-dark">
        <div class="col-md-6">
            <h1 class="display-5">Title of a longer featured blog post</h1>
            <p class="my-3">Multiple lines of text that form the lede , informing new readers quickly and efficently about what's most interesting in this post's content</p>
            <p class="mb-0"><a href="#" class="text-white fw-bold">Read more...</a> </p>
        </div>
    </div>


    <c:if test="${ dBUtil.allBlogList().size() > 0 }">
    <c:forEach items="${ dBUtil.allBlogList() }" var="item" >
    <div>
        <div class="col-md-12">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-success">BLOG</strong>
                    <h3 class="mb-0"><c:out value="${item.title}"></c:out></h3>
                    <div class="mb-1 text-muted">Nov 11</div>
                    <p class="mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="home-servlet?cidx=${item.cidx}" class="stretched-link">Continue reading</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

                </div>
            </div>
        </div>
    </div>
    </c:forEach>
    </c:if>













<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>


</body>
</html>