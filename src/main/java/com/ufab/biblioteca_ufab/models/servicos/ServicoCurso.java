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
		curso1.setNome("Ci�ncia da Computa��o");
		curso1.setArea("Ci�ncias Exatas");
		curso1.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso1);
		
		Curso curso2 = new Curso();
		curso2.setNome("Ci�ncia da Computa��o");
		curso2.setArea("Ci�ncias Exatas");
		curso2.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso2);
		
		Curso curso3 = new Curso();
		curso3.setNome("Administra��o");
		curso3.setArea("Ci�ncias Humanas");
		curso3.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso3);
		
		Curso curso4 = new Curso();
		curso4.setNome("Administra��o");
		curso4.setArea("Ci�ncias Humanas");
		curso4.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso4);
		
		Curso curso5 = new Curso();
		curso5.setNome("Direito");
		curso5.setArea("Ci�ncias Humanas");
		curso5.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso5);
		
		Curso curso6 = new Curso();
		curso6.setNome("Direito");
		curso6.setArea("Ci�ncias Humanas");
		curso6.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso6);
		
		Curso curso7 = new Curso();
		curso7.setNome("Engenharia Eletrica");
		curso7.setArea("Ci�ncias Exatas");
		curso7.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso7);
		
		Curso curso8 = new Curso();
		curso8.setNome("Engenharia Eletrica");
		curso8.setArea("Ci�ncias Exatas");
		curso8.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso8);
		
		Curso curso9 = new Curso();
		curso9.setNome("Engenharia Mecatonica");
		curso9.setArea("Ci�ncias Exatas");
		curso9.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso9);
		
		Curso curso10 = new Curso();
		curso10.setNome("Engenharia Mecatonica");
		curso10.setArea("Ci�ncias Exatas");
		curso10.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso10);
		
		Curso curso11 = new Curso();
		curso11.setNome("Matematica");
		curso11.setArea("Ci�ncias Exatas");
		curso11.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso11);
		
		Curso curso12 = new Curso();
		curso12.setNome("Matematica");
		curso12.setArea("Ci�ncias Exatas");
		curso12.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso12);
		
		Curso curso13 = new Curso();
		curso13.setNome("Medicina");
		curso13.setArea("Ci�ncias Humanas");
		curso13.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso13);
		
		Curso curso14 = new Curso();
		curso14.setNome("Medicina");
		curso14.setArea("Ci�ncias Humanas");
		curso14.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso14);
		
		Curso curso15 = new Curso();
		curso15.setNome("Nutri��o");
		curso15.setArea("Ci�ncias Humanas");
		curso15.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso15);
		
		Curso curso16 = new Curso();
		curso16.setNome("Nutri��o");
		curso16.setArea("Ci�ncias Humanas");
		curso16.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso16);
		
		Curso curso17 = new Curso();
		curso17.setNome("Odontologia");
		curso17.setArea("Ci�ncias Humanas");
		curso17.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso17);
		
		Curso curso18 = new Curso();
		curso18.setNome("Odontologia");
		curso18.setArea("Ci�ncias Humanas");
		curso18.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso18);
		
		Curso curso19 = new Curso();
		curso19.setNome("Psicologia");
		curso19.setArea("Ci�ncias Humanas");
		curso19.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso19);
		
		Curso curso20 = new Curso();
		curso20.setNome("Psicologia");
		curso20.setArea("Ci�ncias Humanas");
		curso20.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso20);
		
		Curso curso21 = new Curso();
		curso21.setNome("Veterinaria");
		curso21.setArea("Ci�ncias Humanas");
		curso21.setTipo(TipoDeCurso.GRADUACAO);
		cursos.add(curso21);
		
		Curso curso22 = new Curso();
		curso22.setNome("Veterinaria");
		curso22.setArea("Ci�ncias Humanas");
		curso22.setTipo(TipoDeCurso.POSGRADUACAO);
		cursos.add(curso22);
		
		for (Curso curso : cursos) {
			
			cursosRepositorio.save(curso);
			
		}
		
	}

}
