package br.com.rrc.explore.enterprise.exceptions;

public class ComandoInvalidoException extends RuntimeException{

	/**
	 * Serial. 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO = "O(s) comando(s): %s informado(s) s\u00E3o inv\u00E1lido(s)  ";

	public ComandoInvalidoException(char instrucao) {
		super (String.format(MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO , instrucao));
	}

	public ComandoInvalidoException(String instrucao) {
		super (String.format(MSG_ERRO_COMANDO_INFORMADO_E_INVALIDO , instrucao));
	}
}
