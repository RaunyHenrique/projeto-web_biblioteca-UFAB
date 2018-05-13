<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Modal -->
<%@taglib prefix="tagModal" tagdir="/WEB-INF/tags" %>

<tagModal:modal url="${url}">

<jsp:attribute name="modal_csrf_token">

	<input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">

</jsp:attribute>
 
<jsp:attribute name="modal_body">

	<div class="form-group">

	<input type="hidden" class="form-control" id="id" name="id">
	
	<label for="aluno" class="control-label">Aluno:</label> 
	<select class="form-control" id="aluno" name="aluno" required>

		<c:forEach items="${alunos}" var="aluno">

			<option value="${aluno.id}">${aluno.matricula} - ${aluno.nome}</option>

		</c:forEach>

	</select>
	
	<label for="items_emprestados" class="control-label">Itens do emprestimo (*disponiveis):</label> 
	<select class="form-control" id="items_emprestados" name="items_emprestados" required multiple="multiple">

		<c:forEach items="${itensDoAcervo}" var="item">

			<option value="${item.id}">${item.tipo} - ${item.titulo}</option>

		</c:forEach>

	</select>

	<div style="margin-top: 16px;">
	
		<div class="checkbox-nice">
		                 
		   <input class="checkbox-nice" type="checkbox" value="false" id="is_pedente" name="is_pedente">
		   <label for="is_pedente"> Emprestimo pendente? </label>
		   
		</div>
		
	</div>

	</div>
	
	<script>
	
		$(document).ready(function() {
			
			// url
			var url = "emprestimos/alunos";
			
		    $('#aluno').select2({
		    	
		    	placeholder: 'Selecione...',
		    	
// 				ajax: {
// 					url : url,
// 					dataType: 'json',
// 				    processResults: function (data) {
				    	
// 				        return {
// 				            results: data
// 				          };
						
// 				    }
// 				},
						    
		    });
		    
		    $('#items_emprestados').select2({
		    							    
		    });
		    
		});
	
	</script>
	
</jsp:attribute>

</tagModal:modal>
