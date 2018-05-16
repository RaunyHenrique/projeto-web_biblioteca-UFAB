package com.ufab.biblioteca_ufab.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufab.biblioteca_ufab.models.entidades.Autor;
import com.ufab.biblioteca_ufab.models.repositorios.AutorRepositorio;

//PropertyEditorSupport faz o parse de dois id's para os objetos
@Component
public class AutorPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private AutorRepositorio autorRepositorio;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		long idAutor = Long.parseLong(text);
		
		Optional<Autor> autor = autorRepositorio.findById(idAutor);
		//seta o objeto
		setValue(autor.get());
		
	}

}
