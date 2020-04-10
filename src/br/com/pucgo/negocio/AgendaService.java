package br.com.pucgo.negocio;

import java.util.ArrayList;

import br.com.pucgo.entidade.Agenda;
import br.com.pucgo.percistencia.AgendaDAO;

public class AgendaService {
	
	private AgendaDAO agendaDAO = new AgendaDAO();
	
	public ArrayList<Agenda> exibirAgenda() {
		return agendaDAO.consultarAgenda();
	}
	
	public Agenda exibirContatoAgenda(int id) {
		return agendaDAO.consultarAgendaId(id);
	}
	
	public boolean adicionarNaAgenda(Agenda agenda) {
		//faz de conta que tem validação
		return agendaDAO.IncluirAgendaTelefones(agenda);
	}
	
}
