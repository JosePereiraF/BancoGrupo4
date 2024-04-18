package project.funcionalidades;


import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import project.entities.Pessoa;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.entities.funcionario.Diretor;
import project.entities.funcionario.Gerente;
import project.entities.funcionario.Presidente;
import project.enums.CargoENUM;
import project.enums.TipoContaENUM;

public class Criacao {


    public static int gerarNumeroDaConta(Map <String, Conta> listaConta) {
		int numeroDaConta = 0;
		boolean criacao = false;
		
		do {
			Random random = new Random();
			int numeroGerado = random.nextInt();
			if (confereNumeroDaConta(numeroGerado,listaConta) == true || numeroGerado < 0) {
				
			} else {
				numeroDaConta = numeroGerado;
				criacao = true;
			}
		} while (criacao == false);
		return numeroDaConta;
	}

	public static boolean confereNumeroDaConta(int numeroGerado, Map <String, Conta> listaConta) {
		for (Conta conta : listaConta.values()) {//talvez pode modificar e ler a lista de contas que eu vou criar para usar no escritor contas
			if (conta.getNumeroDaConta() == numeroGerado) {
				
				return true;
			}
		}
		return false;
	}

	public static void criarConta(String cpf, Map <String, Conta> listaConta){ //Truncar o numeroDaConta pra String
		Scanner sc = new Scanner(System.in);
		TipoContaENUM tipo = null;
		int numeroAgencia = 0;
		do {
			System.out.println("Insira que tipo de conta você deseja criar: \n1-Conta Corrente \n2-Conta Poupança");
			int opcao = sc.nextInt();//esta quebrando aqui quando se cria 2 contas seguidas

			switch (opcao) {
			case 1:
				tipo = TipoContaENUM.CONTACORRENTE;
				System.out.println("Você escolheu Conta Corrente");
				break;
			case 2:
				tipo = TipoContaENUM.CONTAPOUPANCA;
				System.out.println("Você escolheu Conta Poupança");
				break;
			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				continue;
			}
		} while (tipo == null);
		LocalDate diaCriacao = LocalDate.now();
		sc.close();

		int NumeroDaContaGerado = gerarNumeroDaConta(listaConta);
		if (tipo == TipoContaENUM.CONTACORRENTE) {

			ContaCorrente conta = new ContaCorrente(cpf, NumeroDaContaGerado, tipo, 0.0, diaCriacao,numeroAgencia);
			System.out.println("Você criou a conta com sucesso");
			listaConta.put(cpf, conta);
		}
		if (tipo == TipoContaENUM.CONTAPOUPANCA) {
			ContaCorrente conta = new ContaCorrente(cpf, NumeroDaContaGerado, tipo, 0.0, diaCriacao,numeroAgencia);
			System.out.println("Você criou a conta com sucesso");
			listaConta.put(cpf, conta);
		}
	}

    public static void criarCliente(Map <String, Pessoa> listaPessoa,Scanner sc) {
		//(String nome, String cpf, String senha, LocalDate dataNascimento, String numeroAgencia) 
		String nomeDigitado;
		String cpfDigitado;
		String senhaDigitada;
		String numeroAgenciaDigitada;
		
		System.out.println("Digite o nome: ");
		nomeDigitado = sc.nextLine();
		System.out.println("Digite o CPF: ");
		cpfDigitado = sc.nextLine();
		System.out.println("Digite a senha: ");
		senhaDigitada = sc.nextLine();
		System.out.println("Digite o número da agência: ");
		numeroAgenciaDigitada = sc.nextLine();
		
		Cliente clinte = new Cliente(nomeDigitado,cpfDigitado,senhaDigitada,numeroAgenciaDigitada);
		listaPessoa.put(cpfDigitado, clinte);
		
	}

    public static void criarFuncionario(Map <String, Pessoa> listaPessoa,Scanner sc) {
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
				sc.nextLine();// não é bom deixar assim
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
				cargoDigitado = criarCargo(sc.nextLine());
				while(cargoDigitado== null) {
					System.err.println("\nCargo invalido digite um cargo válido:\n");
					System.out.println("Digite "+digitacao[i]);
					cargoDigitado = criarCargo(sc.nextLine());
					}
				break;
				
			}
			
		}
		
		salvaFuncionario(nomeDigitado, cpfDigitado, senhaDigitado,  cargoDigitado,listaPessoa,sc);
		
		
	}

    public static CargoENUM criarCargo(String cargo) {
		if(cargo.equalsIgnoreCase("Diretor")) return CargoENUM.DIRETOR;
		else if(cargo.equalsIgnoreCase("Gerente")) return CargoENUM.GERENTE;
		else if(cargo.equalsIgnoreCase("Presidente"))return CargoENUM.PRESIDENTE;
		else return null;
		
	}
	
	public static void salvaFuncionario(String nome, String cpf, String senha,CargoENUM cargo,Map <String, Pessoa> listaPessoa ,Scanner sc) {
		if(cargo == CargoENUM.DIRETOR) {
			
			Diretor diretor = new Diretor(nome,cpf,senha,cargo);
			listaPessoa.put(cpf, diretor);
			
		}else if(cargo == CargoENUM.GERENTE) {
			System.out.println("Digite o numero da agencia que o "+ nome+" é responsavel");
			int agenciaResponsavel= sc.nextInt();//add tratamento para quando receber texto
			Gerente gerente = new Gerente(nome,cpf,senha,cargo,agenciaResponsavel);
			listaPessoa.put(cpf, gerente);
			
		}else if(cargo == CargoENUM.PRESIDENTE) {
			
			Presidente presidente = new Presidente(nome,cpf,senha,cargo);
			listaPessoa.put(cpf, presidente);
			
		}
	}

    
}
