package com.alexis.financeiro.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NomesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private List<String> nomes = new ArrayList<>();

	public String adicionar() {
		this.nomes.add(nome);

		if (this.nomes.size() > 3) {
			return "Ola?faces-redirect=true";
		}
		
		return null;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getNomes() {
		return nomes;
	}
}
