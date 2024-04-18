package project.entities.cliente;

import java.util.HashMap;

import project.entities.Pessoa;

public class Cliente extends Pessoa{
	private String numeroAgencia;
	
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public static HashMap<String, Cliente>lista_cliente = new HashMap<>();
	
	public Cliente(String nome, String cpf, String senha,String numeroAgencia) {
		super(nome, cpf, senha );
		this.numeroAgencia = numeroAgencia;
	}
	public Cliente () {
		super();
	}
	

	@Override
	public String toString() {
		
		return nome +";"+ cpf + ";"+ senha +";"+numeroAgencia;
	}

	
		public static Cliente buscar_cliente(String key) {
			
			return lista_cliente.get(key);
			
		}
	
	
}
