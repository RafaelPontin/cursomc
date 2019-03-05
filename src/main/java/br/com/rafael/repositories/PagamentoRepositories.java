package br.com.rafael.repositories;

import br.com.rafael.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepositories extends JpaRepository<Pagamento, Integer>{
    
}
