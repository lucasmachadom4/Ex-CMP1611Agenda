package br.com.pucgo.percistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.pucgo.entidade.Agenda;

public class AgendaDAO {

	private Conecxao conexaoDB = new Conecxao();

	public ArrayList<Agenda> consultarAgenda() {
		try {
			ArrayList<Agenda> listaAgendas = new ArrayList<Agenda>();
			Connection conn = conexaoDB.abreConexao();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM agenda;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Agenda agenda = new Agenda();
				agenda.setId(resultSet.getInt("id"));
				agenda.setNome(resultSet.getString("nome"));
				CategoriaDAO categoriaDAO = new CategoriaDAO();
				agenda.setCategoria(categoriaDAO.consultarCategoriaId(resultSet.getInt("categoria_id")));
				TelefoneDAO telefoneDAO = new TelefoneDAO();
				agenda.setTelefones(telefoneDAO.consultarTelefonesPorAgenda(agenda.getId()));

				listaAgendas.add(agenda);
			}
			conn.close();

			return listaAgendas;
		} catch (Exception e) {
			System.out.println("Erro na consulta: " + e.getMessage());
			return null;
		}
	}

	public Agenda consultarAgendaId(int id) {
		try {
			Agenda agenda = new Agenda();
			Connection conn = conexaoDB.abreConexao();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM agenda where id = " + id + ";");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				agenda.setId(resultSet.getInt("id"));
				agenda.setNome(resultSet.getString("nome"));
				CategoriaDAO categoriaDAO = new CategoriaDAO();
				agenda.setCategoria(categoriaDAO.consultarCategoriaId(resultSet.getInt("categoria_id")));
				TelefoneDAO telefoneDAO = new TelefoneDAO();
				agenda.setTelefones(telefoneDAO.consultarTelefonesPorAgenda(agenda.getId()));
			}
			conn.close();

			return agenda;
		} catch (Exception e) {
			System.out.println("Erro na consulta: " + e.getMessage());
			return null;
		}
	}
	
	private int incluirAgenda(Agenda agenda) {
		try {			
			Connection conn = conexaoDB.abreConexao();
			Statement statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO agenda(nome, categoria_id) VALUES('" + agenda.getNome() + "', "
					+ agenda.getCategoria().getId() + ");");
			
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT LAST_INSERT_ID();");
			ResultSet resultSet = preparedStatement.executeQuery();
			int id=0;
			while ( resultSet.next() ) {
				id = resultSet.getInt("LAST_INSERT_ID()");
			}
			
			conn.close();			
			return id;
		} catch (Exception e) {
			System.out.println("Erro ao incluir: " + e.getMessage());
			return 0;
		}
	}

	/**
		 *  TERminar inclusao esta dando errada, fazer alteração, e exclusao por ultimo testar
		 * @param agenda
		 * @return
		 */
	public boolean incluirAgendaTelefones(Agenda agenda) {
		try {
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			for(int i=0; i< agenda.getTelefones().size(); i++) {
				agenda.getTelefones().get(i).setId(  telefoneDAO.incluirTelefone( agenda.getTelefones().get(i) ) );
			}
			int agendaId;
			agendaId = incluirAgenda(agenda);
			
			
			for(int i=0; i< agenda.getTelefones().size(); i++) {

				Connection conn = conexaoDB.abreConexao();
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO agenda_telefones(agenda_id, telfone_id) VALUES(" + agendaId + ", "
						+ agenda.getTelefones().get(i).getId() + ");");
				conn.close();
			}						
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao incluir: " + e.getMessage());
			return false;
		}
	}
	
	public boolean alterarAgendaTelefones(Agenda agenda) {
		try {
			
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao alterar: " + e.getMessage());
			return false;
		}
	}
	
	public boolean excluirAgendaTelefones(Agenda agenda) {
		try {
			
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao incluir: " + e.getMessage());
			return false;
		}
	}
}
