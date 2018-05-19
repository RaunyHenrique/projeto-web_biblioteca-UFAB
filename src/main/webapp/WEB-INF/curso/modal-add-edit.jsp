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

	<label for="nome" class="control-label">Nome:</label>
	<input type="text" class="form-control" id="nome" name="nome">
	
	<label for="area" class="control-label">Área:</label>
	<input type="text" class="form-control" id="area" name="area">
	
	<label for="tipo_curso" class="control-label">Tipo de
		curso: </label> 
	<select class="form-control" id="tipo" name="tipo" required>

		<c:forEach items="${tipo_curso}" var="tipo">

			<option value="${tipo}">${tipo}</option>

		</c:forEach>

	</select>
    
	</div>
			
</jsp:attribute>

</tagModal:modal>
