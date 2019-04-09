package br.com.db1.pedidos.pedidosapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.StatusTipoProduto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	List<Produto> findByCodigo(Produto codigo);
	
	List<Produto> findByStatus(StatusTipoProduto status);

	

}
