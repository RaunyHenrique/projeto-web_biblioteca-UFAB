package com.ufab.biblioteca_ufab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Classe responsavel por direcionar as views em casos de erro
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */
@Controller
public class ErrorController {

    public static final String VIEW_INTERNAL_SERVER_ERROR = "error/error";
    public static final String VIEW_NOT_FOUND = "error/404";

    /**
     * Define a view de erro para uma requisição não encontrada
	 * 
	 * @return VIEW_NOT_FOUND
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
    @RequestMapping(value = "/error/404", method = RequestMethod.GET)
    public String show404Page() {
        return VIEW_NOT_FOUND;
    }

    /**
     * Define a view de erro para um erro de consulta no servidor
	 * 
	 * @return VIEW_INTERNAL_SERVER_ERRO
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
    @RequestMapping(value = "/error/error", method = RequestMethod.GET)
    public String showInternalServerErrorPage() {
        return VIEW_INTERNAL_SERVER_ERROR;
    }
}
