package br.com.rrc.explore.enterprise.beans;

public class VirarDireita implements Controle {
	
	@Override
	public void executarComando(Sonda sonda) {
		sonda.virarDireita();
	}
}
