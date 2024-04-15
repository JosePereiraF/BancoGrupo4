package project.entities.conta;

import java.time.LocalDate;

import project.enums.TipoContaENUM;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao, int numeroAgencia) {
		super(cpf, numeroDaConta, tipoConta, saldo, dataCriacao, numeroAgencia);
	}

	@Override
	public String toString() {
		return "ContaPoupanca [cpf=" + cpf + ", numeroDaConta=" + numeroDaConta + ", tipoConta=" + tipoConta
				+ ", saldo=" + saldo + ", dataCriacao=" + dataCriacao + "]";
	}

	
	
}
