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
								<td style="width: 5%">Data do emprestimo</td>
								<td style="width: 5%">Data da devolução</td>
								<td style="width: 5%">Status</td>
								<td style="width: 30%">Ações</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach items="${emprestimos}" var="emprestimo">

								<tr data-id="${emprestimo.id}">

									<td>${emprestimo.aluno.matricula}</td>
									<td>${emprestimo.aluno.nome}</td>
									<td>
									
										<c:forEach items="${emprestimo.items_emprestados}" var="item_emprestado">
											${item_emprestado.titulo}
										</c:forEach>
										
									</td>
									<td><fmt:formatDate value="${emprestimo.data_emprestimo}" pattern="dd/MM/yyyy"/></td>
									<td><fmt:formatDate value="${emprestimo.data_devolucao}" pattern="dd/MM/yyyy"/></td>
									<td class="text-center">
									
										<c:if test="${emprestimo.is_pendente == true}">Pendente</c:if>
										
										<c:if test="${emprestimo.is_pendente == false}">OK</c:if>
									
									</td>
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