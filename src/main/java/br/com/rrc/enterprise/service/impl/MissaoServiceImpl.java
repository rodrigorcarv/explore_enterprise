package br.com.rrc.enterprise.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.hk2.annotations.Service;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Dimensao;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Movimentar;
import br.com.rrc.enterprise.beans.Sonda;
import br.com.rrc.enterprise.beans.VirarDireita;
import br.com.rrc.enterprise.beans.VirarEsquerda;

@Service
public class MissaoServiceImpl {

	public String explorar(Dimensao dimensao, Sonda sonda, List<Comando> comandos) {

		List<Coordenada> coordenadas = new ArrayList<>();
		
		Coordenada coordenada = sonda.getCoordenada();
		Direcao direcao = sonda.getDirecao();

		for (Comando comando : comandos) {

			switch (comando) {

			case ESQUERDA:

				VirarEsquerda virarEsquerda = new VirarEsquerda();
				virarEsquerda.executarComando(sonda);
				break;

			case DIREITA:

				VirarDireita virarDireita = new VirarDireita();
				virarDireita.executarComando(sonda);
				break;

			case MOVER:

				Movimentar movimentar = new Movimentar();
				movimentar.moverSonda(sonda, dimensao);
				coordenadas.add(coordenada);
				break;
			}
		}
		return String.format("%s %s %s", coordenada.getLatitude(), coordenada.getLongitude(), direcao);
	}
}
