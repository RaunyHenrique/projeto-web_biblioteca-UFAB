var isAddIndex = 0;

$(document).ready(function() {
	
	aplicarListenersModal();

	aplicarListenersTable();

	setFocus();

	setTitleModal();
	
	selectTipoCursoOnChange();
	
	$('#modal-add-edit').on('hidden.bs.modal', function (e) {
		
		if (isAddIndex != 0) {
			
			if ($('#aluno').find("option[value='" + isAddIndex + "']").length) {
				
				$('#aluno').find("option[value='" + isAddIndex + "']").remove();
			    
			}
			
			isAddIndex = 0;
			
		}
		
	});
	
	$('#modal-add-edit').on('hide.bs.modal', function(e) {
        
        if (e.namespace === 'bs.modal') {
    		limparCampos();
        }
        
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
												
//						if (recipient == "Inserir") {
//							limparCampos();
//						}
						
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
	
	// btn-finalizar (emprestimo)
	$('.btn-finalizar').on('click', function() {
		
		var itemEvt = this;
		
		var csrf = $('#csrf').val();
						
		$.confirm({
		    title: 'Finalizar emprestimo',
		    content: 'Você tem certeza que deseja finalizar este emprestimo?',
		    type: 'blue',
		    typeAnimated: true,
		    buttons: {
		        cancelar: function () {
		            
		        },
		        ok: {
		        	btnClass: 'btn-green',
		            action: function () {

		            	var id = $(itemEvt).parents('tr').data('id');

		            	$.ajax({
		            		url : "/biblioteca_ufab/home/" + id + "/finalizar",
		            		type : 'POST',
		            		headers: {'X-CSRF-TOKEN': csrf},
		            	}).done(function(pagina) {

							$('#section-table').html(pagina);
							
							aplicarListenersTable();
							
							aplicarDataTable();

		            	});
		                
		            }
		        	
		        },
		    }
		});

	});
	
	// btn-quitar-divida
	$('.btn-quitar-divida').on('click', function() {
		
		var itemEvt = this;
		
		var csrf = $('#csrf').val();
				
		var url = $(this).data('urlquitar');
		
		var nomeAluno = $(this).data('nome');
		
		var valor = $(this).data('valor');
		
		$.confirm({
		    title: 'Quitar divida',
		    content: 'Você tem certeza que deseja quitar a divida no valor de <strong>'+valor+'</strong> de '+nomeAluno+'?',
		    type: 'blue',
		    typeAnimated: true,
		    buttons: {
		        cancelar: function () {
		            
		        },
		        ok: {
		        	btnClass: 'btn-green',
		            action: function () {

		            	var id = $(itemEvt).parents('tr').data('id');

		            	$.ajax({
		            		url : url + "/" + id + "/quitar",
		            		type : 'POST',
		            		headers: {'X-CSRF-TOKEN': csrf},
		            	}).done(function(pagina) {

							$('#section-table').html(pagina);
							
							aplicarListenersTable();
							
							aplicarDataTable();

		            	});
		                
		            }
		        	
		        },
		    }
		});

	});

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
				
				//Tipo do campo
				var field = $('[name="' + key + '"]');
				var fieldType = field.prop('nodeName');
				var fieldTypeName = field.prop('type');
				
				console.log(fieldTypeName, fieldType);
				
				switch (fieldType) {
				
					case "INPUT":
						
						if (fieldTypeName == "date") {
							
							var date = new Date(value);
							field.val(date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2) + "-" + date.getDate());
							
						} else {
							
							field.val(value);

						}
						
						break;
	
					case "SELECT":
						//multiplo
						if (fieldTypeName == "select-multiple") {
							
							var item = value;
							var itemName = key;
								
							var array = [];
							$.each(item, function(key, value) {
								
								array.push(value["id"]);
								
							});
							
							$('[name="' + itemName + '"]').val(array).change();
							
						} else {//normal
							
							//casos especiais
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
								
							} else if(key == "tipo_curso" || key == "tipo") {
								
								field.val(value);
								
							} else {
								
								if ($.isArray(value)) {
									
									field.val(value[0]["id"]).change();
									
								} else {
									
									field.val(value["id"]).change();
									
								}
																
							}

						}
						
						break;
						
				}

			});

			$('#modal-add-edit').modal('show');

		});

	});

};