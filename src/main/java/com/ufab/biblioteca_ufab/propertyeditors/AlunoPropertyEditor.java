package com.ufab.biblioteca_ufab.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;

@Component
public class AlunoPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private AlunoRepositorio alunoRepositorio;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		long idAluno = Long.parseLong(text);
		
		Optional<Aluno> aluno = alunoRepositorio.findById(idAluno);
		//seta o objeto
		setValue(aluno.get());
		
	}

}
