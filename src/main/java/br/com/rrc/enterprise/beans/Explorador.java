package br.com.rrc.enterprise.beans;

import java.util.List;

public class Explorador {
	
	private Sonda sonda;
	private List<Comando> comandos;
	
	public Explorador(Sonda sonda, List<Comando> comandos) {
		super();
		this.sonda = sonda;
		this.comandos = comandos;
	}
	
	public Sonda getSonda() {
		return sonda;
	}
	public void setSonda(Sonda sonda) {
		this.sonda = sonda;
	}
	public List<Comando> getComandos() {
		return comandos;
	}
	public void setComandos(List<Comando> comandos) {
		this.comandos = comandos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comandos == null) ? 0 : comandos.hashCode());
		result = prime * result + ((sonda == null) ? 0 : sonda.hashCode());
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
		Explorador other = (Explorador) obj;
		if (comandos == null) {
			if (other.comandos != null)
				return false;
		} else if (!comandos.equals(other.comandos))
			return false;
		if (sonda == null) {
			if (other.sonda != null)
				return false;
		} else if (!sonda.equals(other.sonda))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Explorador [sonda=%s, comandos=%s]", sonda, comandos);
	}
	
	
}
