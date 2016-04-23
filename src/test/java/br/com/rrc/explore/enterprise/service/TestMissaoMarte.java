package br.com.rrc.explore.enterprise.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.enterprise.service.MissaoService;
import br.com.rrc.explore.enterprise.beans.Posicao;

public class TestMissaoMarte {
	
	@Test
	public void testExploraMarte () {
		
		String [][] mapa = new String[6][6];
		
		int posicaoEntradaX = 1;
		int posicaoEntradaY = 2;

		Posicao posicao = new Posicao(new AtomicInteger(posicaoEntradaX), new AtomicInteger(posicaoEntradaY));
		String direcao = "N";

		String comandos = "LMLMLMLMM";

		MissaoService missaoMarteService = new MissaoService();
		String resultaMissao = missaoMarteService.explorar(mapa, posicao, direcao, comandos);
		
		Assert.assertEquals("1 3 N", resultaMissao);
	}
}