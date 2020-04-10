package br.com.pucgo.controle;

import java.util.ArrayList;

import br.com.pucgo.entidade.Agenda;
import br.com.pucgo.negocio.AgendaService;

public class AgendaController {

	private AgendaService agendaService = new AgendaService();

	public void exibirAgenda() {
		try {
			ArrayList<Agenda> listaAgenda = new ArrayList<Agenda>();
			listaAgenda = agendaService.exibirAgenda();
			System.out
					.println(" | ID |        Nome        |   Categoria   |             Telefones e Tipo              |\n");
			for (int i = 0; i < listaAgenda.size(); i++) {
				System.out.print(" | ");
				System.out.print(listaAgenda.get(i).getId());
				System.out.print(" | ");
				System.out.print(listaAgenda.get(i).getNome());
				System.out.print(" | ");
				System.out.print(listaAgenda.get(i).getCategoria().getNome());
				System.out.print(" | ");
				for (int j = 0; j < listaAgenda.get(i).getTelefones().size(); j++) {
					System.out.print(listaAgenda.get(i).getTelefones().get(j).getNumero());
					System.out.print(" | ");
					System.out.print(listaAgenda.get(i).getTelefones().get(j).getTipo().getNome());
					System.out.print(" | ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Erro: Contato  não encotrado! " + e.getMessage());
		}
		
	}

	public void exibirContadoAgenda(int id) {
		try {
			Agenda contato = new Agenda();
			contato = agendaService.exibirContatoAgenda(id);			
			System.out
					.println(" | ID |        Nome        |   Categoria   |             Telefones e Tipo              |\n");

			System.out.print(" | ");
			System.out.print(contato.getId());
			System.out.print(" | ");
			System.out.print(contato.getNome());
			System.out.print(" | ");
			System.out.print(contato.getCategoria().getNome());
			System.out.print(" | ");
			for (int i = 0; i < contato.getTelefones().size(); i++) {
				System.out.print(contato.getTelefones().get(i).getNumero());
				System.out.print(" <> ");
				System.out.print(contato.getTelefones().get(i).getTipo().getNome());
				System.out.print(" | ");
			}
			System.out.println();

		} catch (Exception e) {
			System.out.println("Erro: Contato  não encotrado! " + e.getMessage());			
		}		
	}
	
	public void adicionarNaAgenda(Agenda agenda) {
		if(agendaService.adicionarNaAgenda(agenda)) {
			System.out.println("Contato salvo com sucesso!");
		}else {
			System.out.println("Contato não foi salvo");
		}
	}

}
