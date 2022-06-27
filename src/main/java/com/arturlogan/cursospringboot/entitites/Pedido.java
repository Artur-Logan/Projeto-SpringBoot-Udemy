package com.arturlogan.cursospringboot.entitites;

import com.arturlogan.cursospringboot.entitites.enuns.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.type.SetType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer pedidoStatus;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Usuario cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoItem> itens = new HashSet<>();

    private Pedido(){
    }

    public Pedido(Long id, Instant momento, PedidoStatus pedidoStatus, Usuario cliente) {
        this.id = id;
        this.momento = momento;
        setPedidoStatus(pedidoStatus);
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public PedidoStatus getPedidoStatus() {
        return PedidoStatus.valueOf(pedidoStatus);
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        if (pedidoStatus != null){
            this.pedidoStatus = pedidoStatus.getCodigo();
        }
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<PedidoItem> getItens(){
        return itens;
    }

    public Double getTotal(){
        double soma = 0.0;
        for (PedidoItem  pedidoItem : itens){
            soma = soma + pedidoItem.getSubTotal();
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return getId().equals(pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
