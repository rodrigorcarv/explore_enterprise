package br.com.rrc.explore.enterprise.convert;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.explore.enterprise.beans.Comando;
import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.Dimensao;
import br.com.rrc.explore.enterprise.beans.Direcao;
import br.com.rrc.explore.enterprise.beans.Explorador;
import br.com.rrc.explore.enterprise.beans.Mapa;
import br.com.rrc.explore.enterprise.beans.Sonda;
import br.com.rrc.explore.enterprise.convert.MapaConvert;

public class TestConvert {
	
	@Test
	public void testMapaConvert() {
		
		String coodenadas = 
				  "5 5 \n"
				+ "1 2 N \n "
				+ "LMLMLMLMM \n"
				+ "3 3 E \n"
				+ "MMRMMRMRRM";
		
		MapaConvert mapaConvert = new MapaConvert();
		Mapa mapaConvertido = mapaConvert.string2Mapa(coodenadas);
	
		Mapa mapa = new Mapa();
		
		Dimensao dimensao = new Dimensao(5, 5);
		mapa.setDimensao(dimensao);
		
		List<Explorador> exploradores = new ArrayList<>();
		exploradores.add(exploradoraPhoenix());
		exploradores.add(exploradoraObiter());
		mapa.setExploradores(exploradores );
		
		Assert.assertEquals(mapaConvertido.getDimensao(), mapa.getDimensao());
		Assert.assertEquals(mapaConvertido.getExploradores(), mapa.getExploradores());
		
		
		Assert.assertEquals(mapaConvertido, mapa);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMapaConvertDadosDimensaoIncorretos() {
		
		String coodenadas = 
				  "5 5 5 \n"
				+ "1 2 N \n "
				+ "LMLMLMLMM \n"
				+ "3 3 E \n"
				+ "MMRMMRMRRM";
		
		MapaConvert mapaConvert = new MapaConvert();
		mapaConvert.string2Mapa(coodenadas);
		
		Assert.fail("A excecao IllegalArgumentException NAO foi lancada");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMapaConvertDadosDaCoordenaIncorretos() {
		
		String coodenadas = 
				  "5 5 \n"
				+ "1 2  \n "
				+ "LMLMLMLMM \n"
				+ "3 3 E \n"
				+ "MMRMMRMRRM";
		
		MapaConvert mapaConvert = new MapaConvert();
		mapaConvert.string2Mapa(coodenadas);
		
		Assert.fail("A excecao IllegalArgumentException NAO foi lancada");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMapaConvertComandosIncorretos() {
		
		String coodenadas = 
				  "5 5 \n"
				+ "1 2 N \n "
				+ "LMLMLMLG \n"
				+ "3 3 E \n"
				+ "MMRMMRMRRM";
		
		MapaConvert mapaConvert = new MapaConvert();
		mapaConvert.string2Mapa(coodenadas);
		
		Assert.fail("A excecao IllegalArgumentException NAO foi lancada");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMapaConvertDirecaoIncorreta() {
		
		String coodenadas = 
				  "5 5 \n"
				+ "1 2 G \n "
				+ "LMLMLMLM \n"
				+ "3 3 E \n"
				+ "MMRMMRMRRM";
		
		MapaConvert mapaConvert = new MapaConvert();
		mapaConvert.string2Mapa(coodenadas);
		
		Assert.fail("A excecao IllegalArgumentException NAO foi lancada");
	}
	
	
	private Explorador exploradoraPhoenix() {

		Coordenada coordenada = new Coordenada(1, 2);
		Sonda sonda = new Sonda(coordenada , Direcao.NORTE);

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
		
		return new Explorador(sonda, comandos);
		
	}
	
	private Explorador exploradoraObiter() {
		
		Coordenada coordenada = new Coordenada(3, 3);
		Sonda sonda = new Sonda(coordenada , Direcao.LESTE);

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
		
		return new Explorador(sonda, comandos);
	}
}
