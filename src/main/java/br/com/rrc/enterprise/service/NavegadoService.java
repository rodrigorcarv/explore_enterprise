package br.com.rrc.enterprise.service;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Direcao;

/**
 * Classe responsavel por realizar a navegacao da sonda 
 * 
 * @author rodrigo
 *
 */
public class NavegadoService {

	private static final String MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO = "O(s) comando(s): %s informado(s) s\u00E3o inv\u00E1lido(s) ";
	private static final String MSG_ERRO_DIRECAO_INFORMADO_E_INVALIDO = "A(s) dire\u00E7\u00E3o(s): %s informada(s) est\u00E1 inv\u00E1lida(s)  ";;

	/**
	 * Responsavel por realizar a navegacao da sonda
	 * de acordo com as seguintes regras:
	 * 
	 *  Esquerda vira 90 graus;
	 *  Direita vira 90 graus;
	 *  
	 *  Aplicando esta regras a rosas dos ventos {@link Direcao}
	 *  
	 *  Sonda apontando para o NORTE 
	 *  	vira 90 graus a esquerda obter direcao OESTE
	 *      vira 90 graus a direita obter direcao LESTE
	 *  
	 *  Sonda apontando para o LESTE 
	 *  	vira 90 graus a esquerda obter direcao NORTE
	 *      vira 90 graus a direita obter direcao SUL
	 * 
	 *  Sonda apontando para o SUL 
	 *  	vira 90 graus a esquerda obter direcao LESTE
	 *      vira 90 graus a direita obter direcao OESTE
	 *
	 *  Sonda apontando para o OESTE 
	 *  	vira 90 graus a esquerda obter direcao SUL
	 *      vira 90 graus a direita obter direcao NORTE
	 *      
	 * @param comando {@link Comando}
	 * @param direcao {@link Direcao}
	 * @return {@link Direcao}
	 * @exception {@link IllegalArgumentException} um dos campos de entrada estaja nulo.
	 * 
	 */
	public Direcao navega(Comando comando, Direcao direcao) {

		validaNavegacao(comando, direcao);

		if (Comando.ESQUERDA.equals(comando)) {

			switch (direcao) {

			case NORTE:
				return Direcao.OESTE;

			case LESTE:
				return Direcao.NORTE;

			case SUL:
				return Direcao.LESTE;

			case OESTE:
				return Direcao.SUL;

			}

		} else if (Comando.DIREITA.equals(comando)) {

			switch (direcao) {

			case NORTE:
				return Direcao.LESTE;

			case LESTE:
				return Direcao.SUL; 

			case SUL:
				return Direcao.OESTE;

			case OESTE:
				return Direcao.NORTE;

			}

		}
		throw new IllegalArgumentException(String.format(MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO, comando));
	}


	private void validaNavegacao(Comando comando, Direcao direcao) {

		if (comando == null) {
			throw new IllegalArgumentException(String.format(MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO, comando));
		}

		if (direcao == null) {
			throw new IllegalArgumentException(String.format(MSG_ERRO_DIRECAO_INFORMADO_E_INVALIDO, direcao));
		}
	}
}
