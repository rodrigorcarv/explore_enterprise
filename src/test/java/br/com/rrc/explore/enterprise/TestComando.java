package br.com.rrc.explore.enterprise;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.explore.enterprise.beans.enums.Comando;
import br.com.rrc.explore.enterprise.exceptions.ComandoInvalidoException;

public class TestComando {
	
	@Test 
	public void testBuscarComandoL() {
		
		char instrucao = 'L';
		Assert.assertEquals(Comando.ESQUERDA, Comando.buscaComando(instrucao));
	}
	
	@Test 
	public void testBuscarComandoR() {
		
		char instrucao = 'R';
		Assert.assertEquals(Comando.DIREITA, Comando.buscaComando(instrucao));
	}
	
	@Test 
	public void testBuscarComandoM() {
		
		char instrucao = 'M';
		Assert.assertEquals(Comando.MOVER, Comando.buscaComando(instrucao));
	}

	@Test (expected=ComandoInvalidoException.class)
	public void testBuscarComandoVazio() {
		
		char instrucao = ' ';
		Comando.buscaComando(instrucao);
	}
	
	@Test
	public void testParseString2Comando() {
		
		String instrucao = "LMLMLMLMM";
		List<Comando> comandos = Comando.parseString2Comando(instrucao);
		
		List<Comando> comandosExperados = new ArrayList<Comando>();
		
		comandosExperados.add(Comando.ESQUERDA);
		comandosExperados.add(Comando.MOVER);
		comandosExperados.add(Comando.ESQUERDA);
		comandosExperados.add(Comando.MOVER);
		comandosExperados.add(Comando.ESQUERDA);
		comandosExperados.add(Comando.MOVER);
		comandosExperados.add(Comando.ESQUERDA);
		comandosExperados.add(Comando.MOVER);
		comandosExperados.add(Comando.MOVER);
		
		Assert.assertEquals(comandosExperados, comandos);
	}
	
	@Test(expected=ComandoInvalidoException.class)
	public void testParseString2ComandoVazio() {
		
		String instrucao = "";
		Comando.parseString2Comando(instrucao);
	}
	
	@Test(expected=ComandoInvalidoException.class)
	public void testParseString2ComandoEspacoEmBranco() {
		
		String instrucao = " ";
		Comando.parseString2Comando(instrucao);
	}
}
