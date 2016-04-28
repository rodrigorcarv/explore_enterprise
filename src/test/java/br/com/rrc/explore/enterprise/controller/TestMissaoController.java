package br.com.rrc.explore.enterprise.controller;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import br.com.rrc.explore.enterprise.ExploreEnterpriseApplication;
import br.com.rrc.explore.enterprise.beans.Coordenada;
import br.com.rrc.explore.enterprise.beans.Dimensao;
import br.com.rrc.explore.enterprise.beans.Explorador;
import br.com.rrc.explore.enterprise.beans.Mapa;
import br.com.rrc.explore.enterprise.beans.Sonda;
import br.com.rrc.explore.enterprise.beans.enums.Comando;
import br.com.rrc.explore.enterprise.beans.enums.Direcao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExploreEnterpriseApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class TestMissaoController {

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}	

	@Test
	public void exploraPlanatoTest() throws IOException {

		String coodenadas = 
				"5 5 \n"
						+ "1 2 N \n "
						+ "LMLMLMLMM \n"
						+ "3 3 E \n"
						+ "MMRMMRMRRM";
		given().
			contentType(ContentType.TEXT).
			body(coodenadas).
		when().
			post("/missao/explorar-planalto").
		then().
			statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void exploraTest() throws IOException {

		int comprimento = 5;
		int largura = 5;
		
		Mapa mapa = new Mapa();
		Dimensao dimensao = new Dimensao(comprimento, largura);
		mapa.setDimensao(dimensao);
		
		Explorador phoenix = exploradoraPhoenix();
		Explorador obiter = exploradoraObiter();
		
		List<Explorador> exploradores = new ArrayList<>();
		exploradores.add(phoenix);
		exploradores.add(obiter);
		
		mapa.setExploradores(exploradores);
		
		String json = objectToJson(mapa);
		
		System.out.println(json);

		given().
			contentType(ContentType.JSON).
			body(json).
		when().
			post("/missao/exploracao-detalhada").
		then().
			statusCode(HttpStatus.SC_OK);

	}
	
	@Test
	public void exploraTestDimensoesInvalidas() throws IOException {

		int comprimento = -1;
		int largura = 5;
		
		Mapa mapa = new Mapa();
		Dimensao dimensao = new Dimensao(comprimento, largura);
		mapa.setDimensao(dimensao);
		
		Explorador phoenix = exploradoraPhoenix();
		Explorador obiter = exploradoraObiter();
		
		List<Explorador> exploradores = new ArrayList<>();
		exploradores.add(phoenix);
		exploradores.add(obiter);
		
		mapa.setExploradores(exploradores);
		
		String json = objectToJson(mapa);

		given().
			contentType(ContentType.JSON).
			body(json).
		when().
			post("/missao/exploracao-detalhada").
		then().
			statusCode(HttpStatus.SC_BAD_REQUEST);

	}

	
	private Explorador exploradoraPhoenix() {

		Coordenada coordenada = new Coordenada(1, 2);
		Sonda sonda = new Sonda(coordenada , Direcao.NORTE);
		sonda.setNome("Phoenix");

		List<Comando> comandos = new ArrayList<Comando>();
		
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		
		return new Explorador(sonda, comandos);
		
	}
	
	private Explorador exploradoraObiter() {
		
		Coordenada coordenada = new Coordenada(3, 3);
		Sonda sonda = new Sonda(coordenada , Direcao.LESTE);
		sonda.setNome("Obiter");

		List<Comando> comandos = new ArrayList<Comando>();

		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.MOVER);
		
		return new Explorador(sonda, comandos);
	}
	
	 /**
     * Converte o JSON na Classe informada
     *
     * @param json JSON recebido
     * @param retorno  Classe a ser retornada
     *
     * @return Retorna a classe informada no retorno populada com os dados do JSON.
     */
    private <T> T jsonToObject(String json, Class retorno){

        Gson gson = new Gson();
        return (T) gson.fromJson(json, retorno);
    }
    
    /**
     * Converte um Object e um JSON
     *
     * @param object recebido
     * @param retorno  Classe a ser retornada
     *
     * @return Retorna a classe informada no retorno populada com os dados do JSON.
     */
    private String objectToJson(Object object){

        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
