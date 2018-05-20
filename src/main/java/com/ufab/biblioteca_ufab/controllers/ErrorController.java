package com.ufab.biblioteca_ufab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

    public static final String VIEW_INTERNAL_SERVER_ERROR = "error/error";
    public static final String VIEW_NOT_FOUND = "error/404";

    @RequestMapping(value = "/error/404", method = RequestMethod.GET)
    public String show404Page() {
        return VIEW_NOT_FOUND;
    }

    @RequestMapping(value = "/error/error", method = RequestMethod.GET)
    public String showInternalServerErrorPage() {
        return VIEW_INTERNAL_SERVER_ERROR;
    }
}
