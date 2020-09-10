package com.lucas.curso;

import java.text.SimpleDateFormat;
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
import com.lucas.curso.domain.ItemPedido;
import com.lucas.curso.domain.Pagamento;
import com.lucas.curso.domain.PagamentoComBoleto;
import com.lucas.curso.domain.PagamentoComCartao;
import com.lucas.curso.domain.Pedido;
import com.lucas.curso.domain.Produto;
import com.lucas.curso.domain.enums.EstadoPagamento;
import com.lucas.curso.domain.enums.TipoCliente;
import com.lucas.curso.repositories.CategoriaRepository;
import com.lucas.curso.repositories.CidadeRepository;
import com.lucas.curso.repositories.ClienteRepository;
import com.lucas.curso.repositories.EnderecoRepository;
import com.lucas.curso.repositories.EstadoRepository;
import com.lucas.curso.repositories.ItemPedidoRepository;
import com.lucas.curso.repositories.PagamentoRepository;
import com.lucas.curso.repositories.PedidoRepository;
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
	
	@Autowired
	private PagamentoRepository   pagamentorepository;
	
	@Autowired
	private PedidoRepository   pedidorepository;
	
	@Autowired
	private ItemPedidoRepository   itempedidorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");		
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Jardinagem");
		Categoria cat5 = new Categoria(null, "Eletronicos");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");


		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 2000.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
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
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2020  10:25"), cli1 , e1);
		
		Pedido ped2 = new Pedido(null, sdf.parse("15/10/2020  21:05"), cli1 , e2);
		
		Pagamento pgto1 = new PagamentoComCartao(null , EstadoPagamento.QUITADO, ped1, 6);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("15/10/2020  21:05"), null);
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p2, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));




		ped1.setPagamento(pgto1);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		produtorepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));


		categoriarepository.saveAll(Arrays.asList(cat1,cat2 , cat3 , cat4 , cat5 , cat6 ,cat7));
		
		
		estadorepository.saveAll(Arrays.asList(est1,est2));
		
		cidaderepository.saveAll(Arrays.asList(c1,c2,c3));
		
		clienterepository.saveAll(Arrays.asList(cli1)); 
		
		enderecorepository.saveAll(Arrays.asList(e1,e2)); 
		pedidorepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentorepository.saveAll(Arrays.asList(pgto1,pgto2));
		itempedidorepository.saveAll(Arrays.asList(ip1,ip2,ip3));

	}

}
