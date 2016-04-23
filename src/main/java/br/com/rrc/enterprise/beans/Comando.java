package br.com.rrc.enterprise.beans;

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
	
	L("esquerda"),
	R("direita"),
	M("mover");
	
	private String descricao;

	Comando (String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
