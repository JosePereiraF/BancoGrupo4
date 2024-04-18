package project.entities.funcionario;

import java.util.HashMap;
import java.util.Scanner;

import project.entities.Pessoa;
import project.enums.CargoENUM;

public abstract class Funcionario<E> extends Pessoa{
	protected CargoENUM cargo;
	static Scanner sc = new Scanner(System.in);
	public static HashMap<String,Funcionario> lista_funcionario = new HashMap<>();
	
	public Funcionario(String nome, String cpf, String senha,  CargoENUM cargo) {
		super(nome, cpf, senha);
		this.cargo = cargo;
	}
	public Funcionario() {
		super();
	}
	public CargoENUM getCargo() {
		return cargo;
	}

	public void setCargo(CargoENUM cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		
		return nome + ";" +cpf+";"+senha+";"+cargo;
	}
	
	
}
