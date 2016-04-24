package br.com.rrc.enterprise.beans;

/**
 *  Enum para indicar os pontos cardiais 
 * 
 *  Pontos cardeais: Norte (N), Sul (S), Leste (E) e Oeste (W)
 *  
 *  Desmostração de rosa dos ventos:
 *  
 *  		 Norte (N)
 *  			|
 *  Oeste (W)---|---Leste (E)
 *  			|	
 *  		 Sul (S)  
 * 
 * @author rodrigo
 *
 */
public enum Direcao {
	
	NORTE("N"),
	SUL("S"),
	LESTE("L"),
	OESTE("O");

	private static final String MENSAGEM_COORDENADA_NAO_ENCONTRADA = "A direção %s informada não foi encontrada";

	private String descricao;
	private Direcao direita;
	private Direcao esquerda;
	
	Direcao (String descricao) {
		this.descricao = descricao;
	}
	
	static {
		NORTE.navegar(Direcao.LESTE, Direcao.OESTE);
		SUL.navegar(Direcao.OESTE, Direcao.LESTE);
		LESTE.navegar(Direcao.SUL, Direcao.NORTE);
		OESTE.navegar(Direcao.NORTE, Direcao.SUL);
	}
	
	/**
	 * Busca no enum Rosas dos Ventos a coordenada informada devolvendo a mesma em forma de 
	 * {@link Direcao}
	 * Caso não exista será exibida a exceção de {@link IllegalArgumentException}.
	 * 
	 * @param coordenada 
	 * @return {@link Direcao}
	 */
	public static Direcao buscaCoordenada (String coordenada) {
		
		for (Direcao bussula : Direcao.values()) {
			
			if (bussula.descricao.equals(coordenada)){
				return bussula;
			}
		}
		throw new IllegalArgumentException(String.format(MENSAGEM_COORDENADA_NAO_ENCONTRADA, coordenada));
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Direcao virarEsqueda(Direcao direcao) {
		return direcao.esquerda;
	}
	
	public Direcao virarDireita(Direcao direcao) {
		return direcao.direita;
	}
	
	private void navegar(Direcao direita, Direcao esquerda) {
		this.direita = direita;
		this.esquerda = esquerda;
	}
}
