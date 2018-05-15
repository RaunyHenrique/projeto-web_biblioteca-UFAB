<!DOCTYPE html>
<%@tag description="Template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%@attribute name="title"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
 
<html>
 <head>
 
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	
 	<title>${title}</title>
 	
 	<link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/bootstrap/css/bootstrap-theme.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/jquery-confirm.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/datatables.min.css" />" rel="stylesheet">
	
    <jsp:invoke fragment="header"/>
     
 </head>
 <body>
 
    <jsp:invoke fragment="body"/>
    
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-3.3.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/bootstrap/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-confirm.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/datatables.min.js" />"></script>
     
    <jsp:invoke fragment="footer"/>
     
 </body>
</html>