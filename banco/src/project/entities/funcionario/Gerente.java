package project.entities.funcionario;

import java.time.LocalDate;

import project.enums.CargoENUM;

public class Gerente extends Funcionario{
	//criar um
	public Gerente(String nome, String cpf, String senha, LocalDate dataNascimento, CargoENUM cargo) {
		super(nome, cpf, senha, dataNascimento, cargo);
	}

	@Override
	public String toString() {
		return "Gerente [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", dataNascimento="
				+ dataNascimento + "]";
	}
		
}
