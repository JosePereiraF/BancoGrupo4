package project.funcionalidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import project.entities.Pessoa;
import project.entities.conta.Conta;
import project.entities.conta.ContaPoupanca;
import project.entities.funcionario.Diretor;
import project.entities.funcionario.Funcionario;
import project.entities.funcionario.Gerente;
import project.entities.funcionario.Presidente;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.Deposito;
import project.extrato.Extrato;
import project.extrato.Saque;
import project.extrato.Transferencia;
import project.imprimeRelatorio.ImprimeRelatorio;

public class MenuPresidente {

	public static void menuPresidente(Presidente presidente,Scanner sc,Map<String,Pessoa> listaPessoa,Map<String, Conta> listaConta,ArrayList<Saque> saques,ArrayList<Deposito> depositos,ArrayList<Transferencia> transferencias) throws ExcecaoTransferencias, IOException {


		int option = 0;
		Extrato e = new Extrato();
		Conta conta = listaConta.get(presidente.getCpf());
		
		System.out.println("Bem vindo ao menu do Presidente");

		int tentativa = 0;

		while (option != 11) {
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
				Extrato.transferencia(conta ,listaConta.get(cpfRecebe),transferencias,listaPessoa,sc );
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
				System.out.println("Digite o número do CPF do Gerente responsável pela agência a ser selecionada: ");
				String cpfGerente = sc.nextLine();
				Gerente gerente = (Gerente) listaPessoa.get(cpfGerente);
				int a = Extrato.contarContas(gerente.getAgenciaResponsavel(),listaConta);
				System.out.println("A agência do " +gerente.getNome()+ " tem: " + a + " clientes. ");
				break;
				
			case 9:
				Extrato.relatorioClientes(listaPessoa,listaConta);
				break;
			case 10:
				Extrato.calcCapital(listaConta);
				break;		
			
			case 11:
				
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
		
		System.out.println(" 9 - Relatório dos clientes  "); 
		
		System.out.println(" 10 - Capital acumulado do banco ");
		
		System.out.println(" 11 - Sair  ");
		
		imprimeLinha();

	}
	
}
