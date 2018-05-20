<%@tag description="Form item do acervo" pageEncoding="UTF-8"%>

<label style="margin-top: 8px;" class="control-label">Item do
	acervo:</label>
<div class="panel panel-default">
	<div class="panel-body">

		<label for="quantidade" class="control-label">Quantidade:</label> <input
			type="number" class="form-control" id="quantidade" name="quantidade"
			required> 
			
		<label for="palavra_chave" class="control-label">Palavras chave:</label> 
		<input type="text" class="form-control" id="palavra_chave" name="palavra_chave" data-role="tagsinput">
		
		<label class="control-label">Localização:</label>
		
		<div class="row">
			<div class="col-xs-6 col-md-4">

				<div class="form-group">
					<label for="estante" class="sr-only">Estante:</label> <input
						type="text" class="form-control" id="estante" name="estante"
						placeholder="Estante">
				</div>

			</div>
			<div class="col-xs-6 col-md-4">

				<div class="form-group">
					<label for="corredor" class="sr-only">Corredor:</label> <input
						type="text" class="form-control" id="corredor" name="corredor"
						placeholder="Corredor">
				</div>

			</div>
			<div class="col-xs-6 col-md-4">

				<div class="form-group">
					<label for="prateleira" class="sr-only">Prateleira:</label> <input
						type="text" class="form-control" id="prateleira" name="prateleira"
						placeholder="Prateleira">
				</div>

			</div>
		</div>

	</div>
</div>