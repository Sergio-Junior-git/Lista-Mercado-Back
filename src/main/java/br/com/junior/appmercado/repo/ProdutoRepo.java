package br.com.junior.appmercado.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.junior.appmercado.model.Produto;

public interface ProdutoRepo extends CrudRepository<Produto, Integer> {
    public List<Produto> findAllByNomeContaining(String palavraChave);
}
