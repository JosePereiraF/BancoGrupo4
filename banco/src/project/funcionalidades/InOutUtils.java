package project.funcionalidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import project.entities.Pessoa;
import project.entities.agencia.Agencia;
import project.entities.cliente.Cliente;
import project.entities.conta.Conta;
import project.entities.conta.ContaCorrente;
import project.entities.conta.ContaPoupanca;
import project.entities.funcionario.Diretor;
import project.entities.funcionario.Funcionario;
import project.entities.funcionario.Gerente;
import project.entities.funcionario.Presidente;
import project.enums.CargoENUM;
import project.enums.TipoContaENUM;
import project.extrato.Deposito;
import project.extrato.Extrato;
import project.extrato.Saque;
import project.extrato.Transferencia;

public class InOutUtils {

	public static void escrevePessoa(List<Pessoa> lista) throws IOException {
		// carregar esse metodo sempre que add alguem no banco de dados para sobrepor a
		// lista antiga
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//usuarios.txt", false));
		// modificar o path para uma variavel talvez ou deixar um comentario sobre o
		// path
		String linha = ";";
		for (int i = 0; i < lista.size(); i++) {
			buffWrite.append(lista.get(i).toString() + "\n");

		}
		buffWrite.close();
	}

	public static void escreveConta(List<Conta> contas) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//contas.txt",false));// criar um txt
		String linha = ";";
		for (Conta conta : contas) {
			buffWrite.append(conta.toString()+"\n");
		}

