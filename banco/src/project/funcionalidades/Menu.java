package project.funcionalidades;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import project.entities.Pessoa;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.entities.funcionario.Diretor;
import project.entities.funcionario.Gerente;
import project.entities.funcionario.Presidente;
import project.enums.TipoContaENUM;
import project.excecoes.ExcecaoTransferencias;
import project.extrato.Deposito;
import project.extrato.Extrato;
import project.extrato.Saque;
import project.extrato.Transferencia;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Scanner scint = new Scanner(System.in);
	Conta conta = new ContaCorrente();
	Extrato ex = new Extrato();
	public static void menu(Scanner sc,Map<String,Pessoa> listaPessoa,Map<String, Conta> listaConta,ArrayList<Saque> saques,ArrayList<Deposito> depositos,ArrayList<Transferencia> transferencias) throws IOException, ExcecaoTransferencias {
		
		String loginDigitado;
		String senhaDigitada;
		String opcao = "";
		do {
		System.out.println("Bem vindo ao menu");
		System.out.println("\nDigite seu login");
		loginDigitado= sc.nextLine();

		if (listaPessoa.get(loginDigitado)!= null) {
			System.out.println("Digite sua senha");
			senhaDigitada = sc.nextLine();
			if (listaPessoa.get(loginDigitado).getSenha().equals(senhaDigitada)) {
				if (listaPessoa.get(loginDigitado).getClass()==Cliente.class) {
					MenuCliente.menuCliente((Cliente) listaPessoa.get(loginDigitado), sc ,listaPessoa , listaConta,saques , depositos,transferencias);
					
				}else if(listaPessoa.get(loginDigitado).getClass()==Diretor.class){
					MenuDiretor.menuDiretor((Diretor)listaPessoa.get(loginDigitado), sc, listaPessoa, listaConta, saques, depositos, transferencias);

				}else if (listaPessoa.get(loginDigitado).getClass()==Gerente.class) {

					MenuGerente.menuGerente((Gerente)listaPessoa.get(loginDigitado), sc, listaPessoa, listaConta, saques, depositos, transferencias);
					
				}else{
					MenuPresidente.menuPresidente((Presidente)listaPessoa.get(loginDigitado), sc, listaPessoa, listaConta, saques, depositos, transferencias);
					
				}
				
			}
		}


			
			System.out.println("Login ou senha erradas quer tentar novamente");
			opcao = sc.nextLine();
		} while (!opcao.equalsIgnoreCase("s"));

	}
	
}
