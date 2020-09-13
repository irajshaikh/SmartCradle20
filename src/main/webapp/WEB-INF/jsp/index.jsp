<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Smart Cradle</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel="stylesheet" href='/css/style.css'>
</head>
<body style="background-image: url('/images/bg.jpg')">

	<%
	// Set refresh, autoload time as 5 seconds
	response.setIntHeader("Refresh", 5);
	%>

	<jsp:include page="sidenav.jsp"></jsp:include>


	<div class="container container-div">
		<c:choose>
			<c:when test="${sensorData.temperature == -1}">
				<div class="row">
					<div class="col s12 l6 m6">
						<div class="card">
							<div class="card-image">
								<img src="/images/noDataFound.png">
							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>

				<div class="row">
					<div class="col s12 l4 m4">
						<div class="card">
							<div class="card-image">
								<img src="/images/temp.jpg">
							</div>
							<div class="card-content">
								<span class="card-title activator grey-text text-darken-4">${sensorData.temperature} &#176C</span>
							</div>
						</div>
					</div>
					<div class="col s12 l4 m4">
						<c:choose>
							<c:when test="${sensorData.hasWetDiaper}">

								<div class="card">
									<div class="card-image">
										<img src="/images/wet.png">
									</div>
									<div class="card-content">
										<span class="card-title activator grey-text text-darken-4">Baby's
											diaper is wet</span>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="card">
									<div class="card-image">
										<img src="/images/dry.jpg">
									</div>
									<div class="card-content">
										<span class="card-title activator grey-text text-darken-4">Baby's
											diaper is not wet</span>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col s12 l4 m4">
						<c:choose>
							<c:when test="${sensorData.isCrying}">
								<div class="card">
									<div class="card-image">
										<img src="/images/cryingBaby.jpg">
									</div>
									<div class="card-content">
										<span class="card-title activator grey-text text-darken-4">Baby
											is crying</span>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="card">
									<div class="card-image">
										<img class="adjust-width" src="/images/happyBaby.jpg">
									</div>
									<div class="card-content">
										<span class="card-title activator grey-text text-darken-4">Baby
											is not crying</span>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js'></script>
	<script src='<c:url value="/js/script.js" />'></script>

</body>
</html>