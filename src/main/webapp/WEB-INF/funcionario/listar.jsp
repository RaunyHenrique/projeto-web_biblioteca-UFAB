<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:layout title="${titulo}">
 
<jsp:attribute name="header">

	<link href="<c:url value="/assets/css/checkbox-nice.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/select2.min.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/bootstrap-datepicker3.min.css" />" rel="stylesheet">
	
	<style type="text/css">
		
		#btn-inserir {
			margin-top: 8px;
			margin-bottom: 16px;
		}
		
		.select2 {
			width:100%!important;
		}
		
	</style>

</jsp:attribute>
 
<jsp:attribute name="body">

	<div class="container">

		<jsp:include page="../menu.jsp"></jsp:include>

		<c:if test="${not empty mensagensErro}">

			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

				<h3>Ops, ocorrem os seguintes erros:</h3>

				<c:forEach items="${mensagensErro}" var="mensagem">

					<p>
						<strong>${mensagem.getField()}</strong>
						${mensagem.getDefaultMessage()}
					</p>

				</c:forEach>

			</div>

		</c:if>

		<c:if test="${not empty mensagemSucesso}">

			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

				<h3>${mensagemSucesso}</h3>

			</div>

		</c:if>
		
		<button type="button" id="btn-inserir" class="btn btn-primary" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Inserir">
			<span class="glyphicon glyphicon-plus"></span> Cadastrar funcionário
		</button>

		<section id="section-table">

			<jsp:include page="table-listar.jsp"></jsp:include>

		</section>

	</div>

</jsp:attribute>

<jsp:attribute name="footer">

	<script type="text/javascript" src="<c:url value="/assets/js/select2.full.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/data-table-config.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/bootstrap-datepicker.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/bootstrap-datepicker.pt-BR.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/modal-request.js" />"></script>

	<jsp:include page="modal-add-edit.jsp"></jsp:include>

</jsp:attribute>
 
</tag:layout>
