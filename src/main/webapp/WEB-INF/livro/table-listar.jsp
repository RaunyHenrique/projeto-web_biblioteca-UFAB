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

								<td style="width: 15%">Titulo</td>
								<td style="width: 5%">Edição</td>
								<td style="width: 15%">Autor</td>
								<td style="width: 10%">Editora</td>
								<td style="width: 5%">Ano</td>
								<td style="width: 5%">Area</td>
								<td style="width: 5%">Tema</td>		
								<td style="width: 40%">Ações</td>
							</tr>

						</thead>

						<tbody>

							<c:forEach items="${livros}" var="livro">

								<tr data-id="${livro.id}">

									<td>${livro.titulo}</td>
									<td>${livro.edicao}</td>
									<td>${livro.autores}</td>
									<td>${livro.editora}</td>
									<td>${livro.anoDePublicacao}</td>
									<td>${livro.area}</td>
									<td>${livro.tema}</td>
									
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