package project.funcionalidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import project.entities.Pessoa;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.entities.funcionario.Diretor;
import project.entities.funcionario.Funcionario;
import project.entities.funcionario.Gerente;
import project.entities.funcionario.Presidente;
import project.enums.CargoENUM;
import project.enums.TipoContaENUM;

public class InOutUtils {

	public static void escreve_pessoa(List<Pessoa> lista) throws IOException {
		// carregar esse metodo sempre que add alguem no banco de dados para sobrepor a
		// lista antiga
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//usuarios.txt", true));
		// modificar o path para uma variavel talvez ou deixar um comentario sobre o
		// path
		String linha = "]";
		for (int i = 0; i < lista.size(); i++) {
			buffWrite.append(lista.get(i).toString() + "\n");

		}
		buffWrite.close();
	}

	public static void escreve_conta(List<Conta> contas) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//contas.txt", true));// criar um txt
		String linha = "";
		for (Conta conta : contas) {
			buffWrite.append(conta.toString()+"\n");
		}

		buffWrite.close();
	}

	public static void leitor_pessoa() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("//home/administrador//Documents//usuarios.txt"));
		String linha = "";

		while ((linha = buffRead.readLine()) != null) {
			String pessoas[] = linha.split(";");
			if (pessoas[3].equalsIgnoreCase(CargoENUM.GERENTE.name())) {
				Funcionario g = new Gerente(pessoas[0], pessoas[1], // cpf
						pessoas[2], Funcionario.criar_cargo(pessoas[3]), Integer.parseInt(pessoas[4]));
				Funcionario.lista_funcionario.put(pessoas[1], g);
				Pessoa.lista_pessoa.add(g);
			} else if (pessoas[3].equalsIgnoreCase(CargoENUM.DIRETOR.name())) {
				Funcionario d = new Diretor(pessoas[0], pessoas[1], // cpf
						pessoas[2], Funcionario.criar_cargo(pessoas[3]));
				Funcionario.lista_funcionario.put(pessoas[1], d);
				Pessoa.lista_pessoa.add(d);
			} else if (pessoas[3].equalsIgnoreCase(CargoENUM.PRESIDENTE.name())) {
				Funcionario p = new Presidente(pessoas[0], pessoas[1], // cpf
						pessoas[2], Funcionario.criar_cargo(pessoas[3]));
				Funcionario.lista_funcionario.put(pessoas[1], p);
				Pessoa.lista_pessoa.add(p);
			} else {
				Cliente c = new Cliente(pessoas[0], pessoas[1], pessoas[2], pessoas[3]);
				Cliente.lista_cliente.put(pessoas[1], c);
				Pessoa.lista_pessoa.add(c);
			}
		}

		buffRead.close();

	}

	public static void leitor_contas() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("//home/administrador//Documents//contas.txt"));
		String linha = ";";
		while ((linha = buffRead.readLine()) != null) {
			
			if (linha != null) {
				String[] contas = linha.split(";");
				// String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo,
				// LocalDate dataCriacao, int numeroAgencia
				if (contas[2].equalsIgnoreCase(TipoContaENUM.CONTACORRENTE.name())) {
					Conta c = new ContaCorrente(contas[0], Integer.parseInt(contas[1]), TipoContaENUM.CONTACORRENTE,
							Double.parseDouble(contas[3]), LocalDate.parse(contas[4]), Integer.parseInt(contas[5]));
					Conta.lista_contas.add(c);
					Conta.listaConta.put(contas[0], c);
				}else {
					Conta c = new ContaCorrente(contas[0], Integer.parseInt(contas[1]), TipoContaENUM.CONTAPOUPANCA,
							Double.parseDouble(contas[3]), LocalDate.parse(contas[4]), Integer.parseInt(contas[5]));
					Conta.lista_contas.add(c);
					Conta.listaConta.put(contas[0], c);
				}
			} 
		}
		buffRead.close();

	}

}
