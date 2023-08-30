package model.dao;

import db.DB;
import model.dao.impl.PessoaDaoJDBC;


public class DaoFactory {

	public static PessoaDao createVendedorDao() {
		return new PessoaDaoJDBC(DB.getConnection());
	}
	public static PessoaServiçoDao createDepartamentoDao() {
		return new PessoaServiçoDaoJDBC(DB.getConnection());
	}
}
