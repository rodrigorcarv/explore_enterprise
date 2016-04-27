package br.com.rrc.explore.enterprise.dto;

import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.Direcao;

public class PosicaoDTO {
	
	private Coordenada coordenada;
	private Direcao direcao;
	
	public PosicaoDTO(Coordenada coordenada, Direcao direcao) {
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
	@Override
	public String toString() {
		return String.format("PosicaoDTO [coordenada=%s, direcao=%s]", coordenada, direcao);
	}
}
