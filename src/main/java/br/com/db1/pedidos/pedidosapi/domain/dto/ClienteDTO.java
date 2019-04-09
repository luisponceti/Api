package br.com.db1.pedidos.pedidosapi.domain.dto;

import java.io.Serializable;

import br.com.db1.pedidos.pedidosapi.domain.entity.StatusTipoCliente;

public class ClienteDTO implements Serializable {

	public static final long serialVersionUID = 1L;

	private Long id;
	private String cpf;
	private String nome;
	private StatusTipoCliente status;

	public ClienteDTO() {
		super();
	}
	
	public Long getId(){
		return this.id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}
	
	public StatusTipoCliente getStatus(){
		return this.status;
	}

	public Long setId(){
		return this.id;
	}
	
	public String setCpf(String cpf) {
		return this.cpf;

	}
	
	public String setNome(String nome){
		return this.nome;
	}
	
	public ClienteDTO(Long id,String cpf, String nome, StatusTipoCliente status) {
        this.id = id;
		this.cpf = cpf;
        this.nome = nome;
        this.status = status;
    }
	
	

	
	
	
}
