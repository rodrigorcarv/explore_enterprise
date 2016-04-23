package br.com.rrc.enterprise.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Enum que representa os comandos de controle da Sonda
 * 
 * Os comando L e R servem para virar a sonda 90 graus
 * para esquerda ou para direita.
 * 
 * O comando mover serve para que a sonda se mova sem 
 * alterar a direcao.
 *  
 * @author rodrigo
 */
public enum Comando {
	
	ESQUERDA("L"),
	DIREITA("R"),
	MOVER("M");
	
	private String sigla;
	
	private static final String MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO = "O(s) comando(s): %s informado(s) s\u00E3o inv\u00E1lidos  ";

	Comando (String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	/**
	 * Faz a conversao de uma String que contem as intrucoes(comandos)
	 * da sonda para uma {@link List} de {@link Comando};
	 * 
	 * Caso os comandos informados em forma de {@link String} nao 
	 * 
	 * @param comando
	 * @return {@link List} de {@link Comando}
	 **/
	public static List<Comando> parseString2Comando(String instrucao) {
		
		if (StringUtils.isBlank(instrucao)) {
			throw new IllegalArgumentException(String.format(MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO, instrucao));
		}
		
		char instrucoes[] = instrucao.toCharArray();
		List<Comando> comandos = new ArrayList<Comando>();

		for (int i = 0; i < instrucoes.length; i++) {
			
			Comando comando = buscaComando(instrucoes[i]);
			comandos.add(comando);
		}
		
		return comandos;
	}
	
	/**
	 * Busca no enum {@link Comando} o comnado informado devolvendo o mesmo em forma de 
	 * {@link Comando}
	 * Caso nao exista sera exibida a excecao de {@link IllegalArgumentException}.
	 * 
	 * @param instrucao 
	 * @return {@link Comando}
	 */
	public static Comando buscaComando(char instrucao) {

		for (Comando comando : Comando.values()) {
			
			if (comando.sigla.equals(String.valueOf(instrucao))){
				return comando;
			}
		}
		throw new IllegalArgumentException(String.format(MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO, instrucao));
	}
}
