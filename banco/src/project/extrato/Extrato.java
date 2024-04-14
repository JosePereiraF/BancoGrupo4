package project.extrato;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import project.entities.conta.Conta;

public class Extrato {
	private String cpf;
	private ArrayList<Saque> saques;
	private Deposito depositos;
	private ArrayList<Transferencia> transferencias;
	
	
	public static HashMap<String, Extrato> lista_extrato = new HashMap<>();
	public static ArrayList<Deposito> lista_depositos = new ArrayList<>();
	public static ArrayList<Saque> lista_saques = new ArrayList<>();
	public static ArrayList<Transferencia> lista_transferencia = new ArrayList<>();
	//montar uma lista de saques depositos e transferencias e criar um metodo que cria o hashmap depois que a pessoa pedir o extrato
	
	
	
	
	
	
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
		int opcao;
		double taxa = 0.10;
		Scanner sc = new Scanner(System.in);
		Extrato ex = lista_extrato.get(conta.getCpf());
		
		System.out.println("O seu saldo é: "+conta.getSaldo());
		
		System.out.println("\nQuando voce deseja sacar?");
		valor = sc.nextDouble();
		System.out.println("A cada saque será acrescido uma taxa de R$0,10. Valor final: "+(valor+taxa));
		Saque saque = new Saque(conta,-(valor+taxa),LocalDateTime.now(),conta.getCpf(),taxa);
		lista_saques.add(saque);
		conta.setSaldo(conta.getSaldo()-(valor+taxa));

		
	}
	public void deposito(Conta conta) {
		double valor;
		double taxa = 0.10;
		Scanner sc = new Scanner(System.in);
		Extrato ex = lista_extrato.get(conta.getCpf());
		
		System.out.println(lista_extrato.get(conta.getCpf()));
		System.out.println("Digite o valor que você deseja despositar:");
		valor = sc.nextDouble();
		System.out.println("A cada deposito será descontado uma taxa de R$0,10. Valor final: "+(valor-taxa));
		Deposito d = new Deposito(conta,(valor-taxa),LocalDateTime.now(),conta.getCpf(),taxa);
		//ex.getDepositos().add(d);
		conta.setSaldo(conta.getSaldo()+(valor-taxa));
		lista_depositos.add(d);//funcionou
		
	}
	
	public void transferencia(Conta contaOrigem ,Conta contaDestino ) {
		double valor;
		int tentativa=0;
		Scanner sc = new Scanner(System.in);
		double taxa = 0.20;
	
		System.out.println("Digite o valor que você deseja fazer a transferencia");
		valor = sc.nextDouble();
		System.out.println("A cada transferência será descontado uma taxa de R$0,20. Valor final: "+(valor+taxa));	
//		String origem, String destino, double valor, LocalDateTime hora, String cpf
		System.out.println("Transferencia realizada com sucesso");
		Transferencia origem = new Transferencia(contaOrigem.getNumeroDaConta(),contaDestino.getNumeroDaConta(),-valor,LocalDateTime.now(),contaOrigem.getCpf(),taxa);
		Transferencia destino = new Transferencia(contaDestino.getNumeroDaConta(),contaOrigem.getNumeroDaConta(),+valor,LocalDateTime.now(),contaDestino.getCpf(),0);
		lista_transferencia.add(origem);
		lista_transferencia.add(destino);
		contaOrigem.setSaldo(contaOrigem.getSaldo()-(valor+taxa));
		contaDestino.setSaldo(contaDestino.getSaldo()+valor);
				
				
			
			
	}
	public void mostrar_extrato(Conta conta) {
		for(int i = 0 ; i<lista_saques.size();i++) {
			if(conta.getCpf().equals(lista_saques.get(i).getCpf())) {
				System.out.println(lista_saques.get(i).getHoraSaque()+ " "+ lista_saques.get(i).getValor());
			}
		}
		for(int j = 0 ; j<lista_depositos.size();j++) {
			if(conta.getCpf().equals(lista_depositos.get(j).getCpf())) {
				System.out.println(lista_depositos.get(j).getHora()+ " "+lista_depositos.get(j).getValor());
			}
		}
		for(int k = 0 ; k<lista_transferencia.size();k++) {
			if(conta.getCpf().equals(lista_transferencia.get(k).getCpf())) {
				System.out.println(lista_transferencia.get(k).getOrigem()+ " "+ lista_transferencia.get(k).getDestino()+
						" "+ lista_transferencia.get(k).getValor());
				
			}
		}
		
	}
	
}
