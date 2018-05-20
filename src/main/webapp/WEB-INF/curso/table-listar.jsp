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

<!-- Table -->
<table id="table-listar-datatable"
	class="table table-hover table-condensed table-striped table-bordered"
	style="width: 100%">

	<thead>

		<tr class="text-center">

			<td style="width: 30%">Nome</td>
			<td style="width: 20%">Área</td>
			<td style="width: 5%">Tipo de curso</td>
			<td style="width: 30%">Ações</td>

		</tr>

	</thead>

	<tbody>

		<c:forEach items="${cursos}" var="curso">

			<tr data-id="${curso.id}">

				<td>${curso.nome}</td>
				<td>${curso.area}</td>
				<td>${curso.tipo}</td>

				<td class="text-center">
					<div class="btn-group">
						<button type="button" class="btn btn-info btn-editar"
							data-toggle="modal" data-target="#modal-add-edit"
							data-tipo="Editar">
							<span class="fas fa-pencil-alt mr-1"></span>
						</button>

						<security:authorize access="hasRole('ADMIN')">
							<button type="button" class="btn btn-danger btn-deletar">
								<span class="far fa-trash-alt mr-1"></span>
							</button>
						</security:authorize>
					</div>
				</td>

			</tr>

		</c:forEach>

	</tbody>

</table>