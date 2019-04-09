package br.com.db1.pedidos.pedidosapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Validador;

@Entity
@Table(name = "pedido_item")
public class ProdutoDoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;

	@Column(name = "quantidade", nullable = false, precision = 16, scale = 3)
	private Double quantidade;

	@Column(name = "valor_unitario", nullable = false, precision = 16, scale = 3)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;

	
	public ProdutoDoPedido(Pedido pedido,Produto produto2, Double quantidade) {

		Validador.naoPodeSerNulo(produto2, "produto");
		Validador.naoPodeSerNulo(quantidade, "quantidade");
		Validador.valorDeveSerMaiorQueZero(quantidade, "quantidade");

		this.produto = produto2;
		this.quantidade = quantidade;
	
	}

	public Produto getProduto() {
		return this.produto;
	}

	public Double getQuantidade() {
		return this.quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public Double getValorTotal() {
		return this.quantidade * this.valor;
	}

}
