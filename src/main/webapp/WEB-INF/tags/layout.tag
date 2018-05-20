<!DOCTYPE html>
<%@tag description="Template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%@attribute name="title"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
 
<html lang="pt-br">
 <head>
 
 	<style type="text/css">
 
 		.dataTables_wrapper .dataTables_length {
			float: left;
		}
		.dataTables_wrapper .dataTables_filter {
			float: right;
			text-align: left;
		}
		
		div.dt-buttons {
			position:relative;
			float:right;
			margin-top: -2px;
			padding-left: 8px;
		}
		
		body {
		  margin:0;
		  padding:0;  
		  display:flex;
		  flex-direction:column;
		  justify-content:space-between;
		  min-height:100vh;
		}
		
		.container {
		  flex:1 0 auto;
		}
		
/* 		footer { */
/* 		    position: fixed; */
/* 		    bottom: 0; */
/* 		    clear: both; */
/* 		    width: 100%; */
/* 		} */
 		
 	</style>
 
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 	<meta http-equiv="x-ua-compatible" content="ie=edge">
 
 	<title>${title}</title>
 	
 	<link href="<c:url value="/assets/bootstrap/css/bootstrap-reboot.min.css" />" rel="stylesheet">
 	<link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/jquery-confirm.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/datatables.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/jquery.toast.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/bootstrap-tagsinput.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/fontawesome-all.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/mdb.min.css" />" rel="stylesheet">
	
    <jsp:invoke fragment="header"/>
     
 </head>
 <body>
 
    <jsp:invoke fragment="body"/>
    
	<!--Footer-->
	<footer class="page-footer center-on-small-only indigo pt-0 mt-5">
		
	    <!--Copyright-->
	    <div class="footer-copyright py-3 text-center">
	        <a href="#"> Criado por: Rauny Henrique Bezerra e Luis Lancelote </a>
	    </div>
	    <!--/.Copyright-->
	
	</footer>
	<!--/.Footer-->
    
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-3.3.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/bootstrap/js/popper.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/bootstrap/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-confirm.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/datatables.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.toast.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-tagsinput.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/mdb.min.js" />"></script>
    
    <jsp:invoke fragment="footer"/>
     
 </body>
</html>