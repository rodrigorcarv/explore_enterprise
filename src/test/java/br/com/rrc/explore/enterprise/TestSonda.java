package br.com.rrc.explore.enterprise;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.Dimensao;
import br.com.rrc.explore.enterprise.beans.Direcao;
import br.com.rrc.explore.enterprise.beans.Sonda;

public class TestSonda {

	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoENorte() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.NORTE);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.OESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoENorte() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.NORTE);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.LESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoESul() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.SUL);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.LESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoESul() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.SUL);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.OESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoELeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.LESTE);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.NORTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoELeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.LESTE);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.SUL, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoEOeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.OESTE);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.SUL, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoEOeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.OESTE);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.NORTE, sonda.getDirecao());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testViraSondaEsquerdaDirecaoNull() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada , null );
		sonda.virarEsquerda();
		
		Assert.fail("Deveria ter sido lancado a exececao IllegalArgumentException ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testViraSondaDireitaDirecaoNull() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada , null );
		sonda.virarDireita();
		
		Assert.fail("Deveria ter sido lancado a exececao IllegalArgumentException ");
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testMoverSondaParaForaDaDimensaoNaDirecaoNorte() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(1 , 5);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.NORTE);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.fail("Deveria ter sido lancado a exececao IllegalArgumentException ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMoverSondaParaForaDaDimensaoNaDirecaoSul() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(3 , 0);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.SUL);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.fail("Deveria ter sido lancado a exececao IllegalArgumentException ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMoverSondaParaForaDaDimensaoNaDirecaoLeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(5 , 3);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.LESTE);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.fail("Deveria ter sido lancado a exececao IllegalArgumentException ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMoverSondaParaForaDaDimensaoNaDirecaoOeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(0 , 3);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.OESTE);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.fail("Deveria ter sido lancado a exececao IllegalArgumentException ");
	}
	
	@Test
	public void testMoverSondaNaDirecaoNorte() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(2 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.NORTE);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.assertEquals(sonda.getCoordenada(), new Coordenada(2, 3));
	}
	
	@Test
	public void testMoverSondaSondaNaDirecaoSul() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(2 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.SUL);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.assertEquals(sonda.getCoordenada(), new Coordenada(2, 1));
	}
	
	@Test
	public void testMoverSondaSondaNaDirecaoLeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(2 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.LESTE);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.assertEquals(sonda.getCoordenada(), new Coordenada(3, 2));
	}
	
	@Test
	public void testMoverSondaNaDirecaoOeste() {
		
		String nome = "Maven";
		Coordenada coordenada = new Coordenada(2 , 2);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.OESTE);
		Dimensao dimensao = new Dimensao(5, 5);
		sonda.mover(dimensao);
		
		Assert.assertEquals(sonda.getCoordenada(), new Coordenada(1, 2));
	}
}
