package com.ufab.biblioteca_ufab.models.servicos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.biblioteca_ufab.models.entidades.Curso;
import com.ufab.biblioteca_ufab.models.enums.TipoDeCurso;
import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;

@Service
public class ServicoCurso {
	
	@Autowired private CursoRepositorio cursosRepositorio;

	public void setAllCursos() {
		
		List<Curso> cursos = new ArrayList<Curso>();
				
		Curso curso1 = new Curso();
		curso1.setNome("Ciência da Computação");
		curso1.setArea("Ciências Exatas");
		curso1.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso1);
		
		Curso curso2 = new Curso();
		curso2.setNome("Ciência da Computação");
		curso2.setArea("Ciências Exatas");
		curso2.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso2);
		
		Curso curso3 = new Curso();
		curso3.setNome("Administração");
		curso3.setArea("Ciências Humanas");
		curso3.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso3);
		
		Curso curso4 = new Curso();
		curso4.setNome("Administração");
		curso4.setArea("Ciências Humanas");
		curso4.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso4);
		
		Curso curso5 = new Curso();
		curso5.setNome("Direito");
		curso5.setArea("Ciências Humanas");
		curso5.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso5);
		
		Curso curso6 = new Curso();
		curso6.setNome("Direito");
		curso6.setArea("Ciências Humanas");
		curso6.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso6);
		
		Curso curso7 = new Curso();
		curso7.setNome("Engenharia Eletrica");
		curso7.setArea("Ciências Exatas");
		curso7.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso7);
		
		Curso curso8 = new Curso();
		curso8.setNome("Engenharia Eletrica");
		curso8.setArea("Ciências Exatas");
		curso8.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso8);
		
		Curso curso9 = new Curso();
		curso9.setNome("Engenharia Mecatonica");
		curso9.setArea("Ciências Exatas");
		curso9.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso9);
		
		Curso curso10 = new Curso();
		curso10.setNome("Engenharia Mecatonica");
		curso10.setArea("Ciências Exatas");
		curso10.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso10);
		
		Curso curso11 = new Curso();
		curso11.setNome("Matematica");
		curso11.setArea("Ciências Exatas");
		curso11.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso11);
		
		Curso curso12 = new Curso();
		curso12.setNome("Matematica");
		curso12.setArea("Ciências Exatas");
		curso12.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso12);
		
		Curso curso13 = new Curso();
		curso13.setNome("Medicina");
		curso13.setArea("Ciências Humanas");
		curso13.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso13);
		
		Curso curso14 = new Curso();
		curso14.setNome("Medicina");
		curso14.setArea("Ciências Humanas");
		curso14.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso14);
		
		Curso curso15 = new Curso();
		curso15.setNome("Nutrição");
		curso15.setArea("Ciências Humanas");
		curso15.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso15);
		
		Curso curso16 = new Curso();
		curso16.setNome("Nutrição");
		curso16.setArea("Ciências Humanas");
		curso16.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso16);
		
		Curso curso17 = new Curso();
		curso17.setNome("Odontologia");
		curso17.setArea("Ciências Humanas");
		curso17.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso17);
		
		Curso curso18 = new Curso();
		curso18.setNome("Odontologia");
		curso18.setArea("Ciências Humanas");
		curso18.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso18);
		
		Curso curso19 = new Curso();
		curso19.setNome("Psicologia");
		curso19.setArea("Ciências Humanas");
		curso19.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso19);
		
		Curso curso20 = new Curso();
		curso20.setNome("Psicologia");
		curso20.setArea("Ciências Humanas");
		curso20.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso20);
		
		Curso curso21 = new Curso();
		curso21.setNome("Veterinaria");
		curso21.setArea("Ciências Humanas");
		curso21.setTipo(TipoDeCurso.GRADUAÇÃO);
		cursos.add(curso21);
		
		Curso curso22 = new Curso();
		curso22.setNome("Veterinaria");
		curso22.setArea("Ciências Humanas");
		curso22.setTipo(TipoDeCurso.POSGRADUAÇÃO);
		cursos.add(curso22);
		
		for (Curso curso : cursos) {
			
			cursosRepositorio.save(curso);
			
		}
		
	}

}
