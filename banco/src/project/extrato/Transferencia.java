package project.extrato;

import java.time.LocalDateTime;

import project.entities.conta.Conta;

public class Transferencia {
	private int origem;
	private int destino;
	private double valor;
	private LocalDateTime hora;
	private String cpf;
	private double taxa;
	public Transferencia(int origem, int destino, double valor, LocalDateTime hora, String cpf, double taxa) {
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


	public int getOrigem() {
		return origem;
	}
	public void setOrigem(int origem) {
		this.origem = origem;
	}
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
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
		return "Transferencia [origem=" + origem + ", destino=" + destino + ", valor=" + valor + ", hora=" + hora
				+ ", cpf=" + cpf + ", taxa=" + taxa + "]";
	}

	
	
}
