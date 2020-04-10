package br.com.pucgo.view;

import java.util.ArrayList;

import br.com.pucgo.controle.AgendaController;
import br.com.pucgo.entidade.Agenda;
import br.com.pucgo.entidade.Categoria;
import br.com.pucgo.entidade.Telefone;
import br.com.pucgo.entidade.Tipo;

public class Main {

	public static void main(String[] args) {		
		AgendaController agendaController = new AgendaController();
		////
		Agenda agenda = new Agenda();		
		agenda.setNome("Altair Flior");		
		agenda.setCategoria(new Categoria(4));		
		
		ArrayList<Telefone> listaTelefones1 = new ArrayList<Telefone>();		
		listaTelefones1.add(new Telefone("(62) 0000-0009", new Tipo(3) ) );
		listaTelefones1.add(new Telefone("(62) 9 5566-8009", new Tipo(2) ) );
		listaTelefones1.add(new Telefone("(62) 9 5566-8009", new Tipo(1) ) );
		agenda.setTelefones(listaTelefones1);
		
		agendaController.adicionarNaAgenda(agenda);		
		/////
		Agenda agenda2 = new Agenda();
		agenda2.setNome("Melisandra Alq");		
		agenda2.setCategoria(new Categoria(4));		
		
		ArrayList<Telefone> listaTelefones2 = new ArrayList<Telefone>();		
		listaTelefones2.add(new Telefone("(62) 0000-0009", new Tipo(3) ) );
		listaTelefones2.add(new Telefone("(62) 9 5566-8009", new Tipo(2) ) );
		agenda2.setTelefones(listaTelefones2);
		
		agendaController.adicionarNaAgenda(agenda2);
		/////		
		agendaController.exibirAgenda();
	}

}
