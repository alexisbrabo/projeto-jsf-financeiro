package com.alexis.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alexis.financeiro.bancodedados.JpaUtil;
import com.alexis.financeiro.model.Pessoa;
import com.alexis.financeiro.repository.Pessoas;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter<Pessoa>{

	@Inject // funciona graças ao OmniFaces
	private Pessoas pessoas;
	
	@Override
	public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			if (value != null && !"".equals(value)) {
				retorno = this.pessoas.porId(new Long(value));
			}
			return retorno;
		} finally {
			manager.close();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, final Pessoa value) {
		if (value != null) {
			return ((Pessoa) value).getId().toString();
		}
		return null;
	}
}