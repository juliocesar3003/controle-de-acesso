package model.dao;

import java.util.List;

import model.entities.Pessoa;

public interface PessoaDao {

	void insert(Pessoa obj);
	void update(Pessoa obj);
	void deleteById(Pessoa obj);
	Pessoa FindById(Integer id);
	List<Pessoa> findAll();
	List<Pessoa> findBYbloco();
}
