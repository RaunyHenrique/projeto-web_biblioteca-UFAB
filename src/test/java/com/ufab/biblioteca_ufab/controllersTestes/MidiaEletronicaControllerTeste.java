package com.ufab.biblioteca_ufab.controllersTestes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;

import org.hamcrest.collection.IsArray;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static org.hamcrest.Matchers.is;
import com.ufab.biblioteca_ufab.configuracoes.ConfiguracoesApp;
import com.ufab.biblioteca_ufab.models.entidades.MidiaEletronica;
import com.ufab.biblioteca_ufab.models.enums.TipoDeItemDoAcervo;
import com.ufab.biblioteca_ufab.models.servicos.ServicoMidiaEletronica;
import com.ufab.biblioteca_ufab.utilsTestes.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfiguracoesApp.class })
@WebAppConfiguration
public class MidiaEletronicaControllerTeste {
	
	@Autowired
	private WebApplicationContext wac;

    private MockMvc mockMvc;
    
	@Autowired
	private ServicoMidiaEletronica servicoMidiaEletronica;

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
    	me.setId(1L);
    	me.setCorredor("ddasd");
    	me.setEstante("ddasd");
    	me.setPrateleira("ddasd");
    	me.setItem_tipo(TipoDeItemDoAcervo.MIDIAELETRONICA);
    	me.setPalavra_chave("dasd,asdasd,asdasd");;
    	me.setQuantidade(10);
    	me.setQuantidade_emprestada(2);
    	me.setTitulo("Opa");
    	    	    	
		mockMvc.perform(post("/midias")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(me))
		)
		.andExpect(status().isOk())
		.andExpect(view().name("midia/table-listar"));
        
    }
    
}
