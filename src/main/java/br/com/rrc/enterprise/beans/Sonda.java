package br.com.rrc.enterprise.beans;

public class Sonda {
	
	private static final String MSG_ERR0_DIRECAO_NAO_ENCONTRADA = "A direção %s informada não foi encontrada";
	
	private String id;
	private String nome;
	private Coordenada coordenada;
	private Direcao direcao;
	
	public Sonda(String nome, Coordenada coordenada, Direcao direcao) {
		super();
		this.nome = nome;
		this.coordenada = coordenada;
		this.direcao = direcao;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public void virarEsquerda() {
		
		if (direcao == null) {
			throw new IllegalArgumentException(String.format(MSG_ERR0_DIRECAO_NAO_ENCONTRADA, direcao));
		}

		direcao = direcao.virarEsqueda(direcao);
	}
	
	public void virarDireita() {
		
		if (direcao == null) {
			throw new IllegalArgumentException(String.format(MSG_ERR0_DIRECAO_NAO_ENCONTRADA, direcao));
		}
		direcao = direcao.virarDireita(direcao);
	}

	public void mover() {
		
		if (direcao == null) {
			throw new IllegalArgumentException(String.format(MSG_ERR0_DIRECAO_NAO_ENCONTRADA, direcao));
		}
		
		direcao.navegar(coordenada);
	}

	@Override
	public String toString() {
		return String.format("Sonda [id=%s, nome=%s, coordenada=%s, direcao=%s]", id, nome, coordenada, direcao);
	}
}
