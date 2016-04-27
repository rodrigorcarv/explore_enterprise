package br.com.rrc.enterprise.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Mapa;
import br.com.rrc.enterprise.beans.Sonda;
import br.com.rrc.enterprise.convert.MapaConvert;
import br.com.rrc.enterprise.dto.RelatorioExploracaoDTO;
import br.com.rrc.enterprise.service.MissaoService;

@RestController
@RequestMapping(value="/missao")
public class MissaoController {

	@Inject
	private MissaoService missaoService;

	@Inject
	private MapaConvert mapaConvert;

	@RequestMapping(value = "/explorar-planalto", method = RequestMethod.POST, consumes = "text/plain", produces = "text/plain")
	public @ResponseBody String missao (String nomeMissao,  @RequestBody String coordenadaAndComandos){

		Mapa mapa = mapaConvert.string2Mapa(coordenadaAndComandos);
		List<RelatorioExploracaoDTO> exploracaoDTOs = missaoService.explorar(mapa);
		
		StringBuilder builder = new StringBuilder();
		
		for (RelatorioExploracaoDTO relatorioExploracaoDTO : exploracaoDTOs) {
			
			Sonda sonda = relatorioExploracaoDTO.getSonda();
			Coordenada coordenada = sonda.getCoordenada();
			Direcao direcao = sonda.getDirecao();
			
			builder.append(String.format("%s %s %s \n", coordenada.getLatitude(), coordenada.getLongitude(), direcao.getDescricao()));
		}
		
		return builder.toString();
	}

	@RequestMapping(value = "/exploracao-detalhada", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<RelatorioExploracaoDTO> missao (String nomeMissao,  @RequestBody Mapa mapa){
		return missaoService.explorar(mapa);
	}
}
