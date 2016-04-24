package br.com.rrc.enterprise.beans;

/**
 * Classe {@link Posicao} representa um ponto unico no planeta 
 * a ser explorado.
 * 
 * Sendo assim sempre temos que ter a latitude e logitude preenchido e 
 * a {@link Direcao} preenchida para um dos pontos cardeais;
 * como indicado no construtor;
 * 
 * @author rodrigo
 *
 */
public class Posicao {

	private Coordenada coordenada;
	private Direcao direcao;
	
	public Posicao(Coordenada coordenada, Direcao direcao) {
		super();
		this.coordenada = coordenada;
		this.direcao = direcao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}
	
	public void virarEsquerda() {
		direcao = direcao.virarEsqueda(direcao);
	}
	
	public void virarDireita() {
		direcao = direcao.virarDireita(direcao);
	}

	@Override
	public String toString() {
		return String.format("Posicao [coordenada=%s, direcao=%s]", coordenada, direcao);
	}
}
