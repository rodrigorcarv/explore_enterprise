package br.com.rrc.enterprise.beans;

public class Dimensao {
	
	private int comprimento;
	private int largura;
	
	public Dimensao() {}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comprimento;
		result = prime * result + largura;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimensao other = (Dimensao) obj;
		if (comprimento != other.comprimento)
			return false;
		if (largura != other.largura)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Dimensao [comprimento=%s, largura=%s]", comprimento, largura);
	}
}
