package com.alexis.financeiro.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PadraoRepository {

    @Inject
    @PersistenceContext(name="FinanceiroPU")
    protected EntityManager manager;

    public void adicionar(Object object) {
        this.manager.persist(object);
    }

    public void guardar(Object object) {
        this.manager.merge(object);
    }

    public void remover(Object object) {
        this.manager.remove(object);
    }

    public Object porId(Long id, Class<?> classe) {
        return this.manager.find(classe, id);
    }

}
