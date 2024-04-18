package project.extrato;

import java.time.LocalDateTime;

import project.entities.conta.Conta;

public class Saque {
	
	private Conta saque;
	private double valor;
	private LocalDateTime horaSaque;
	private String cpf;
	private double taxa;
	public Saque(Conta saque, double valor, LocalDateTime horaSaque, String cpf, double taxa) {
		super();
		this.saque = saque;
		this.valor = valor;
		this.horaSaque = horaSaque;
		this.cpf = cpf;
		this.taxa = taxa;
	}
	public Saque() {
		super();
	}
	public Conta getSaque() {
		return saque;
	}
	public void setSaque(Conta saque) {
		this.saque = saque;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public LocalDateTime getHoraSaque() {
		return horaSaque;
	}
	
	@Override
	public String toString() {
		//Conta saque, double valor, LocalDateTime horaSaque, String cpf, double taxa
		return saque +";"+valor+";"+horaSaque+";"+cpf+";"+taxa;
	}
	
	
	

}
