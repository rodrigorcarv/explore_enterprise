package br.com.rrc.explore.enterprise.service;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.enterprise.service.MissaoService;

public class ExploraMarteTest {
	
	@Test
	public void testExploraMarte () {
		
		String [][] mapa = new String[6][6];
		int posicaoEntradaX = 1;
		int posicaoEntradaY = 2;
		String direcao = "N";

		String comandos = "LMLMLMLMM";

		MissaoService missaoMarteService = new MissaoService();
		String resultaMissao = missaoMarteService.explorar(mapa, posicaoEntradaX, posicaoEntradaY, direcao, comandos);
		
		Assert.assertEquals("1 3 N", resultaMissao);
	}
}
