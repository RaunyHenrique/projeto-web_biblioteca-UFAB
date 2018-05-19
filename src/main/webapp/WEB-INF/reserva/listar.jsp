<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:layout title="${titulo}">
 
<jsp:attribute name="header">

	<link href="<c:url value="/assets/css/checkbox-nice.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/select2.min.css" />" rel="stylesheet">
	
	<style type="text/css">
	
		#btn-inserir {
			margin-top: 8px;
			margin-bottom: 16px;
		}
		
		.select2 {
			width:100%!important;
		}
		
	</style>

</jsp:attribute>
 
<jsp:attribute name="body">

	<div class="container">

		<jsp:include page="../menu.jsp"></jsp:include>

		<c:if test="${not empty mensagensErro}">

			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

				<h3>Ops, ocorrem os seguintes erros:</h3>

				<c:forEach items="${mensagensErro}" var="mensagem">

					<p>
						<strong>${mensagem.getField()}</strong>
						${mensagem.getDefaultMessage()}
					</p>

				</c:forEach>

			</div>

		</c:if>

		<c:if test="${not empty mensagemSucesso}">

			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

				<h3>${mensagemSucesso}</h3>

			</div>

		</c:if>
		
		<div id="tabs">

		  <!-- Nav tabs -->
		  <ul class="nav nav-tabs" role="tablist" id="tabs-links">
		    <li role="presentation"><a href="home" id="home" aria-controls="home" role="tab" data-url="/biblioteca_ufab/home">Emprestimos</a></li>
		    <li role="presentation" class="active"><a href="reservas" id="reservas" aria-controls="profile" role="tab" data-url="/biblioteca_ufab/reservas">Reservas</a></li>
		    <li role="presentation"><a href="home/pendencias" id="pendencias" aria-controls="messages" role="tab" data-url="/biblioteca_ufab/home/pendencias">Pendências</a></li>
		  </ul>
		
			<button type="button" id="btn-inserir" class="btn btn-primary" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Inserir">
				<span class="glyphicon glyphicon-plus"></span> Nova reserva
			</button>
	
			<section id="section-table">
	
				<jsp:include page="table-listar.jsp"></jsp:include>
	
			</section>
		
		</div>

	</div>

</jsp:attribute>

<jsp:attribute name="footer">
		
	<script type="text/javascript" src="<c:url value="/assets/js/select2.full.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/data-table-config.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/modal-request.js" />"></script>
	
	<jsp:include page="modal-add-edit.jsp"></jsp:include>
	
	<!-- Modal emprestimos -->
	<div class="modal fade" id="modal-emprestimo" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<form method="post" id="form-emprestimo" data-url="home">

				<input type="hidden" id="csrf" name="_csrf" value="${_csrf.token}">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Novo emprestimo</h4>
				</div>

				<div class="modal-body">

						<div class="form-group">

						<input type="hidden" class="form-control" id="idReserva" name="idReserva">
						
						<label style="display: none" for="aluno" class="control-label">Aluno:</label> 
						<select style="display: none" class="form-control" id="aluno" name="aluno" required>
					
							<c:forEach items="${alunos}" var="aluno">
					
								<option value="${aluno.id}">${aluno.matricula} - ${aluno.nome}</option>
					
							</c:forEach>
					
						</select>
						
						<label style="display: none" for="items_emprestados" class="control-label">Itens do emprestimo (*disponiveis):</label> 
						<select style="display: none" class="form-control" id="items_emprestados" name="items_emprestados" required>
					
							<c:forEach items="${itensDoAcervo}" var="item">
					
								<option value="${item.id}">${item.item_tipo} - ${item.titulo}</option>
					
							</c:forEach>
					
						</select>
						
						<label for="data_emprestimo" class="control-label">Data do emprestimo:</label>
						<input type="date"  class="form-control" id="data_emprestimo" name="data_emprestimo" required> 
						
						<label for="data_devolucao" class="control-label">Data da devolução:</label>
						<input type="date" class="form-control" id="data_devolucao" name="data_devolucao" required> 
					
						</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-ok"></span> Salvar
					</button>
				</div>

			</form>

		</div>
	</div>
</div>


	<script>
	
		$(document).ready(function() {
		    
		    $('#items_emprestados').select2({
		    	placeholder: 'Selecione...',	
		    	containerCssClass : "show-hide"
		    });
		    
			$('#modal-emprestimo')
			.on(
					'show.bs.modal',
					function() {
						
						$(".show-hide").parent().parent().hide();

					});

			// btn-emprestimo
			$('.btn-emprestimo').on('click', function() {
								
				// url
				var url = "/biblioteca_ufab/reservas";

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
									
									if (key == "id") {
										
										$('[name="idReserva"]').val(value).change();

									} else {
										
										field.val(value);

									}

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
										
										field.val(value["id"]).trigger('change');
										
									}

								}
								
								break;
								
						}
						
					});
					
				});

			});
			
			// Form modal
			$("#form-emprestimo").submit(
					function(event) {

						// Stop form from submitting normally
						event.preventDefault();
						
						// url
						var url = $(this).data('url');
												
						console.log("URL: " + url);

						// Get some values from elements on the page:
						var dadosForm = $(this).serializeArray();
						
						var id = $('[name="idReserva"]').val();
						
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

							var url = $("#form-add-edit").data('url');
							var csrf = $('#csrf').val();

							$.ajax({
								url : url + "/" + id,
								type : 'DELETE',
								headers: {'X-CSRF-TOKEN': csrf},
							}).done(function(result) {

								$('tr[data-id="' + id + '"]').remove();

							});

						}).fail(function(errror) {

							alert(errror);

						}).always(function() {

							$('#modal-emprestimo').modal('hide');

						});

					});
		    
		});
	
	</script>

</jsp:attribute>
 
</tag:layout>
