package br.com.junior.appmercado.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lista")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlista")
    private Integer id;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate data;

    @Column(name = "nome_mercado", length = 45)
    private String nomeMercado;

    @Column(name = "valor_total", length = 70, nullable = false)
    private double valorTotal;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("lista")
    private List<itemlista> itens;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getNomeMercado() {
        return nomeMercado;
    }
    public void setNomeMercado(String nomeMercado) {
        this.nomeMercado = nomeMercado;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public List<itemlista> getItens() {
        return itens;
    }
    public void setItens(List<itemlista> itens) {
        this.itens = itens;
    }
  

}
