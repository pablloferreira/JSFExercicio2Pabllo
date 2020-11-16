package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class ControlePabllo {

	private Long id ;
	private String descricao;
	private String especificacao;
	private String departamento;
	private double valor;
	private Date data_cadastro;
	
	public ControlePabllo() {
		
	}

	public ControlePabllo(Long id, String descricao, String especificacao, String departamento, double valor, Date data_cadastro) {
		this.id = id;
		this.descricao = descricao;
		this.especificacao = especificacao;
		this.departamento = departamento;
		this.valor  =  valor;
		this.data_cadastro = data_cadastro;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControlePabllo other = (ControlePabllo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
