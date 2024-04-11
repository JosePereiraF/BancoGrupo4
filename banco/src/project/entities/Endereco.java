package project.entities;

import java.util.HashMap;
import java.util.Scanner;

public class Endereco {
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String complemento;
	
	public HashMap<String,Endereco> lista_endereco = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	Scanner scint = new Scanner(System.in);
	public Endereco(String cep, String estado, String cidade, String bairro, String rua, int numero,
			String complemento) {
		super();
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro + ", rua="
				+ rua + ", numero=" + numero + ", complemento=" + complemento + "]";
	}
	
	public void cria_endereco(String key) {
		String cepDigitado;
		String estadoDigitado;
		String cidadeDigitado;
		String bairroDigitado;
		String ruaDigitado;
		int numeroDigitado;
		String complementoDigitado;
		System.out.println("Digite seu cep: ");
		cepDigitado = sc.nextLine();
		System.out.println("Digite seu estado");
		estadoDigitado =sc.nextLine();
		System.out.println("Digite sua cidade: ");
		cidadeDigitado = sc.nextLine();
		System.out.println("Digite seu bairro: ");
		bairroDigitado = sc.nextLine();
		System.out.println("Digite sua rua: ");
		ruaDigitado = sc.nextLine();
		System.out.println("Digite o seu numero de endereço: ");
		numeroDigitado = scint.nextInt();
		System.out.println("Digite o complemento");
		complementoDigitado = sc.nextLine();
		
		Endereco endereco = new Endereco(cepDigitado,estadoDigitado,cidadeDigitado,bairroDigitado,ruaDigitado,
				numeroDigitado,complementoDigitado);
		
		lista_endereco.put(key, endereco);
	}
}
