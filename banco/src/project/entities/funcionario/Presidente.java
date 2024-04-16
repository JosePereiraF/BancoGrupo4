package project.entities.funcionario;

import project.enums.CargoENUM;

public class Presidente extends Funcionario{

	public Presidente(String nome, String cpf, String senha, CargoENUM cargo) {
		super(nome, cpf, senha, cargo);
	}

	@Override
	public String toString() {
		return "Presidente [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}

	

}
