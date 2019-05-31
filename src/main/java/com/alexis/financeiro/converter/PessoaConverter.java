package com.alexis.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.alexis.financeiro.model.Pessoa;
import com.alexis.financeiro.repository.Pessoas;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter<Pessoa> {

	@Inject // funciona graças ao OmniFaces
	private Pessoas pessoas;

	@Override
	public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = (Pessoa) this.pessoas.porId(new Long(value), Pessoa.class);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, final Pessoa value) {
		if (value != null) {
			Pessoa pessoa = ((Pessoa) value);
			return pessoa.getId() == null ? null : pessoa.getId().toString();
		}
		return null;
	}
}
