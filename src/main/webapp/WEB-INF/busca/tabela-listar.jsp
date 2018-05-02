<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Table -->
<table
	class="table table-hover table-condensed table-striped table-bordered">

	<thead>

		<tr class="text-center">

			<td style="width: 10%">#</td>
			<td style="width: 30%">Titulo</td>
			<td style="width: 20%">Autor</td>
			<td style="width: 5%">Estante</td>
			<td style="width: 5%">Corredor</td>
			<td style="width: 30%">Prateleira</td>

		</tr>

	</thead>

	<tbody>

		<c:forEach items="${resultados}" var="resultado">

			<tr data-id="${resultado.id}">

				<td>${resultado.id}</td>
				<td>${resultado.titulo}</td>
				<td>${resultado.autor}</td>
				<td>${resultado.estante}</td>
				<td>${resultado.corredor}</td>
				<td>${resultado.prateleira}</td>

			</tr>

		</c:forEach>

	</tbody>

	<tfoot>

		<tr>

			<td colspan="6">Total de itens cadastrados: <span
				id="total-items">${resultados.size()}</span>
			</td>

		</tr>

	</tfoot>

</table>