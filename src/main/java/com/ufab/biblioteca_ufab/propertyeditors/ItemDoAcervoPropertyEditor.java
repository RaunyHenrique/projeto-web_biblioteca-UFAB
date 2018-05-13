package com.ufab.biblioteca_ufab.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;
import com.ufab.biblioteca_ufab.models.repositorios.ItemDoAcervoRepositorio;

@Component
public class ItemDoAcervoPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private ItemDoAcervoRepositorio itemDoAcervoRepositorio;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		long idItemDoAcervo = Long.parseLong(text);
		
		Optional<ItemDoAcervo> itemDoAcervo = itemDoAcervoRepositorio.findById(idItemDoAcervo);
		//seta o objeto
		setValue(itemDoAcervo.get());
		
	}

}
