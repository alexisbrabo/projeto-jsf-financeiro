package com.alexis.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.alexis.financeiro.model.Lancamento;
import com.alexis.financeiro.model.Pessoa;
import com.alexis.financeiro.model.TipoLancamento;
import com.alexis.financeiro.repository.Pessoas;
import com.alexis.financeiro.service.CadastroLancamentos;
import com.alexis.financeiro.service.NegocioException;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroLancamentos cadastro;
	@Inject
	private Pessoas pessoas;

	private Lancamento lancamento;
	private List<Pessoa> todasPessoas;

	public void prepararCadastro() {
		if (lancamento == null) {
			lancamento = new Lancamento();
			lancamento.setTipo(TipoLancamento.RECEITA);
		}
		this.todasPessoas = this.pessoas.todas();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.lancamento);
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void dataVencimentoAlterada(AjaxBehaviorEvent event) {
		if (this.lancamento.getDataPagamento() == null) {
			this.lancamento.setDataPagamento(this.lancamento.getDataVencimento());
		}
	}

	public List<Pessoa> getTodasPessoas() {
		return this.todasPessoas;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

}
