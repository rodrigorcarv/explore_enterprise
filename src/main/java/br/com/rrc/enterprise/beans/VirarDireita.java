package br.com.rrc.enterprise.beans;

public class VirarDireita implements Controle {
	
	@Override
	public void executarComando(Sonda sonda) {
		sonda.virarDireita();
	}
}
