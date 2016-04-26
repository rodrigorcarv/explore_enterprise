package br.com.rrc.enterprise.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rrc.enterprise.beans.Mapa;
import br.com.rrc.enterprise.convert.MapaConvert;
import br.com.rrc.enterprise.dto.RelatorioExploracaoDTO;
import br.com.rrc.enterprise.service.MissaoService;

@RestController
public class MissaoController {

	@Inject
	private MissaoService missaoService;
	
	@Inject
	private MapaConvert mapaConvert;

	@RequestMapping(value = "/missao/explorar", method = RequestMethod.GET, consumes = "text/plain")
	public List<RelatorioExploracaoDTO> missao (@PathVariable(value = "nomeMissao") String nomeMissao,  @RequestBody String coordenadaAndComandos){
		
		Mapa mapa = mapaConvert.string2Mapa(coordenadaAndComandos);
		return missaoService.explorar(mapa);
	}

	@RequestMapping(value = "/missao", method = RequestMethod.POST, consumes = "application/json")
	public List<RelatorioExploracaoDTO> missao (@PathVariable(value = "nomeMissao") String nomeMissao,  @RequestBody Mapa mapa){
		return null;
	}
}
