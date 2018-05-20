<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />

<tag:layout title="Login">
 
<jsp:attribute name="header">

	<link href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	
	<link href="<c:url value="/assets/bootstrap/css/bootstrap-theme.min.css" />" rel="stylesheet">
	
	<style type="text/css">
		
		#login {
			width: 400px;
			margin-left: auto;
			margin-right: auto;
			margin-top: 100px;
		}
		
		#btn-login {
			width: 100%;
		}
		
		body {
		  margin:0;
		  padding:0;  
		  display:flex;
		  flex-direction:column;
		  justify-content:space-between;
		  min-height:100vh;
		}
		
		section {
		  flex:1 0 auto;
		}
		
	</style>

</jsp:attribute>
 
<jsp:attribute name="body">

	<section id="login" class="panel panel-primary">
	
		<c:if test="${not empty param['error']}">
		
			<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
	
					<p>Usuário ou senha incorretos.</p>
	
			</div>
		
		</c:if>
		
		<c:if test="${not empty param['logout']}">
		
			<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
	
					<p>Saiu com sucesso!</p>
	
			</div>
		
		</c:if>
		
		
		<!-- Card -->
		<div class="card lx-xl-5">
		
		    <!-- Card body -->
		    <div class="card-body">
		
		        <form action="${path}/autenticar" method="post">
		            <p class="h4 text-center py-4">Biblioteca - UFAB</p>
		
					<div class="form-group">
	
						<label for="email" class="control-label">Email:</label> <input
							type="email" class="form-control" id="email" name="email" required>
	
						<label for="password" class="control-label">Senha:</label> <input
							type="password" class="form-control" id="password" name="password" required>
						
					  <div class="custom-control custom-checkbox my-1 mr-sm-2">
					    <input type="checkbox" class="custom-control-input" id="remember-me" name="remember-me">
					    <label class="custom-control-label" for="remember-me">Lembrar-me?</label>
					  </div>
	
					</div>
					
					<input type="hidden" name="_csrf" value="${_csrf.token}">
		
		            <div class="text-center py-4 mt-3">
		                <button class="btn btn-indigo" type="submit"><i class="fas fa-sign-in-alt ml-2"></i> Login</button>
		            </div>
		        </form>
		
		    </div>
		    <!-- Card body -->
		
		</div>
		<!-- Card -->

	</section>

</jsp:attribute>
 
</tag:layout>
