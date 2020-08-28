package com.lucas.curso;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.curso.domain.Categoria;
import com.lucas.curso.domain.Cidade;
import com.lucas.curso.domain.Cliente;
import com.lucas.curso.domain.Endereco;
import com.lucas.curso.domain.Estado;
import com.lucas.curso.domain.Produto;
import com.lucas.curso.domain.enums.TipoCliente;
import com.lucas.curso.repositories.CategoriaRepository;
import com.lucas.curso.repositories.CidadeRepository;
import com.lucas.curso.repositories.ClienteRepository;
import com.lucas.curso.repositories.EnderecoRepository;
import com.lucas.curso.repositories.EstadoRepository;
import com.lucas.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository  categoriarepository;
	
	@Autowired
	private ProdutoRepository  produtorepository;

	@Autowired
	private EstadoRepository   estadorepository;
	
	@Autowired
	private CidadeRepository   cidaderepository;
	
	@Autowired
	private ClienteRepository   clienterepository;
	
	@Autowired
	private EnderecoRepository   enderecorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 2000.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais"); 
		Estado est2 = new Estado(null, "São Paulo "); 
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "SP", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		Cliente cli1 = new Cliente(null, "João Victor", "joao2011@gmail.com", "0055778833", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("33278414","35887414")); 
		
		Endereco e1 = new Endereco(null, "Rua joaquin vieira", "120", "Apartamento", "ibiratinga", "718537", cli1, c2) ; 
		
		Endereco e2 = new Endereco(null, "Avenida das Palmeiras", "35", "Galpão", "Campo Grande", "335571", cli1, c1) ; 

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));



		categoriarepository.saveAll(Arrays.asList(cat1,cat2));
		
		produtorepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadorepository.saveAll(Arrays.asList(est1,est2));
		
		cidaderepository.saveAll(Arrays.asList(c1,c2,c3));
		
		clienterepository.saveAll(Arrays.asList(cli1)); 
		
		enderecorepository.saveAll(Arrays.asList(e1,e2)); 

	}

}
