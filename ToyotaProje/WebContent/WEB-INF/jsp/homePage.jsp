<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">-->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>


<title>Sistem</title>
</head>
<body>

		<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Toyota Proje</h1>
				<p>Anıl Yetişgin</p>
			</div>
		</div>
	</section>
	
	<section class="container">
	
	<div class="row">
  <div class="col-xs-6 col-md-3">
    <a href="<c:url value="/login"/>" class="thumbnail">
      <img src="<c:url value="/resources/img/SeyahatS259x237.png"/>" alt="Seyahat Sistemi">
    </a>
  </div>
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="<c:url value="/resources/img/NobetciSistemi.png"/>" alt="...">
    </a>
  </div>
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="<c:url value="/resources/img/DuyuruSistemi.png"/>" alt="...">
    </a>
  </div>
  <div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail">
      <img src="<c:url value="/resources/img/ProjeSistemi.png"/>" alt="...">
    </a>
  </div>
 
</div>
		
		
	</section>
</body>
</html>
