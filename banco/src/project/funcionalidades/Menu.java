package project.funcionalidades;

import java.time.LocalDate;
import java.util.Scanner;

import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.enums.TipoContaENUM;
import project.extrato.Extrato;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Scanner scint = new Scanner(System.in);
	Conta conta = new ContaCorrente();
	Extrato ex = new Extrato();
	public void menu() {
		int sair= 0;
		int escolha = 0;
		String cpf;
		String cpf2="234";
		int numero = conta.gerarNumeroDaConta();
		
		System.out.println("Digite um cpf");
		cpf = sc.nextLine();
		//String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao
		ContaCorrente conta = new ContaCorrente(cpf, numero, TipoContaENUM.CONTAPOUPANCA, 0.0, LocalDate.now());
		ContaCorrente conta2 = new ContaCorrente(cpf2, numero, TipoContaENUM.CONTAPOUPANCA, 0.0, LocalDate.now());
		System.out.println(conta);
		System.out.println("Você criou a conta com sucesso");
		Conta.listaConta.put(cpf, conta);
		Conta.listaConta.put(cpf2, conta2);
		while(sair !=2) {
			
			System.out.println("1 para ir para o menu 2 para sair");
			sair=scint.nextInt();
			
			if(sair == 1) {
				
				do {
					System.out.println("Digite 1 para criar a conta.\n2-para fazer deposito\n3- para fazer saque\n4-para fazer transferencia.\n5- para extrato\n6- para informações da conta");
					escolha= scint.nextInt();
					switch (escolha) {
					case 1: 
						System.out.println();
						
						conta.criarConta(cpf);
						break;
					case 2:
						System.out.println();
						
						ex.deposito(conta);
						break;
					case 3:
						System.out.println();
						
						 ex.saque(conta);
						
						break;
					case 4:

						ex.transferencia(conta, conta2);
						break;
					case 5:
						ex.mostrar_extrato(conta);
						break;
					case 6:
						System.out.println("Digite o cpf do titular da conta para aparecer as informações");
						cpf = sc.nextLine();
						System.out.println(Conta.listaConta.get(cpf));
						break;
					}
					
					
				}while(escolha != 7);
			}
		}
	}
}
