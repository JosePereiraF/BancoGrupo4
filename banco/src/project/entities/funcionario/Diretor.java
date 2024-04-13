package project.entities.funcionario;

import java.time.LocalDate;
import java.util.Scanner;

import project.enums.CargoENUM;

public class Diretor extends Funcionario{

	Scanner sc = new Scanner (System.in);
	public Diretor(String nome, String cpf, String senha, LocalDate dataNascimento, CargoENUM cargo) {
		super(nome, cpf, senha, dataNascimento, cargo);
	}

	@Override
	public String toString() {
		return "Diretor [cargo=" + cargo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
	public void criar_diretor() {
		String nomeDigitado;
		String cpfDigitado;
		String senhaDigitado;
		LocalDate data_nascimento;
		String cargo;
		
		System.out.println("Digite seu nome:");
		nome = sc.nextLine();
		System.out.println("Digite seu cpf: ");
		cpfDigitado = sc.nextLine();
		System.out.println("Digite sua senha: ");
		senhaDigitado = sc.nextLine();
		System.out.println("Digite sua data de nascimento no formato dd/mm/yyyy");
		data_nascimento = data_convertida(sc.nextLine());
		//achar uma forma de converter Strin
		
		
	}
	
	public void cadastra_cargo(String cargo) {
		
	}
//	public LocalDate data_convertida(String data_nascimento) {
//		
//	}
	
}
