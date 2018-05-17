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

								<td style="width: 5%">Matricula</td>
								<td style="width: 20%">Aluno</td>
								<td style="width: 30%">Itens</td>
								<td style="width: 5%">Dias de atraso</td>
								<td style="width: 5%">Valor da multa</td>
								<td style="width: 30%">Ações</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach items="${pendencias}" var="pendencia">

								<tr data-id="${pendencia.id}">

									<td>${pendencia.aluno.matricula}</td>
									<td>${pendencia.aluno.nome}</td>
									<td>
									
										<c:forEach items="${pendencia.items_emprestados}" var="item_emprestado">
											${item_emprestado.titulo}
										</c:forEach>
										
									</td>
									<td><fmt:formatDate value="${pendencia.data_emprestimo}" pattern="dd/MM/yyyy"/></td>
									<td>valor</td>

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