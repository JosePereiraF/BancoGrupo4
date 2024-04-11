package project.entities.funcionario;

import java.time.LocalDate;

import project.enums.CargoENUM;

public class Diretor extends Funcionario{

	public Diretor(String nome, String cpf, String senha, LocalDate dataNascimento, CargoENUM cargo) {
		super(nome, cpf, senha, dataNascimento, cargo);
	}

	@Override
	public String toString() {
		return "Diretor [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", dataNascimento="
				+ dataNascimento + "]";
	}
	


}
