package com.alexis.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.alexis.financeiro.bancodedados.JpaUtil;
import com.alexis.financeiro.model.Lancamento;
import com.alexis.financeiro.repository.Lancamentos;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Lancamento> lancamentos;
	
	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		Lancamentos lancamentos = new Lancamentos(manager);
		this.lancamentos = lancamentos.todos();
		
		manager.close();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
