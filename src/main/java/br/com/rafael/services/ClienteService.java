package br.com.rafael.services;

import br.com.rafael.domain.Cliente;
import br.com.rafael.repositories.ClienteRepository;
import br.com.rafael.services.services.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente find(Integer id)
    {
        Optional<Cliente> listCliente = clienteRepository.findById(id);
        return listCliente.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado o cliente "+ id));
    }
    
}
