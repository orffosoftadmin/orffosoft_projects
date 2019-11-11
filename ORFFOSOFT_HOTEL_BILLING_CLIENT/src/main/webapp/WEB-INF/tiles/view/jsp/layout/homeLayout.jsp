<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!doctype html>
<html lang="en">

<!-- Mirrored from demo.thedevelovers.com/dashboard/klorofil-v2.0/elements.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Jul 2017 10:24:50 GMT -->
<head>
<title>
<tiles:getAsString name="title" />
</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<!-- VENDOR CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/datepicker.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/linearicons/style.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">

<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css">

<!-- GOOGLE FONTS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.css">
<%-- 
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
--%>
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/assets/img/favicon.png">
</head>
<body>
<!-- WRAPPER -->
<div id="wrapper"> 
  
  <!-- NAVBAR -->
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="brand"> <a href="index-2.html"><img src="${pageContext.request.contextPath}/assets/img/finatel_logo.png" alt="Klorofil Logo" class="img-responsive logo"></a> </div>
    <div class="container-fluid">
      <div class="navbar-btn">
        <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
      </div>
      
      <div id="navbar-menu">
        <ul class="nav navbar-nav navbar-right">
          <%--
						<li class="dropdown">
							<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								<i class="lnr lnr-alarm"></i>
								<span class="badge bg-danger">5</span>
							</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
								<li><a href="#" class="more">See all notifications</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic Use</a></li>
								<li><a href="#">Working With Data</a></li>
								<li><a href="#">Security</a></li>
								<li><a href="#">Troubleshooting</a></li>
							</ul>
						</li>
                        --%>
                   <c:if test="${emp.firstName!=null}">     
          <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="${pageContext.request.contextPath}/assets/img/user.png" class="img-circle" alt="Avatar"> <span>${emp.firstName}&nbsp;${emp.lastName}</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath}/myfinatel/myprofile"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
              <%--
              <li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
              <li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
              --%>
              <li><a href="${pageContext.request.contextPath}/logout"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
            </ul>
          </li>
          </c:if>
          <!-- <li>
							<a class="update-pro" href="https://www.themeineed.com/downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
        </ul>
      </div>
    </div>
  </nav>
  <!-- END NAVBAR --> 
  
  <!-- LEFT SIDEBAR -->
  <tiles:insertAttribute name="sideMenu" />
  <!-- END LEFT SIDEBAR --> 
  
  <!-- MAIN -->
  <div class="main"> 
    
    <!-- MAIN CONTENT -->
    
    <tiles:insertAttribute name="body" />
    
    
    <!-- END MAIN CONTENT --> 
  </div>
  <!-- END MAIN -->
  
  <div class="clearfix"></div>
  <footer>
    <div class="container-fluid">
      <p class="copyright">&copy; 2017 <a href="https://www.finateltech.com/" target="_blank">Cooptex</a>. All Rights Reserved.</p>
    </div>
  </footer>
</div>
<!-- END WRAPPER --> 

<!-- Javascript --> 
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap-datepicker.js"></script> 
<script src="${pageContext.request.contextPath}/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script> 
<script src="${pageContext.request.contextPath}/assets/scripts/klorofil-common.js"></script>
 <tiles:insertAttribute name="script" />
</body>


</html>