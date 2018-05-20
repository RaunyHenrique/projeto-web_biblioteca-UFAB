<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<style>
/* 	#btn-logout{ */
/* 		margin-top: 7px; */
/* 	} */
</style>

<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark indigo">

    <!-- Navbar brand -->
    <a class="navbar-brand" href="#">Biblioteca - UFAB</a>

    <!-- Collapse button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Collapsible content -->
    <div class="collapse navbar-collapse" id="basicExampleNav">

        <!-- Links -->
        <ul class="navbar-nav mr-auto">
        
<!--             <li class="nav-item active"> -->
<!--                 <a class="nav-link" href="#">Home -->
<!--                     <span class="sr-only">(current)</span> -->
<!--                 </a> -->
<!--             </li> -->

      	<li class="nav-item active"><a class="nav-link" href="/biblioteca_ufab/home">Home</a></li>
      	<li class="nav-item"><a class="nav-link" href="/biblioteca_ufab/alunos">Alunos</a></li>
      	<li class="nav-item"><a class="nav-link" href="/biblioteca_ufab/cursos">Cursos</a></li>
		<security:authorize access="hasRole('ADMIN')">
		
     		<li class="nav-item"><a class="nav-link" href="/biblioteca_ufab/funcionarios">Funcionários</a></li>
	      	
            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Itens do acervo</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/biblioteca_ufab/livros">Livros</a>
                    <a class="dropdown-item" href="/biblioteca_ufab/jornais">Jornais</a>
                    <a class="dropdown-item" href="/biblioteca_ufab/revistas">Revistas</a>
                    <a class="dropdown-item" href="/biblioteca_ufab/anais">Anais de congresso</a>
                    <a class="dropdown-item" href="/biblioteca_ufab/trabalhos">Trabalhos de conclusão</a>
                    <a class="dropdown-item" href="/biblioteca_ufab/midias">Midias eletronicas</a>
                </div>
            </li>
	        
		</security:authorize>

        </ul>
        <!-- Links -->
        
		<ul class="navbar-nav ml-auto">
             <li class="nav-item">
                 <a class="nav-link waves-effect waves-light" href="" id="btn-logout">
                     <i class="fa fa-sign-out-alt"></i> Logout
                 </a>
             </li>
         </ul>

		<input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">

    </div>
    <!-- Collapsible content -->

</nav>
<!--/.Navbar-->  
