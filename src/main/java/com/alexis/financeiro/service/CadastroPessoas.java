package com.alexis.financeiro.service;

import com.alexis.financeiro.model.Pessoa;
import java.io.Serializable;

import javax.inject.Inject;

import com.alexis.financeiro.repository.Pessoas;
import com.alexis.financeiro.util.Transactional;

public class CadastroPessoas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Pessoas pessoas;

    @Inject
    public CadastroPessoas() {
    }

    @Transactional
    public void salvar(Pessoa pessoa) throws NegocioException {
        this.pessoas.guardar(pessoa);
    }

    @Transactional
    public void excluir(Pessoa pessoa) throws NegocioException {
        pessoa = (Pessoa) this.pessoas.porId(pessoa.getId(), Pessoa.class);

        this.pessoas.remover(pessoa);
    }
}
