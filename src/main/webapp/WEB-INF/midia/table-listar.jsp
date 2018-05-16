<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
			<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
				<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
					<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					
					<!-- Table -->
					<table id="table-listar-datatable" class="table table-hover table-condensed table-striped table-bordered" style="width:100%">

						<thead>

							<tr class="text-center">

								<td style="width: 20%">Título</td>
								<td style="width: 20%">Tipo</td>
								<td style="width: 20%">Data de gravação</td>
								<td style="width: 40%">Ações</td>

							</tr>

						</thead>

						<tbody class="text-center">

							<c:forEach items="${midias}" var="midia">

								<tr data-id="${midia.id}">

									<td>${midia.titulo}</td>
									<td>${midia.tipo}</td>
									<td><fmt:formatDate value="${midia.dataDeGravacao}" pattern="dd/MM/yyyy"/></td>
									
									<td class="text-center">
										<button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Editar">
										<span class="glyphicon glyphicon-edit"></span> Editar</button>
										<button type="button" class="btn btn-danger btn-deletar">
										<span class="glyphicon glyphicon-trash"></span> Deletar</button>
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>