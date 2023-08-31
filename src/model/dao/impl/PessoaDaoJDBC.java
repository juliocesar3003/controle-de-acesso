package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.PessoaDao;
import model.entities.Pessoa;


public class PessoaDaoJDBC implements PessoaDao{

	private Connection connect;
	
	
	
	public PessoaDaoJDBC(Connection connect) {
		this.connect = connect;
	}
	
	private Pessoa instaciarPessoa(ResultSet rs) throws SQLException{
		Pessoa obj = new Pessoa();
		
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Nome"));
		obj.setCpf(rs.getInt("Cpf"));
		obj.setNapartament(rs.getInt("Apartamento"));
		obj.setNblock(rs.getString("bloco"));
		
		return obj;
		
	}
	
	
	@Override
	public void insert(Pessoa obj) {
		PreparedStatement st = null;
		try {
			st = connect.prepareStatement(
					"INSERT INTO morador "
					+"(Nome, Cpf, Apartamento, bloco) "
					+"VALUES "
					+"(?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getCpf());
			st.setInt(3, obj.getNapartament());
			st.setString(4,obj.getNblock());
			
		    
		    int rowsAffected = st.executeUpdate();
		    
		    if (rowsAffected > 0) {
		    	ResultSet rs = st.getGeneratedKeys();
		    	
		    	if(rs.next()) {
		    		int id = rs.getInt(1);
		    		obj.setId(id);
		    	}
		    	DB.closeResultSet(rs);
		    }
		    else {
		    	throw new DbException("erro inesperado nenhuma linha foi afetada");
		    }
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Pessoa obj) {
		PreparedStatement st = null;
		try {
			st = connect.prepareStatement(
					"UPDATE morador "
					+"SET Nome = ?, Cpf = ?, Apartamento = ?, bloco = ? "
					+"WHERE Id = ?");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getCpf());
			st.setInt(3, obj.getNapartament());
			st.setString(4,obj.getNblock());
			
		    
		    st.executeUpdate();
		   
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Pessoa obj) {
		PreparedStatement st = null;
		
		try {
			st = connect.prepareStatement("DELETE FROM morador WHERE Id = ?");
			st.setInt(1, obj.getId());
			
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}
	
	@Override
	public void EntradaId(Pessoa obj, Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		
	 try {
		 	st = connect.prepareStatement( "UPDATE morador Set Estado = ? WHERE Id = ?");
				
		 	st.setBoolean(1,true);
			st.setInt(2,id);
		 	st.executeUpdate();
			
		
			
		
		
	}
	 
	 catch(SQLException e) {
		throw new DbException(e.getMessage());
	}
	
	 finally {
		DB.closeStatement(st);
		DB.closeResultSet(rs);
	 	}
		
	}
	
	@Override
	public void SaidaId(Pessoa obj, Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		
	 try {
		 	st = connect.prepareStatement( "UPDATE morador Set Estado = ? WHERE Id = ?");
				
		 	st.setBoolean(1,false);
			st.setInt(2,id);
		 	st.executeUpdate();
			
		
			
		
		
	}
	 
	 catch(SQLException e) {
		throw new DbException(e.getMessage());
	}
	
	 finally {
		DB.closeStatement(st);
		DB.closeResultSet(rs);
	 	}
		
	}
	
	@Override
	public Pessoa FindById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
	 try {
		 	st = connect.prepareStatement( "SELECT * FROM morador WHERE Id = ?");
				
		 	st.setInt(1, id);
			
		 	rs = st.executeQuery();
			
		 	if(rs.next()) {
	
			Pessoa obj = new Pessoa();
			obj.setId(rs.getInt("Id"));
			obj.setName(rs.getString("Nome"));
			return obj;
		}
		return null;
	}
	 
	 catch(SQLException e) {
		throw new DbException(e.getMessage());
	}
	
	 finally {
		DB.closeStatement(st);
		DB.closeResultSet(rs);
	 	}
		
	}

	@Override
	public List<Pessoa> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			
			st = connect.prepareStatement(
					
					"SELECT morador.Name as moradName "
				    +"FROM morador ");
					
					rs = st.executeQuery();
		 
					List<Pessoa> lista = new ArrayList<Pessoa>();
										
					while (rs.next()) {
				
						Pessoa obj = new Pessoa();
						obj.setId(rs.getInt("Id"));
						obj.setName(rs.getString("Name"));
						lista.add(obj);
				
				
				
			}
			return lista;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Pessoa> findBYbloco() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			
			st = connect.prepareStatement(
					
					"SELECT morador.bloco as mdsBloco "
				    +"FROM morador ");
					
					rs = st.executeQuery();
		 
					List<Pessoa> lista = new ArrayList<Pessoa>();
										
					while (rs.next()) {
				
						Pessoa obj = new Pessoa();
						obj.setId(rs.getInt("Id"));
						obj.setName(rs.getString("Nome"));
						obj.setNblock(rs.getNString("bloco"));
						lista.add(obj);
				
				
				
			}
			return lista;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	
		
	
	
	

	
	

}
