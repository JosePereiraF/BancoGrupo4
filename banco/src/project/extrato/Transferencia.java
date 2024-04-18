package project.extrato;

import java.time.LocalDateTime;

import project.entities.conta.Conta;

public class Transferencia {
	private Conta origem;
	private Conta destino;
	private double valor;
	private LocalDateTime hora;
	private String cpf;
	private double taxa;
	public Transferencia(Conta origem, Conta destino, double valor, LocalDateTime hora, String cpf, double taxa) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
		this.hora = hora;
		this.cpf = cpf;
		this.taxa = taxa;
	}
	
	
	public Transferencia() {
		super();
	}


	public Conta getOrigem() {
		return origem;
	}
	public void setOrigem(Conta origem) {
		this.origem = origem;
	}
	public Conta getDestino() {
		return destino;
	}
	public void setDestino(Conta destino) {
		this.destino = destino;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
		this.hora = hora;
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


	@Override
	public String toString() {
		//int origem, int destino, double valor, LocalDateTime hora, String cpf, double taxa
		return origem+";"+destino+";"+valor+";"+hora+";"+cpf+";"+taxa;
	}

	
	
}
