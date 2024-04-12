package project.entities.cliente;

import java.time.LocalDate;

import project.entities.Pessoa;

public class Cliente extends Pessoa{
	private String numeroAgencia;
	//criar um HashMap para armazer os cliente seguindo os parametros estipulados ou seja o cpf vai ser a key do hasmap.
    //criar metodo para criar um cliente e para busca-lo
	//adcionar os clientes criados dentro do hashmap
	
	public Cliente(String nome, String cpf, String senha, LocalDate dataNascimento, String numeroAgencia) {
		super(nome, cpf, senha, dataNascimento);
		this.numeroAgencia = numeroAgencia;
	}

	@Override
	public String toString() {
		return "Cliente [numeroAgencia=" + numeroAgencia + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", dataNascimento=" + dataNascimento + "]";
	}

	
	
	
}
