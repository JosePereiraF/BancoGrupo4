package project.extrato;


import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import project.entities.Pessoa;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.excecoes.ExcecaoTransferencias;
import project.imprimeRelatorio.ImprimeRelatorio;


public class Extrato { //Sugestão: Mudar o nome da classe

	Cliente cliente;
	
	
	
	//possivel problema como estamos trabalhando com um txt e estou pretendendo nao salvar o arquivo
	//Quando eu puxar o arquivo eu posso ter problemas sobre nao existir o extrato pois as conta
	//ja estao criadas no banco e isso pode dar problema pq estou pensando em colocar para criar o extrato
	// quando a conta for criada
	
	
	
	public static void saque(Conta conta,ArrayList<Saque> listaSaque ,String path) throws ExcecaoTransferencias{
		double valor;
		double taxa = 0.10;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("O seu saldo é:\t\t R$"+conta.getSaldo());
		System.out.println("A cada Saque será descontada uma taxa de R$"+taxa);
		System.out.println("\nDigite o valor que você deseja sacar");
		valor = sc.nextDouble();
		if(valor<0) throw new ExcecaoTransferencias();
		if(conta.getSaldo()<valor+taxa) {
			
			if((conta.getSaldo()+200)>valor+taxa) {

				System.err.println("Saldo insuficiente você deseja usar o cheque especial de até 200 reais? S/N" );
				String escolha = sc.next();
				
				if(escolha.equalsIgnoreCase("s")) {
					System.out.println("Valor do saque:\t\t R$" + valor +"\nValor da taxa:\t\t R$" + taxa 
				+ "\nValor sacado:\t\t R$"+(valor-taxa));
		
				Saque saque = new Saque(conta,-(valor+taxa),LocalDateTime.now(),conta.getCpf(),taxa);
				listaSaque.add(saque);
				conta.setSaldo(conta.getSaldo()-(valor+taxa));
				System.out.println("Saldo: \t\t\t R$" + conta.getSaldo());
				System.out.println("Ação realizada com sucesso\n");
					ImprimeRelatorio.imprimeSaque(saque, conta, path,valor);
				}else {
					System.out.println("Transação cancelada");
					
				}
				
			}else {
				System.err.println("Saldo insuficiente para realizar a operação");
				
			}
		}else {
			System.out.println("Valor do saque:\t\t R$" + valor +"\nValor da taxa:\t\t R$" + taxa 
				+ "\nValor sacado:\t\t R$"+(valor-taxa));
		
			Saque saque = new Saque(conta,-(valor+taxa),LocalDateTime.now(),conta.getCpf(),taxa);
			listaSaque.add(saque);
			conta.setSaldo(conta.getSaldo()-(valor+taxa));
			ImprimeRelatorio.imprimeSaque(saque, conta, path,valor);
			System.out.println("Saldo: \t\t\t R$" + conta.getSaldo());
			System.out.println("Ação realizada com sucesso\n");
		}
		
	}
	public static void deposito(Conta conta,ArrayList<Deposito> listaDeposito, String path ) throws ExcecaoTransferencias{
		
		double valor;
		double taxa = 0.10;
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("A cada depósito será descontada uma taxa de R$"+taxa);
		System.out.println("\nDigite o valor que você deseja despositar:");
		valor = sc.nextDouble();
		if(valor<0) throw new ExcecaoTransferencias();
		System.out.println("Valor do depósito:\t R$" + valor +"\nValor da taxa:\t\t R$" + taxa 
				+ "\nValor depositado:\t R$"+(valor-taxa));
		Deposito d = new Deposito(conta,(valor-taxa),LocalDateTime.now(),conta.getCpf(),taxa);
		conta.setSaldo(conta.getSaldo()+(valor-taxa));
		listaDeposito.add(d);
		ImprimeRelatorio.imprimeDeposito(d, conta, path,valor);
		System.out.println("Saldo: \t\t\t R$" + conta.getSaldo());
		System.out.println("Ação realizada com sucesso\n");

	}
	
