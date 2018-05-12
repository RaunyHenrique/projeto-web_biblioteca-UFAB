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
	
	<label for="aluno" class="control-label">Aluno:
	
		<select class="form-control" id="aluno" name="aluno" required>

			<c:forEach items="${alunos}" var="aluno">
	
				<option value="${aluno.id}">${aluno.nome}</option>
	
			</c:forEach>

		</select>
	
	</label> 

	<div style="margin-top: 16px;">
	
		<label for="isPedente" class="control-label">Emprestimo pendente?:</label>
		<input type="checkbox" data-toggle="toggle" id="isPedente" name="isPedente" 
		data-on="Sim" data-off="Não" data-onstyle="danger" data-offstyle="success">
	
	</div>

	</div>
	
	<script>
	
		$(document).ready(function() {
			
		    $('#aluno').select2({
		    	placeholder: 'Selecione...',
		        width: 'resolve', // need to override the changed default
		    });
		    
		});
	
	</script>
	
</jsp:attribute>

</tagModal:modal>
