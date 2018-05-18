<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
			<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
				<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

					<!-- Table -->
					<table id="table-listar-datatable" class="table table-hover table-condensed table-striped table-bordered" style="width:100%">

						<thead>

							<tr class="text-center">

								<td style="width: 20%">Data da reserva</td>
								<td style="width: 10%">Matricula</td>
								<td style="width: 20%">Aluno</td>
								<td style="width: 20%">Item do emprestimo</td>
								<td style="width: 30%">Ações</td>

							</tr>

						</thead>

						<tbody>
						
<!-- 						OBS: a data de devolução mais proxima e igual a data da reserva.. setar a data como hidden -->

							<c:forEach items="${reservas}" var="reserva">

								<tr data-id="${reserva.id}">

									<td><fmt:formatDate value="${reserva.data_reserva_entrega}" pattern="dd/MM/yyyy"/></td>
									<td>${reserva.aluno.matricula}</td>
									<td>${reserva.aluno.nome}</td>
									<td>${reserva.item.titulo}</td>
									<td class="text-center">
										<button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Editar">
										<span class="glyphicon glyphicon-edit"></span> Editar</button>
										<button type="button" class="btn btn-danger btn-deletar">
										<span class="glyphicon glyphicon-trash"></span> Deletar</button>
										<button type="button" class="btn btn-primary btn-emprestimo" data-toggle="modal" data-target="#modal-emprestimo">
										<span class="glyphicon glyphicon-ok"></span> Realizar emprestimo</button>
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>