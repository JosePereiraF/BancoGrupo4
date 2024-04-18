package project.entities.funcionario;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import project.entities.Pessoa;
import project.entities.conta.Conta;
import project.enums.CargoENUM;

public class Diretor extends Funcionario{

	
	public Object relatorioClientes;
	public Diretor(String nome, String cpf, String senha, CargoENUM cargo) {
		super(nome, cpf, senha, cargo);
	}

	public Diretor() {
		super();
	}
	@Override
	public String toString() {
		
		return nome+ ";"+ cpf+";"+senha+";"+ cargo;
	}
	public static void relatorioClientes() {
		ArrayList<Conta> contasAtuais = new ArrayList<>(Conta.listaConta.values());
		ArrayList<String> relatorio = new ArrayList<>();
		relatorio.add("-----------RELATÓRIO DE CLIENTES-----------");
		relatorio.add("-------Nome | CPF | Número da Agência------");
	
		for (Conta conta : contasAtuais) {
			String cpf = conta.getCpf();
			String numAgencia = Integer.toString(conta.getNumeroAgencia());
			String nome = null;
	
			for (Pessoa pessoa : Pessoa.lista_pessoa) {
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
		}
	
		Collections.sort(relatorio);
		for (String linha : relatorio) {
			System.out.println(linha);
		}
	}


	
	
	
	
}
