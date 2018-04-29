package com.ufab.biblioteca_ufab;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Aplicacao implements WebApplicationInitializer {

	public Aplicacao() {}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//Mapeia todos os controllers pela url
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("com.ufab.biblioteca_ufab.configuracoes");
		
		//DispatcherServlet.. observa todas as url's '/app/*'
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/app/*");
		
		//Add observer as url's
		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
		
	}
	
}
