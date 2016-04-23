package br.com.rrc.enterprise.service;


import java.util.List;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Posicao;

public class MissaoService {

	public String explorar(String[][] mapa, Posicao posicao, Direcao direcao, List<Comando> comandos) {
	
		String sonda = "SONDA :-> ";
		
		for (Comando comando : comandos) {
		
			System.out.println("ENTRADA ************************************************* " );
			System.out.format("INSTRUCAO: %s", comando);
			System.out.format("\nDIRECAO  : %s", direcao);
			System.out.format("\n[X][Y] ->: %s %s" , posicao.getLatitude(), posicao.getLongitude());
			System.out.println("\nENTRADA ************************************************* " );
			
			switch (comando) {

			case ESQUERDA:

				direcao = rosaDosVetos(Comando.ESQUERDA, direcao);
				mapa [posicao.getLatitude().get()][posicao.getLongitude().get()] = sonda + direcao;
				break;

			case DIREITA:

				direcao = rosaDosVetos(Comando.DIREITA, direcao);
				mapa [posicao.getLatitude().get()][posicao.getLongitude().get()] = sonda + direcao;
				break;

			case MOVER:

				switch (direcao) {
				
				case NORTE:
					
					posicao.getLongitude().incrementAndGet();
					break;

				case LESTE:

					posicao.getLatitude().incrementAndGet();
					break;

				case SUL:

					posicao.getLongitude().decrementAndGet();
					break;

				case OESTE:

					posicao.getLatitude().decrementAndGet();
					break;

				default:
					break;
				}
				
				mapa [posicao.getLatitude().get()][posicao.getLongitude().get()] = sonda + direcao;

			default:
				break;
			}
			System.out.println("SAIDA ************************************************* " );
			System.out.format("INSTRUCAO: %s", comando);
			System.out.format("\nDIRECAO  : %s", direcao);
			System.out.format("\n[X][Y] ->: %s %s" , posicao.getLatitude(), posicao.getLongitude());
			System.out.println("\nSAIDA ************************************************* " );
			
			imprimirMapa(mapa);
		}
		
		System.out.format("[X][Y] ->: %s %s - Direcao ->: %s", posicao.getLatitude(), posicao.getLongitude(), direcao );
		return String.format("%s %s %s", posicao.getLatitude(), posicao.getLongitude(), direcao);
	
	}
	
	private Direcao rosaDosVetos(Comando comando, Direcao direcao) {

		if (Direcao.NORTE.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.OESTE;
		} else if (Direcao.NORTE.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.LESTE;
		} else if (Direcao.LESTE.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.NORTE;
		} else if (Direcao.LESTE.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.SUL; 
		} else if (Direcao.SUL.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.LESTE;
		} else if (Direcao.SUL.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.OESTE;
		} else if (Direcao.OESTE.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.SUL;
		} else if (Direcao.OESTE.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.SUL;
		}
		return direcao;
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
