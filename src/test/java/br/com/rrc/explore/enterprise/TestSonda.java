package br.com.rrc.explore.enterprise;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Sonda;

public class TestSonda {

	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoENorte() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.NORTE);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.OESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoENorte() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.NORTE);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.LESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoESul() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.SUL);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.LESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoESul() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.SUL);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.OESTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoELeste() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.LESTE);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.NORTE, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoELeste() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.LESTE);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.SUL, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaEsquerdaAtualDirecaoEOeste() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada, Direcao.OESTE);
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.SUL, sonda.getDirecao());
	}
	
	@Test
	public void testViraSondaParaDireitaAtualDirecaoEOeste() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada , Direcao.OESTE);
		sonda.virarDireita();
		
		Assert.assertEquals(Direcao.NORTE, sonda.getDirecao());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testViraSondaDireitaDirecaoNull() {
		
		String nome = "Maven";
		AtomicInteger latitude = new AtomicInteger(1);
		AtomicInteger longitude = new AtomicInteger(2);
		Coordenada coordenada = new Coordenada(latitude , longitude);
	
		Sonda sonda = new Sonda(nome, coordenada , null );
		sonda.virarEsquerda();
		
		Assert.assertEquals(Direcao.LESTE, sonda.getDirecao());
	}
	
}
