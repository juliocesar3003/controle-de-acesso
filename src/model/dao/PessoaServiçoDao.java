package model.dao;

import java.util.List;


import model.entities.PessoaServiço;

public interface PessoaServiçoDao {
	void insert(PessoaServiço obj);
	void update(PessoaServiço obj);
	void deleteById(PessoaServiço obj);
	void EntradaId(PessoaServiço obj, Integer id);
	void SaidaId(PessoaServiço obj, Integer id);
	PessoaServiço FindById(Integer id);
	List<PessoaServiço> findAll();
	List<PessoaServiço> findBYbloco();
}
