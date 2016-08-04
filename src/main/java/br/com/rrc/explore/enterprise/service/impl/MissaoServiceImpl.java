package br.com.rrc.explore.enterprise.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.Dimensao;
import br.com.rrc.explore.enterprise.beans.Explorador;
import br.com.rrc.explore.enterprise.beans.Mapa;
import br.com.rrc.explore.enterprise.beans.Sonda;
import br.com.rrc.explore.enterprise.beans.enums.Comando;
import br.com.rrc.explore.enterprise.dto.PosicaoDTO;
import br.com.rrc.explore.enterprise.dto.RelatorioExploracaoDTO;
import br.com.rrc.explore.enterprise.service.MissaoService;

@Service
public class MissaoServiceImpl implements MissaoService {

	public RelatorioExploracaoDTO explorar(Dimensao dimensao, Explorador explorador) {

		Sonda sonda = explorador.getSonda();
		List<PosicaoDTO> posicaoDTOs = new ArrayList<>();

		for (Comando comando : explorador.getComandos()) {
			
			comando.criarControlePorTipoDeComando().executarComando(sonda);
			
			Coordenada coordenada = sonda.getCoordenada();
			
			PosicaoDTO posicaoDTO;
			try {
				posicaoDTO = new PosicaoDTO(coordenada.clone(), sonda.getDirecao());
				posicaoDTOs.add(posicaoDTO);
			} catch (CloneNotSupportedException e) {
				throw new RuntimeException("Não foi possível realizar o clone da coordenada");
			}
		}
		
		RelatorioExploracaoDTO relatorioExploracaoDTO = new RelatorioExploracaoDTO();
		relatorioExploracaoDTO.setPosicaoDTOs(posicaoDTOs);
		relatorioExploracaoDTO.setSonda(sonda);
		
		return relatorioExploracaoDTO;
	}

	@Override
	public List<RelatorioExploracaoDTO> explorar(Mapa mapa) {
		
		List<RelatorioExploracaoDTO> relExploracaoDTOs = new ArrayList<>();
		
		for (Explorador explorador : mapa.getExploradores()) {
			
			RelatorioExploracaoDTO relExploracaoDTO = explorar(mapa.getDimensao(), explorador);
			relExploracaoDTOs.add(relExploracaoDTO);
		}
		
		return relExploracaoDTOs;
	}
}
