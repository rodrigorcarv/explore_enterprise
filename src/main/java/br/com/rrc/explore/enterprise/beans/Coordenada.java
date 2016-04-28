package br.com.rrc.explore.enterprise.beans;

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
public class Coordenada implements Cloneable{
	
	private int latitude;
	private int longitude;
	
	public Coordenada() {}
	
	public Coordenada(int latitude, int longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
    public Coordenada clone() throws CloneNotSupportedException {  
    	
    	Coordenada clonada = (Coordenada) super.clone();  
        return clonada;  
    }  
	
	
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + latitude;
		result = prime * result + longitude;
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
		if (latitude != other.latitude)
			return false;
		if (longitude != other.longitude)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Coordenada [latitude=%s, longitude=%s]", latitude, longitude);
	}

	public void incrementLongitude() {
		++longitude;
	}

	public void decrementLongitude() {
		--longitude;
	}

	public void incrementLatitude() {
		++latitude;
	}

	public void decrementLatitude() {
		--latitude;
	}
}
