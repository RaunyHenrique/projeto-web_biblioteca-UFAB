<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
			<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
				<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

					<!-- Modal -->
					<div class="modal fade" id="modal-add-edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">

								<form method="post" id="form-add-edit" data-url="${url}">

									<input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">

									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel"></h4>
									</div>

									<div class="modal-body">

										<div class="form-group">

											<input type="hidden" class="form-control" id="id" name="id">

											<label hidden="true" for="matricula" class="control-label">Matricula:</label>
											<input type="hidden" class="form-control" id="matricula" name="matricula">
											<label for="nome" class="control-label">Nome:</label>
											<input type="text" class="form-control" id="nome" name="nome" required>

											<label for="cpf" class="control-label">Cpf:</label>
											<input type="text" class="form-control" id="cpf" name="cpf" required>
											<label for="rg" class="control-label">Rg:</label>
											<input type="text" class="form-control" id="rg" name="rg" required>
											<label for="naturalidade" class="control-label">Naturalidade:</label>
											<input type="text" class="form-control" id="naturalidade" name="naturalidade" required>
											<label for="nomeDaMae" class="control-label">Nome da mãe:</label>
											<input type="text" class="form-control" id="nomeDaMae" name="nomeDaMae" required>
											<label for="endereco" class="control-label">Endereço:</label>
											<input type="text" class="form-control" id="endereco" name="endereco" required>

											<label for="telefone" class="control-label">Telefone:</label>
											<input type="text" class="form-control" id="telefone" name="telefone" required>

											<label for="curso" class="control-label">Curso:</label>
											<select class="form-control" id="curso" name="curso" required>

												<c:forEach items="${cursos}" var="curso">

													<option value="${curso.id}">${curso.nome}</option>

												</c:forEach>

											</select>
											
											<label for="tipo_curso" class="control-label">Tipo de curso:
											</label>
											<select class="form-control" id="tipo_curso" name="tipo_curso" required>

												<c:forEach items="${tipo_curso}" var="tipo">

													<option value="${tipo}">${tipo}</option>

												</c:forEach>

											</select>
											
											<label for="ano" class="control-label">Ano:</label>
											<input type="text" class="form-control" id="ano" name="ano" required>
											<label for="periodo" class="control-label">Periodo:</label>
											<input type="text" class="form-control" id="periodo" name="periodo" required>

										</div>

									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
										<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-ok"></span> Salvar</button>
									</div>

								</form>

							</div>
						</div>
					</div>
