package br.com.junior.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.junior.appmercado.model.Lista;
import br.com.junior.appmercado.model.itemlista;
import br.com.junior.appmercado.repo.ListaRepo;

@Component
public class ListaServiceImpl implements IListaService {

    @Autowired
    private ListaRepo repo;

    @Override
    public Lista criarNovaLista(Lista nova) {
        // TODO Auto-generated method stub
        nova.setId(null);
       return repo.save(nova);
    }

    @Override
    public void removerLista(Integer id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }

    @Override
    public Lista fecharLista(Integer id) {
        // TODO Auto-generated method stub
        Lista l = repo.findById(id).get();
        double total=0.0;
        for (itemlista item: l.getItens()) {
            total += l.getValorTotal();
        }
        l.setValorTotal(total);
        l.setStatus(1);
        return repo.save(l);
    }

    @Override
    public Lista buscarPeloId(Integer id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Lista> buscarTodas() {
        // TODO Auto-generated method stub
       return (List<Lista>) repo.findAll();
    }

    
}
