var isAddIndex = 0;

$(document).ready(function() {
	
	aplicarListenersModal();

	aplicarListenersTable();

	setFocus();

	setTitleModal();
	
	selectTipoCursoOnChange();

	limparCampos();
	
	$('#modal-add-edit').on('hidden.bs.modal', function (e) {
		
		console.log("VA: " + isAddIndex);

		if (isAddIndex != 0) {
			
			if ($('#aluno').find("option[value='" + isAddIndex + "']").length) {
				
				$('#aluno').find("option[value='" + isAddIndex + "']").remove();
			    
			}
			
			isAddIndex = 0;
			
		}
		
	});
	
	$('#modal-add-edit').on('hide.bs.modal', function() {

		limparCampos();

	});

});

var selectTipoCursoOnChange = function() {
	
	// url
	var url = $("#form-add-edit").data('url');
	
	console.log("URL: " + url);
					
	if (url == "alunos") {
		
		$('#tipo_curso').change(function(select) {
			
			var value = select.target.value;
			
			if (value == "GRADUAÇÃO") {
				
				$('.cursos-graduacao').show();
				$('.cursos-posgraduacao').hide();
				
			} else {
				
				$('.cursos-graduacao').hide();
				$('.cursos-posgraduacao').show();
				
			}

		});
		
	}
	
};

var setSelectedTipoCurso = function() {
	
	// url
	var url = $("#form-add-edit").data('url');
	
	console.log("URL: " + url);
	
	if (url == "alunos") {
		
		var value = $('#tipo_curso').val();
		
		if (value == "GRADUAÇÃO") {
			
			$('.cursos-graduacao').show();
			$('.cursos-posgraduacao').hide();
			
		} else {
			
			$('.cursos-graduacao').hide();
			$('.cursos-posgraduacao').show();
			
		}
		
	}
	
};

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
				var dadosForm = $(this).serializeArray();
				
				console.log(dadosForm);
				
				var result = {};
				$.each(dadosForm, function() {
					
					//verifica se já existe a key
					if(result.hasOwnProperty(this.name)){
						
						//verifica se é array
						if ($.isArray(result[this.name])) {
														
							result[this.name].push(parseInt(this.value));
							
						} else {
							
							var array = [];
							array.push(parseInt(result[this.name]));
							
							array.push(parseInt(this.value));
							
							result[this.name] = array;
							
						}
						
					} else {
					    result[this.name] = this.value;
					}
					
				});

				console.log(result);
				
				var strParse = "";
				var count = 0;
				
				$.each(result, function(key, value) {
					
					//console.log(key, value);
					
					if ($.isArray(value)) {
						
						$.each(value, function(index, element) {
							
							if (count == 0) {
								
								strParse += key + "["+ index +"]" + "=" + element;
								
							} else {
								strParse += "&" + key + "["+ index +"]" + "=" + element;
							}
							
						});
						
					} else {
						
						if (count == 0) {
							
							strParse += key + "=" + value;
							
						} else {
							strParse += "&" + key + "=" + value;
						}
	
					}
					
					count++;
					
				});
				
				console.log(strParse);

				$.post(url, dadosForm).done(function(pagina) {

					$('#section-table').html(pagina);
					
					aplicarListenersTable();
					
					aplicarDataTable();

				}).fail(function(errror) {

					alert(errror);

				}).always(function() {

					$('#modal-add-edit').modal('hide');

				});

			});
	
};

var limparCampos = function() {

	var fields = $('#form-add-edit').serializeArray();

	$.each(fields, function(index, value) {

		var campoName = $('#' + fields[index]['name']).attr('id');
					
		if (campoName == "tipo_curso") {
			
			//faz nada
			
		} else {
							
			$('#' + fields[index]['name']).val('').change();
			
		}
		

	});

};

var setFocus = function() {

	$('#modal-add-edit')
			.on(
					'shown.bs.modal',
					function() {
						
						setSelectedTipoCurso();

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

						var button = $(event.relatedTarget);
						var recipient = button.data('tipo');
						
						console.log("P:" + recipient);
						
						if (recipient == "Inserir") {
							limparCampos();
						}
						
						var modal = $(this).find('.modal-title')
								.text(recipient)

						$('#form-add-edit')
								.find(
										':input:not(input[type=button],input[type=submit],button):visible:first')
								.focus();

					});

};

var handlerDeletar = function(itemEvt) {
	
	// url
	var url = $("#form-add-edit").data('url');
	var csrf = $('#csrf').val();

	var id = $(itemEvt).parents('tr').data('id');
	var total = $('#total-items').text();

	$.ajax({
		url : url + "/" + id,
		type : 'DELETE',
		headers: {'X-CSRF-TOKEN': csrf},
	}).done(function(result) {

		$('tr[data-id="' + id + '"]').remove();
		$('#total-items').text(total - 1);

	});
	
};

var aplicarListenersTable = function() {

	// btn-deletar
	$('.btn-deletar').on('click', function() {
		
		var itemEvt = this;
		$.confirm({
		    title: 'Deletar',
		    content: 'Você tem certeza que deseja deletar este item?',
		    type: 'red',
		    typeAnimated: true,
		    buttons: {
		        cancelar: function () {
		            
		        },
		        ok: {
		        	btnClass: 'btn-red',
		            action: function () {
		            	
		            	handlerDeletar(itemEvt);
		                
		            }
		        	
		        },
		    }
		});

	});

	// btn-editar
	$('.btn-editar').on('click', function() {
		
		// url
		var url = $("#form-add-edit").data('url');

		var id = $(this).parents('tr').data('id');

		$.get(url + "/" + id).done(function(entity) {
			
			console.log(entity);

			$.each(entity, function(key, value) {
				
				if (key == "curso" || key == "aluno") {
										
					if (key == "aluno") {
									
						var itemEntityValue = value["id"];
						var itemEntityNome = value["matricula"] + " - " + value["nome"];
						
						if ($('#aluno').find("option[value='" + itemEntityValue + "']").length) {
							
						    $('#aluno').val(itemEntityValue).trigger('change');
						    
						} else { 
							
							//guarda value para excluir depois!
							isAddIndex = itemEntityValue;
							
						    var newOption = new Option(itemEntityNome, itemEntityValue, true, true);
						    // Append it to the select
						    $('#aluno').append(newOption).trigger('change');
						    
						} 
						
					} else {
						
						$('[name="' + key + '"]').val(value["id"]).change();
						
					}
						
				} else if (key == "items_emprestados") {
					
					var item = value;
					var itemName = key;
						
					var array = [];
					$.each(item, function(key, value) {
						
//						console.log("ITEM: " + key, value);
						array.push(value["id"]);
						
					});
					
					$('[name="' + itemName + '"]').val(array).change();
					
				} else if (key == "data_emprestimo" || key == "data_devolucao") {
					
					var date = new Date(value);
					$('[name="' + key + '"]').val(date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2) + "-" + date.getDate());
				
				} else {
					$('[name="' + key + '"]').val(value);
				}

			});

			$('#modal-add-edit').modal('show');

		});

	});

};