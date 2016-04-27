package br.com.rrc.explore.enterprise.service;

import java.util.List;

import br.com.rrc.explore.enterprise.beans.Dimensao;
import br.com.rrc.explore.enterprise.beans.Explorador;
import br.com.rrc.explore.enterprise.beans.Mapa;
import br.com.rrc.explore.enterprise.dto.RelatorioExploracaoDTO;

public interface MissaoService {

	public List<RelatorioExploracaoDTO> explorar(Mapa mapa);
	
	public RelatorioExploracaoDTO explorar(Dimensao dimensao, Explorador explorador);
	
}
