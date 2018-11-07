package com.alexis.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.alexis.financeiro.model.Lancamento;

public class Lancamentos extends PadraoRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    public Lancamentos() {
    }

    public List<Lancamento> todos() {
        TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
        return query.getResultList();
    }
}
