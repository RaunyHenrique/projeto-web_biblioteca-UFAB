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
	<input type="text" class="form-control" id="titulo"name="titulo">
	
	<label for="nomeDoCongresso" class="control-label">Nome do congresso:</label>
	<input type="text" class="form-control" id="nomeDoCongresso" name="nomeDoCongresso" required> 
			
	<label for="local" class="control-label">Local de publicação:</label>
	<input type="text"  class="form-control" id="local" name="local" required>
	
	<label for="anoDePublicacao" class="control-label">Ano de publicação:</label>
	<input type="number"  class="form-control" id="anoDePublicacao" name="anoDePublicacao" required>
	
	<label for="autores" class="control-label">Autores:</label>
	<input type="text"  class="form-control" id="autores" name="autores" required>
	
	<label for="tipo" class="control-label">tipo:</label>
		<select class="form-control" id="tipo"
		name="tipo" required>

			<c:forEach items="${tipos}" var="tipo">
				<option value="${tipo}">${tipo}</option>
			</c:forEach>
		</select>
		
			<label style="margin-top: 8px;" class="control-label">Item do acervo:</label>
	<div class="panel panel-default">
	  <div class="panel-body">
	  
	  <label for="quantidade" class="control-label">Quantidade:</label>
	<input type="number" class="form-control" id="quantidade" name="quantidade" required> 
	
	<label for="palavra_chave" class="control-label">Palavras chave:</label>
	<input type="text" class="form-control" id="palavra_chave"name="palavra_chave">
	
	<label class="control-label">Localização:</label>
	<div class="row">
		  <div class="col-xs-6 col-md-4">
		  
		  <div class="form-group">
			<label for="estante" class="sr-only">Estante:</label>
			<input type="text" class="form-control" id="estante"name="estante" placeholder="Estante">
		  </div>
		  
		  </div>
		  <div class="col-xs-6 col-md-4">
		  
		  <div class="form-group">
			<label for="corredor" class="sr-only">Corredor:</label>
			<input type="text" class="form-control" id="corredor"name="corredor" placeholder="Corredor">
		  </div>
		  
		  </div>
		  <div class="col-xs-6 col-md-4">
		  
		  <div class="form-group">
			<label for="prateleira" class="sr-only">Prateleira:</label>
			<input type="text" class="form-control" id="prateleira"name="prateleira" placeholder="Prateleira">
		</div>
		  
		  </div>
	</div>
    
	  </div>
	</div>
		
</div>
	
</jsp:attribute>

</tagModal:modal>
