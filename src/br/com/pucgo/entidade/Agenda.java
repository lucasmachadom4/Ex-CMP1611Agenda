package br.com.pucgo.entidade;

import java.util.ArrayList;

public class Agenda {

	private int id;
	private String nome;
	private ArrayList<Telefone> telefones; 	
	private Categoria categoria;
	
	public Agenda() {		
	}

	public Agenda(int id, String nome, ArrayList<Telefone> telefones, Categoria categoria) {		
		this.id = id;
		this.nome = nome;
		this.telefones = telefones;
		this.categoria = categoria;
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

	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
