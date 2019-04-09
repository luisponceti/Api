package br.com.db1.pedidos.pedidosapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.StatusTipoCliente;
import br.com.db1.pedidos.pedidosapi.repository.ClienteRepository;
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> getAllActive(){
		return this.getByStatus(StatusTipoCliente.ATIVO);
	}

	public List<ClienteDTO> getAllInactive(){
		
		return this.getByStatus(StatusTipoCliente.INATIVO);
	}
	
	public List<ClienteDTO> getByStatus(StatusTipoCliente status){
		List<Cliente> clientesDatabase = clienteRepository.findByStatus(status);
		Iterator<Cliente> iterator = clientesDatabase.iterator();
		
		List<ClienteDTO> cliente = new ArrayList<>(); 
		
		while(iterator.hasNext())
			{
			Cliente next = iterator.next();
			ClienteDTO clienteDTO = this.clienteToDto(next) ;
			cliente.add(clienteDTO);
			}
		return cliente;
	}
	

	public  ClienteDTO save(ClienteDTO dto){
		Cliente cliente = new Cliente(dto.getNome(), dto.getCpf());
		Cliente clienteSave = clienteRepository.save(cliente);
		return this.clienteToDto(clienteSave);
		
	}
	
	private ClienteDTO clienteToDto(Cliente cliente){
		return new ClienteDTO(cliente.getId(),cliente.getCpf(),cliente.getNome(),cliente.getStatus());
	}

	public ClienteDTO alterar(Long id, ClienteDTO body) {
		Cliente clienteDatabse = clienteRepository.getOne(id);
		clienteDatabse.setCpf(body.getCpf());
		clienteDatabse.setNome(body.getNome());
		clienteRepository.save(clienteDatabse);
		return this.clienteToDto(clienteDatabse);
	}
}
