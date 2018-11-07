package com.alexis.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.alexis.financeiro.model.Pessoa;

public class Pessoas extends PadraoRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    public Pessoas() {
    }

    public List<Pessoa> todas() {
        TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
        return query.getResultList();
    }
}
