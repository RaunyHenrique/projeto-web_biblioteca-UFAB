<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />

<!DOCTYPE html>
<style>
	#btn-logout{
		margin-top: 7px;
	}
</style>

<nav class="navbar navbar-default">
  <div class="container-fluid">
  
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Biblioteca UFAB</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
<!--       	home => emprestimos -->
      	<li><a href="home">Home</a></li>
      	<li><a href="alunos">Alunos</a></li>
      	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Itens do acervo <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Livros</a></li>
            <li><a href="#">Jornais</a></li>
            <li><a href="#">Anais de congresso</a></li>
            <li><a href="#">Trabalhos de conclusão</a></li>
            <li><a href="#">Midias eletronicas</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Adicionar autores</a></li>
            <li><a href="#">Adicionar editoras</a></li>
          </ul>
        </li>
      
      </ul>

      <ul class="nav navbar-nav navbar-right">
			
		<li>
		
			<form action="${path}/logout" method="post">
				
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<button id="btn-logout" type="submit" class="btn btn-danger">
				<span class="glyphicon glyphicon-log-out"></span> Logout</button>
			
			</form>
		
		</li>
			
      </ul>
    </div>
  </div>
</nav>