	public static void transferencia(Conta contaOrigem ,Conta contaDestino,ArrayList<Transferencia> listaTransferencia, Map<String, Pessoa> listaPessoa,Scanner sc,String path ) throws ExcecaoTransferencias{
		double valor;
		double taxa = 0.20;
	
		System.out.println("Seu saldo é \t\t R$" + contaOrigem.getSaldo()); 
		System.out.println("A cada transferência será descontado uma taxa de R$0,20.");	
		System.out.println("Digite o valor que você deseja transferir");
		valor = sc.nextDouble();
		if(valor<0) throw new ExcecaoTransferencias();
		

		if(contaOrigem.getSaldo()<valor+taxa) {
			if((contaOrigem.getSaldo()+200)> valor+taxa) {
				System.err.println("Saldo insuficiente você deseja usar o cheque especial de até 200 reais? S/N" );
				String escolha = sc.next();
				if(escolha.equalsIgnoreCase("s")) {
					
					Transferencia origem = new Transferencia(contaOrigem,contaDestino,-(valor+taxa),LocalDateTime.now(),contaOrigem.getCpf(),taxa);
					Transferencia destino = new Transferencia(contaDestino,contaOrigem,+valor,LocalDateTime.now(),contaDestino.getCpf(),0);
					listaTransferencia.add(origem);
					listaTransferencia.add(destino);
					contaOrigem.setSaldo(contaOrigem.getSaldo()-(valor+taxa));
					contaDestino.setSaldo(contaDestino.getSaldo()+valor);
					ImprimeRelatorio.imprimeTransferencia(listaPessoa, contaOrigem, contaDestino, origem, valor,path);
					System.out.println("Ação realizada com sucesso");
					System.out.println("Dados do pagador \n");
					System.out.println("Nome: "+listaPessoa.get(contaOrigem.getCpf()).getNome());//Inserir nome 
					System.out.println("CPF: " + contaOrigem.getCpf());
					System.out.println("Agência: "+ contaOrigem.getNumeroAgencia());//Inserir Agência
					System.out.println("Tipo de conta: " + contaOrigem.getTipoConta().name());		
					System.out.println("Número da conta: " + contaOrigem.getNumeroDaConta() + "\n");		
					
					System.out.println("Dados do recebedor \n");
					System.out.println("Nome: "+listaPessoa.get(contaDestino.getCpf()).getNome());//Inserir nome 
					System.out.println("CPF: " + contaDestino.getCpf());
					System.out.println("Agência: "+contaDestino.getNumeroAgencia());//Inserir Agência	
					System.out.println("Tipo de conta: " + contaDestino.getTipoConta().name());		
					System.out.println("Número da conta: " + contaDestino.getNumeroDaConta() + "\n");
					
					System.out.println("Valor da tranferêcia: \t\t R$" + (valor + taxa));
					System.out.println("Valor da taxa: \t\t\t R$" + taxa);
					System.out.println("Valor Transferido: \t\t R$" + (valor));
					
				}else {
					System.out.println("Transação cancelada");
				}
			}else {
				System.err.println("Saldo insuficiente para realizar a operação");
			}
		}else {
			
		Transferencia origem = new Transferencia(contaOrigem,contaDestino,-(valor+taxa),LocalDateTime.now(),contaOrigem.getCpf(),taxa);
		Transferencia destino = new Transferencia(contaDestino,contaOrigem,+valor,LocalDateTime.now(),contaDestino.getCpf(),0);
		listaTransferencia.add(origem);
		listaTransferencia.add(destino);
		contaOrigem.setSaldo(contaOrigem.getSaldo()-(valor+taxa));
		contaDestino.setSaldo(contaDestino.getSaldo()+valor);
		
		ImprimeRelatorio.imprimeTransferencia(listaPessoa, contaOrigem, contaDestino, origem, valor,path);
		System.out.println("Ação realizada com sucesso");
		System.out.println("Dados do pagador \n");
		System.out.println("Nome: "+listaPessoa.get(contaOrigem.getCpf()).getNome());//Inserir nome 
		System.out.println("CPF: " + contaOrigem.getCpf());
		System.out.println("Agência: "+ contaOrigem.getNumeroAgencia());//Inserir Agência
		System.out.println("Tipo de conta: " + contaOrigem.getTipoConta().name());		
		System.out.println("Número da conta: " + contaOrigem.getNumeroDaConta() + "\n");		
		
		System.out.println("Dados do recebedor \n");
		System.out.println("Nome: "+listaPessoa.get(contaDestino.getCpf()).getNome());//Inserir nome 
		System.out.println("CPF: " + contaDestino.getCpf());
		System.out.println("Agência: "+contaDestino.getNumeroAgencia());//Inserir Agência	
		System.out.println("Tipo de conta: " + contaDestino.getTipoConta().name());		
		System.out.println("Número da conta: " + contaDestino.getNumeroDaConta() + "\n");
		
		System.out.println("Valor da tranferêcia: \t\t R$" + (valor + taxa));
		System.out.println("Valor da taxa: \t\t\t R$" + taxa);
		System.out.println("Valor Transferido: \t\t R$" + (valor));



		}

	}
	
	
	//fazer um metodo para entregar o saldo da conta de forma formatada(opcional)*
	
	public static void saldo (Conta conta,Map<String, Pessoa> listaPessoa, String path) {
		System.out.println("-----------Saldo-----------");
		System.out.println("Dados da conta \n");
		System.out.println("Nome: "+listaPessoa.get(conta.getCpf()).getNome());
		System.out.println("CPF: " + conta.getCpf());
		System.out.println("Agência: "+ conta.getNumeroAgencia());
		System.out.println("Tipo de conta: " + conta.getTipoConta().name());		
		System.out.println("Número da conta: " + conta.getNumeroDaConta() + "\n");	
		System.out.println("Saldo: " + conta.getSaldo());
		ImprimeRelatorio.imprimeSaldo(conta ,listaPessoa,path);
	}

	//calcular o total de dinheiro adquirido nas taxas e mostrar o valor que é cobrado em cada transferencia;*

