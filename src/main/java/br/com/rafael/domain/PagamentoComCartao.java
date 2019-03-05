package br.com.rafael.domain;

import br.com.rafael.domain.enuns.EstadoPagamento;
import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{
    
    private static final long serialVersionUID = 1L;
    private Integer numeroParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer numeroParcelas, Integer id, EstadoPagamento estado, Pedido pedido) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
    
    
}
