package br.com.rrc.enterprise.service;

import java.util.List;

import br.com.rrc.enterprise.beans.Dimensao;
import br.com.rrc.enterprise.beans.Explorador;
import br.com.rrc.enterprise.beans.Mapa;
import br.com.rrc.enterprise.dto.RelatorioExploracaoDTO;

public interface MissaoService {

	public List<RelatorioExploracaoDTO> explorar(Mapa mapa);
	
	public RelatorioExploracaoDTO explorar(Dimensao dimensao, Explorador explorador);
	
}
