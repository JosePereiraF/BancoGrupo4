package project.entities.conta;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import project.enums.TipoContaENUM;

public abstract class Conta {
	protected String cpf;
	protected int numeroDaConta;
	protected TipoContaENUM tipoConta;
	protected double saldo;
	protected LocalDate dataCriacao;
	protected int numeroAgencia;

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public static HashMap<String, Conta> listaConta = new HashMap<>();

	public int gerarNumeroDaConta() {
		int numeroDaConta = 0;
		boolean criacao = false;
		
		do {
			Random random = new Random();
			int numeroGerado = random.nextInt();
			if (confereNumeroDaConta(numeroGerado) == true || numeroGerado < 0) {
				
			} else {
				numeroDaConta = numeroGerado;
				criacao = true;
			}
		} while (criacao == false);
		return numeroDaConta;
	}

	public boolean confereNumeroDaConta(int numeroGerado) {
		for (Conta conta : listaConta.values()) {
			if (conta.getNumeroDaConta() == numeroGerado) {
				return true;
			}
		}
		return false;
	}

	public void criarConta(String cpf) { //Truncar o numeroDaConta pra String
		Scanner sc = new Scanner(System.in);
		TipoContaENUM tipo = null;
		int numeroAgencia = 0;
		do {
			System.out.println("Insira que tipo de conta você deseja criar: \n1-Conta Corrente \n2-Conta Poupança");

			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				tipo = TipoContaENUM.CONTACORRENTE;
				System.out.println("Você escolheu Conta Corrente");
				break;
			case 2:
				tipo = TipoContaENUM.CONTAPOUPANCA;
				System.out.println("Você escolheu Conta Poupança");
				break;
			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				continue;
			}
		} while (tipo == null);
		LocalDate diaCriacao = LocalDate.now();
		sc.close();

		int NumeroDaContaGerado = gerarNumeroDaConta();
		if (tipo == TipoContaENUM.CONTACORRENTE) {

			ContaCorrente conta = new ContaCorrente(cpf, NumeroDaContaGerado, tipo, 0.0, diaCriacao,numeroAgencia);
			System.out.println("Você criou a conta com sucesso");
			listaConta.put(cpf, conta);
		}
		if (tipo == TipoContaENUM.CONTAPOUPANCA) {
			ContaCorrente conta = new ContaCorrente(cpf, NumeroDaContaGerado, tipo, 0.0, diaCriacao,numeroAgencia);
			System.out.println("Você criou a conta com sucesso");
			listaConta.put(cpf, conta);
		}
	}

	public Conta(String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao, int numeroAgencia) {
		super();
		this.cpf = cpf;
		this.numeroDaConta = numeroDaConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
		this.dataCriacao = dataCriacao;
		this.numeroAgencia = numeroAgencia;
	}

	public Conta() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(int numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public TipoContaENUM getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaENUM tipoConta) {
		this.tipoConta = tipoConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Conta [cpf=" + cpf + ", numeroDaConta=" + numeroDaConta + ", tipoConta=" + tipoConta + ", saldo="
				+ saldo + ", dataCriacao=" + dataCriacao + "]";
	}

}
