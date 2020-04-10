package br.com.pucgo.entidade;

public class Telefone {
	
	private int id;
	private String numero;
	private Tipo tipo;
	
	public Telefone() {
		
	}
	public Telefone(String numero, Tipo tipo) {		
		this.numero = numero;
		this.tipo = tipo;
	}

	public Telefone(int id, String numero, Tipo tipo) {
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	

}
