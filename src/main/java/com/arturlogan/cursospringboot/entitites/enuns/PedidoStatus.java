package com.arturlogan.cursospringboot.entitites.enuns;

public enum PedidoStatus {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int codigo;

    private PedidoStatus (int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static PedidoStatus valueOf (int codigo){
        for (PedidoStatus pedidoStatus : PedidoStatus.values()){
            if (pedidoStatus.getCodigo() == codigo){
                return pedidoStatus;
            }
        }
        throw new IllegalArgumentException("Codigo inválido");
    }
}
