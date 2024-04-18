package project.entities.conta;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		return cpf+ ";"+numeroDaConta+";"+tipoConta+";"+saldo+";"+dataCriacao+";"+numeroAgencia;
		
		
	}
	

}
