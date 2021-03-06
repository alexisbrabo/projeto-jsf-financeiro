package com.alexis.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.alexis.financeiro.model.Lancamento;
import com.alexis.financeiro.repository.Lancamentos;

@FacesConverter(forClass = Lancamento.class)
public class LancamentosConverter implements Converter<Lancamento> {

    @Inject
    private Lancamentos lancamentos;

    @Override
    public Lancamento getAsObject(FacesContext context, UIComponent component, String value) {
        Lancamento retorno = null;
        if (value != null && !"".equals(value)) {
            retorno = (Lancamento) this.lancamentos.porId(new Long(value), Lancamento.class);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Lancamento value) {
        if (value != null) {
            Lancamento lancamento = ((Lancamento) value);
            return lancamento.getId() == null ? null : lancamento.getId().toString();
        }
        return null;
    }
}
