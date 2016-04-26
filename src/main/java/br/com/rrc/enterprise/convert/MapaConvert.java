package br.com.rrc.enterprise.convert;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.convert.StringConvert;
import org.springframework.stereotype.Component;

import br.com.rrc.enterprise.beans.Comando;
import br.com.rrc.enterprise.beans.Coordenada;
import br.com.rrc.enterprise.beans.Dimensao;
import br.com.rrc.enterprise.beans.Direcao;
import br.com.rrc.enterprise.beans.Explorador;
import br.com.rrc.enterprise.beans.Mapa;
import br.com.rrc.enterprise.beans.Sonda;

/**
 * Classe responsavel por convert as um 
 * 
 * 
 * @author rodrigo
 *
 */
@Component
public class MapaConvert {

	private static final String LINE = "\r\n";

	private static final String DIMENSOES   = "\\s*?(\\d+)\\s*(\\d+)\\s*";
	private static final String COORDENADAS = "\\s*?(\\d+)\\s*(\\d+)\\s*([A-Z]+)\\s*";
	private static final String COOMANDOS   = "\\s*([A-Z]+)\\s*";

	/**
	 * Conter de String(text/plain) para um {@link Mapa} seguindo as seguintes configuracoes;
	 * 
	 *	 5 5 
	 * 	 1 2 N
	 * 	 LMLMLMLMM
	 * 	 3 3 E
	 *	 MMRMMRMRRM
	 * 
	 * 5 5        (Dimensao) largura - comprimento
	 * 1 2 N      (Sonda) coordenada x (latitude) - coordenada y(longitude) - direcao
	 * LMLMLMLMM   sequencia de comandos
	 * 3 3 E      (Sonda) coordenada x (latitude) - coordenada y(longitude) - direcao
	 * MMRMMRMRRM  sequencia de comandos
	 * 
	 * @param caminho linha contendo cidade (ponto) origim e destino
	 * @param mapa nome do mapa
	 * @return {@link Mapa}
	 */
	public Mapa string2Mapa(String coordenadaAndComandos) {

		List<Explorador> exploradores = new ArrayList<>(); 

		Pattern patternCoordenada = Pattern.compile(COORDENADAS);
		Pattern patternComando = Pattern.compile(COOMANDOS);
		Pattern patternDimensoes = Pattern.compile(DIMENSOES);

		StringTokenizer linesTokenizer = new StringTokenizer(coordenadaAndComandos, LINE, false);

		Matcher matcherDimensao = getMatcher(patternDimensoes, linesTokenizer.nextToken());
		Dimensao dimensao = string2Dimensao(matcherDimensao.group(1), matcherDimensao.group(2));

		while (linesTokenizer.hasMoreTokens()) {

			Matcher matcherCoordenadas = getMatcher(patternCoordenada, linesTokenizer.nextToken());
			Sonda sonda = string2Sonda(matcherCoordenadas.group(1), matcherCoordenadas.group(2), matcherCoordenadas.group(3));
			
			Matcher matcherComandos = getMatcher(patternComando, linesTokenizer.nextToken());
			List<Comando> comandos = string2Comando(matcherComandos.group(1));
			
			Explorador explorador = new Explorador(sonda, comandos);
			exploradores.add(explorador);
		}

		Mapa mapa = new Mapa();
		mapa.setDimensao(dimensao);
		mapa.setExploradores(exploradores);

		return mapa;
	}

	/**
	 * Cria uma {@link Sonda} com base nas string fornecidas.
	 * 
	 * @param coordenadaLatitude posicao da coordenada eixo x 
	 * @param coordenadaLongitude posicao da coordenada do eixo y
	 * @param direcaoSonda direcao da {@link Sonda}
	 * @return {@link Sonda} sonda
	 */
	private Sonda string2Sonda(String coordenadaLatitude, String coordenadaLongitude, String direcaoSonda) {

		AtomicInteger latitude = StringConvert.INSTANCE.convertFromString(AtomicInteger.class, coordenadaLatitude);
		AtomicInteger longitude = StringConvert.INSTANCE.convertFromString(AtomicInteger.class, coordenadaLongitude);
		Coordenada coordenada = new Coordenada(latitude , longitude);
		Direcao direcao = Direcao.buscaCoordenada(direcaoSonda); 
		Sonda sonda = new Sonda(coordenada, direcao);
		return sonda;
	}

	/**
	 * Cria uma {@link List} de {@link Comando}  com base nas string fornecidas.
	 * 
	 * @param comandos comandos a serem convertidos
	 * @return {@link List} de {@link Comando} 
	 */
	private List<Comando>  string2Comando(String comandos) {
		return Comando.parseString2Comando(comandos);
	}
	
	/**
	 * Convert as strings fornecidas em uma {@link Dimensao} 
	 * 
	 * @param dimensaoComprimento comprimento 
	 * @param dimensaoLargura largura
	 * @return {@link Dimensao}
	 */
	private Dimensao string2Dimensao(String dimensaoComprimento, String dimensaoLargura) {
		
		int comprimento = StringConvert.INSTANCE.convertFromString(int.class, dimensaoComprimento);
		int largura = StringConvert.INSTANCE.convertFromString(int.class, dimensaoLargura);

		return new Dimensao(comprimento, largura);
	}
	
	/**
	 * Obtem o {@link Matcher} com base nos paramentros informados
	 * 
	 * @param pattern {@link Pattern} 
	 * @param token texto a ser virificado se atendo o  {@link Pattern} 
	 * @return Retorna o {@link o Matcher} do token
	 * 
	 * @throws IllegalArgumentException Exececao sera disparada caso nao ocorra o {@link Matcher} 
	 *                                  do token.
	 */
	private Matcher getMatcher(Pattern pattern, String token) {

		final Matcher matcher = pattern.matcher(token);
		
		if (!matcher.matches()) {
			throw new IllegalArgumentException(String.format("Linha %s esta invalida", token));
		}
		
		return matcher;
	}
}
