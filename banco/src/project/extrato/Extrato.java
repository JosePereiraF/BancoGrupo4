package project.extrato;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import project.entities.conta.Conta;

public class Extrato { //Sugestão: Mudar o nome da classe
	private String cpf;
	private ArrayList<Saque> saques;
	private Deposito depositos;
	private ArrayList<Transferencia> transferencias;
	
	
	public static HashMap<String, Extrato> lista_extrato = new HashMap<>();
	public static ArrayList<Deposito> lista_depositos = new ArrayList<>();
	public static ArrayList<Saque> lista_saques = new ArrayList<>();
	public static ArrayList<Transferencia> lista_transferencia = new ArrayList<>();
	//TODO montar uma lista de saques depositos e transferencias e criar um metodo que cria o hashmap depois que a pessoa pedir o extrato
	
	
	
	
	
	
	//possivel problema como estamos trabalhando com um txt e estou pretendendo nao salvar o arquivo
	//Quando eu puxar o arquivo eu posso ter problemas sobre nao existir o extrato pois as conta
	//ja estao criadas no banco e isso pode dar problema pq estou pensando em colocar para criar o extrato
	// quando a conta for criada
	
	

	public Extrato(String cpf, ArrayList<Saque> saques, Deposito depositos, ArrayList<Transferencia> transferencias) {
		super();
		this.cpf = cpf;
		this.saques = saques;
		this.depositos = depositos;
		this.transferencias = transferencias;
	}
	public Extrato() {
		super();
	}




	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Saque> getSaques() {
		return saques;
	}

	public void setSaques(ArrayList<Saque> saques) {
		this.saques = saques;
	}

	

	public Deposito getDepositos() {
		return depositos;
	}

	public void setDepositos(Deposito depositos) {
		this.depositos = depositos;
	}

	public ArrayList<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(ArrayList<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}

	public HashMap<String, Extrato> getLista_extrato() {
		return lista_extrato;
	}

	public void setLista_extrato(HashMap<String, Extrato> lista_extrato) {
		this.lista_extrato = lista_extrato;
	}
	

	@Override
	public String toString() {
		return "Extrato [cpf=" + cpf + ", saques=" + saques + ", depositos=" + depositos + ", transferencias="
				+ transferencias + ", lista_extrato=" + lista_extrato + "]";
	}

//	public void cria_extrato(Conta conta) {
//		ArrayList<Saque> saques = new ArrayList<>();
//		Deposito depositos = new Deposito();
//		ArrayList<Transferencia> transferencias = new ArrayList<>();
//		Deposito d = new Deposito(conta,50.00,LocalDateTime.now(),conta.getCpf());
//		
//		lista_depositos.add(depositos);
//		
//	}
	
	public void saque(Conta conta) {
		double valor;
		double taxa = 0.10;
		Scanner sc = new Scanner(System.in);
		Extrato ex = lista_extrato.get(conta.getCpf());
		
		System.out.println("O seu saldo é:\t\t R$"+conta.getSaldo());
		System.out.println("A cada Saque será descontada uma taxa de R$0,10");
		System.out.println("\nDigite o valor que você deseja sacar");
		valor = sc.nextDouble();
		System.out.println("Valor do saque:\t\t R$" + valor +"\nValor da taxa:\t\t R$" + taxa 
				+ "\nValor sacado:\t\t R$"+(valor-taxa));
		
		Saque saque = new Saque(conta,-(valor+taxa),LocalDateTime.now(),conta.getCpf(),taxa);
		lista_saques.add(saque);
		conta.setSaldo(conta.getSaldo()-(valor+taxa));
		System.out.println("Saldo: \t\t\t R$" + conta.getSaldo());
		System.out.println("Ação realizada com sucesso\n");

		
	}
	public void deposito(Conta conta) {
		
		double valor;
		double taxa = 0.10;
		Scanner sc = new Scanner(System.in);
		Extrato ex = lista_extrato.get(conta.getCpf());
				
		System.out.println(lista_extrato.get(conta.getCpf())); //TODO está retornando NULL
		
		
		
		System.out.println("A cada depósito será descontada uma taxa de R$0,10");
		System.out.println("\nDigite o valor que você deseja despositar:");
		valor = sc.nextDouble();
		System.out.println("Valor do depósito:\t R$" + valor +"\nValor da taxa:\t\t R$" + taxa 
				+ "\nValor depositado:\t R$"+(valor-taxa));
		Deposito d = new Deposito(conta,(valor-taxa),LocalDateTime.now(),conta.getCpf(),taxa);
		//ex.getDepositos().add(d);
		conta.setSaldo(conta.getSaldo()+(valor-taxa));
		lista_depositos.add(d);//funcionou
		System.out.println("Saldo: \t\t\t R$" + conta.getSaldo());
		System.out.println("Ação realizada com sucesso\n");

	}
	
