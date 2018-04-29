<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Table -->
<table
	class="table table-hover table-condensed table-striped table-bordered">

	<thead>

		<tr>

			<td>Matricula</td>
			<td>Nome</td>
			<td>Curso</td>
			<td>Periodo</td>
			<td>Telefone</td>

		</tr>

	</thead>

	<tbody>

		<c:forEach items="${alunos}" var="aluno">

			<tr>

				<td>${aluno.matricula}</td>
				<td>${aluno.nome}</td>
				<td>${aluno.curso_id}</td>
				<td>${aluno.periodo}</td>
				<td>${aluno.telefone}</td>

			</tr>

		</c:forEach>

	</tbody>

	<tfoot>

		<tr>

			<td colspan="3">Total de alunos cadastrados: ${alunos.size()}</td>

		</tr>

		<tr>

			<td colspan="3">

				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-add-edit">Inserir aluno</button>

			</td>

		</tr>

	</tfoot>

</table>