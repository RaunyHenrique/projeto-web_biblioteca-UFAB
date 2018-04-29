<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Modal -->
<div class="modal fade" id="modal-add-edit" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<form method="post" id="form-add-edit">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">${tituloModal}</h4>
				</div>

				<div class="modal-body">

					<div class="form-group">

						<label for="nome" class="control-label">Nome:</label> <input
							type="text" class="form-control" id="nome"> <label
							for="curso_id" class="control-label">Curso:</label> <select
							class="form-control" id="curso_id" name="curso_id">

							<c:forEach items="${cursos}" var="curso">

								<option value="${curso.id}">${curso.nome}</option>

							</c:forEach>

						</select>

					</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</div>

			</form>

		</div>
	</div>
</div>

<script>

	$("#form-add-edit")
			.submit(
					function(event) {

						// Stop form from submitting normally
						event.preventDefault();
						
						//url
						var url = "alunos";

						// Get some values from elements on the page:
						var dadosForm = $(this).serialize();

						$.post(url, dadosForm)
							  .done(function() {
							    alert( "success" );
							  })
							  .fail(function() {
							    alert( "error" );
							  })
							  .always(function() {
							    alert( "finished" );
							  });
						
					});
	
</script>