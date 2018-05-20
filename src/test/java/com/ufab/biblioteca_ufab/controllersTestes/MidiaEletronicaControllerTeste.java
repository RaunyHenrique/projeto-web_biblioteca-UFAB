package com.ufab.biblioteca_ufab.controllersTestes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;

import org.hamcrest.collection.IsArray;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import com.ufab.biblioteca_ufab.configuracoes.ConfiguracoesApp;
import com.ufab.biblioteca_ufab.models.entidades.MidiaEletronica;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfiguracoesApp.class })
@WebAppConfiguration
public class MidiaEletronicaControllerTeste {
	
	@Autowired
	private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    @Test
    public void listar() throws Exception {
    	
		mockMvc.perform(get("/midias"))
		.andExpect(status().isOk())
		.andExpect(view().name("midia/listar"));
        
    }
    
    @Test
    public void salvar() throws Exception {
    	
    	MidiaEletronica me = new MidiaEletronica();
    	
		mockMvc.perform(get("/midias"))
		.andExpect(status().isOk())
		.andExpect(view().name("midia/listar"))
		.andExpect(model().attribute("titulo", "Listagem de midias eletronicas"));
        
    }
    
}
