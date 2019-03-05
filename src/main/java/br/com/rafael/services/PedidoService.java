package br.com.rafael.services;

import br.com.rafael.domain.Pedido;
import br.com.rafael.repositories.PedidoRepository;
import br.com.rafael.services.services.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido find(Integer id)
    {
        Optional<Pedido> listCliente = pedidoRepository.findById(id);
        return listCliente.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado o cliente "+ id));
    }

    
}
