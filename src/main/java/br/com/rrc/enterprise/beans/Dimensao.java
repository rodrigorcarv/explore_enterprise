package br.com.rrc.enterprise.beans;

public class Dimensao {
	
	private int comprimento;
	private int largura;
	
	public Dimensao(int comprimento, int largura) {
		super();
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public int getComprimento() {
		return comprimento;
	}
	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}

}
