package br.com.rrc.enterprise.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.hk2.annotations.Service;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Dimensao;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Explorador;
import br.com.rrc.enterprise.beans.Mapa;
import br.com.rrc.enterprise.beans.Movimentar;
import br.com.rrc.enterprise.beans.Sonda;
import br.com.rrc.enterprise.beans.VirarDireita;
import br.com.rrc.enterprise.beans.VirarEsquerda;
import br.com.rrc.enterprise.dto.PosicaoDTO;
import br.com.rrc.enterprise.dto.RelatorioExploracaoDTO;
import br.com.rrc.enterprise.service.MissaoService;

@Service
public class MissaoServiceImpl implements MissaoService {

	public RelatorioExploracaoDTO explorar(Dimensao dimensao, Explorador explorador) {

		Sonda sonda = explorador.getSonda();
		List<PosicaoDTO> posicaoDTOs = new ArrayList<>();

		for (Comando comando : explorador.getComandos()) {

			switch (comando) {

			case ESQUERDA:

				VirarEsquerda virarEsquerda = new VirarEsquerda();
				virarEsquerda.executarComando(sonda);
				break;

			case DIREITA:

				VirarDireita virarDireita = new VirarDireita();
				virarDireita.executarComando(sonda);
				break;

			case MOVER:

				Movimentar movimentar = new Movimentar();
				movimentar.moverSonda(sonda, dimensao);
				break;
			}
			
			PosicaoDTO  posicaoDTO = new PosicaoDTO(sonda.getCoordenada(), sonda.getDirecao());
			posicaoDTOs.add(posicaoDTO);
		}
		
		RelatorioExploracaoDTO relatorioExploracaoDTO = new RelatorioExploracaoDTO();
		relatorioExploracaoDTO.setPosicaoDTOs(posicaoDTOs );
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
