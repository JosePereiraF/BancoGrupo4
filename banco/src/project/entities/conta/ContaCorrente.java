package project.entities.conta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import project.enums.TipoContaENUM;

public class ContaCorrente extends Conta{

	public HashMap<String,ContaCorrente>  lista_contaCorrente = new HashMap();
	
	public ContaCorrente(String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao) {
		super(cpf, numeroDaConta, tipoConta, saldo, dataCriacao);
	}

	@Override
	public String toString() {
		return "ContaCorrente [cpf=" + cpf + ", numeroDaConta=" + numeroDaConta + ", tipoConta=" + tipoConta
				+ ", saldo=" + saldo + ", dataCriacao=" + dataCriacao + "]";
	}
	
	
	
	public void criarContaCorrente(String key) {
		//cpf vai ser a key
		//numeroDaConta -aleatorizar
		//Tipo conta sempre TipoContaENUM.CONTACORRENTE
		//saldo -sempre iniciar em 0
		//diaCriacao vai sempre no instante (LocalDate.now)
		
		/*Sugestões: Alterar o numeroDaConta para String ao invés de Int
		* diaCriacao ser LocalDate ser LocalDateTime
		* Segundo o texto do projeto a conta deve ter um atributo identificador da agência.
		acho que seria ninteressante apenas criarmos 
		* Seria viável colocar o HashMap na classe Conta?
		*/ 
		//metodo para gerar numeros da conta
		//metodo para verificar se os numeros estao validos
//		boolean numeroDiferente= false;
//		
//		while(numeroDiferente == false) {
//			verificaConta(numerogerado)
//		}
//		for(int i - 0 ; i<numeros_gerados.size();i++) {
//			if(numeros_gerados.get(i).getNumeros.equals(geradoAgora)) {
//				
//			}
//		}
//			
//		List<String> numeros_gerados = new ArrayList<>();
		
		Random random = new Random();
		int numeroDaContaGerado = random.nextInt(20);
		//É necessário cirar um método para ver se numeroDaContaGerado 
		// já existe e se pertence a outra conta um Numero da conta igual
		LocalDate diaCriacao = LocalDate.now();
		
		
		ContaCorrente contaCorrente = new ContaCorrente(key,numeroDaContaGerado,TipoContaENUM.CONTACORRENTE,0.0,diaCriacao);
		lista_contaCorrente.put(key, contaCorrente);
	}

	
}
