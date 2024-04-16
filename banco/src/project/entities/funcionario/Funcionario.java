package project.entities.funcionario;

import java.util.HashMap;
import java.util.Scanner;

import project.entities.Pessoa;
import project.enums.CargoENUM;

public abstract class Funcionario extends Pessoa{
	protected CargoENUM cargo;
	//criar um HashMap de funcionario onde nele sera armazenados todos os tipos de funcionarios independente do cargo
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
		return "Funcionario [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}
	
	public static void criar_funcionario() {
		//String nome, String cpf, String senha, LocalDate dataNascimento, CargoENUM cargo
		String nomeDigitado = "";
		String cpfDigitado = "";
		String senhaDigitado = "";
		CargoENUM cargoDigitado= null;
		
//		System.out.println("Digite seu nome:");
//		nomeDigitado = sc.nextLine();
//		System.out.println("Digite seu cpf:");
//		cpfDigitado = sc.nextLine();
//		System.out.println("Digite sua senha: ");
//		senhaDigitado = sc.nextLine();
//		
//		System.out.println("Digite seu cargo:");
//		cargoDigitado = criar_cargo(sc.nextLine());
//		while(cargoDigitado== null) {
//		System.out.println("Digite seu cargo:");
//		cargoDigitado = criar_cargo(sc.nextLine());
//		}
		String [] digitacao = {"seu nome: ", "seu cpf: ", "sua senha: ",  "seu cargo: ", };
		for(int i = 0; i < digitacao.length; i++) {
			switch(digitacao[i]) {
			case "seu nome: ":
				System.out.println("Digite "+digitacao[i]);
				nomeDigitado = sc.nextLine();
				break;
			case "seu cpf: ":
				System.out.println("Digite "+digitacao[i]);
				cpfDigitado = sc.nextLine();
				break;
			case "sua senha: ":
				System.out.println("Digite "+digitacao[i]);
				senhaDigitado = sc.nextLine();
				break;
			case "seu cargo: ":
				System.out.println("Digite "+digitacao[i]);
				cargoDigitado = criar_cargo(sc.nextLine());
				while(cargoDigitado== null) {
					System.err.println("\nCargo invalido digite um cargo válido:\n");
					System.out.println("Digite "+digitacao[i]);
					cargoDigitado = criar_cargo(sc.nextLine());
					}
				break;
				
			}
			
		}
		
		salva_funcionario(nomeDigitado, cpfDigitado, senhaDigitado,  cargoDigitado);
		
		
	}
	public static CargoENUM criar_cargo(String cargo) {
		if(cargo.equalsIgnoreCase("Diretor")) return CargoENUM.DIRETOR;
		else if(cargo.equalsIgnoreCase("Gerente")) return CargoENUM.GERENTE;
		else if(cargo.equalsIgnoreCase("Presidente"))return CargoENUM.PRESIDENTE;
		else return null;
		
	}
	
	public static void salva_funcionario(String nome, String cpf, String senha,CargoENUM cargo) {
		if(cargo == CargoENUM.DIRETOR) {
			
			Diretor diretor = new Diretor(nome,cpf,senha,cargo);
			lista_funcionario.put(cpf, diretor);
		}else if(cargo == CargoENUM.GERENTE) {
			System.out.println("Digite o numero da agencia que o "+ nome+" é responsavel");
			int agenciaResponsavel= sc.nextInt();
			Gerente gerente = new Gerente(nome,cpf,senha,cargo,agenciaResponsavel);
			lista_funcionario.put(cpf, gerente);
		}else if(cargo == CargoENUM.PRESIDENTE) {
			
			Presidente presidente = new Presidente(nome,cpf,senha,cargo);
			lista_funcionario.put(cpf, presidente);
		}
	}
	
}
