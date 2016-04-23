package br.com.rrc.enterprise.service;

import br.com.rrc.explore.enterprise.beans.Posicao;

public class MissaoService {


	public String explorar(String[][] mapa, Posicao posicao, String direcao, String comandos) {

		char comando[] = comandos.toCharArray();

		String sonda = "SONDA :-> ";
		
		for (int i = 0; i < comando.length; i++) {

			System.out.println("ENTRADA ************************************************* " );
			System.out.format("INSTRUCAO: %s", comando[i]);
			System.out.format("\nDIRECAO  : %s", direcao);
			System.out.format("\n[X][Y] ->: %s %s" , posicao.getLatitude(), posicao.getLongitude());
			System.out.println("\nENTRADA ************************************************* " );
			
			switch (comando[i]) {

			case 'L':

				direcao = rosaDosVetos("L", direcao);
				mapa [posicao.getLatitude().get()][posicao.getLongitude().get()] = sonda + direcao;
				break;

			case 'R':

				direcao = rosaDosVetos("R", direcao);
				mapa [posicao.getLatitude().get()][posicao.getLongitude().get()] = sonda + direcao;
				break;

			case 'M':

				switch (direcao) {
				
				case "N":

					
					posicao.getLongitude().incrementAndGet();
					break;

				case "E":

					posicao.getLatitude().incrementAndGet();
					break;

				case "S":

					posicao.getLongitude().decrementAndGet();
					break;

				case "W":

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
			System.out.format("INSTRUCAO: %s", comando[i]);
			System.out.format("\nDIRECAO  : %s", direcao);
			System.out.format("\n[X][Y] ->: %s %s" , posicao.getLatitude(), posicao.getLongitude());
			System.out.println("\nSAIDA ************************************************* " );
			
			imprimirMapa(mapa);
		}
		
		System.out.format("[X][Y] ->: %s %s - Direcao ->: %s", posicao.getLatitude(), posicao.getLongitude(), direcao );
		return String.format("%s %s %s", posicao.getLatitude(), posicao.getLongitude(), direcao);
	
	}
	
	private String rosaDosVetos(String comando, String direcao) {

		if ("N".equals(direcao) &&  "L".equals(comando)) {
			return "W";
		} else if ("N".equals(direcao) &&  "R".equals(comando)) {
			return "E";
		} else if ("E".equals(direcao) &&  "L".equals(comando)) {
			return "N";
		} else if ("E".equals(direcao) &&  "R".equals(comando)) {
			return "S"; 
		} else if ("S".equals(direcao) &&  "L".equals(comando)) {
			return "E";
		} else if ("S".equals(direcao) &&  "R".equals(comando)) {
			return "W";
		} else if ("W".equals(direcao) &&  "L".equals(comando)) {
			return "S";
		} else if ("W".equals(direcao) &&  "R".equals(comando)) {
			return "S";
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