		buffWrite.close();
	}
	public static void escreveSaque(Saque saque) throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//saques.txt",true));// criar um txt
		String linha = ";";
		
			buffWrite.append(saque.toString()+"\n");
		

		buffWrite.close();
	}
	public static void escreveDeposito(Deposito deposito) throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//deposito.txt",true));// criar um txt
		String linha = ";";
		
			buffWrite.append(deposito.toString()+"\n");
		
		buffWrite.close();
	}
	
	public static void escreveTransferencia(Transferencia transferencia) throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//transferencia.txt",true));// criar um txt
		String linha = ";";
			buffWrite.append(transferencia.toString()+"\n");
		
		buffWrite.close();
	}
	public static void escreveAgencia(Agencia a) throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter("//home/administrador//Documents//agencia.txt",true));
				String linha = ";";
			buffWrite.append(a.toString()+"\n");
		
		buffWrite.close();
	}
	public static void leitorAgencia() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("//home/administrador//Documents//agencia.txt"));
		String linha = ";";

		while ((linha = buffRead.readLine()) != null) {
			String agencias[] = linha.split(";");
			Agencia a = new Agencia(
				agencias[0],
				Integer.parseInt(agencias[1])
			);
			Agencia.Lista_Agencias.put(Integer.parseInt(agencias[1]), a); 
		}

		buffRead.close();

	}
	
	public static void leitorTransferencia() throws IOException{
		BufferedReader buffRead = new BufferedReader(new FileReader("//home/administrador//Documents//transferencia.txt"));
		String linha = ";";
		while ((linha = buffRead.readLine()) != null) {
			
			if (linha != null) {
				// String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo,
				// LocalDate dataCriacao, int numeroAgencia
				String[] transferencia = linha.split(";");
				if (transferencia[2].equalsIgnoreCase(TipoContaENUM.CONTACORRENTE.name()) && transferencia[8].equalsIgnoreCase(TipoContaENUM.CONTACORRENTE.name()))
				{
					Conta cOrigem = new ContaCorrente(transferencia[0],
							Integer.parseInt(transferencia[1]),
							TipoContaENUM.CONTACORRENTE,
							Double.parseDouble(transferencia[3]),
							LocalDate.parse(transferencia[4]),
							Integer.parseInt(transferencia[5]));
					//Conta saque, double valor, LocalDateTime horaSaque, String cpf, double taxa
					Conta cDestino = new ContaCorrente (transferencia[6],
							Integer.parseInt(transferencia[7]),
							TipoContaENUM.CONTACORRENTE,
							Double.parseDouble(transferencia[9]),
							LocalDate.parse(transferencia[10]),
							Integer.parseInt(transferencia[11]));
					// double valor, LocalDateTime hora, String cpf, double taxa
					Transferencia t = new Transferencia(
							cOrigem,
							cDestino,
							Double.parseDouble(transferencia[12]),
							LocalDateTime.parse(transferencia[13]),
							transferencia[14],
							Double.parseDouble(transferencia[14])
							);
							Extrato.lista_transferencia.add(t);
				}else if(transferencia[2].equalsIgnoreCase(TipoContaENUM.CONTACORRENTE.name()) && transferencia[8].equalsIgnoreCase(TipoContaENUM.CONTAPOUPANCA.name()))
				{
					Conta cOrigem = new ContaCorrente(transferencia[0],
							Integer.parseInt(transferencia[1]),
							TipoContaENUM.CONTACORRENTE,
							Double.parseDouble(transferencia[3]),
							LocalDate.parse(transferencia[4]),
							Integer.parseInt(transferencia[5]));
					//Conta saque, double valor, LocalDateTime horaSaque, String cpf, double taxa
					Conta cDestino = new ContaPoupanca (transferencia[6],
							Integer.parseInt(transferencia[7]),
							TipoContaENUM.CONTAPOUPANCA,
							Double.parseDouble(transferencia[9]),
							LocalDate.parse(transferencia[10]),
							Integer.parseInt(transferencia[11]));
					// double valor, LocalDateTime hora, String cpf, double taxa
					Transferencia t = new Transferencia(
							cOrigem,
							cDestino,
							Double.parseDouble(transferencia[12]),
							LocalDateTime.parse(transferencia[13]),
							transferencia[14],
							Double.parseDouble(transferencia[14])
							);
							Extrato.lista_transferencia.add(t);
				}else if(transferencia[2].equalsIgnoreCase(TipoContaENUM.CONTAPOUPANCA.name()) && transferencia[8].equalsIgnoreCase(TipoContaENUM.CONTAPOUPANCA.name())) 
				{
					Conta cOrigem = new ContaPoupanca(transferencia[0],
							Integer.parseInt(transferencia[1]),
							TipoContaENUM.CONTAPOUPANCA,
							Double.parseDouble(transferencia[3]),
							LocalDate.parse(transferencia[4]),
							Integer.parseInt(transferencia[5]));
					//Conta saque, double valor, LocalDateTime horaSaque, String cpf, double taxa
					Conta cDestino = new ContaPoupanca (transferencia[6],
							Integer.parseInt(transferencia[7]),
							TipoContaENUM.CONTAPOUPANCA,
							Double.parseDouble(transferencia[9]),
							LocalDate.parse(transferencia[10]),
							Integer.parseInt(transferencia[11]));
					// double valor, LocalDateTime hora, String cpf, double taxa
					Transferencia t = new Transferencia(
							cOrigem,
							cDestino,
							Double.parseDouble(transferencia[12]),
							LocalDateTime.parse(transferencia[13]),
							transferencia[14],
							Double.parseDouble(transferencia[14])
							);
							Extrato.lista_transferencia.add(t);
				}else if(transferencia[2].equalsIgnoreCase(TipoContaENUM.CONTAPOUPANCA.name()) && transferencia[8].equalsIgnoreCase(TipoContaENUM.CONTACORRENTE.name()))
				{
					Conta cOrigem = new ContaPoupanca(transferencia[0],
							Integer.parseInt(transferencia[1]),
							TipoContaENUM.CONTAPOUPANCA,
							Double.parseDouble(transferencia[3]),
							LocalDate.parse(transferencia[4]),
							Integer.parseInt(transferencia[5]));
					//Conta saque, double valor, LocalDateTime horaSaque, String cpf, double taxa
					Conta cDestino = new ContaCorrente (transferencia[6],
							Integer.parseInt(transferencia[7]),
							TipoContaENUM.CONTACORRENTE,
							Double.parseDouble(transferencia[9]),
							LocalDate.parse(transferencia[10]),
							Integer.parseInt(transferencia[11]));
					// double valor, LocalDateTime hora, String cpf, double taxa
					Transferencia t = new Transferencia(
							cOrigem,
							cDestino,
							Double.parseDouble(transferencia[12]),
							LocalDateTime.parse(transferencia[13]),
							transferencia[14],
							Double.parseDouble(transferencia[14])
							);
							Extrato.lista_transferencia.add(t);
				}

			} 
		}
		buffRead.close();

	}
		
		
	
	
	public static void leitorSaque() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("//home/administrador//Documents//saques.txt"));
		String linha = ";";
		while ((linha = buffRead.readLine()) != null) {
			
			if (linha != null) {
				String[] contas = linha.split(";");
				// String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo,
				// LocalDate dataCriacao, int numeroAgencia
				if (contas[2].equalsIgnoreCase(TipoContaENUM.CONTACORRENTE.name())) {
					Conta c = new ContaCorrente(contas[0], Integer.parseInt(contas[1]), TipoContaENUM.CONTACORRENTE,
							Double.parseDouble(contas[3]), LocalDate.parse(contas[4]), Integer.parseInt(contas[5]));
					//Conta saque, double valor, LocalDateTime horaSaque, String cpf, double taxa
					Saque saque = new Saque (
							c,
							Double.parseDouble(contas[6]),
							LocalDateTime.parse(contas[7]),
							contas[8],
							Double.parseDouble(contas[8])
							);
					Extrato.lista_saques.add(saque);
				}else {
					Conta c = new ContaCorrente(contas[0],
							Integer.parseInt(contas[1]),
							TipoContaENUM.CONTAPOUPANCA,
							Double.parseDouble(contas[3]),
							LocalDate.parse(contas[4]),
							Integer.parseInt(contas[5]));
					Saque saque = new Saque (
							c,
							Double.parseDouble(contas[6]),
							LocalDateTime.parse(contas[7]),
							contas[8],
							Double.parseDouble(contas[8])
							);
					Extrato.lista_saques.add(saque);
				}
			} 
		}
		buffRead.close();

	}
	
	public static void leitorDeposito() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("//home/administrador//Documents//deposito.txt"));
		String linha = ";";
		while ((linha = buffRead.readLine()) != null) {
			
			if (linha != null) {
				String[] contas = linha.split(";");
				// String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo,
				// LocalDate dataCriacao, int numeroAgencia
				if (contas[2].equalsIgnoreCase(TipoContaENUM.CONTACORRENTE.name())) {
					Conta c = new ContaCorrente(contas[0],
					 Integer.parseInt(contas[1]),
					  TipoContaENUM.CONTACORRENTE,
					  Double.parseDouble(contas[3]),
					   LocalDate.parse(contas[4]),
					    Integer.parseInt(contas[5]));
					//destino+":"+valor+":"+hora+":"+cpf+":"+taxa;
					Deposito deposito = new Deposito (
							c,
							Double.parseDouble(contas[6]),
							LocalDateTime.parse(contas[7]),
							contas[8],
							Double.parseDouble(contas[8])
							);
					Extrato.lista_depositos.add(deposito);
				}else {
					Conta c = new ContaCorrente(contas[0],
							Integer.parseInt(contas[1]),
							TipoContaENUM.CONTAPOUPANCA,
							Double.parseDouble(contas[3]),
							LocalDate.parse(contas[4]),
							Integer.parseInt(contas[5]));
					Deposito deposito = new Deposito (
							c,
							Double.parseDouble(contas[6]),
							LocalDateTime.parse(contas[7]),
							contas[8],
							Double.parseDouble(contas[8])
							);
					Extrato.lista_depositos.add(deposito);
				}
			} 
		}
		buffRead.close();

	}

	public static void leitorPessoa() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("//home/administrador//Documents//usuarios.txt"));
		String linha = ";";

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

	public static void leitorContas() throws IOException {
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
