package br.com.rrc.explore.enterprise.beans;

import br.com.rrc.explore.enterprise.beans.enums.Direcao;
import br.com.rrc.explore.enterprise.exceptions.DirecaoInvalidaException;
import br.com.rrc.explore.enterprise.exceptions.PosicaoSondaInvalidaException;

public class Sonda {
	
	private String id;
	private String nome;
	private Coordenada coordenada;
	private Direcao direcao;
	
	public Sonda() {}
	
	public Sonda(String nome, Coordenada coordenada, Direcao direcao) {
		super();
		this.nome = nome;
		this.coordenada = coordenada;
		this.direcao = direcao;
	}
	
	public Sonda(Coordenada coordenada, Direcao direcao) {
		super();
		this.coordenada = coordenada;
		this.direcao = direcao;
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
	
	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public void virarEsquerda() {
		
		if (direcao == null) {
			throw new DirecaoInvalidaException(direcao);
		}

		direcao = direcao.virarEsqueda(direcao);
	}
	
	public void virarDireita() {
		
		if (direcao == null) {
			throw new DirecaoInvalidaException(direcao);
		}
		direcao = direcao.virarDireita(direcao);
	}

	public void mover(Dimensao dimensao) {
		
		if (direcao == null) {
			throw new DirecaoInvalidaException(direcao);
		}
		
		if (direcao.isCoordenadaValida(coordenada, dimensao)) {
			throw new PosicaoSondaInvalidaException(coordenada, direcao);
		}
		
		direcao.navegar(coordenada);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((direcao == null) ? 0 : direcao.hashCode());
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
		Sonda other = (Sonda) obj;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (direcao != other.direcao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Sonda [id=%s, nome=%s, coordenada=%s, direcao=%s]", id, nome, coordenada, direcao);
	}
}