	public static void totalArrecadado(ArrayList<Saque> listaSaque,ArrayList<Deposito> listaDeposito,ArrayList<Transferencia> listaTransferencia,String path) {
		double taxaSaque = 0.10;
		double taxaDeposito = 0.10;
		double taxaTransferencia = taxaSaque + taxaDeposito;
		double arrecadSaque = listaSaque.size()*taxaSaque;
		double arrecadDeposito = listaDeposito.size()*taxaDeposito;

		double arrecadTransferencia = listaTransferencia.size()/2*taxaTransferencia;
		double total = arrecadSaque + arrecadDeposito + arrecadTransferencia;

		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String saqueFormatada = formatoMoeda.format(taxaSaque);
		String depositoFormatada = formatoMoeda.format(taxaDeposito);
		String transferenciaFormatada = formatoMoeda.format(taxaTransferencia);
		String totalFormatada = formatoMoeda.format(total);

		System.out.println("Com as taxas de: \n" + saqueFormatada + " para saques \n" + depositoFormatada + " para Depósitos \n" + transferenciaFormatada + " para Transferências,");
		System.out.println("\n e com: " + listaSaque.size() + " Saques, " + listaDeposito.size() + " Depositos e " +  listaTransferencia.size() + " Transferências,\n foi arrecadado o total de " + totalFormatada + " atualmente.");
		ImprimeRelatorio.imprimeTotalArrecadado(saqueFormatada,depositoFormatada,transferenciaFormatada,listaSaque.size(),listaDeposito.size(),listaTransferencia.size(),totalFormatada,path);
	}
	public static void relatorioClientes(Map <String, Pessoa> listaPessoa,Map <String, Conta> listaConta,String path) {
		ArrayList<Conta> contasAtuais = new ArrayList<>(listaConta.values());
		ArrayList<String> relatorio = new ArrayList<>();
		relatorio.add("-----------RELATÓRIO DE CLIENTES-----------");
		relatorio.add("-------Nome | CPF | Número da Agência------");
	
		for (Conta conta : contasAtuais) {
			String cpf = conta.getCpf();
			String numAgencia = Integer.toString(conta.getNumeroAgencia());
			String nome = null;
	
			for (Pessoa pessoa : listaPessoa.values()) {
				if (pessoa.getCpf().equals(cpf)) {
					nome = pessoa.getNome();
					break;
				}
			}
	
			if (nome != null) {
				relatorio.add(nome + ";" + cpf + ";" + numAgencia);
			} else {
				System.out.println("Nome da conta de CPF: " + cpf + " não encontrado.");
			}
			ImprimeRelatorio.relatorioClientes(relatorio,path);
		}
	
		Collections.sort(relatorio);
		for (String linha : relatorio) {
			System.out.println(linha);
		}
	}


	public int contarContas (int numeroAgencia , Map <String, Conta> listaConta,String path) {
		int numContas = 0;
		for (Conta conta: listaConta.values()) {
			if(conta.getNumeroAgencia() == numeroAgencia) {
				numContas+=1;
				
			}
				
		}ImprimeRelatorio.imprimeTotalDeContasBanco(numContas,path);
		return numContas;

	}
	public double calcCapital(Map <String, Conta> listaConta,String path) {
        double totalValor = 0;

            for (Conta conta : listaConta.values()) {
                double saldoConta = conta.getSaldo();
                totalValor = totalValor + saldoConta;

        }
		ImprimeRelatorio.imprimeCalcCapital(totalValor, path);
            return totalValor;
    }


	public static void calcularRendimento(Scanner sc, String path) {
		LocalDate hoje = LocalDate.now();
		LocalDate dataFinal = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean continuar = true;
		
		
		while (continuar) {
			System.out.println("\n------------Relatório de Rendimento da poupança------------\n");
			System.out.println("1 - Adicionar data\n2 - Adicionar dias");
			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:

				System.out.println("\nDigite o dia: DD");
				int dia = sc.nextInt();
				if (dia < 1 || dia > 31) {
					System.out.println("\nVocê digitou um dia inválido. Tente novamente\n");
					continue;
				}
				System.out.println("Digite o mês: MM"); 
				int mes = sc.nextInt();
				if (mes < 1 || mes > 12) {
					System.out.println("\nVocê digitou um mês inválido. Tente novamente\n");
					continue;
				}
				System.out.println("Digite o ano: AAAA");
				int ano = sc.nextInt();
				dataFinal = LocalDate.of(ano, mes, dia);
				break;
				
			case 2:

				System.out.println("\nEscreva quantos dias você deseja deixar o seu dinheiro rendendo na poupança");
				int diasRendendo = sc.nextInt();
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
			
			sc.nextLine();
			System.out.println("Seu plano é que a poupança renda até o dia " + dataFinal.format(formatter) + "? S/N");
			String confirmacao = sc.nextLine();
			if (confirmacao.equalsIgnoreCase("S")) {
				break;
			}
			if (confirmacao.equalsIgnoreCase("N")) {
				continue;
			}
			continuar = false;
		}
		System.out.println("\nDigite o valor em reais que deseja simular: ");
		double valorSimulado = sc.nextDouble();
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
			ImprimeRelatorio.imprimeCalcRendimentos(hoje, dataFinal,jurosMensal,jurosGanhos,valorSimulado ,path);
	}






}

