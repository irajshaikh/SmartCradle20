<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
	<div class="nav-wrapper">
		<a href="#" data-activates="mobile-demo"
			class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
		<span class="brand-logo">Smart Cradle</span>

		<ul class="side-nav grey darken-2" id="mobile-demo">
			<li class="sidenav-header blue">
				<div class="row">
					<div class="col s12">
						<span class="white-text name">${profileData.babyName}</span>
					</div>
				</div>
			</li>


			<li class="white"><a href="/" class="waves-effect waves-blue"><i
					class="material-icons">dashboard</i>Dashboard</a></li>
			<li class="white"><a href="edit-profile"
				class="waves-effect waves-blue"><i class="material-icons">edit</i>Edit
					profile</a></li>
			<li class="white"><a href="#" class="waves-effect waves-blue"><i
					class="material-icons">info</i>About us</a></li>

			<li class="sidenav-footer grey darken-2">
				<div class="row center-align">
					<div class="social-icons">
						<div class="col s12">
							<a href="https://www.linkedin.com/school/13645927/"><i
								class="fa fa-lg fa-linkedin-square"></i> </a> <a
								href="https://facebook.com/viitpu"><i
								class="fa fa-lg fa-facebook-official"></i></a>
						</div>
					</div>
				</div>
			</li>
		</ul>

	</div>

</nav>