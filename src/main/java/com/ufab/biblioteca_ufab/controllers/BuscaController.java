package com.ufab.biblioteca_ufab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ufab.biblioteca_ufab.models.entidades.Livro;
import com.ufab.biblioteca_ufab.models.repositorios.LivroRepositorio;


@Controller
@RequestMapping("/buscar")
public class BuscaController {
	
	@Autowired LivroRepositorio livroRepositorio;//e outros...

	@RequestMapping(method=RequestMethod.GET, value = "/{tipo}/{busca}")
	public String index(@PathVariable String tipo, @PathVariable String busca, Model model) {
				
		if (tipo.equals("livro")) {
			
			Iterable<Livro> livros = livroRepositorio.findAll();
			
			model.addAttribute("resultados", livros);

		}
				
		return "busca/buscar-itens";
		
	}

}
