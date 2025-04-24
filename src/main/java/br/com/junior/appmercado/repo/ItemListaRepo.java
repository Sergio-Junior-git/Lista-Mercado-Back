package br.com.junior.appmercado.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.junior.appmercado.model.itemlista;

public interface ItemListaRepo extends CrudRepository<itemlista, Integer> {
    
}
