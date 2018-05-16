<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Modal -->
<%@ taglib prefix="tagModal" tagdir="/WEB-INF/tags" %>

<tagModal:modal url="${url}">

<jsp:attribute name="modal_csrf_token">

	<input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">

</jsp:attribute>

<jsp:attribute name="modal_body">

	<div class="form-group">

	<input type="hidden" class="form-control" id="id" name="id">

	<label for="data_reserva_entrega" class="control-label">Data para reserva:</label>
	<input type="date"  class="form-control" id="data_reserva_entrega" name="data_reserva_entrega" required> 
		
	<label for="aluno" class="control-label">Aluno:</label> 
	<select class="form-control" id="aluno" name="aluno" required>

		<c:forEach items="${alunos}" var="aluno">

			<option value="${aluno.id}">${aluno.matricula} - ${aluno.nome}</option>

		</c:forEach>

	</select>
		
	<label for="item" class="control-label">Item do emprestimo (*disponiveis para reserva):</label> 
	<select class="form-control" id="item" name="item" required>

		<c:forEach items="${itensDoAcervo}" var="item">

			<option value="${item.id}">${item.tipo} - ${item.titulo}</option>

		</c:forEach>

	</select>
	
	<div style="margin-top: 16px;">
	
		<div class="checkbox-nice">
		                 
		   <input class="checkbox-nice" type="checkbox" value="false" id="receber_notificacao" name="receber_notificacao">
		   <label for="receber_notificacao"> Receber notificação? </label>
		   
		</div>
		
	</div>

	</div>
	
	<script>
	
		$(document).ready(function() {
			
		    $('#aluno').select2({
		    	placeholder: 'Selecione...',	    
		    });
		    
		    $('#item').select2({
		    	placeholder: 'Selecione...',			    
		    });
		    
		});
	
	</script>
	
</jsp:attribute>

</tagModal:modal>
