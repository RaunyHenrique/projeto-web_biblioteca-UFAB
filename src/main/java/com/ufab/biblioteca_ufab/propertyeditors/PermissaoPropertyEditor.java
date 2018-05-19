package com.ufab.biblioteca_ufab.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufab.biblioteca_ufab.models.entidades.Permissao;
import com.ufab.biblioteca_ufab.models.repositorios.PermissaoRepositorio;

@Component
public class PermissaoPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private PermissaoRepositorio permissaoRepositorio;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		long idPermissao = Long.parseLong(text);
		
		Optional<Permissao> permissao = permissaoRepositorio.findById(idPermissao);
		//seta o objeto
		setValue(permissao.get());
		
	}
	
}
