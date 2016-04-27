package br.com.rrc.explore.enterprise.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorOrder;

public class Mapa {
	
	private Dimensao dimensao;
	private List<Explorador> exploradores;

	public Dimensao getDimensao() {
		return dimensao;
	}
	public void setDimensao(Dimensao dimensao) {
		this.dimensao = dimensao;
	}
	public List<Explorador> getExploradores() {
		return exploradores;
	}
	public void setExploradores(List<Explorador> exploradores) {
		this.exploradores = exploradores;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dimensao == null) ? 0 : dimensao.hashCode());
		result = prime * result + ((exploradores == null) ? 0 : exploradores.hashCode());
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
		Mapa other = (Mapa) obj;
		if (dimensao == null) {
			if (other.dimensao != null)
				return false;
		} else if (!dimensao.equals(other.dimensao))
			return false;
		if (exploradores == null) {
			if (other.exploradores != null)
				return false;
		} else if (!exploradores.equals(other.exploradores))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Mapa [dimensao=%s, exploradores=%s]", dimensao, exploradores);
	}
	
	
}
