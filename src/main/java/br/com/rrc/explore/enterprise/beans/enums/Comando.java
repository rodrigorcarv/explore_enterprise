package br.com.rrc.explore.enterprise.beans.enums;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.rrc.explore.enterprise.beans.Controle;
import br.com.rrc.explore.enterprise.beans.VirarDireita;
import br.com.rrc.explore.enterprise.beans.VirarEsquerda;
import br.com.rrc.explore.enterprise.exceptions.ComandoInvalidoException;

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
	
	ESQUERDA("L"){

		@Override
		public VirarEsquerda criarControlePorTipoDeComando() {
			return new VirarEsquerda();
		} 
	},
	DIREITA("R"){

		@Override
		public Controle criarControlePorTipoDeComando() {
			return new VirarEsquerda();
		}
	},
	MOVER("M"){

		@Override
		public Controle criarControlePorTipoDeComando() {
			return new VirarEsquerda();
		}
	};
	
	private String sigla;
	
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
	 * constem na lista de enum seram considerados invalidos.
	 * 
	 * Para a instrucao ser valida ela nao pode ser nula, vazio ou espaco em branco
	 * 
	 * @param comando
	 * @return {@link List} de {@link Comando}
	 * @throws ComandoInvalidoException essa excecao pode ocorrer caso a instrucao seja
	 *         invalida
	 **/
	public static List<Comando> parseString2Comando(String instrucao) {
		
		if (StringUtils.isBlank(instrucao)) {
			throw new ComandoInvalidoException(instrucao);
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
	 * @throws ComandoInvalidoException essa excecao pode ocorrer caso a instrucao seja
	 *         invalida
	 */
	public static Comando buscaComando(char instrucao) {

		for (Comando comando : Comando.values()) {
			
			if (comando.sigla.equals(String.valueOf(instrucao))){
				return comando;
			}
		}
		
		throw new ComandoInvalidoException(instrucao);
	}
	
	/**
	 * Busca no enum {@link Comando} o comnado informado devolvendo o mesmo em forma de 
	 * {@link Comando}
	 * Caso nao exista sera exibida a excecao de {@link IllegalArgumentException}.
	 * 
	 * @param instrucao 
	 * @return {@link Comando}
	 * @throws ComandoInvalidoException essa excecao pode ocorrer caso a instrucao seja
	 *         invalida
	 */
	public static Controle buscaControlePorComando(char instrucao) {

		for (Comando comando : Comando.values()) {
			
			if (comando.sigla.equals(String.valueOf(instrucao))){
				return comando.criarControlePorTipoDeComando();
			}
		}
		
		throw new ComandoInvalidoException(instrucao);
	}
	
	public abstract Controle criarControlePorTipoDeComando();
}