<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>InfoTex</title>

<!-- Global stylesheets -->
<link href="../assets/images/favicon.ico" rel="shortcut icon" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900"
	rel="stylesheet" type="text/css">
<link href="../assets/css/icons/icomoon/styles.css" rel="stylesheet"
	type="text/css" />
<link href="../assets/css/icons/fontawesome/styles.min.css"
	rel="stylesheet" type="text/css" />
<link href="../assets/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/core.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/theme.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/components.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/colors.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/withoustjsf.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/responsive.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/custom6.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/overrides/components.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/overrides/theme.css"
		rel="stylesheet" type="text/css" />
<!-- /global stylesheets -->

<!-- Core JS files -->
<script type="text/javascript"
	src="../assets/js/plugins/loaders/pace.min.js"></script>
<script type="text/javascript"
	src="../assets/js/core/libraries/jquery.min.js"></script>
<script type="text/javascript"
	src="../assets/js/core/libraries/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../assets/js/plugins/loaders/blockui.min.js"></script>
<!-- /core JS files -->

<!-- Theme JS files -->
<script type="text/javascript"
	src="../assets/js/plugins/forms/styling/uniform.min.js"></script>

<script type="text/javascript" src="../assets/js/core/app.js"></script>
<script type="text/javascript" src="../assets/js/pages/invoice_grid.js"></script>
<script type="text/javascript" src="../assets/js/pages/layout_fixed_custom.js"></script>
<script type="text/javascript" src="../assets/js/pages/layout_navbar_hideable_sidebar.js"></script>
<!-- /theme JS files -->

</head>

<body class="sidebar-xs  has-detached-right">

	<!-- Main navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="dashboard.xhtml"><img
				src="../assets/images/logo_light.png" alt=""> <span
				class="brand-title">Co-optex</span></a>

			<ul class="nav navbar-nav visible-xs-block">
				<li><a data-toggle="collapse" data-target="#navbar-mobile"><i
						class="icon-tree5"></i></a></li>
				<li><a class="sidebar-mobile-main-toggle"><i
						class="icon-paragraph-justify3"></i></a></li>
				<li><a class="sidebar-mobile-detached-toggle"><i
						class="icon-grid7"></i></a></li>
			</ul>
		</div>

		<div class="navbar-collapse collapse" id="navbar-mobile">
			<ul class="nav navbar-nav">
				<li><a class="sidebar-control sidebar-main-toggle hidden-xs">
						<i class="icon-paragraph-justify3"></i>
				</a></li>


			</ul>


			<div class="navbar-right">
				<ul class="nav navbar-nav">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-bubbles4"></i> <span
							class="visible-xs-inline-block position-right">Messages</span> <span
							class="badge bg-warning-400">2</span>
					</a>

						<div class="dropdown-menu dropdown-content width-350">
							<div class="dropdown-content-heading">
								Messages
								<ul class="icons-list">
									<li><a href="#"><i class="icon-compose"></i></a></li>
								</ul>
							</div>

							<ul class="media-list dropdown-content-body">

							</ul>

							<div class="dropdown-content-footer">
								<a href="#" data-popup="tooltip" title="All messages"><i
									class="icon-menu display-block"></i></a>
							</div>
						</div></li>

					<li class="dropdown dropdown-user"><a class="dropdown-toggle"
						data-toggle="dropdown"> <img
							src="/assets/images/placeholder.jpg" alt=""> <span>User</span>
							<i class="caret"></i>
					</a>

						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="#"><i class="icon-user-plus"></i> My
									profile</a></li>
							<li><a href="#"><i class="icon-coins"></i> My balance</a></li>
							<li><a href="#"><span class="badge bg-blue pull-right">58</span>
									<i class="icon-comment-discussion"></i> Messages</a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="icon-cog5"></i> Account
									settings</a></li>
							<li><a href="#"><i class="icon-switch2"></i> Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- /main navbar -->


	<!-- Page container -->
	<div class="page-container">

		<!-- Page content -->
		<div class="page-content">

			<!-- Main sidebar -->
			<tiles:insertAttribute name="menu" />
			<!-- /main sidebar -->





			<!-- Main content -->
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />

		</div>
		<!-- /page content -->

	</div>
	<!-- /page container -->

	<tiles:insertAttribute name="model" />
	<tiles:insertAttribute name="script" />

</body>
</html>