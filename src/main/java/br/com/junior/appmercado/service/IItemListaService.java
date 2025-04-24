package br.com.junior.appmercado.service;

import br.com.junior.appmercado.model.itemlista;

public interface IItemListaService {
    public itemlista inserirItem(itemlista novo);
    public itemlista alterarItem(itemlista item);
    public void      removerItem(Integer numSeq);
}
