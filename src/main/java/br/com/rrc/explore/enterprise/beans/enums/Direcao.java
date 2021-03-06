package br.com.rrc.explore.enterprise.beans.enums;

import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.Dimensao;
import br.com.rrc.explore.enterprise.exceptions.DirecaoInvalidaException;

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
	
	NORTE("N") {
		
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.incrementLongitude();
		}

		public boolean isCoordenadaValida(Coordenada coordenada, Dimensao dimensao) {
			return coordenada.getLongitude() +1 > dimensao.getComprimento();
		}
	},
	SUL("S") {
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.decrementLongitude();
		}
		
		public boolean isCoordenadaValida(Coordenada coordenada, Dimensao dimensao) {
			return coordenada.getLongitude() -1 < 0;
		}
	},
	LESTE("E") {
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.incrementLatitude();
		}
		
		public boolean isCoordenadaValida(Coordenada coordenada, Dimensao dimensao) {
			return coordenada.getLatitude() +1 > dimensao.getLargura();
		}
	},
	OESTE("W") {
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.decrementLatitude();
		}
		
		public boolean isCoordenadaValida(Coordenada coordenada, Dimensao dimensao) {
			return coordenada.getLatitude() -1 < 0;
		}
	};

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
	 **/  
	static {
		NORTE.navegar(Direcao.LESTE, Direcao.OESTE);
		SUL.navegar(Direcao.OESTE, Direcao.LESTE);
		LESTE.navegar(Direcao.SUL, Direcao.NORTE);
		OESTE.navegar(Direcao.NORTE, Direcao.SUL);
	}
	
	
	private String descricao;
	private Direcao direita;
	private Direcao esquerda;
	
	Direcao (String descricao) {
		this.descricao = descricao;
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
		throw new DirecaoInvalidaException(coordenada);
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Direcao virarEsqueda(Direcao direcao) {
		
		if (direcao == null ) {
			throw new DirecaoInvalidaException(direcao);
		}
		
		return direcao.esquerda;
	}
	
	public Direcao virarDireita(Direcao direcao) {
		
		if (direcao == null ) {
			throw new DirecaoInvalidaException(direcao);
		}
		
		return direcao.direita;
	}
	
	private void navegar(Direcao direita, Direcao esquerda) {
		this.direita = direita;
		this.esquerda = esquerda;
	}

	public abstract void navegar(Coordenada coordenada);
	 
	public abstract boolean isCoordenadaValida(Coordenada coordenada, Dimensao dimensao);
}
