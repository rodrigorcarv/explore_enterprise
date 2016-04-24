package br.com.rrc.enterprise.beans;

public class Sonda extends Controle{
	
	private String id;
	private String nome;
	private Posicao posicao;
	
	public Sonda(String nome, Posicao posicao) {
		super();
		this.nome = nome;
		this.posicao = posicao;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Posicao getPosicao() {
		return posicao;
	}
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

}
