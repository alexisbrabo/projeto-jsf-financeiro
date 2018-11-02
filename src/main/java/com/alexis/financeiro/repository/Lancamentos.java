package com.alexis.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alexis.financeiro.model.Lancamento;

public class Lancamentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Lancamentos(EntityManager manager) {
		this.manager = manager;
	}

	public void adicionar(Lancamento lancamento) {
		this.manager.persist(lancamento);
	}
	
	public void guardar(Lancamento lancamento) {
		this.manager.merge(lancamento);
	}
	
	public void remover(Lancamento lancamento) {
		this.manager.remove(lancamento);
	}
	
	public Lancamento porId(Long id) {
		return this.manager.find(Lancamento.class, id);
	}

	public List<Lancamento> todos() {
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();
	}
}