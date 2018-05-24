<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>

<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link href="<c:url value="/resources/css/datepicker.css"/>" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>

<script>
$( function() {
 
$( "#startDate, #finishDate" ).datepicker();
} );
 
</script>

</head>
<body>

	<!-- ----------------------------NAVBAR----------------------------------------------- -->

				<nav class="navbar navbar-inverse" style="margin-bottom:0px">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">Admin</a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li><a href="<c:url value="/admin/listUser" />">Kullanıcılar</a></li>
			        <li><a href="<c:url value="/admin/listTravel"/>">Seyahatler</a></li>
			       </ul>
			       
			        <ul class="nav navbar-nav navbar-right">
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${name}  <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				             <li><a href="<c:url value="/admin/updateMyProfile" />">${name}</a></li>
				            <li role="separator" class="divider"></li>
				            <li><a href="<c:url value="/login/logOut" />">Çıkış</a></li>
				          </ul>
				        </li>
				     </ul>
			      
			      
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
	

	
	<!-- --------------------------FORM-------------------------------------------------- -->
	
	<div class="row">
					<div class="col-md-11 col-md-offset-1">
					
						<form:form  modelAttribute="searchTravel" class="form-horizontal" method="post" >
							<fieldset>

								<!-- Form Name -->
								<legend>Seyahat Ara</legend>
								
					<!-- Text input -->
					<div class="form-group">
						<label class="control-label col-md-2" for="username">Kullanıcı</label>
						<div class="col-md-2">
							<form:select id="username" path="username" type="text"
								class="form:input-large form-control" items="${userNameList}" />
						</div>
					</div>

					<!-- Text input-->
								<div class="form-inline">
								<div class="form-group">
									<label class="col-md-3 control-label" for="SDate">Başlangıç</label>
									<div class="col-md-6">		
										<form:input id="startDate"  type="text" path="startDate" class="form-control input-md" readonly="true"/>
										<form:errors path="startDate" cssClass="text-danger" cssStyle="display: inline-flex;"/>
									</div>
								</div>
								
								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-2 control-label" for="FDate">Bitiş</label>
									<div class="col-md-6">		
										<form:input id="finishDate"  type="text" path="finishDate" class="form-control input-md" readonly="true"/>
										<form:errors path="finishDate" cssClass="text-danger" cssStyle="display: inline-flex;"/>
									</div>
								</div>

								

								

								<!-- Button -->
								<div class="form-group">
									<div class="col-md-4 col-md-offset-2">
										<input type="submit" id="btnAdd" class="btn btn-primary" value ="Ara"/>
									</div>
								</div>
							</div>
							</fieldset>
						</form:form>
					</div>
					<div class="col-md-6"></div>
				</div>
				<div class="row">
				<div class="col-md-offset-10">
					<a href="${pageContext.request.contextPath}/admin/addTravel" class="btn btn-info"
						type="button">Ekle</a>
				</div>
				</div>
	
	
	
	
	<!-- -------------------------------TABLE------------------------------------------------ -->
	
		<div class="row">
			<div class="col-md-12"></div>
			  <div class="row">
				<div class="col-md-10 col-md-offset-1">
					<legend>Seyahatler</legend>
					<div class="table-responsive">
						<table id="example" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Bölümü</th>
									<th>Müdürü</th>
									<th>Seyahat Eden</th>
									<th>Seyahat Başlangıcı</th>
									<th>Seyahat Sonu</th>
									<th>Seyahat Yeri</th>
									<th>Gidiş Amacı</th>
									<th>Seyahat Maliyeti</th>
									<th>Proje Kodu</th>
									<th>İşlemler</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${allTravels}" var="travel">

									<tr>
										<td><c:out value="${travel.kullanici.bolum}" /></td>
										<td><c:out value="${travel.kullanici.mudurAdi}" /></td>
										<td><c:out value="${travel.kullanici.kullaniciAdi}" /></td>
										<td><c:out value="${travel.transBaslangic}" /></td>
										<td><c:out value="${travel.transBitis}" /></td>
										<td><c:out value="${travel.seyahatYeri}" /></td>
										<td><c:out value="${travel.gidisAmaci}" /></td>
										<td><c:out value="${travel.maliyet}" /></td>
										<td><c:out value="${travel.projeKodu}" /></td>
										<td><a
											href="<c:url value="/admin/deleteTravel?travelId=${travel.id}" />"
											class="btn btn-danger" type="button">Sil</a>
											<a
											href="<c:url value="/admin/updateTravel?travelId=${travel.id}" />"
											class="btn btn-warning" type="button">Güncelle</a>
											
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
			<!--  button -->
			<div class="row">
				<div class="col-md-offset-1">
				<form id="myform" action="excelExport" class="form-horizontal" method="POST">
				<div class="form-group">
					<input type="submit" id="btnAdd" class="btn btn-primary" value ="Excel Olarak Çıkar"/>
				</div>
				</form>
			</div>	
		</div>
	</div>
	

	
	
</body>
</html>