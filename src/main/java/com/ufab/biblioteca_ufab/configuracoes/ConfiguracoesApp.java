package com.ufab.biblioteca_ufab.configuracoes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc

@Configuration

//Diz ao Spring quais pacotes escaniar a procura de classes
//com anotations... Component, Service e etc
@ComponentScan(basePackages="com.ufab.biblioteca_ufab")

public class ConfiguracoesApp implements WebMvcConfigurer {
	
	public ConfiguracoesApp() {}
	
	
	//ViewResolvers - Transforma url's em view's que est�o na pasta WEB-INF
	//ex: WEB-INF/alunos.jsp
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		registry.viewResolver(viewResolver);
		
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login").setViewName("login");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}

}
