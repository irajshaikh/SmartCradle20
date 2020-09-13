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



	<jsp:include page="sidenav.jsp"></jsp:include>


	<div class="container container-div">
		<div class="row">
			<div class="col s12 m8">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
						<span class="card-title">My profile</span>
						<div class="row">
							<form method="post" action="edit-profile" class="col s12">
								<div class="row">
									<div class="input-field col s12">
										<input id="icon_telephone" type="text" class="validate"
											name="mobNo" value="${profileData.mobNo}"
											maxlength="10" onkeypress='validatePhoneNumber(event)'>
											<label for="icon_telephone">Telephone</label>
									</div>
								</div>
								<div class="row">
									<div class="input-field col s12">
										<input id="baby_name" type="text" class="validate"
											name="babyName" value="${profileData.babyName}"
											maxlength="30"> 
											<label for="baby_name">Baby's name</label>
									</div>
								</div>
								<div class="row">
									<div class="col s6">
										<button onclick="toast()" class="btn waves-effect waves-light"
											type="submit" name="action">
											Submit <i class="material-icons right">send</i>
										</button>
									</div>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js'>
		
	</script>
	<script src='<c:url value="/js/script.js" />'></script>

</body>
</html>