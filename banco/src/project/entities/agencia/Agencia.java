package project.entities.agencia;

import java.util.HashMap;
import java.util.Scanner;

public class Agencia {
	private String nome;
	private int numeroAgencia;
	
	public HashMap<Integer,Agencia> Lista_Agencias = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	
	public Agencia(String nome, int numeroAgencia) {
		super();
		this.nome = nome;
		this.numeroAgencia = numeroAgencia;
	}
	
	
	
	public Agencia() {
	}

	

	public String getNome() {
		return nome;
	}



	public int getNumeroAgencia() {
		return numeroAgencia;
	}
	
	@Override
	public String toString() {
		return "Agencia [nome=" + nome + ", numeroAgencia=" + numeroAgencia + "]";
	}

	//nesse caso, não vai ter uma key pois ela em sí vai ser usado como chave.
	public void criaAgencia() {
		int nAgencia;
		String nomeDigitado;
		
		while (true) {
			System.out.println("Digite o numero da agência  que deseja criar: ");
			nAgencia = sc.nextInt();
			
			if (Lista_Agencias.containsKey(nAgencia)) {
				System.out.println("O número de Agência informado já é registrado.");
			} else {
				sc.nextLine();
				System.out.println("Digite o nome da agência: ");
				nomeDigitado = sc.nextLine();
			
				Agencia agencia = new Agencia(nomeDigitado, nAgencia);
				Lista_Agencias.put(nAgencia, agencia);
				break;
			}
		}
	}
	//consultar Agencias adicionadas no Hashmap
	public void consultarAgencias() {
        System.out.println("Agências cadastradas:");

        for (Agencia agencia : Lista_Agencias.values()) {
            System.out.println("Nome: " + agencia.getNome() + ", Número da Agência: " + agencia.getNumeroAgencia());
        }
	}
}
