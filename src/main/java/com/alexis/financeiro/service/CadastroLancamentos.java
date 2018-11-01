package com.alexis.financeiro.service;

import java.io.Serializable;
import java.time.LocalDate;

import javax.inject.Inject;

import com.alexis.financeiro.model.Lancamento;
import com.alexis.financeiro.repository.Lancamentos;
import com.alexis.financeiro.util.Transactional;

public class CadastroLancamentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Lancamentos lancamentos;

	@Inject
	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null && lancamento.getDataPagamento().isAfter(LocalDate.now())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		
		this.lancamentos.adicionar(lancamento);
	}
}
