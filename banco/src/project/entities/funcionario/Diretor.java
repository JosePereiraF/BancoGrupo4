package project.entities.funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import project.enums.CargoENUM;

public class Diretor extends Funcionario{

	Scanner sc = new Scanner (System.in);
	public Diretor(String nome, String cpf, String senha, CargoENUM cargo) {
		super(nome, cpf, senha, cargo);
	}

	@Override
	public String toString() {
		return "Diretor [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
	public void criar_funcionario() {
		//String nome, String cpf, String senha, LocalDate dataNascimento, CargoENUM cargo
		String nomeDigitado;
		String cpfDigitado;
		String senhaDigitado;
		CargoENUM cargoDigitado;
		
		System.out.println("Digite seu nome:");
		nomeDigitado = sc.nextLine();
		System.out.println("Digite seu cpf:");
		cpfDigitado = sc.nextLine();
		System.out.println("Digite sua senha: ");
		senhaDigitado = sc.nextLine();
		
		System.out.println("Digite seu cargo:");
		cargoDigitado = criar_cargo(sc.nextLine());
		while(cargoDigitado== null) {
		System.out.println("Digite seu cargo:");
		cargoDigitado = criar_cargo(sc.nextLine());
		}
		salva_funcionario(nomeDigitado, cpfDigitado, senhaDigitado,  cargoDigitado);
		
		
	}
	public CargoENUM criar_cargo(String cargo) {
		if(cargo.equalsIgnoreCase("Diretor")) return CargoENUM.DIRETOR;
		else if(cargo.equalsIgnoreCase("Gerente")) return CargoENUM.GERENTE;
		else if(cargo.equalsIgnoreCase("Presidente"))return CargoENUM.PRESIDENTE;
		else return null;
		
	}
	
	public LocalDate convercao_data(String data){
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/mm/dd");
		
		
				LocalDate date = LocalDate.parse(data,formato) ;
				return date;
		
	}
	public void salva_funcionario(String nome, String cpf, String senha,CargoENUM cargo) {
		if(cargo == CargoENUM.DIRETOR) {
			
			Diretor diretor = new Diretor(nome,cpf,senha,cargo);
			lista_funcionario.put(cpf, diretor);
		}else if(cargo == CargoENUM.GERENTE) {
			
			Gerente gerente = new Gerente(nome,cpf,senha,cargo);
			lista_funcionario.put(cpf, gerente);
		}else if(cargo == CargoENUM.PRESIDENTE) {
			
			Presidente presidente = new Presidente(nome,cpf,senha,cargo);
			lista_funcionario.put(cpf, presidente);
		}
	}
	
}
