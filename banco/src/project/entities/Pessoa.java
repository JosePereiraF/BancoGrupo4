package project.entities;

import java.util.ArrayList;
import java.util.List;

import project.entities.cliente.Cliente;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected String senha;
	
	public static List<Pessoa> lista_pessoa = new ArrayList<>();
	
	public Pessoa(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		
	}
	public void eeee() {
		
		
	}
	public Pessoa() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return nome + ";" + cpf + ";" + senha ;
	
	}
	
	
	
	
	
	}

