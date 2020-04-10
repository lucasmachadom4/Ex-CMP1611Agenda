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
		
		Agenda agenda = new Agenda();
		
		agenda.setNome("Melisandra Alq");		
		agenda.setCategoria(new Categoria(4));
		
		
		ArrayList<Telefone> listaTelefones = new ArrayList<Telefone>();		
		listaTelefones.add(new Telefone("(62) 0000-0009", new Tipo(3) ) );
		listaTelefones.add(new Telefone("(62) 9 5566-8009", new Tipo(2) ) );
		agenda.setTelefones(listaTelefones);
		
		agendaController.adicionarNaAgenda(agenda);
		
		agendaController.exibirAgenda();
	}

}
