<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Table -->
<table id="table-listar-datatable"
	class="table table-hover table-condensed table-striped table-bordered"
	style="width: 100%">

	<thead>

		<tr class="text-center">

			<td style="width: 30%">Titulo</td>
			<td style="width: 20%">Quantidade disponível</td>
			<td style="width: 30%">Localização (corredor/estante/prateleira)</td>
			<td style="width: 20%">Palavras chaves</td>

		</tr>

	</thead>

	<tbody>

		<c:forEach items="${itens}" var="item">

			<tr data-id="${item.id}">

				<td>${item.item_tipo} - ${item.titulo}</td>
				<td>${item.quantidade_emprestada}/${item.quantidade}</td>
				<td>${item.corredor} / ${item.estante} / ${item.prateleira}</td>
				<td>
				
					<c:forEach var="splt" items="${fn:split(item.palavra_chave,',')}">
					
						<span class="badge cyan">${splt}</span>
					     
					</c:forEach>

				</td>
				
			</tr>

		</c:forEach>

	</tbody>

</table>