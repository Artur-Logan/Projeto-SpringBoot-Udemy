package com.arturlogan.cursospringboot.entitites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descriçao;
    private Double preço;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "db_produto_categoria",
            joinColumns = @JoinColumn(name = "produtoId"),
    inverseJoinColumns = @JoinColumn(name = "categoriaId"))
    private Set<Categoria> categorias = new HashSet<>();

    public Produto(){
    }

    public Produto(Long id, String nome, String descriçao, Double preço, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descriçao = descriçao;
        this.preço = preço;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return getId().equals(produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
