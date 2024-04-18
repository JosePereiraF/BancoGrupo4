package project.entities.conta;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import project.enums.TipoContaENUM;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao, int numeroAgencia) {
		super(cpf, numeroDaConta, tipoConta, saldo, dataCriacao, numeroAgencia);
	}

	@Override
	public String toString() {
		return cpf+ ";"+numeroDaConta+";"+tipoConta+";"+saldo+";"+dataCriacao+";"+numeroAgencia;
	}
	
	public static void calcularRendimento() {
		LocalDate hoje = LocalDate.now();
		LocalDate dataFinal = LocalDate.now();
		Scanner diasc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean continuar = true;
		
		
		while (continuar) {
			System.out.println("\n------------Relatório de Rendimento da poupança------------\n");
			System.out.println("1 - Adicionar data\n2 - Adicionar dias");
			int opcao = diasc.nextInt();

			switch (opcao) {
			case 1:

				System.out.println("\nDigite o dia: DD");
				int dia = diasc.nextInt();
				if (dia < 1 || dia > 31) {
					System.out.println("\nVocê digitou um dia inválido. Tente novamente\n");
					continue;
				}
				System.out.println("Digite o mês: MM"); 
				int mes = diasc.nextInt();
				if (mes < 1 || mes > 12) {
					System.out.println("\nVocê digitou um mês inválido. Tente novamente\n");
					continue;
				}
				System.out.println("Digite o ano: AAAA");
				int ano = diasc.nextInt();
				dataFinal = LocalDate.of(ano, mes, dia);
				break;
				
			case 2:

				System.out.println("\nEscreva quantos dias você deseja deixar o seu dinheiro rendendo na poupança");
				int diasRendendo = diasc.nextInt();
				dataFinal = hoje.plusDays(diasRendendo);
				break;
				
			default:
				System.out.println("Opção inválida! Tente Novamente.");
				continue;
			}

			if (dataFinal.isBefore(hoje)) { //condicional que vê se o a dataFinal é anterior ao dia de hoje
				System.out.println("\nVocê digitou uma data anterior ao dia de hoje " + hoje.format(formatter) + 
						"\nPara fazer a simulação dar certo é necessário inserir uma data posterior\n");
				continue;
			}
			
			diasc.nextLine();
			System.out.println("Seu plano é que a poupança renda até o dia " + dataFinal.format(formatter) + "? S/N");
			String confirmacao = diasc.nextLine();
			if (confirmacao.equalsIgnoreCase("S")) {
				break;
			}
			if (confirmacao.equalsIgnoreCase("N")) {
				continue;
			}
			continuar = false;
		}
		System.out.println("\nDigite o valor em reais que deseja simular: ");
		double valorSimulado = diasc.nextDouble();
		double jurosMensal = 0.8; // porcentagem
		double periodoDeTempo = Period.between(hoje, dataFinal).getMonths();// período em meses
		System.out.println();
		double jurosGanhos = valorSimulado * (jurosMensal / 100) * periodoDeTempo; // Usando a fórmula de Juros Simples J =
																				// P × r × t

		System.out.println("\n------------Simulação------------");
		System.out.println("\nDia de hoje: \t\t\t" + hoje.format(formatter));
		System.out.println("Dia da simulação: \t\t" + dataFinal.format(formatter));
		System.out.println("Com um juros de " + jurosMensal + "% ao mês.\n" + "Com um investimento inicial de \tR$"
				+ valorSimulado + "\nVocê terá um retorno de \tR$" + jurosGanhos + "\nTendo um total de \t\tR$"
				+ (valorSimulado + jurosGanhos));

	}
	
	
}
