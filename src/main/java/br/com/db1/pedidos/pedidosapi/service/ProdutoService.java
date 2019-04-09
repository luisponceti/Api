package br.com.db1.pedidos.pedidosapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.StatusTipoProduto;
import br.com.db1.pedidos.pedidosapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> getAllActive() {
		return this.getByStatus(StatusTipoProduto.ATIVO);
	}

	public List<ProdutoDTO> getAllInactive() {

		return this.getByStatus(StatusTipoProduto.INATIVO);
	}

	public List<ProdutoDTO> getByStatus(StatusTipoProduto status) {
		List<Produto> produtoDatabase = produtoRepository.findByStatus(status);
		Iterator<Produto> iterator = produtoDatabase.iterator();

		List<ProdutoDTO> produto = new ArrayList<>();

		while (iterator.hasNext()) {
			Produto next = iterator.next();
			ProdutoDTO ProdutoDTO = this.produtoToDto(next);
			produto.add(ProdutoDTO);
		}
		return produto;
	}

	public List<ProdutoDTO> getByCodigo(Produto codigo) {
		List<Produto> produtoDatabase = produtoRepository.findByCodigo(codigo);
		Iterator<Produto> iterator = produtoDatabase.iterator();

		List<ProdutoDTO> produto = new ArrayList<>();

		while (iterator.hasNext()) {
			Produto next = iterator.next();
			ProdutoDTO ProdutoDTO = this.produtoToDto(next);
			produto.add(ProdutoDTO);
		}
		return produto;
	}
	
	
	public ProdutoDTO save(ProdutoDTO dto) {
		Produto produto = new Produto(dto.getCodigo(), dto.getNome(), dto.getValor());
		Produto produtoSave = produtoRepository.save(produto);
		return this.produtoToDto(produtoSave);

	}

	private ProdutoDTO produtoToDto(Produto produto) {
		return new ProdutoDTO(produto.getCodigo(), produto.getNome(), produto.getValor());
	}

}
