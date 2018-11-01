package com.alexis.financeiro.service;

import java.io.Serializable;
import java.time.LocalDate;

import com.alexis.financeiro.model.Lancamento;
import com.alexis.financeiro.repository.Lancamentos;

public class CadastroLancamentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Lancamentos lancamentos;

	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null && lancamento.getDataPagamento().isAfter(LocalDate.now())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		
		this.lancamentos.adicionar(lancamento);
	}
}
