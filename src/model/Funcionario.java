package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@Column(name = "id_funcionario")
	@NotNull
	private int id;
	
	@Column(name = "nome_funcionario")
	@NotNull
	private String nome;
	
	@Column(name = "salario_funcionario")
	@NotNull
	private double salario;
	
	@Column(name = "desconto_inss_funcionario")
	private double descontoINSS;
	
	public Funcionario() {
		this.descontoINSS = 0.0f;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getDescontoINSS() {
		return descontoINSS;
	}
	public void setDescontoINSS(double desconto) {
		this.descontoINSS = desconto;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", salario=" + salario + ", descontoINSS=" + descontoINSS
				+ "]";
	}
	

		
}
