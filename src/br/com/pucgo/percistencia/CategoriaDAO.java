package br.com.pucgo.percistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.pucgo.entidade.Categoria;

public class CategoriaDAO {
	
	 private Conecxao conexaoDB = new Conecxao();
	 
	 public ArrayList<Categoria> consultarCategorias(){	
		 try {
				ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
				Connection conn = conexaoDB.abreConexao();				
				PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM categoria;");
				ResultSet resultSet = preparedStatement.executeQuery();			
				while ( resultSet.next() ) {				
					Categoria categoria = new Categoria();
					categoria.setId( resultSet.getInt("id") );
					categoria.setNome( resultSet.getString("nome") );
					
					listaCategorias.add(categoria);
				}			
				conn.close();
				
				return listaCategorias;
			} catch (Exception e) {
				
				System.out.println("Erro na consulta: " + e.getMessage());
				return null;
			}		 
	 }
	 
	 public Categoria consultarCategoriaId(int id) {
		 try {
			 	Categoria categoria = new Categoria();
				Connection conn = conexaoDB.abreConexao();				
				PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM categoria where id = " + id +";");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {				
					categoria.setId( resultSet.getInt("id") );
					categoria.setNome( resultSet.getString("nome") );
				}			
				conn.close();			
				return categoria;
			} catch (Exception e) {
				System.out.println("Erro na consulta: " + e.getMessage());
				return null;
			}	
	 }
	 
	 public boolean incluirCategoria(Categoria categoria) {
			try {
				Connection conn = conexaoDB.abreConexao();
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO categoria(nome) VALUES('" + categoria.getNome() + "');");
				conn.close();
				return true;
			} catch (Exception e) {
				System.out.println("Erro na inclusão: " + e.getMessage());
				return false;
			}
		}
	 
	 public boolean alterarCategoria(Categoria categoria) {
			try {
				Connection conn = conexaoDB.abreConexao();
				Statement statement = conn.createStatement();				
				if(statement.executeUpdate("UPDATE categoria SET nome='"+ categoria.getNome() +"' WHERE id = " + categoria.getId() + ";") != 0) {
					conn.close();
					return true;
				}
				conn.close();
				return false;
			} catch (Exception e) {
				System.out.println("Erro na alteração: " + e.getMessage());
				return false;
			}
		}
	 
	 public boolean excluirCategoria(int id) {
			try {
				Connection conn = conexaoDB.abreConexao();
				Statement statement = conn.createStatement();

				if(statement.executeUpdate("DELETE FROM categoria WHERE id = " + id + ";") != 0) {
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
