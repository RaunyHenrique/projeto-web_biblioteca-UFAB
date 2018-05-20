<%@tag description="Modal" pageEncoding="UTF-8"%>
 
<%@attribute name="url"%>
<%@attribute name="modal_csrf_token" fragment="true" %>
<%@attribute name="modal_body" fragment="true" %>

<div class="modal fade" id="modal-add-edit" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<form method="post" id="form-add-edit" data-url="${url}">

				<jsp:invoke fragment="modal_csrf_token" />

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>

				<div class="modal-body">

					<jsp:invoke fragment="modal_body" />

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-primary">
						<span class="fas fa-check mr-1"></span> Salvar
					</button>
				</div>

			</form>

		</div>
	</div>
</div>