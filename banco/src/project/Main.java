package project;

import java.io.IOException;

import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.funcionalidades.InOutUtils;

public class Main {

	public static void main(String[] args) throws IOException {
	//criar clientes e contas 
		Cliente cliente = new Cliente();
		Conta conta = new ContaCorrente();
		
		InOutUtils.leitor_pessoa();
		InOutUtils.leitor_contas();
		
		
//		Conta.criarConta("15798");
		System.out.println(Conta.listaConta.get("15798"));
		


	}
}
