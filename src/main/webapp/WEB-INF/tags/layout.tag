<!DOCTYPE html>
<%@tag description="Template" pageEncoding="UTF-8"%>
 
<%@attribute name="title"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
 
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>${title}</title>
     <jsp:invoke fragment="header"/>
 </head>
 <body>
     <jsp:invoke fragment="body"/>
     <jsp:invoke fragment="footer"/>
 </body>
</html>