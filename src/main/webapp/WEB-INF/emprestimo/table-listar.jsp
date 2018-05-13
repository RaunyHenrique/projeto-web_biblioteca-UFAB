<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
			<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
				<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

					<!-- Table -->
					<table class="table table-hover table-condensed table-striped table-bordered">

						<thead>

							<tr class="text-center">

								<td style="width: 10%">Aluno</td>
								<td style="width: 40%">Itens</td>
								<td style="width: 20%">Status</td>
								<td style="width: 30%">Ações</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach items="${emprestimos}" var="emprestimo">

								<tr data-id="${emprestimo.id}">

									<td>${emprestimo.aluno.nome}</td>
									<td>
										<c:forEach items="${item.items_emprestados}" var="item_emprestado">
											${item_emprestado.titulo}
										</c:forEach>
										
									</td>
									<td>${emprestimo.is_pedente}</td>
									<td class="text-center">
										<button type="button" class="btn btn-info btn-editar" data-tipo="Editar">
										<span class="glyphicon glyphicon-edit"></span> Editar</button>
										<button type="button" class="btn btn-danger btn-deletar">
										<span class="glyphicon glyphicon-trash"></span> Deletar</button>
									</td>

								</tr>

							</c:forEach>

						</tbody>

						<tfoot>

							<tr>

								<td colspan="4">Total de emprestimos cadastrados:
									<span id="total-items">${emprestimos.size()}</span>
								</td>

							</tr>

						</tfoot>

					</table>