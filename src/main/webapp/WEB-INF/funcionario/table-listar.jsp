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

								<td style="width: 10%">Nome</td>
								<td style="width: 10%">Email</td>
								<td style="width: 10%">Cpf</td>
								<td style="width: 10%">Rg</td>
								<td style="width: 10%">Telefone</td>
								<td style="width: 20%">Permissões</td>
								<td style="width: 30%">Ações</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach items="${funcionarios}" var="funcionario">

								<tr data-id="${funcionario.id}">

									<td>${funcionario.nome}</td>
									<td>${funcionario.email}</td>
									<td>${funcionario.cpf}</td>
									<td>${funcionario.rg}</td>
									<td>${funcionario.telefone}</td>
									<td>
									
										<c:forEach items="${funcionario.permissoes}" var="permissao">
											${(permissao.nome == 'ROLE_ADMIN') ? 'Administrador' : 'Operador'}
										</c:forEach>
										
									</td>
									<td class="text-center">
									
									<div class="btn-group">
									  	<button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Editar">
										<span class="fas fa-pencil-alt mr-1"></span></button>
										
										<button type="button" class="btn btn-danger btn-deletar">
										<span class="far fa-trash-alt mr-1"></span></button>
									</div>
									
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>