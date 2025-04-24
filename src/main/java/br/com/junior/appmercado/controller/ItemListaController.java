package br.com.junior.appmercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.junior.appmercado.model.itemlista;
import br.com.junior.appmercado.service.IItemListaService;

@RestController
@CrossOrigin("*")
public class ItemListaController {


    @Autowired
    private IItemListaService service;

    @PostMapping("/itemlista")
    public ResponseEntity<itemlista> inserir(@RequestBody itemlista novo){
        itemlista res = service.inserirItem(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/itemlista/{numSeq}")
    public ResponseEntity<itemlista> alterar(@RequestBody itemlista item, @PathVariable Integer numSeq) {
        item.setNumSeq(numSeq);
        itemlista res = service.alterarItem(item);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/itemlista/[numSeq]")
    public ResponseEntity<?> apagar(@PathVariable Integer numSeq){
        service.removerItem(numSeq);
        return ResponseEntity.ok("ok");
    }
    

}
