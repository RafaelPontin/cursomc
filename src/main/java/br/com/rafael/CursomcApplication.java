package br.com.rafael;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rafael.domain.Categoria;
import br.com.rafael.domain.Cidade;
import br.com.rafael.domain.Cliente;
import br.com.rafael.domain.Endereco;
import br.com.rafael.domain.Estado;
import br.com.rafael.domain.Produto;
import br.com.rafael.domain.enuns.TipoCliente;
import br.com.rafael.repositories.CategoriaRepository;
import br.com.rafael.repositories.CidadeRepository;
import br.com.rafael.repositories.ClienteRepository;
import br.com.rafael.repositories.EnderecoRepository;
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
        @Autowired
        private EnderecoRepository enderecoRepository;
        @Autowired
        private ClienteRepository clienteRepository;
        
        
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
                c3.setEstado(e1);
                
                e1.getCidades().addAll(Arrays.asList(c1));
                e2.getCidades().addAll(Arrays.asList(c2,c3));
                
                estadoRepository.saveAll(Arrays.asList(e1,e2));
                cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
                
                Cliente cliente = new Cliente(null, "Rafael", "rfmpontin@gmail.com", "123123123", TipoCliente.PESSOAFISICA);
                
                cliente.getTelefones().addAll(Arrays.asList("4652111231","12312312"));
                
                Endereco end1 = new Endereco(null, "Jose zaniratto", "819", "", "santa candida", "171200000", cliente, c3);
                Endereco end2 = new Endereco(null, "Jose zaniratto", "819", "", "santa candida", "171200000", cliente, c1);
                
                cliente.getEnderecos().addAll(Arrays.asList(end1,end2));
                
                clienteRepository.save(cliente);
                enderecoRepository.saveAll(Arrays.asList(end1,end2));
                
	}

}
