package br.com.db1.pedidos.pedidosapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.StatusTipoProduto;
import br.com.db1.pedidos.pedidosapi.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<ProdutoDTO> getByStatus(@RequestParam("status")StatusTipoProduto status){
		return produtoService.getByStatus(status);
		
	}
	@PostMapping
	public ProdutoDTO post(@RequestBody ProdutoDTO body){
		return produtoService.save(body);
	}

}
