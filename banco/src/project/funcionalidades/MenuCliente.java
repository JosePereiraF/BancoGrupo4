package project.funcionalidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import project.entities.Pessoa;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaPoupanca;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.Deposito;
import project.extrato.Extrato;
import project.extrato.Saque;
import project.extrato.Transferencia;
import project.imprimeRelatorio.ImprimeRelatorio;

public class MenuCliente {

	public static void menuCliente(Cliente cliente,Scanner sc,Map<String,Pessoa> listaPessoa,Map<String, Conta> listaConta,ArrayList<Saque> saques,ArrayList<Deposito> depositos,ArrayList<Transferencia> transferencias) throws ExcecaoTransferencias, IOException {


		int option = 0;
		Extrato e = new Extrato();
		Conta conta =listaConta.get(cliente.getCpf());
		
		System.out.println("Bem vindo ao menu do cliente");

		int tentativa = 0;

		while (option != 8) {
			imprimeMenu();

			option = sc.nextInt();
			switch (option) {
			case 1:
				Extrato.saldo(conta,listaPessoa);

				break;

			case 2:
				Extrato.saque(conta,saques );
				break;

			case 3:
				Extrato.deposito(conta,depositos);
				break;

			case 4:
				System.out.println("Digite o CPF do titular que receberá a transferência: ");
				String cpfRecebe = sc.nextLine();
				Extrato.transferencia(conta ,listaConta.get(cpfRecebe),transferencias,listaPessoa,sc);
				break;

			case 5:
				ImprimeRelatorio.imprimeExtrato(saques, depositos, transferencias, conta);
				break;

			case 6:
				Extrato.totalArrecadado(saques,depositos,transferencias);
				break;
				
			case 7:
				Extrato.calcularRendimento(sc);
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
