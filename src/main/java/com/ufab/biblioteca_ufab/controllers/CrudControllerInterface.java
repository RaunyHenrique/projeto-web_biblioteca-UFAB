package com.ufab.biblioteca_ufab.controllers;

import java.util.List;

public interface CrudControllerInterface<T> {

	public void inserir(T model);
	public List<T> getAll();
	public List<T> buscar(String param);
	public void alterar(int ID, T model);
	public void excluir(int ID);

}
