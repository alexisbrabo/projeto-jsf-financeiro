package com.alexis.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.alexis.financeiro.model.Lancamento;
import com.alexis.financeiro.repository.Lancamentos;
import com.alexis.financeiro.service.CadastroLancamentos;
import com.alexis.financeiro.service.NegocioException;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<Lancamento> lancamentos;

    private Lancamento lancamentoSelecionado;

    @Inject
    private CadastroLancamentos cadastro;

    @Inject
    private Lancamentos lancamentosRepository;

    public void consultar() {
        this.lancamentos = lancamentosRepository.todos();
    }

    public void excluir() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.cadastro.excluir(lancamentoSelecionado);
            this.consultar();

            context.addMessage(null, new FacesMessage("Lançamento excluído com sucesso"));
        } catch (NegocioException e) {
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }

    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public Lancamento getLancamentoSelecionado() {
        return lancamentoSelecionado;
    }

    public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
        this.lancamentoSelecionado = lancamentoSelecionado;
    }
}
