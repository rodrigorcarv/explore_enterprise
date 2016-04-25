package br.com.rrc.enterprise.beans;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe {@link Coordenada} representa um ponto unico no planeta 
 * a ser explorado.
 * 
 * Sendo assim sempre temos que ter a latitude e logitude preenchido
 * como indicado no construtor;
 * 
 * @author rodrigo
 *
 */
public class Coordenada {
	
	private AtomicInteger latitude;
	private AtomicInteger longitude;
	
	public Coordenada(AtomicInteger latitude, AtomicInteger longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public AtomicInteger getLatitude() {
		return latitude;
	}
	public void setLatitude(AtomicInteger latitude) {
		this.latitude = latitude;
	}
	public AtomicInteger getLongitude() {
		return longitude;
	}
	public void setLongitude(AtomicInteger longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
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
		Coordenada other = (Coordenada) obj;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!(latitude.intValue() == other.latitude.intValue()))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!(longitude.intValue() == other.longitude.intValue()))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return String.format("Coordenada [latitude=%s, longitude=%s]", latitude, longitude);
	}
}
