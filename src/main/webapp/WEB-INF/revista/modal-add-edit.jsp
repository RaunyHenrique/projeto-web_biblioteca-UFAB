<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Modal -->
<%@ taglib prefix="tagModal" tagdir="/WEB-INF/tags"%>

<tagModal:modal url="${url}">

	<jsp:attribute name="modal_csrf_token">

	<input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">

</jsp:attribute>

	<jsp:attribute name="modal_body">

	<div class="form-group">

	<input type="hidden" class="form-control" id="id" name="id">
	
	<label for="titulo" class="control-label">Título:</label>
	<input type="text" class="form-control" id="titulo" name="titulo">
	
	<label for="dataDePublicacao" class="control-label">Data de publicação:</label>
	<input type="date" class="form-control" id="dataDePublicacao"
				name="dataDePublicacao" required> 

	<label for="edicao" class="control-label">Edição:</label>
	<input type="number" class="form-control" id="edicao" name="edicao">
	
	<label for="numeroDePaginas" class="control-label">Numero de paginas:</label>
	<input type="number" class="form-control" id="numeroDePaginas"
				name="numeroDePaginas">
	
	<tagModal:form_item_acervo></tagModal:form_item_acervo>
    
	</div>
			
</jsp:attribute>

</tagModal:modal>
