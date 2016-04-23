package br.com.rrc.explore.enterprise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Posicao;
import br.com.rrc.enterprise.service.MissaoService;

public class TestMissaoMarte {
	
	@Test
	public void testExploraMarte () {
		
		String [][] mapa = new String[6][6];
		
		Posicao posicao = new Posicao(new AtomicInteger(1), new AtomicInteger(2));
		
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
		
		
		MissaoService missaoMarteService = new MissaoService();
		String resultaMissao = missaoMarteService.explorar(mapa, posicao, Direcao.NORTE, comandos);
		
		Assert.assertEquals("1 3 N", resultaMissao);
	}
}
