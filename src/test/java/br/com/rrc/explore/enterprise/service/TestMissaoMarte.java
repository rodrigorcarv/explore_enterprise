package br.com.rrc.explore.enterprise.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.rrc.explore.enterprise.ExploreEnterpriseApplication;
import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.Dimensao;
import br.com.rrc.explore.enterprise.beans.Explorador;
import br.com.rrc.explore.enterprise.beans.Sonda;
import br.com.rrc.explore.enterprise.beans.enums.Comando;
import br.com.rrc.explore.enterprise.beans.enums.Direcao;
import br.com.rrc.explore.enterprise.dto.RelatorioExploracaoDTO;
import br.com.rrc.explore.enterprise.service.impl.MissaoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExploreEnterpriseApplication.class)
@WebAppConfiguration
public class TestMissaoMarte {
	
	@Inject
	MissaoServiceImpl missaoMarteService;
	
	@Test
	public void testExploraMarteCoordenadaLatitudeUmLongitudeTresDirecaoNorte () {
		
		Dimensao dimensao = new Dimensao(5, 5);
		
		Coordenada coordenada = new Coordenada(1, 2);
		Sonda sonda = new Sonda("Maven", coordenada, Direcao.NORTE);
		
		List<Comando> comandos = new ArrayList<Comando>();
		
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		
		Explorador explorador = new Explorador(sonda, comandos);
		
		RelatorioExploracaoDTO explorarDTO = missaoMarteService.explorar(dimensao, explorador);
		
		Coordenada coordenadaSonda = explorarDTO.getSonda().getCoordenada();
		Direcao direcao = explorarDTO.getSonda().getDirecao();
		
		String resultaMissao = String.format("%s %s %s", coordenadaSonda.getLatitude(), coordenadaSonda.getLongitude(), direcao);
		
		Assert.assertEquals("1 3 NORTE", resultaMissao);
	}
	
	@Test
	public void testExploraMarteCoordenadaLatitudeTresLongitudeTresDirecaoLeste () {
		
		Dimensao dimensao = new Dimensao(5, 5);
		
		Coordenada coordenada = new Coordenada(3, 3);
		Sonda sonda = new Sonda("Maven", coordenada, Direcao.LESTE);
		
		List<Comando> comandos = new ArrayList<Comando>();
		
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		
		Explorador explorador = new Explorador(sonda, comandos);
		RelatorioExploracaoDTO explorarDTO = missaoMarteService.explorar(dimensao, explorador);
		
		Coordenada coordenadaSonda = explorarDTO.getSonda().getCoordenada();
		Direcao direcao = explorarDTO.getSonda().getDirecao();
		
		String resultaMissao = String.format("%s %s %s", coordenadaSonda.getLatitude(), coordenadaSonda.getLongitude(), direcao);
		
		Assert.assertEquals("5 1 LESTE", resultaMissao);
	}
	
	
	@Test
	public void testExploraMarteDimensoesInvalidas () {
		
		Dimensao dimensao = new Dimensao(-1, 5);
		
		Coordenada coordenada = new Coordenada(3, 3);
		Sonda sonda = new Sonda("Maven", coordenada, Direcao.LESTE);
		
		List<Comando> comandos = new ArrayList<Comando>();
		
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		
		Explorador explorador = new Explorador(sonda, comandos);
		RelatorioExploracaoDTO explorarDTO = missaoMarteService.explorar(dimensao, explorador);
		
		Coordenada coordenadaSonda = explorarDTO.getSonda().getCoordenada();
		Direcao direcao = explorarDTO.getSonda().getDirecao();
		
		String resultaMissao = String.format("%s %s %s", coordenadaSonda.getLatitude(), coordenadaSonda.getLongitude(), direcao);
		
		Assert.assertEquals("5 1 LESTE", resultaMissao);
	}

}
