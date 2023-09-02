package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.PessoaServiçoDao;
import model.entities.PessoaServiço;
import model.entities.Enum.TipoDataServiço;


public class PessoaServiçoDaoJDBC implements PessoaServiçoDao{

	private Connection connect;
	
	public PessoaServiçoDaoJDBC(Connection connect) {
		this.connect = connect;
	}
	
	private PessoaServiço instaciarPessoaServ(ResultSet rs) throws SQLException{
		PessoaServiço obj = new PessoaServiço();
		
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Nome"));
		obj.setCpf(rs.getInt("Cpf"));
		obj.setNapartament(rs.getInt("Apartamento"));
		obj.setNblock(rs.getString("bloco"));
		obj.setHoraEntrada(rs.getTimestamp("HoraEntrada").toLocalDateTime());
		obj.setHoraSaida(rs.getTimestamp("HoraSaida").toLocalDateTime());
		obj.setNomeEmpresa(rs.getString("NomeEmpresa"));
		obj.setNomeContratante(rs.getString("NomeContratante"));
		obj.setTipoTrabalho(rs.getString("TipoTrabalho"));
		obj.setEstado(rs.getBoolean("Estado"));
		obj.setDataServiço(TipoDataServiço.valueOf(rs.getString("TipoDataServiço")));
		
		return obj;
		
	}
	
	
	
	@Override
	public void insert(PessoaServiço obj) {
		
		PreparedStatement st = null;
		
		try {
			st = connect.prepareStatement(
					"INSERT INTO pessoaServiço "
					+"(Nome, Cpf, Apartamento, bloco, HoraEntrada, HoraSaida, NomeEmpresa,TipoTrabalho,TipoDataServiço) "
					+"VALUES "
					+"(?, ?, ?, ?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getCpf());
			st.setInt(3, obj.getNapartament());
			st.setString(4,obj.getNblock());
			st.setTimestamp(5, Timestamp.valueOf(obj.getHoraEntrada()));
			st.setTimestamp(5, Timestamp.valueOf(obj.getHoraSaida()));
			st.setString(7, obj.getNomeEmpresa());
			st.setString(7, obj.getTipoTrabalho());
			st.setString(8, obj.getTipoTrabalho()); 
			st.setString(0, obj.getDataServiço().toString());
		    
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
	public void update(PessoaServiço obj) {
		
		PreparedStatement st = null;
		
		try {
			st = connect.prepareStatement(
					"UPDATE pessoaServiço "
					+"SET Nome = ?, Cpf = ?, Apartamento = ?, bloco = ?, HoraEntrada = ?, "
					+ "HoraSaida = ?, NomeEmpresa = ?, TipoTrabalho = ?, TipoDataServiço = ? "
					+"WHERE Id = ?");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getCpf());
			st.setInt(3, obj.getNapartament());
			st.setString(4,obj.getNblock());
			st.setTimestamp(5, Timestamp.valueOf(obj.getHoraEntrada()));
			st.setTimestamp(5, Timestamp.valueOf(obj.getHoraSaida()));
			st.setString(7, obj.getNomeEmpresa());
			st.setString(7, obj.getTipoTrabalho());
			st.setString(8, obj.getTipoTrabalho()); 
			st.setString(0, obj.getDataServiço().toString());	
			
		    
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
	public void deleteById(PessoaServiço obj) {
		PreparedStatement st = null;
		
		try {
			st = connect.prepareStatement("DELETE FROM pessoaServiço WHERE Id = ?");
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
	public void EntradaId(PessoaServiço obj, Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		
	 try {
		 	st = connect.prepareStatement( "UPDATE pessoaServiço Set Estado = ? WHERE Id = ?");
				
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
	public void SaidaId(PessoaServiço obj, Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		
	 try {
		 	st = connect.prepareStatement( "UPDATE pessoaServiço Set Estado = ? WHERE Id = ?");
				
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
	public PessoaServiço FindById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
	 try {
		 	st = connect.prepareStatement( "SELECT * FROM pessoaServiço WHERE Id = ?");
				
		 	st.setInt(1, id);
			
		 	rs = st.executeQuery();
			
		 	if(rs.next()) {
	
		    PessoaServiço obj = instaciarPessoaServ(rs);
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
	public List<PessoaServiço> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			
			st = connect.prepareStatement(
					
					"SELECT PessoaServiço.Name as ServName "
				    +"FROM morador ");
					
					rs = st.executeQuery();
		 
					List<PessoaServiço> lista = new ArrayList<PessoaServiço>();
										
					while (rs.next()) {
				
						PessoaServiço obj = instaciarPessoaServ(rs);
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
	public List<PessoaServiço> findBYbloco() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			
			st = connect.prepareStatement(
					
					"SELECT pessoaServiço.bloco as psServBloco "
				    +"FROM morador ");
					
					rs = st.executeQuery();
		 
					List<PessoaServiço> lista = new ArrayList<PessoaServiço>();
										
					while (rs.next()) {
				
						PessoaServiço obj = instaciarPessoaServ(rs);
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
