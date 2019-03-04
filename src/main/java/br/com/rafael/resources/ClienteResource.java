package br.com.rafael.resources;

import br.com.rafael.domain.Cliente;
import br.com.rafael.repositories.ClienteRepository;
import br.com.rafael.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    
    @Autowired
    ClienteService clienteService;
    
    //end point de cliente
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id)
    {
        Cliente cliente = clienteService.find(id);
        return ResponseEntity.ok(cliente);
    }
        
    
}
