package project.entities.cliente;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import project.entities.Pessoa;
import project.funcionalidades.InOutUtils;

public class Cliente extends Pessoa{
	private String numeroAgencia;
	//criar um HashMap para armazer os cliente seguindo os parametros estipulados ou seja o cpf vai ser a key do hasmap.
    //criar metodo para criar um cliente e para busca-lo
	//adcionar os clientes criados dentro do hashmap
	
	static Scanner sc = new Scanner(System.in);
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



	public static void criar_cliente() throws IOException {
		//(String nome, String cpf, String senha, LocalDate dataNascimento, String numeroAgencia) 
		String nomeDigitado;
		String cpfDigitado;
		String senhaDigitada;
		String numeroAgenciaDigitada;
		
		System.out.println("Digite o nome: ");
		nomeDigitado = sc.nextLine();
		System.out.println("Digite o CPF: ");
		cpfDigitado = sc.nextLine();
		System.out.println("Digite a senha: ");
		senhaDigitada = sc.nextLine();
		System.out.println("Digite o número da agência: ");
		numeroAgenciaDigitada = sc.nextLine();
		
		Cliente clinte = new Cliente(nomeDigitado,cpfDigitado,senhaDigitada,numeroAgenciaDigitada);
		lista_cliente.put(cpfDigitado, clinte);
		lista_pessoa.add(clinte);
		saveTXT();
		
	}
	
		public Cliente buscar_cliente(String key) {
			
			return lista_cliente.get(key);
			
		}
	public static void saveTXT() throws IOException {
		//InOutUtils.leitor_pessoa("//home/administrador//Documents//usuarios.txt");
		InOutUtils.escreve_pessoa(lista_pessoa);
	}
	
}