	public void transferencia(Conta contaOrigem ,Conta contaDestino ) {
		double valor;
		int tentativa=0; // Isso está sendo usado?
		Scanner sc = new Scanner(System.in);
		double taxa = 0.20;
	
		System.out.println("Seu saldo é \t\t R$" + contaOrigem.getSaldo()); 
		System.out.println("A cada transferência será descontado uma taxa de R$0,20.");	
		System.out.println("Digite o valor que você deseja trasnferir");
		valor = sc.nextDouble();
		// System.out.println("Digite o número da conta que deseja tranferir"); TODO
//		String origem, String destino, double valor, LocalDateTime hora, String cpf
		
		
		Transferencia origem = new Transferencia(contaOrigem.getNumeroDaConta(),contaDestino.getNumeroDaConta(),-valor,LocalDateTime.now(),contaOrigem.getCpf(),taxa);
		Transferencia destino = new Transferencia(contaDestino.getNumeroDaConta(),contaOrigem.getNumeroDaConta(),+valor,LocalDateTime.now(),contaDestino.getCpf(),0);
		lista_transferencia.add(origem);
		lista_transferencia.add(destino);
		contaOrigem.setSaldo(contaOrigem.getSaldo()-(valor+taxa));
		contaDestino.setSaldo(contaDestino.getSaldo()+valor);
		
		System.out.println("Ação realizada com sucesso");
		System.out.println("Dados do pagador \n");
		System.out.println("Nome: ");//Inserir nome 
		System.out.println("CPF: " + contaOrigem.getCpf());
		System.out.println("Agência: ");//Inserir Agência
		System.out.println("Tipo de conta: " + contaOrigem.getTipoConta());		
		System.out.println("Número da conta: " + contaOrigem.getNumeroDaConta() + "\n");		
		
		System.out.println("Dados do recebedor \n");
		System.out.println("Nome: ");//Inserir nome 
		System.out.println("CPF: " + contaDestino.getCpf());
		System.out.println("Agência: ");//Inserir Agência	
		System.out.println("Tipo de conta: " + contaDestino.getTipoConta());		
		System.out.println("Número da conta: " + contaDestino.getNumeroDaConta() + "\n");
		
		System.out.println("Valor da tranferêcia: \t\t R$" + (valor + taxa));
		System.out.println("Valor da taxa: \t\t\t R$" + taxa);
		System.out.println("Valor Transferido: \t\t R$" + (valor - taxa));
	}
	public void mostrar_extrato(Conta conta) {
		
		System.out.println("Extrato Bancário \t\t Agência: NULL \tCPF: " + conta.getCpf());
		System.out.println("Nome: ");// Associar nome
		System.out.println("\nSAQUES: \n");
		for(int i = 0 ; i<lista_saques.size();i++) {
			if(conta.getCpf().equals(lista_saques.get(i).getCpf())) {
				System.out.println("Data: " + lista_saques.get(i).getHoraSaque()+ "\nValor:\t\t\t R$" + lista_saques.get(i).getValor() + "\n");
			}
		}
		
		System.out.println("\nDEPOSITOS: \n");
		for(int j = 0 ; j<lista_depositos.size();j++) {
			if(conta.getCpf().equals(lista_depositos.get(j).getCpf())) {
				System.out.println("Data: " + lista_depositos.get(j).getHora() + "\nValor:\t\t\t R$" + lista_depositos.get(j).getValor()+ "\n");
			}
		}
		
		System.out.println("\nTRANSFERÊCIAS: \n");
		for(int k = 0 ; k<lista_transferencia.size();k++) {
			if(conta.getCpf().equals(lista_transferencia.get(k).getCpf())) {
				System.out.println("Data: " + lista_transferencia.get(k).getHora() + "\nConta Pagante: "+lista_transferencia.get(k).getOrigem()+ "\nConta Recebedor: "+ lista_transferencia.get(k).getDestino()+ //TODO O lista_transferencia.get(k).getDestino() está retornando o valor do numeroDaConta do pagante ao ivés do recebedor
						" "+ "\nValor da transferência: \tR$" + lista_transferencia.get(k).getValor()+ "\nTaxa:\t\t\t R$" + lista_transferencia.get(k).getTaxa() + "\n");
				
			}
		}	
	}
}
