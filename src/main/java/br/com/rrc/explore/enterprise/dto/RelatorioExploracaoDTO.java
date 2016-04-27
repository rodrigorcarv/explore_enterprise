package br.com.rrc.explore.enterprise.dto;

import java.util.List;

import br.com.rrc.explore.enterprise.beans.Sonda;

public class RelatorioExploracaoDTO {
	
	private Sonda sonda;
	private List<PosicaoDTO> posicaoDTOs;
	
	public Sonda getSonda() {
		return sonda;
	}
	public void setSonda(Sonda sonda) {
		this.sonda = sonda;
	}
	public List<PosicaoDTO> getPosicaoDTOs() {
		return posicaoDTOs;
	}
	public void setPosicaoDTOs(List<PosicaoDTO> posicaoDTOs) {
		this.posicaoDTOs = posicaoDTOs;
	}
	@Override
	public String toString() {
		return String.format("RelatorioExploracaoDTO [sonda=%s, posicaoDTOs=%s]", sonda, posicaoDTOs);
	}
}
