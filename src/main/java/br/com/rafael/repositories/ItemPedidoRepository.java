package br.com.rafael.repositories;

import br.com.rafael.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
}
