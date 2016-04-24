package br.com.rrc.enterprise.beans;

public class VirarEsquerda implements Controle {
	
	@Override
	public void executarComando(Sonda sonda) {
		sonda.virarEsquerda();
	}
}
