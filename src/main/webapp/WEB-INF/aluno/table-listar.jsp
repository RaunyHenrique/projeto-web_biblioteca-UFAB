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

								<td style="width: 10%">Matricula</td>
								<td style="width: 30%">Nome</td>
								<td style="width: 20%">Curso</td>
								<td style="width: 5%">Periodo</td>
								<td style="width: 5%">Telefone</td>
								<td style="width: 30%">Ações</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach items="${alunos}" var="aluno">

								<tr data-id="${aluno.id}">

									<td>${aluno.matricula}</td>
									<td>${aluno.nome}</td>
									<td>${aluno.curso.nome}</td>
									<td>${aluno.periodo}</td>
									<td>${aluno.telefone}</td>
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

								<td colspan="6">Total de alunos cadastrados:
									<span id="total-items">${alunos.size()}</span>
								</td>

							</tr>

						</tfoot>

					</table>