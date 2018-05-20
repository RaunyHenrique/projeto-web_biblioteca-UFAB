package com.ufab.biblioteca_ufab.models.servicos;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.biblioteca_ufab.models.entidades.MidiaEletronica;
import com.ufab.biblioteca_ufab.models.repositorios.MidiaEletronicaRepositorio;

@Service
public class ServicoMidiaEletronica {
	
	static final Logger logger = LoggerFactory.getLogger(ServicoMidiaEletronica.class);
	
	@Autowired private MidiaEletronicaRepositorio midiaEletronicaRepositorio;
	
	public Iterable<MidiaEletronica> findAll() {
		
		return midiaEletronicaRepositorio.findAll();

	}

	public MidiaEletronica add(MidiaEletronica model) {
		
		return midiaEletronicaRepositorio.save(model);

	}
	
	public boolean deleteById(Long id) {
		
		Optional<MidiaEletronica> forDelete = midiaEletronicaRepositorio.findById(id);
		
        if (forDelete.isPresent()) {
        	
    		midiaEletronicaRepositorio.delete(forDelete.get());

        } else {
        	
        	return false;
        	
        }
        
		return true;

	}
	
    public Optional<MidiaEletronica> findById(Long id) {

    	Optional<MidiaEletronica> found = midiaEletronicaRepositorio.findById(id);

        return found;
    }
    
    public MidiaEletronica update(MidiaEletronica model) {
        
        return midiaEletronicaRepositorio.save(model);
        
    }

}
