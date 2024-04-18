package project.entities.funcionario;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import project.entities.Pessoa;
import project.entities.conta.Conta;
import project.enums.CargoENUM;

public class Diretor extends Funcionario{

	
	public Diretor(String nome, String cpf, String senha, CargoENUM cargo) {
		super(nome, cpf, senha, cargo);
	}

	public Diretor() {
		super();
	}
	@Override
	public String toString() {
		
		return nome+ ";"+ cpf+";"+senha+";"+ cargo;
	}

	
}
