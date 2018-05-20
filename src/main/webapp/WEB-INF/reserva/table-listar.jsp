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
									<td>

									<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
									    <div class="btn-group mr-2" role="group" aria-label="First group">
									    
										  	<button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Editar">
											<span class="fas fa-pencil-alt mr-1"></span></button>
											
											<button type="button" class="btn btn-danger btn-deletar">
											<span class="far fa-trash-alt mr-1"></span></button>
										
										<button type="button" class="btn btn-primary btn-emprestimo" data-toggle="modal" data-target="#modal-emprestimo">
										<span class="fas fa-check mr-1"></span></button>
						
									    </div>
									</div>
									
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>