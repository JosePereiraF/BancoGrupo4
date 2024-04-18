package project.funcionalidades;

import java.io.IOException;
import java.util.Scanner;

import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaPoupanca;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.Extrato;

public class MenuCliente {

	public void menuCliente(Cliente cliente) throws ExcecaoTransferencias, IOException {

		Scanner sc = new Scanner(System.in);

		int option = 0;
		Extrato e = new Extrato();
		Conta conta = Conta.listaConta.get(cliente.getCpf());
		
		System.out.println("Bem vindo ao menu do cliente");

		int tentativa = 0;

		while (option != 8) {
			imprimeMenu();

			option = sc.nextInt();
			switch (option) {
			case 1:
				Extrato.saldo(conta);

				break;

			case 2:
				Extrato.saque(conta);
				break;

			case 3:
				Extrato.deposito(conta);
				break;

			case 4:
				System.out.println("Digite o CPF do titular que receberá a transferência: ");
				String cpfRecebe = sc.nextLine();
				Extrato.transferencia(conta, Conta.listaConta.get(cpfRecebe));
				break;

			case 5:
				Extrato.mostrar_extrato(conta);
				break;

			case 6:
				Extrato.totalArrecadado();
				break;
				
			case 7:
				ContaPoupanca.calcularRendimento();
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

		System.out.println(" 5 - Extrato ");

		System.out.println(" 6 - Relatório de tributação  ");

		System.out.println(" 7 - Simulação de Rendimento  ");

		System.out.println(" 8 - Sair  ");
		
		imprimeLinha();

	}
	
}
