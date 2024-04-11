package project.entities.conta;

import java.time.LocalDate;

import project.enums.TipoContaENUM;

public abstract class Conta {
	protected String cpf;
	protected int numeroDaConta;
	protected TipoContaENUM tipoConta;
	protected double saldo;
	protected LocalDate dataCriacao;
	
	public Conta(String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao) {
		super();
		this.cpf = cpf;
		this.numeroDaConta = numeroDaConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
		this.dataCriacao = dataCriacao;
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
