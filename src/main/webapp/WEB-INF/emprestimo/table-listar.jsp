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
									
										<c:if test="${emprestimo.is_pendente == false}">Pendente</c:if>
										
										<c:if test="${emprestimo.is_pendente == true}">OK</c:if>
									
									</td>
									<td>

									<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
									    <div class="btn-group mr-2" role="group" aria-label="First group">
									    
									   	<button type="button" class="btn btn-danger btn-deletar lighten-2">
										<span class="far fa-trash-alt mr-1"></span></button>
										
										<button type="button" class="btn btn-info btn-renovar lighten-2" data-tipo="Editar">
										<span class="fas fa-sync-alt mr-1"></span></button>
										
										<button type="button" class="btn btn-primary btn-finalizar lighten-2" data-urlfinalizar="${url}">
										<span class="fas fa-check mr-1"></span></button>
						
									    </div>
									</div>
									
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>