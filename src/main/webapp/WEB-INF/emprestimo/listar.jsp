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
		
		<div id="tabs">

		  <!-- Nav tabs -->
		  <ul class="nav nav-tabs" role="tablist" id="tabs-links">
		    <li role="presentation" class="active"><a href="home" id="home" aria-controls="home" role="tab" data-url="/biblioteca_ufab/home">Emprestimos</a></li>
		    <li role="presentation"><a href="reservas" id="reservas" aria-controls="profile" role="tab" data-url="/biblioteca_ufab/reservas">Reservas</a></li>
		    <li role="presentation"><a href="#devolucoes" id="devolucoes" aria-controls="messages" role="tab">Devoluções</a></li>
		  </ul>
		
			<button type="button" id="btn-inserir" class="btn btn-primary" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Inserir">
				<span class="glyphicon glyphicon-plus"></span> Realizar novo emprestimo
			</button>
	
			<section id="section-table">
	
				<jsp:include page="table-listar.jsp"></jsp:include>
	
			</section>
		
		</div>

	</div>

</jsp:attribute>

<jsp:attribute name="footer">

	<script type="text/javascript" src="<c:url value="/assets/js/select2.full.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/data-table-config.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/modal-request.js" />"></script>
	
	<script>
	
		$(document).ready(function() {
			
			
// 			$('#tabs').on('click','.tablink,#tabs-links a',function (e) {
				
// 			    e.preventDefault();
			    			    
// 			    var url = $(this).attr("data-url");
// 			    var tabUrl = $(this).attr("id");
			    
// 			    if (typeof url !== "undefined") {
			    	
// 			        var href = this.hash;
			        
// 			        // ajax load from data-url
// 			        $('#section-table').load(url,function(result){      
			        				        				        				        				            
// 			           // $(this).html(result);
			               
// 			            //update url
// 			           	//$("#form-add-edit").data('url', tabUrl);
			            
// 			            //update listerners
// 			            //aplicarDataTable();
			            
// 			            //aplicarListenersTable();
			            
// 			            //USAR??
// 			            //aplicarListenersModal();
			            			            			            
// 			        });
			        
// 			    } else {
			    	
// 			        $(this).tab('show');
			        
// 			    }
			//});
	
		});
	
	</script>

	<jsp:include page="modal-add-edit.jsp"></jsp:include>

</jsp:attribute>
 
</tag:layout>
