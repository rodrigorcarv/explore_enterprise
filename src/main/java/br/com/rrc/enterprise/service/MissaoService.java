package br.com.rrc.enterprise.service;


import java.util.List;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Posicao;
import br.com.rrc.enterprise.beans.Sonda;

public class MissaoService {

	private NavegadoService navegadoService = new NavegadoService();
	
	public String explorar(String[][] mapa, Sonda sonda, List<Comando> comandos) {
	
		Posicao posicao = sonda.getPosicao();
		Coordenada coordenada = posicao.getCoordenada();
		Direcao direcao = posicao.getDirecao();
		
		for (Comando comando : comandos) {
		
			System.out.println("ENTRADA ************************************************* " );
			System.out.format("INSTRUCAO: %s", comando);
			System.out.format("\nDIRECAO  : %s", posicao.getDirecao());
			System.out.format("\n[X][Y] ->: %s %s" , coordenada.getLatitude(), coordenada.getLongitude());
			System.out.println("\nENTRADA ************************************************* " );
			
			switch (comando) {

			case ESQUERDA:

				direcao = navegadoService.navega(Comando.ESQUERDA, direcao);
				mapa [coordenada.getLatitude().get()][coordenada.getLongitude().get()] = sonda.getNome() + direcao;
				break;

			case DIREITA:

				direcao = navegadoService.navega(Comando.DIREITA, direcao);
				mapa [coordenada.getLatitude().get()][coordenada.getLongitude().get()] = sonda.getNome() + direcao;
				break;

			case MOVER:

				switch (direcao) {
				
				case NORTE:
					
					coordenada.getLongitude().incrementAndGet();
					break;

				case LESTE:

					coordenada.getLatitude().incrementAndGet();
					break;

				case SUL:

					coordenada.getLongitude().decrementAndGet();
					break;

				case OESTE:

					coordenada.getLatitude().decrementAndGet();
					break;

				default:
					break;
				}
				
				mapa [coordenada.getLatitude().get()][coordenada.getLongitude().get()] = sonda.getNome() + direcao;

			default:
				break;
			}
			System.out.println("SAIDA ************************************************* " );
			System.out.format("INSTRUCAO: %s", comando);
			System.out.format("\nDIRECAO  : %s", direcao);
			System.out.format("\n[X][Y] ->: %s %s" , coordenada.getLatitude(), coordenada.getLongitude());
			System.out.println("\nSAIDA ************************************************* " );
			
			imprimirMapa(mapa);
		}
		
		System.out.format("[X][Y] ->: %s %s - Direcao ->: %s", coordenada.getLatitude(), coordenada.getLongitude(), direcao );
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
