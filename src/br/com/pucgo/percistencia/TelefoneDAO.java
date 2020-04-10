package br.com.pucgo.percistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.pucgo.entidade.Telefone;

public class TelefoneDAO {

	private Conecxao conexaoDB = new Conecxao();	

	private Telefone consultarTelefonesId(int id) {
		try {
			Telefone telefone = new Telefone();
			Connection conn = conexaoDB.abreConexao();
			PreparedStatement preparedStatement = conn
					.prepareStatement("SELECT * FROM telefone where id = " + id + ";");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				telefone.setId(resultSet.getInt("id"));
				telefone.setNumero(resultSet.getString("numero"));

				TipoDAO tipoDAO = new TipoDAO();
				telefone.setTipo( tipoDAO.consultarTiposId( resultSet.getInt("tipo_id") ) );
			}
			conn.close();
			return telefone;
		} catch (Exception e) {
			System.out.println("Erro na consulta: " + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Telefone> consultarTelefonesPorAgenda(int AgendaId) {
		try {
			ArrayList<Telefone> listaTelefones = new ArrayList<Telefone>();
			Connection conn = conexaoDB.abreConexao();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM agenda_telefones WHERE agenda_id ="+ AgendaId +";");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Telefone telefone = new Telefone();
				telefone = consultarTelefonesId( resultSet.getInt("id") ) ;	
				
				listaTelefones.add(telefone);
			}
			conn.close();

			return listaTelefones;
		} catch (Exception e) {
			System.out.println("Erro na consulta: " + e.getMessage());
			return null;
		}
	}	

	public int incluirTelefone(Telefone telefone) {
		try {
			Connection conn = conexaoDB.abreConexao();
			Statement statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO telefone(numero, tipo_id) VALUES('" + telefone.getNumero() + "', "
					+ telefone.getTipo().getId() + ");");

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
	
	public boolean alterarTelefone(Telefone telefone) {
		try {
			Connection conn = conexaoDB.abreConexao();
			Statement statement = conn.createStatement();
			if(statement.executeUpdate("UPDATE telefone SET numero='"+ telefone.getNumero() +"', tipo_id="+ telefone.getTipo().getId() +" WHERE id = " + telefone.getId() + ";") != 0) {
				conn.close();
				return true;
			}
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro na alteração: " + e.getMessage());
			return false;
		}
	}
	
	public boolean excluirTelefone(int id) {
		try {
			Connection conn = conexaoDB.abreConexao();
			Statement statement = conn.createStatement();
			if(statement.executeUpdate("DELETE FROM telefone WHERE id = " + id + ";") != 0) {
				conn.close();
				return true;
			}			
			conn.close();
			return false;
		} catch (Exception e) {
			System.out.println("Erro na Exclusão: " + e.getMessage());
			return false;
		}
	}
}
