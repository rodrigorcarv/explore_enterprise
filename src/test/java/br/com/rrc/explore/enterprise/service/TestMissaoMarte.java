package br.com.rrc.explore.enterprise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Dimensao;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Sonda;
import br.com.rrc.enterprise.service.impl.MissaoServiceImpl;

public class TestMissaoMarte {
	
	@Test
	public void testExploraMarteCoordenadaLatitudeUmLongitudeTresDirecaoNorte () {
		
		Dimensao dimensao = new Dimensao(5, 5);
		
		Coordenada coordenada = new Coordenada(new AtomicInteger(1), new AtomicInteger(2));
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
		
		MissaoServiceImpl missaoMarteService = new MissaoServiceImpl();
		String resultaMissao = missaoMarteService.explorar(dimensao, sonda, comandos);
		
		Assert.assertEquals("1 3 NORTE", resultaMissao);
	}
	
	@Test
	public void testExploraMarteCoordenadaLatitudeTresLongitudeTresDirecaoLeste () {
		
		Dimensao dimensao = new Dimensao(5, 5);
		
		Coordenada coordenada = new Coordenada(new AtomicInteger(3), new AtomicInteger(3));
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
		
		MissaoServiceImpl missaoMarteService = new MissaoServiceImpl();
		String resultaMissao = missaoMarteService.explorar(dimensao, sonda, comandos);
		
		Assert.assertEquals("5 1 LESTE", resultaMissao);
	}
	
	

}
