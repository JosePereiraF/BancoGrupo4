package project;

import java.io.IOException;

import project.entities.agencia.Agencia;
import project.excecoes.ExcecaoTransferencias;
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
		InOutUtils.leitorConta();
		InOutUtils.leitorDeposito();
		InOutUtils.leitorPessoa();
		InOutUtils.leitorSaque();
		InOutUtils.leitorTransferencia();
		Agencia.consultarAgencias();
		
		








	}

	
	



//	try {
//		contap.calcularRendimento();			
//	} catch (Exception e) {
//		System.err.println("Você digitou o dia errado em relação ao mês!");
//	}


}
