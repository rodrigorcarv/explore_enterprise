package br.com.rrc.enterprise.service;


import java.util.List;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Mapa;
import br.com.rrc.enterprise.beans.Movimentar;
import br.com.rrc.enterprise.beans.Sonda;
import br.com.rrc.enterprise.beans.VirarDireita;
import br.com.rrc.enterprise.beans.VirarEsquerda;

public class MissaoService {

	public String explorar(Mapa mapa, Sonda sonda, List<Comando> comandos) {

		String [][]  planalto = new String [mapa.getComprimento()][mapa.getLargura()];
		
		Coordenada coordenada = sonda.getCoordenada();
		Direcao direcao = sonda.getDirecao();

		for (Comando comando : comandos) {

			switch (comando) {

			case ESQUERDA:

				VirarEsquerda virarEsquerda = new VirarEsquerda();
				virarEsquerda.executarComando(sonda);

				planalto [coordenada.getLatitude().get()][coordenada.getLongitude().get()] = sonda.getNome() + sonda.getDirecao();
				break;

			case DIREITA:

				VirarDireita virarDireita = new VirarDireita();
				virarDireita.executarComando(sonda);

				planalto [coordenada.getLatitude().get()][coordenada.getLongitude().get()] = sonda.getNome() + sonda.getDirecao();
				break;

			case MOVER:

				Movimentar movimentar = new Movimentar();
				movimentar.moverSonda(sonda);

				planalto [coordenada.getLatitude().get()][coordenada.getLongitude().get()] = sonda.getNome() + direcao;
			}

			imprimirMapa(planalto);
		}

		return String.format("%s %s %s", coordenada.getLatitude(), coordenada.getLongitude(), direcao);

	}

	private void imprimirMapa(String[][] mapa) {

		System.out.println("*********************************************************************");

		for (int x=mapa.length-1; x >= 0; x-- ) {

			for (int y=0; y < mapa.length ; y++) {

				System.out.format("[%s, %s  = %12s]", x, y, (mapa[x][y] == null ? " ---------- " : mapa[x][y]));
			}
			System.out.println();
		}
	}

}
