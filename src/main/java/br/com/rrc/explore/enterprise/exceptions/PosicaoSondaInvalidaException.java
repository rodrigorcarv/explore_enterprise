package br.com.rrc.explore.enterprise.exceptions;

import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.enums.Direcao;

public class PosicaoSondaInvalidaException extends RuntimeException{
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	

	private static final String MSG_ERR0_COMANDO_INFORMADO_RESULTARAM_EM_UMA_COORDENADA_INVALDIA = 
			"Os comandos informados levam a sonda para uma coordena %s na dire\u00E7\u00E3o %s que \u00E9 inv\u00E1lida";
	public PosicaoSondaInvalidaException(Coordenada coordenada, Direcao direcao) {
		super (String.format(MSG_ERR0_COMANDO_INFORMADO_RESULTARAM_EM_UMA_COORDENADA_INVALDIA , direcao));
	}
}
