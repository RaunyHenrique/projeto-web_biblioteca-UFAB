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
								<td style="width: 20%">Ano de publicação</td>
								<td style="width: 40%">Ações</td>

							</tr>

						</thead>

						<tbody class="text-center">

							<c:forEach items="${anais}" var="item">

								<tr data-id="${item.id}">

									<td>${item.titulo}</td>
									<td>${item.tipo}</td>
									<td>${item.anoDePublicacao}</td>
									
									<td class="text-center">
										<div class="btn-group">
										  	<button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Editar">
											<span class="glyphicon glyphicon-pencil"></span></button>
											
											<button type="button" class="btn btn-danger btn-deletar">
											<span class="glyphicon glyphicon-trash"></span></button>
										</div>
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>