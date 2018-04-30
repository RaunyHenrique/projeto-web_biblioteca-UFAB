package com.ufab.biblioteca_ufab.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufab.biblioteca_ufab.models.entidades.Curso;
import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;

//PropertyEditorSupport faz o parse de dois id's para os objetos
@Component
public class CursoPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private CursoRepositorio cursoRepositorio;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		long idCurso = Long.parseLong(text);
		
		Optional<Curso> curso = cursoRepositorio.findById(idCurso);
		//seta o objeto
		setValue(curso.get());
		
	}

}
