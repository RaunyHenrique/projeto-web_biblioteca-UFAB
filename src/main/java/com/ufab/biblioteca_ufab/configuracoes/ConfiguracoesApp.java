package com.ufab.biblioteca_ufab.configuracoes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc

//Configurações basicas para web
@Configuration

//Diz ao Spring quais pacotes escaniar a procura de classes
//com anotations... Component, Service e etc
@ComponentScan(basePackages="com.ufab.biblioteca_ufab")

public class ConfiguracoesApp extends WebMvcConfigurerAdapter {
	
	public ConfiguracoesApp() {}
	
	

}
