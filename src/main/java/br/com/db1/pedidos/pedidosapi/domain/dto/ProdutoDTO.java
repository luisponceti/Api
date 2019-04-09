package br.com.db1.pedidos.pedidosapi.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProdutoDTO implements Serializable {

	public static final long serialVersionUID = 1L;

	private String codigo;
	private String nome;
	private Double valor;

	public ProdutoDTO() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public ProdutoDTO(String codigo, String nome, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }


	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ProdutoDTO)) {
			return false;
		}
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome)
				&& Objects.equals(valor, other.valor);
	}

}
