package com.alexis.financeiro.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alexis.bancodedados.JpaUtil;
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
