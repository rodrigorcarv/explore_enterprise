package br.com.rrc.explore.enterprise.exceptions;

import br.com.rrc.explore.enterprise.beans.enums.Direcao;

public class DirecaoInvalidaException extends RuntimeException {
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MSG_ERR0_DIRECAO_INVALIDA = "A direção %s informada é invalida";
	
	public DirecaoInvalidaException(String direcao) {
		super (String.format(MSG_ERR0_DIRECAO_INVALIDA , direcao));
	}

	public DirecaoInvalidaException(Direcao direcao) {
		super (String.format(MSG_ERR0_DIRECAO_INVALIDA , direcao));
	}}
