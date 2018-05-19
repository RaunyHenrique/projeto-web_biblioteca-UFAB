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
	
	<label for="nome" class="control-label">Nome:</label>
	<input type="text" class="form-control" id="nome" name="nome" required>
	
	<label for="email" class="control-label">Email:</label>
	<input type="email" class="form-control" id="email" name="email" required>
	
	<label for="senha" class="control-label">Senha:</label>
	<input type="password" class="form-control" id="senha" name="senha" required>
	
	<label for="cpf" class="control-label">Cpf:</label>
	<input type="number" class="form-control" id="cpf" name="cpf" required>
	
	<label for="rg" class="control-label">Rg:</label>
	<input type="number" class="form-control" id="rg" name="rg" required>
	
	<label for="naturalidade" class="control-label">Naturalidade:</label>
	<input type="text" class="form-control" id="naturalidade" name="naturalidade" required>
	
	<label for="endereco" class="control-label">Endereço:</label>
	<input type="text" class="form-control" id="endereco" name="endereco" required>
	
	<label for="telefone" class="control-label">Telefone:</label>
	<input type="tel" class="form-control" id="telefone" name="telefone" required>
	
	<label for="permissoes" class="control-label">Permissões:</label> 
	<select class="form-control" id="permissoes" name="permissoes" required>

		<c:forEach items="${permissoes}" var="permissao">

			<option value="${permissao.id}">${permissao.nome}</option>

		</c:forEach>

	</select>

	</div>
	
	<script>
	
		$(document).ready(function() {
			
		    $('#permissoes').select2({
		    	placeholder: 'Selecione...',		    
		    });
		    
			$('[name="senha"]').focus(function() {
				
				$('[name="senha"]').val('');

			});
		    
		});
	
	</script>
	
</jsp:attribute>

</tagModal:modal>
