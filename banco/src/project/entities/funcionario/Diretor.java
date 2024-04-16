package project.entities.funcionario;

import project.enums.CargoENUM;

public class Diretor extends Funcionario{

	
	public Diretor(String nome, String cpf, String senha, CargoENUM cargo) {
		super(nome, cpf, senha, cargo);
	}

	@Override
	public String toString() {
		
		return nome+ ";"+ cpf+";"+senha+";"+ cargo;
	}



	
	
	
	
}
