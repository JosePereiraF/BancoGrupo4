package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import project.entities.Pessoa;
import project.entities.agencia.Agencia;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.entities.funcionario.Funcionario;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.*;
import project.extrato.Extrato;
import project.extrato.Saque;
import project.funcionalidades.InOutUtils;
import project.funcionalidades.Menu;

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
		Map <String, Conta> listaContas = InOutUtils.leitorConta();
		ArrayList<Deposito> depositos = InOutUtils.leitorDeposito();
		Map<String,Pessoa> listaPessoas = InOutUtils.leitorPessoa();
		ArrayList<Saque> saques = InOutUtils.leitorSaque();
		InOutUtils.leitorTransferencia();
		ArrayList<Transferencia>transferencias = InOutUtils.leitorTransferencia();
		Scanner sc = new Scanner(System.in);

		Menu.menu(sc, listaPessoas, listaContas, saques, depositos, transferencias);

		InOutUtils.escreveConta(listaContas);
		InOutUtils.escreveDeposito(depositos);
		InOutUtils.escrevePessoa(listaPessoas);
		InOutUtils.escreveSaque(saques);
		InOutUtils.escreveTransferencia(transferencias);






	}

	
	



//	try {
//		contap.calcularRendimento();			
//	} catch (Exception e) {
//		System.err.println("Você digitou o dia errado em relação ao mês!");
//	}


}
