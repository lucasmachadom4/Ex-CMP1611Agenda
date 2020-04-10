package br.com.pucgo.entidade;

public class Tipo {

	private int id;
	private String nome;
	
	public Tipo() {
		
	}
	
	public Tipo(int id) {		
		this.id = id;	
	}
	
	public Tipo(int id, String nome) {		
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
