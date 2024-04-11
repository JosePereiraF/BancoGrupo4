package project.entities.cliente;

import java.time.LocalDate;

import project.entities.Pessoa;

public class Cliente extends Pessoa{
	private String numeroAgencia;

	public Cliente(String nome, String cpf, String senha, LocalDate dataNascimento, String numeroAgencia) {
		super(nome, cpf, senha, dataNascimento);
		this.numeroAgencia = numeroAgencia;
	}

	@Override
	public String toString() {
		return "Cliente [numeroAgencia=" + numeroAgencia + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", dataNascimento=" + dataNascimento + "]";
	}

	
	
	
}
