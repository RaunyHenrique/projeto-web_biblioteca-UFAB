$(document).ready(function() {
	
	aplicarListenersModal();

	aplicarListenersTable();

	setFocus();

	setTitleModal();

	limparCampos();

});

var aplicarListenersModal = function() {
	
	// Form modal
	$("#form-add-edit").submit(
			function(event) {

				// Stop form from submitting normally
				event.preventDefault();
				
				// url
				var url = $(this).data('url');
				
				console.log("URL: " + url);
								
				if (url == "alunos") {

					// gera matricula
					var graduacaoCurso = $(this).find(
							"select[name='tipo_curso']").val();

					if (graduacaoCurso) {

						graduacaoCurso = graduacaoCurso.charAt(0);

					}

					var curso = "";

					// curso
					var cursoId = parseInt($(this).find("select[name='curso']")
							.val());
					console.log(cursoId);
					switch (cursoId) {

					case 1:
						curso = "ADMI";
						break;
					case 2:
						curso = "COMP";
						break;
					case 3:
						curso = "DIRE";
						break;
					case 4:
						curso = "EGEL";
						break;
					case 5:
						curso = "EGME";
						break;
					case 6:
						curso = "MATE";
						break;
					case 7:
						curso = "MEDI";
						break;
					case 8:
						curso = "NUTR";
						break;
					case 9:
						curso = "ODON";
						break;
					case 10:
						curso = "PSIC";
						break;
					case 11:
						curso = "VETR";
						break;

					}

					var anoDeIngresso = $(this).find("input[name='ano']").val()
							.substring(2, 4);
					var periodoDeIngresso = $(this).find(
							"input[name='periodo']").val();

					var codigo = chance.unique(chance.natural, 1, {
						min : 1,
						max : 10000
					});

					var matriculaGerada = graduacaoCurso + curso
							+ anoDeIngresso + periodoDeIngresso + codigo;

					// seta o valor da matricula
					$(this).find("input[name='matricula']")
							.val(matriculaGerada);

				}

				// Get some values from elements on the page:
				var dadosForm = $(this).serialize();

				console.log(dadosForm);

				$.post(url, dadosForm).done(function(pagina) {

					$('#section-table').html(pagina);
					aplicarListenersTable();

				}).fail(function(errror) {

					alert(errror);

				}).always(function() {

					$('#modal-add-edit').modal('hide');

				});

			});
	
};

var limparCampos = function() {

	$('#modal-add-edit').on('hide.bs.modal', function() {

		var fields = $('#form-add-edit').serializeArray();

		$.each(fields, function(index, value) {

			$('#' + fields[index]['name']).val('');

		});

	});

};

var setFocus = function() {

	$('#modal-add-edit')
			.on(
					'shown.bs.modal',
					function() {

						$('#form-add-edit')
								.find(
										':input:not(input[type=button],input[type=submit],button):visible:first')
								.focus();

					});

};

var setTitleModal = function() {

	$('#modal-add-edit')
			.on(
					'show.bs.modal',
					function(event) {

						var button = $(event.relatedTarget)
						var recipient = button.data('tipo')
						var modal = $(this).find('.modal-title')
								.text(recipient)

						$('#form-add-edit')
								.find(
										':input:not(input[type=button],input[type=submit],button):visible:first')
								.focus();

					});

};

var aplicarListenersTable = function() {

	// btn-deletar
	$('.btn-deletar').on('click', function() {
		
		// url
		var url = $("#form-add-edit").data('url');
		var csrf = $('#csrf').val();

		var id = $(this).parents('tr').data('id');
		var total = $('#total-items').text();

		$.ajax({
			url : url + "/" + id,
			type : 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		}).done(function(result) {

			$('tr[data-id="' + id + '"]').remove();
			$('#total-items').text(total - 1);

		});

	});

	// btn-editar
	$('.btn-editar').on('click', function() {
		
		// url
		var url = $("#form-add-edit").data('url');

		var id = $(this).parents('tr').data('id');

		$.get(url + "/" + id).done(function(entity) {

			$.each(entity, function(key, value) {

				if (key == "curso") {
										
					$('[name="' + key + '"]').val(value["id"]);
					
				} else {
					$('[name="' + key + '"]').val(value);
				}

			});

			$('#modal-add-edit').modal('show');

		});

	});

};