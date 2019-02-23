package br.com.rafael.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.domain.Categoria;
import br.com.rafael.repositories.CategoriaRepository;
import br.com.rafael.services.services.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) 
	{
		Optional<Categoria> listCategoria = categoriaRepository.findById(id);
		return listCategoria.orElseThrow(() -> new ObjectNotFoundException("Categoria "+ id + " não encontrada."));
	}
	
	
	
}