package br.com.rafael.repositories;

import br.com.rafael.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
}
