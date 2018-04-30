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
					
						<input type="hidden" class="form-control" id="id" name="id">

						<label hidden="true" for="matricula" class="control-label">Matricula:</label>
						<input type="hidden" class="form-control" id="matricula"
							name="matricula"> 
							
						<label for="nome" class="control-label">Nome:</label>
						<input type="text" class="form-control" id="nome" name="nome">

						<label for="cpf" class="control-label">Cpf:</label> <input
							type="text" class="form-control" id="cpf" name="cpf"> <label
							for="rg" class="control-label">Rg:</label> <input type="text"
							class="form-control" id="rg" name="rg"> <label
							for="naturalidade" class="control-label">Naturalidade:</label> <input
							type="text" class="form-control" id="naturalidade"
							name="naturalidade"> <label for="nomeDaMae"
							class="control-label">Nome da mãe:</label> <input type="text"
							class="form-control" id="nomeDaMae" name="nomeDaMae"> <label
							for="endereco" class="control-label">Endereço:</label> <input
							type="text" class="form-control" id="endereco" name="endereco">

						<label for="telefone" class="control-label">Telefone:</label> <input
							type="text" class="form-control" id="telefone" name="telefone">

						<label for="curso" class="control-label">Curso:</label> 
						<select class="form-control" id="curso" name="curso">

							<c:forEach items="${cursos}" var="curso">

								<option value="${curso.id}">${curso.nome}</option>

							</c:forEach>

						</select> 
						
						<label for="tipo_curso" class="control-label">Tipo de
							curso:</label> 
							<select class="form-control" id="tipo_curso" name="tipo_curso">

							<c:forEach items="${tipo_curso}" var="tipo">

								<option value="${tipo}">${tipo}</option>

							</c:forEach>

						</select> <label for="ano" class="control-label">Ano:</label> <input
							type="text" class="form-control" id="ano" name="ano"> <label
							for="periodo" class="control-label">Periodo:</label> <input
							type="text" class="form-control" id="periodo" name="periodo">

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
	$(document).ready(function() {

		aplicarListeners();
		
		setFocus();
		
		limparCampos();

	});
	
	var limparCampos = function() {
		
		$('#modal-add-edit').on('hide.bs.modal', function () {
			
			var fields = $('#form-add-edit').serializeArray();
						
			$.each(fields, function(index, value) {
				
				$('#'+ fields[index]['name']).val('');
				
			});
			
		});
		
	};
	
	var setFocus = function() {
		
		$('#modal-add-edit').on('shown.bs.modal', function () {
			
			 $('#form-add-edit').find(':input:not(input[type=button],input[type=submit],button):visible:first').focus();
			 
		});
		
	};

	var aplicarListeners = function() {
		
		//url
		var url = "${url}";

		//Form modal
		$("#form-add-edit").submit(
				function(event) {

					// Stop form from submitting normally
					event.preventDefault();
					
					if (url == "alunos") {

						// gera matricula
						var graduacaoCurso = $(this).find(
								"select[name='tipo_curso']").val();

						if (graduacaoCurso) {

							graduacaoCurso = graduacaoCurso.charAt(0);

						}

						var curso = "";

						//curso
						var cursoId = parseInt($(this).find(
								"select[name='curso']").val());
						console.log(cursoId);
						switch (cursoId) {

						case 0:
							curso = "ADMI";
							break;
						case 1:
							curso = "COMP";
							break;
						case 2:
							curso = "DIRE";
							break;
						case 3:
							curso = "EGEL";
							break;
						case 4:
							curso = "EGME";
							break;
						case 5:
							curso = "MATE";
							break;
						case 6:
							curso = "MEDI";
							break;
						case 7:
							curso = "NUTR";
							break;
						case 8:
							curso = "ODON";
							break;
						case 9:
							curso = "PSIC";
							break;
						case 10:
							curso = "VETR";
							break;

						}

						var anoDeIngresso = $(this).find("input[name='ano']")
								.val().substring(2, 4);
						var periodoDeIngresso = $(this).find(
								"input[name='periodo']").val();

						var codigo = chance.unique(chance.natural, 1, {
							min : 1,
							max : 10000
						});

						var matriculaGerada = graduacaoCurso + curso
								+ anoDeIngresso + periodoDeIngresso + codigo;

						//seta o valor da matricula
						$(this).find("input[name='matricula']").val(
								matriculaGerada);

					}

					// Get some values from elements on the page:
					var dadosForm = $(this).serialize();

					console.log(dadosForm);

					$.post(url, dadosForm).done(function(pagina) {

						$('#section-table').html(pagina);
						aplicarListeners();

					}).fail(function(errror) {

						alert(errror);

					}).always(function() {

						$('#modal-add-edit').modal('hide');

					});

				});

		//btn-deletar
		$('.btn-deletar').on('click', function() {
			
			var id = $(this).parents('tr').data('id');
			var total = $('#total-items').text();

			$.ajax({
				url : url + "/" + id,
				type : 'DELETE',
			}).done(function(result) {

				$('tr[data-id="'+ id +'"]').remove();
				$('#total-items').text(total - 1);
				
			});

		});
		
		//btn-editar
		$('.btn-editar').on('click', function() {
			
			var id = $(this).parents('tr').data('id');

			$.get(url + "/" + id).done(function(aluno) {

				$.each(aluno, function(key, value) {
					
					$('[name="'+ key +'"]').val(value);
					
				});
				
				$('#modal-add-edit').modal('show');
				
			});

		});

	};
</script>