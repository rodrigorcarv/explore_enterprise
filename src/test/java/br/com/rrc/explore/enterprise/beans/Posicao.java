package br.com.rrc.explore.enterprise.beans;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe {@link Posicao} representa um ponto unico no planeta 
 * a ser explorado.
 * 
 * Sendo assim sempre temos que ter a latitude e logitude preenchido
 * como indicado no construtor;
 * 
 * @author rodrigo
 *
 */
public class Posicao {

	private AtomicInteger latitude;
	private AtomicInteger longitude;
	
	public Posicao(AtomicInteger latitude, AtomicInteger longitude) {
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
}
