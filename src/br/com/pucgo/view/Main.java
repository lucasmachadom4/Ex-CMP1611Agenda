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
		
		agenda.setNome("Matheus Machado");		
		agenda.setCategoria(new Categoria(1));
		
		
		ArrayList<Telefone> listaTelefones = new ArrayList<Telefone>();		
		listaTelefones.add(new Telefone("(62) 2253-6659", new Tipo(1) ) );
		listaTelefones.add(new Telefone("(62) 9 9666-8956", new Tipo(3) ) );
		agenda.setTelefones(listaTelefones);
		
		agendaController.adicionarNaAgenda(agenda);
		
		agendaController.exibirAgenda();
	}

}
