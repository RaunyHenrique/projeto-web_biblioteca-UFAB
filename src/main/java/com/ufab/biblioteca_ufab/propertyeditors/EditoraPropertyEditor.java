package com.ufab.biblioteca_ufab.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufab.biblioteca_ufab.models.entidades.Editora;
import com.ufab.biblioteca_ufab.models.repositorios.EditoraRepositorio;

//PropertyEditorSupport faz o parse de dois id's para os objetos
@Component
public class EditoraPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private EditoraRepositorio editoraRepositorio;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		long idEditora = Long.parseLong(text);
		
		Optional<Editora> editora = editoraRepositorio.findById(idEditora);
		//seta o objeto
		setValue(editora.get());
		
	}

}
