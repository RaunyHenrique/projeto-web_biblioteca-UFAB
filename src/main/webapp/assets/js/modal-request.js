var isAddIndex = 0;

$(document).ready(function() {
	
	$('#palavra_chave').tagsinput();
	
	logoutHandler();
		
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

var logoutHandler = function() {
	
	$('#btn-logout').on('click', function() {
		
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : '/biblioteca_ufab/logout',
			type : 'POST',
			headers: {'X-CSRF-TOKEN': csrf},
		}).done(function(result) {
			
			showSuccessToast('Fez o logout com sucesso.');
			
		});
		
	});
	
};

var showSuccessToast = function(msg) {

	$.toast({
	    heading: 'Informação',
	    text: msg,
	    allowToastClose: true,
	    showHideTransition: 'fade',
	    icon: 'success',
	    position: 'top-right',
	})
	
};

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
					
					showSuccessToast('Item criado com sucesso.');

					$('#section-table').html(pagina);
					
					aplicarListenersTable();
					
					aplicarDataTable();

				}).fail(function(errror) {

					$.alert('Ops, ocorreu algum erro na renovação do emprestimo.');

				}).always(function() {

					$('#modal-add-edit').modal('hide');

				});

			});
	
};

var limparCampos = function() {

	var fields = $('#form-add-edit').serializeArray();
	
	console.log(fields);

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

	$.ajax({
		url : url + "/" + id,
		type : 'DELETE',
		headers: {'X-CSRF-TOKEN': csrf},
	}).done(function(result) {
		
		showSuccessToast('Item deletado com sucesso.');
				
		//remove a row
		var dt = $('#table-listar-datatable').DataTable();
		dt.row($('tr[data-id="' + id + '"]')).remove().draw();
		$('tr[data-id="' + id + '"]').remove();
			
		//remove os listeners dos botões (evita eventos duplicados)
		$('td button').off("click");
		
		//reaplica listeners
		aplicarListenersTable();
		
	}).fail(function(errror) {

		$.alert('Ops, ocorreu algum erro ao deletar.');

	});
	
};

var aplicarListenersTable = function() {
	
	// btn-renovar (emprestimo)
	$('.btn-renovar').on('click', function() {
		
		var itemEvt = this;
		
		var csrf = $('#csrf').val();
		
		var id = $(itemEvt).parents('tr').data('id');
		
		$.confirm({
		    type: 'blue',
		    typeAnimated: true,
		    buttons: {
	        cancelar: function () {
	            
	        },
	        renovar: {
	        	btnClass: 'btn-green',
	            action: function () {

	                var emprestimo = this.$content.find('.data-emprestimo').val();
	                var devolucao = this.$content.find('.data-devolucao').val();
	                
	                if(!emprestimo || !devolucao){//validar datas..
	                    $.alert('Campos requeridos');
	                    return false;
	                }
	                
	        		$.get("/biblioteca_ufab/home/" + id).done(function(entity) {
	        			
	        			console.log(entity);
	        			
	        			//ajusta datas
	        			var obgResult = {};
	        			//obgResult['_csrf'] = csrf

	        			$.each(entity, function(key, value) {
	        				
	        				if (key == "data_emprestimo") {
	        					
	        					obgResult[key] = emprestimo;
	        					
							} else if(key == "data_devolucao") {
								
								obgResult[key] = devolucao;
								
							} else {
								
								obgResult[key] = value;

							}
	        				
	        			});
	        				        			
	        			console.log(obgResult);
	        			
	        			//ajusta obj para enviar request
	    				var result = {};
	    				$.each(obgResult, function(key, value) {
	    					
	    					if(key == "items_emprestados"){
	    							    						
	    						var array = [];
	    						$.each(value, function(k, v) {
	    							
	    							array.push(parseInt(v['id']));
	    							
	    						});
    							
    							result[key] = array;
	    						
	    					} else if(key == "aluno") {
	    						
	    						result[key] = value['id'];
	    						
	    					} else {
	    					    result[key] = value;
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
	    								
	    								strParse += key + "=" + element;
	    								
	    							} else {
	    								strParse += "&" + key + "=" + element;
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
	    				
	    				$.ajax({
	    					contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	    		            url: '/biblioteca_ufab/home',
	    		            method: 'POST',
	    		            headers: {'X-CSRF-TOKEN': csrf},
	    		            data: strParse,
	    		        }).done(function (pagina) {
	    		        	
	    		        	showSuccessToast('Emprestimo realizado com sucesso.');

	    					$('#section-table').html(pagina);
	    					
	    					aplicarListenersTable();
	    					
	    					aplicarDataTable();
	    		            
	    		        }).fail(function(){

	    		        	$.alert('Ops, ocorreu algum erro na renovação do emprestimo.');
	    		            
	    		        });
	        				        			
	        		}).fail(function(){

	        			 $.alert('Ops, ocorreu algum erro na renovação do emprestimo.');
	        			 
			        });
	                	        	
	            }
	        }
		    },
		    content: function () {
		        var self = this;
		        return $.ajax({
		            url: '/biblioteca_ufab/home/'+id+'/renovar',
		            //dataType: 'json',
		            method: 'POST',
		            headers: {'X-CSRF-TOKEN': csrf},
		        }).done(function () {
		        	
		            self.setTitle('Renovação de emprestimo');
		            self.setContent(
		            		'<form method="post"' +
		            		
		            	    '<div class="form-group">' +
		            	    
		            		'<label for="data_emprestimo" class="control-label">Data do emprestimo:</label>' + 
		            		'<input type="date" class="data-emprestimo form-control" id="data_emprestimo" name="data_emprestimo" required>' + 
		            		
		            		'<label for="data_devolucao" class="control-label">Data da devolução:</label>' + 
		            		'<input type="date" class="data-devolucao form-control" id="data_devolucao" name="data_devolucao" required>' +
	
		            	    '</div>' +
		            	    '</form>');
		            
		        }).fail(function(){

		            self.setTitle('Status');
		            self.setContent('Não é possivel realizar a renovação deste emprestimo.');
		            self.setType('red');
		            self.buttons.cancelar.setText('ok')
		            self.buttons.renovar.hide();
		        });
		    },
		    onContentReady: function () {
		        // bind to events
		        var jc = this;
		        this.$content.find('form').on('submit', function (e) {
		            // if the user submits the form by pressing enter in the field.
		            e.preventDefault();
		            jc.$$formSubmit.trigger('click'); // reference the button and click it
		        });
		    }
		});

	});
	
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
		            		
		            		showSuccessToast('Emprestimo finalizado com sucesso.');

							$('#section-table').html(pagina);
							
							aplicarListenersTable();
							
							aplicarDataTable();

		            	}).fail(function(){

		        			 $.alert('Ops, ocorreu algum erro ao tentar finalizar emprestimo.');
		        			 
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
		            		
		            		showSuccessToast('Divida quitada com sucesso.');

							$('#section-table').html(pagina);
							
							aplicarListenersTable();
							
							aplicarDataTable();

		            	}).fail(function(){

		        			 $.alert('Ops, ocorreu algum erro ao tentar quitar a divida.');
		        			 
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