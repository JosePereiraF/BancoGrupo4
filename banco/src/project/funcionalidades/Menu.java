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
		int numero2 = conta.gerarNumeroDaConta();
		int numeroAgencia = 0;
		
		System.out.println("Digite um cpf");
		cpf = sc.nextLine();
		//String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao
		ContaCorrente conta = new ContaCorrente(cpf, numero, TipoContaENUM.CONTAPOUPANCA, 0.0, LocalDate.now(),numeroAgencia);
		ContaCorrente conta2 = new ContaCorrente(cpf2, numero2, TipoContaENUM.CONTAPOUPANCA, 0.0, LocalDate.now(),numeroAgencia);
		System.out.println(conta);
		System.out.println("Você criou a conta com sucesso");
		Conta.listaConta.put(cpf, conta);
		Conta.listaConta.put(cpf2, conta2);
		while(sair !=2) {
			
			System.out.println("Digite: \n1 - Acessar o menu \n2 - Sair");
			sair=scint.nextInt();
			
			if(sair == 1) {
				
				do {
					System.out.println("Digite: \n1 - Criar conta \n2 - Depósito\n3 - Saque "
							+ "\n4 - Transferência \n5 - Extrato \n6 - Informações da conta");
					escolha= scint.nextInt();
					switch (escolha) {// TODO Fazer um System.out.println("1 - Desejo prosseguir \n2 - Sair"); criar um switch para voltar

					case 1: 
						System.out.println();
						System.out.println("\nVocê selecionou a opção \"Criar Conta\"");
						
						conta.criarConta(cpf);
						break;
					case 2:
						System.out.println();
						System.out.println("\nVocê selecionou a opção \"Depósito\"");
						
						ex.deposito(conta);
						break;
					case 3:
						System.out.println();
						System.out.println("\nVocê selecionou a opção \"Saque\"");
						
						 ex.saque(conta);
						
						break;
					case 4:
						System.out.println();
						System.out.println("\nVocê selecionou a opção \"Transferência\"");
						
						ex.transferencia(conta, conta2);
						break;
					case 5:
						System.out.println();
						System.out.println("\nVocê selecionou a opção \"Extrato\"");
						
						ex.mostrar_extrato(conta);
						break;
					case 6:
						System.out.println();
						System.out.println("\nVocê selecionou a opção \"Informações da conta\"");
						
						
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
