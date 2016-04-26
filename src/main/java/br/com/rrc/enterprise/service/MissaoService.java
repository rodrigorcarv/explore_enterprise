package br.com.rrc.enterprise.service;

import java.util.List;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Dimensao;
import br.com.rrc.enterprise.beans.Sonda;

public interface MissaoService {

	public String explorar(Dimensao dimensao, Sonda sonda, List<Comando> comandos);
	
}
