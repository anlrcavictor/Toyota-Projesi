<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">-->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/datepicker.css"/>" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>





<script>
$( function() {
 
$( "#startDate,#finishDate" ).datepicker();
} );
 
</script>


<title>Seyahat Ekle</title>
</head>
<body>

		<div class="container-fluid">
	 		<div class="row">
				<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">User</a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li><a href="<c:url value="/user/myTravelList" />">Seyahatler</a></li>
			       </ul>
			       
			        <ul class="nav navbar-nav navbar-right">
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${name}  <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				              <li><a href="<c:url value="/user/updateMyProfile"/>">${name}</a></li>
				            <li role="separator" class="divider"></li>
				            <li><a href="<c:url value="/login/logOut" />">Çıkış</a></li>
				          </ul>
				        </li>
				     </ul>
			      
			      
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
		</div>
	</div>
	


	
	<section class="container">
		<!-- watch out modelAttribute ! -->
		<form:form  modelAttribute="newTravel" class="form-horizontal" method="post">
			<fieldset>
				<legend>Seyahat Ekle</legend>

				
				<form:hidden path="kullaniciAdi" value="${name}" />


				<div class="form-group">
					<label class="control-label col-lg-2" for="seyahatYeri">Seyahat Yeri</label>
					<div class="col-md-3">
						<form:input id="seyahatYeri" path="seyahatYeri" type="text" class="form:input-large form-control"/>
						<form:errors path="seyahatYeri" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="gidisAmaci">Gidiş Amacı</label>
					<div class="col-md-2">
						<div class="form:input-prepend">
							<form:input id="gidisAmaci" path="gidisAmaci" type="text" class="form:input-large form-control"/>
							<form:errors path="gidisAmaci" cssClass="text-danger" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for=projeKodu>Proje Kodu</label>
					<div class="col-md-2">
						<div class="form:input-prepend">
							<form:input id="projeKodu" path="projeKodu" type="text" class="form-control"/>
						</div>
					</div>
				</div>	
				
				
				 <div class="form-group">
					<label class="control-label col-lg-2" for="baslangic">Seyahat Başlangıcı</label>
					<div class="col-md-2">
						<div class="form:input-prepend">
							<form:input id="startDate" path="transBaslangic" type="text" class="form-control" readonly="true" />
							<form:errors path="transBaslangic" cssClass="text-danger" />
						</div>
					</div>
				</div>		
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="bitis">Seyahat Sonu</label>
					<div class="col-md-2">
						<div class="form:input-prepend">
							<form:input id="finishDate" path="transBitis" type="text" class="form-control" readonly="true" />
							<form:errors path="transBitis" cssClass="text-danger" />
						</div>
					</div>
				</div>		
				
				
				
				
				
				
				
					

				
				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
					<div class="col-lg-10">				
						
						<form:select id="manufacturer" path="manufacturer" type="text" class="form:input-large">
							<form:option value="Apple">Apple</form:option>
							<form:option value="Google">Google</form:option>
							<form:option value="Samsung">Samsung</form:option>
						</form:select>--%>
					

				<div class="row">
				<div class=" col-md-offset-2 col-md-1">
				<div class="form-group">
					<div>
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Kaydet"/>
					</div>
				</div>
				</div>
				
				<div class="col-md-2">
					<a href="${pageContext.request.contextPath}/user/myTravelList" class="btn btn-info"
						type="button">İptal</a>
				</div>
				
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
