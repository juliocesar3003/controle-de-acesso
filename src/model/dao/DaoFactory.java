package model.dao;

import db.DB;
import model.dao.impl.PessoaDaoJDBC;
import model.dao.impl.PessoaServiçoDaoJDBC;


public class DaoFactory {

	public static PessoaDao createVendedorDao() {
		return new PessoaDaoJDBC(DB.getConnection());
	}
	public static PessoaServiçoDao createDepartamentoDao() {
		return new PessoaServiçoDaoJDBC(DB.getConnection());
	}
}
