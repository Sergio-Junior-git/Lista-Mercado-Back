package br.com.junior.appmercado.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.junior.appmercado.model.Produto;
import br.com.junior.appmercado.repo.ProdutoRepo;
import br.com.junior.appmercado.service.ProdutoServiceImpl;


@SpringBootTest
public class ProdutoTests {

        @InjectMocks
        private ProdutoServiceImpl service;

        @Mock
        private ProdutoRepo repo;

        private Integer existingId = 1;
        private Integer nonExistingId = 100;
        private String keyword = "bolacha";
        private Produto newProduct;
        private Produto createProduct;
        private ArrayList<Produto> listaDeVariosProdutos;

        @BeforeEach
        public void setup() throws Exception{
                newProduct = new Produto();
                newProduct.setNome("Bolacha");

                createProduct = new Produto();
                createProduct.setId(1);
                createProduct.setNome("Bolacha");

                listaDeVariosProdutos = new ArrayList<Produto>();
                Produto p1, p2;
                p1 = new Produto();
                p1.setId(2);
                p1.setNome("Bolacha recheada");
                p2 = new Produto();
                p2.setId(3);
                p2.setNome("Bolacha agua e sal");
                listaDeVariosProdutos.add(p1);
                listaDeVariosProdutos.add(p2);

                Mockito.when(repo.save(newProduct)).thenReturn(createProduct);
                Mockito.when(repo.findById(existingId)).thenReturn(Optional.of(new Produto()));
                Mockito.when(repo.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
                Mockito.when(repo.findAllByNomeContaining("Biscoito")).thenReturn(new ArrayList<Produto>());
                Mockito.when(repo.findAllByNomeContaining(keyword)).thenReturn(listaDeVariosProdutos);
        }

        @Test
        public void deveriaCadastrarProduto(){
               assertEquals(service.criarNovoProduto(newProduct), createProduct); 
        }

        @Test
        public void deveriaRetornarPeloId() {
                assertNotNull(service.buscarPorId(existingId));
        }

        @Test
        public void deveriaNaoEncontrarId(){
                assertNull(service.buscarPorId(nonExistingId));
        }

        @Test
        public void deveriaRetornarListaComPalavraChave(){
                assertTrue(service.buscarPorPalavraChave(keyword).size() > 0);
        }

        @Test
        public void deveriaRetornarListaVazia(){
                assertTrue(service.buscarPorPalavraChave("Biscoito").size() == 0);
        }

}
