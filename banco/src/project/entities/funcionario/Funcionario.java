package project.entities.funcionario;

import java.util.HashMap;

import project.entities.Pessoa;
import project.enums.CargoENUM;

public abstract class Funcionario extends Pessoa{
	protected CargoENUM cargo;
	//criar um HashMap de funcionario onde nele sera armazenados todos os tipos de funcionarios independente do cargo
	
	protected HashMap<String,Funcionario> lista_funcionario = new HashMap<>();
	
	public Funcionario(String nome, String cpf, String senha,  CargoENUM cargo) {
		super(nome, cpf, senha);
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
