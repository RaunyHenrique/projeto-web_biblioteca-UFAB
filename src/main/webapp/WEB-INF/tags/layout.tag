<!DOCTYPE html>
<%@tag description="Template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%@attribute name="title"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
 
<html>
 <head>
 
 	<style type="text/css">
 		
 		div.dt-buttons {
		    float: right;
		    margin-top: -2px;
		    padding-left: 8px;
		}
 		
 	</style>
 
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	
 	<title>${title}</title>
 	
 	<link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/bootstrap/css/bootstrap-theme.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/jquery-confirm.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/datatables.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/jquery.toast.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/bootstrap-tagsinput.css" />" rel="stylesheet">
<%-- 	<link href="<c:url value="/assets/css/mdb.min.css" />" rel="stylesheet"> --%>
	
    <jsp:invoke fragment="header"/>
     
 </head>
 <body>
 
    <jsp:invoke fragment="body"/>
    
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-3.3.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/bootstrap/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-confirm.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/datatables.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.toast.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-tagsinput.min.js" />"></script>
<%--     <script type="text/javascript" src="<c:url value="/assets/js/mdb.min.js" />"></script> --%>
    
    <jsp:invoke fragment="footer"/>
     
 </body>
</html>