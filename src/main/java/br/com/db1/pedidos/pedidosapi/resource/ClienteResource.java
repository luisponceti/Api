package br.com.db1.pedidos.pedidosapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.StatusTipoCliente;
import br.com.db1.pedidos.pedidosapi.service.ClienteService;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<ClienteDTO> getByStatus(@RequestParam("status")StatusTipoCliente status){
		return clienteService.getByStatus(status);
		
	}
	
	@PostMapping
	public ClienteDTO post(@RequestBody ClienteDTO body){
		return clienteService.save(body);
	}
	
	@PutMapping(value = "/{id}")
	public ClienteDTO put(@PathVariable("id")Long id, @RequestBody ClienteDTO body){
		return clienteService.alterar(id, body);
	}
	
}
