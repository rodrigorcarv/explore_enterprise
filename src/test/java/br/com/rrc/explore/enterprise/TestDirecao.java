package br.com.rrc.explore.enterprise;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.explore.enterprise.beans.enums.Direcao;
import br.com.rrc.explore.enterprise.exceptions.DirecaoInvalidaException;

public class TestDirecao {
	
	@Test
	public void testBuscaCoordenadaNorte() {
		
		String direcao = "N";
		Direcao direcaoEnum = Direcao.buscaCoordenada(direcao);
		Assert.assertEquals(Direcao.NORTE, direcaoEnum);
	}

	@Test
	public void testBuscaCoordenadaSul() {
		
		String direcao = "S";
		Direcao direcaoEnum = Direcao.buscaCoordenada(direcao);
		Assert.assertEquals(Direcao.SUL, direcaoEnum);
	}
	
	@Test
	public void testBuscaCoordenadaLeste() {
		
		String direcao = "E";
		Direcao direcaoEnum = Direcao.buscaCoordenada(direcao);
		Assert.assertEquals(Direcao.LESTE, direcaoEnum);
	}

	@Test
	public void testBuscaCoordenadaOeste() {
		
		String direcao = "W";
		Direcao direcaoEnum = Direcao.buscaCoordenada(direcao);
		Assert.assertEquals(Direcao.OESTE, direcaoEnum);
	}

	@Test(expected = DirecaoInvalidaException.class)
	public void testBuscaCoordenadaNull() {
		
		String direcao = null;
		Direcao.buscaCoordenada(direcao);
		Assert.fail();
	}
	
	@Test(expected = DirecaoInvalidaException.class)
	public void testBuscaCoordenadaVazio() {
		
		String direcao = "";
		Direcao.buscaCoordenada(direcao);
		Assert.fail();
	}

	@Test(expected = DirecaoInvalidaException.class)
	public void testBuscaCoordenadaInvalida() {
		
		String direcao = "P";
		Direcao.buscaCoordenada(direcao);
		Assert.fail();
	}
}
