package com.alexis.financeiro.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.alexis.financeiro.model.Pessoa;
import com.alexis.financeiro.service.CadastroPessoas;
import com.alexis.financeiro.service.NegocioException;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroPessoas cadastro;

    private Pessoa pessoa;

    public void prepararCadastro() {
        if (pessoa == null) {
            pessoa = new Pessoa();
        }
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            this.cadastro.salvar(this.pessoa);
            this.pessoa = new Pessoa();
            context.addMessage(null, new FacesMessage("Pessoa salva com sucesso!"));
        } catch (NegocioException e) {
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
