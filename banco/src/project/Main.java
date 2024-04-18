package project;

import java.io.IOException;
import java.util.Scanner;

import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.Extrato;

public class Main {

	public static void main(String[] args) throws IOException {

	}

	public void teste() throws ExcecaoTransferencias {

		Scanner sc = new Scanner(System.in);

		int option = 0;
		Extrato e = new Extrato();
		Conta conta = new ContaCorrente();
		
		System.out.println("Bem vindo ao menu do cliente");

		int tentativa = 0;

		while (option != 8) {
			imprimeMenu();

			option = sc.nextInt();
			switch (option) {
			case 1:
				e.saldo(conta);

				break;

			case 2:
				e.saque(conta);
				break;

			case 3:
				e.deposito(conta);
				break;

			case 4:
				e.transferencia(conta, conta);
				break;

			case 5:
				e.mostrar_extrato(conta);
				break;

			case 6:
				e.totalArrecadado();
				break;
				
			case 7:
				System.out.println("Simulação de Rendimento");
				break;	
				
			case 8:
				System.out.println("Saindo do Menu");
				break;	
				
			default: 
				System.out.println("Digite uma opcão válida");
				
			}

		}
	}

	public static void imprimeLinha() {

		System.out.println(" ************** ");

	}

	public static void imprimeMenu() {

		imprimeLinha();

		System.out.println(" 1 - Saldo: ");

		System.out.println(" 2 - Sacar:  ");

		System.out.println(" 3 - Depósito: ");

		System.out.println(" 4 - Transferência: ");

		System.out.println(" 5 - Extrato. ");

		System.out.println(" 6 - Relatório de tributação  ");

		System.out.println(" 7 - Simulação de Rendimento  ");

		imprimeLinha();

	}
	



//	try {
//		contap.calcularRendimento();			
//	} catch (Exception e) {
//		System.err.println("Você digitou o dia errado em relação ao mês!");
//	}


}
