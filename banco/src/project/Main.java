package project;

import project.entities.Endereco;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endereco endereco = new Endereco();
		String cpf1 ="123";
		String cpf2 ="158";
		
			endereco.cria_endereco(cpf1);
			endereco.cria_endereco(cpf2);
		
		System.out.println(endereco.lista_endereco.get(cpf1));
		System.out.println(endereco.lista_endereco.get(cpf2));
		
	}

}
