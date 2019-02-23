package br.com.rafael;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rafael.domain.Categoria;
import br.com.rafael.domain.Cidade;
import br.com.rafael.domain.Estado;
import br.com.rafael.domain.Produto;
import br.com.rafael.repositories.CategoriaRepository;
import br.com.rafael.repositories.CidadeRepository;
import br.com.rafael.repositories.EstadoRepository;
import br.com.rafael.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
        private CidadeRepository cidadeRepository;
        @Autowired
        private EstadoRepository estadoRepository;
        
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 8000.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
                
                Estado e1 = new Estado(null, "Minas gerais");
                Estado e2 = new Estado(null, "São paulo");
                
                Cidade c1 = new Cidade(null, "Uberlandia");
                c1.setEstado(e1);
                Cidade c2 = new Cidade(null, "São Paulo");
                c2.setEstado(e2);
                Cidade c3 = new Cidade(null, "Agudos");
                c2.setEstado(e1);
                
                e1.getCidades().addAll(Arrays.asList(c1));
                e2.getCidades().addAll(Arrays.asList(c2,c3));
                
                estadoRepository.saveAll(Arrays.asList(e1,e2));
                cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}
