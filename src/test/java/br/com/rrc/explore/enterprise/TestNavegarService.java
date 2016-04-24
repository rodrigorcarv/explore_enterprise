package br.com.rrc.explore.enterprise;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.service.NavegadoService;

public class TestNavegarService {
	
	@Test
	public void testNavegarDirecaoNorteVirarEsquerda() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.ESQUERDA, Direcao.NORTE);
		
		Assert.assertEquals(Direcao.OESTE, direcao);
	}
	
	@Test
	public void testNavegarDirecaoNorteVirarDireita() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.DIREITA, Direcao.NORTE);
		
		Assert.assertEquals(Direcao.LESTE, direcao);
	}
	
	@Test
	public void testNavegarDirecaoLesteVirarEsquerda() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.ESQUERDA, Direcao.LESTE);
		
		Assert.assertEquals(Direcao.NORTE, direcao);
	}
	
	@Test
	public void testNavegarDirecaoLesteVirarDireita() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.DIREITA, Direcao.LESTE);
		
		Assert.assertEquals(Direcao.SUL, direcao);
	}

	@Test
	public void testNavegarDirecaoSulVirarEsquerda() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.ESQUERDA, Direcao.SUL);
		
		Assert.assertEquals(Direcao.LESTE, direcao);
	}
	
	@Test
	public void testNavegarDirecaoSulVirarDireita() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.DIREITA, Direcao.SUL);
		
		Assert.assertEquals(Direcao.OESTE, direcao);
	}
	
	
	@Test
	public void testNavegarDirecaoOesteVirarEsquerda() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.ESQUERDA, Direcao.OESTE);
		
		Assert.assertEquals(Direcao.SUL, direcao);
	}
	
	@Test
	public void testNavegarDirecaoOesteVirarDireita() {
		
		NavegadoService navegadoService = new NavegadoService();
		Direcao direcao = navegadoService.navega(Comando.DIREITA, Direcao.OESTE);
		
		Assert.assertEquals(Direcao.NORTE, direcao);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNavegarDirecaoIgualANullSulVirarDireita() {
		
		NavegadoService navegadoService = new NavegadoService();
		navegadoService.navega(Comando.DIREITA, null);
		Assert.fail("Excecao IllegalArgumentException nao foi dispara");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNavegarDirecaoOesteVirarANull() {
		
		NavegadoService navegadoService = new NavegadoService();
		navegadoService.navega(null, Direcao.OESTE);
		Assert.fail("Excecao IllegalArgumentException nao foi dispara");
	}
	
}
