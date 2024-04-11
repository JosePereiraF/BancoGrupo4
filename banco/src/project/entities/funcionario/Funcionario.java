package project.entities.funcionario;

import java.time.LocalDate;

import project.entities.Pessoa;
import project.enums.CargoENUM;

public abstract class Funcionario extends Pessoa{
	protected CargoENUM cargo;

	public Funcionario(String nome, String cpf, String senha, LocalDate dataNascimento, CargoENUM cargo) {
		super(nome, cpf, senha, dataNascimento);
		this.cargo = cargo;
	}

	public CargoENUM getCargo() {
		return cargo;
	}

	public void setCargo(CargoENUM cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", dataNascimento=" + dataNascimento + "]";
	}
	
	
}
