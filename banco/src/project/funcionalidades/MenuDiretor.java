package project.funcionalidades;

import java.io.IOException;
import java.util.Scanner;

import project.entities.conta.Conta;
import project.entities.conta.ContaPoupanca;
import project.entities.funcionario.Diretor;
import project.entities.funcionario.Funcionario;
import project.entities.funcionario.Gerente;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.Extrato;

public class MenuDiretor {

	public void menuDiretor(Diretor diretor) throws ExcecaoTransferencias, IOException {

		Scanner sc = new Scanner(System.in);

		int option = 0;
		Extrato e = new Extrato();
		Conta conta = Conta.listaConta.get(diretor.getCpf());
		
		System.out.println("Bem vindo ao menu do Diretor");

		int tentativa = 0;

		while (option != 10) {
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
				System.out.println("Digite o número do CPF do Gerente responsável pela agência a ser selecionada: ");
				String cpfGerente = sc.nextLine();
				Gerente gerente = (Gerente) Funcionario.lista_funcionario.get(cpfGerente);
				int a = Conta.contarContas(gerente.getAgenciaResponsavel());
				System.out.println("A agência do " +gerente.getNome()+ " tem: " + a + " clientes. ");
				break;
				
			case 9:
				//relatorio dos clientes
				Diretor.relatorioClientes();
				
				break;	
				
			case 10:
				
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

		System.out.println(" 5 - Extrato: ");

		System.out.println(" 6 - Relatório de tributação  ");

		System.out.println(" 7 - Simulação de Rendimento  ");

		System.out.println(" 8 - Relatório de contas  ");
		
		System.out.println(" 9 - Relatório dos clientes  "); //modificar
		
		System.out.println(" 10 - Sair  ");
		imprimeLinha();

	}
}
