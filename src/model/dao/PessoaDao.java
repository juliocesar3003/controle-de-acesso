package model.dao;

import java.util.List;

import model.entities.Pessoa;

public interface PessoaDao {

	void insert(Pessoa obj);
	void update(Pessoa obj);
	void deleteById(Pessoa obj);
	void EntradaId(Pessoa obj, Integer id);
	void SaidaId(Pessoa obj, Integer id);
	Pessoa FindById(Integer id);
	List<Pessoa> findAll();
	List<Pessoa> findBYbloco();
	
	
}
