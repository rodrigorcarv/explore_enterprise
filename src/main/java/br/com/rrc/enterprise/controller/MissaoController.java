package br.com.rrc.enterprise.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rrc.enterprise.beans.Mapa;
import br.com.rrc.enterprise.service.MissaoService;

@RestController
public class MissaoController {

	@Inject
	private MissaoService missaoService;

	@RequestMapping(value = "/missao", method = RequestMethod.POST, consumes = "text/plain")
	public String missao (@PathVariable(value = "nomeMissao") String nomeMissao,  @RequestBody String coordenadas){
		
		
		return null;
	}

	@RequestMapping(value = "/missao", method = RequestMethod.POST, consumes = "application/json")
	public String missao (@PathVariable(value = "nomeMissao") String nomeMissao,  @RequestBody Mapa mapa){
		
		
		return null;
	}
}
