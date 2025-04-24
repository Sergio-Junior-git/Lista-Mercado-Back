package br.com.junior.appmercado.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.junior.appmercado.model.Lista;

public interface ListaRepo extends CrudRepository<Lista, Integer> {

}
