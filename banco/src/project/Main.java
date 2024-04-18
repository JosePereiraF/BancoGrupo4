package project;

import java.io.IOException;
import java.util.Scanner;

import project.entities.agencia.Agencia;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.entities.funcionario.Funcionario;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.Extrato;
import project.funcionalidades.InOutUtils;

public class Main {

	public static void main(String[] args) throws IOException, ExcecaoTransferencias {
		/*
		 Funcionario leitor e escritor funcionando
		 Contas leitor e escritor funcionando
		 Cliente leitor e escritor funcionando
		 Saque leitor e escritor funcionando
		 Deposito leitor e escritor funcionando
		 transferencia leitor e escritor funcionando
		 Agencia leitor e escritor funcionando
		 */
		InOutUtils.leitorAgencia();
		InOutUtils.leitorContas();
		InOutUtils.leitorDeposito();
		InOutUtils.leitorPessoa();
		InOutUtils.leitorSaque();
		InOutUtils.leitorTransferencia();
		Agencia.consultarAgencias();
		
		








	}

	public void teste() throws ExcecaoTransferencias, IOException {

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
				Extrato.transferencia(conta, conta);
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
