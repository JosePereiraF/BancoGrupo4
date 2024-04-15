package project.entities.conta;

import java.time.LocalDate;


import project.enums.TipoContaENUM;

public class ContaCorrente extends Conta{
	
	public ContaCorrente(String cpf, int numeroDaConta, TipoContaENUM tipoConta, double saldo, LocalDate dataCriacao, int numeroAgencia) {
		super(cpf, numeroDaConta, tipoConta, saldo, dataCriacao,numeroAgencia);
	}

	public ContaCorrente() {
		super();
	}
	@Override
	public String toString() {
		return "ContaCorrente [cpf=" + cpf + ", numeroDaConta=" + numeroDaConta + ", tipoConta=" + tipoConta
				+ ", saldo=" + saldo + ", dataCriacao=" + dataCriacao + "]";
	}
	
	


	
}
