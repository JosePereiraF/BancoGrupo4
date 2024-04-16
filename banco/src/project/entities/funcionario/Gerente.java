package project.entities.funcionario;

import project.enums.CargoENUM;

public class Gerente extends Funcionario{
	//criar um
	int agenciaResponsavel;
	public Gerente(String nome, String cpf, String senha, CargoENUM cargo,int agenciaResponsavel) {
		super(nome, cpf, senha, cargo);
		this.agenciaResponsavel = agenciaResponsavel;
	}
	public Gerente() {
		super();
	}
	
	
	public int getAgenciaResponsavel() {
		return agenciaResponsavel;
	}
	public void setAgenciaResponsavel(int agenciaResponsavel) {
		this.agenciaResponsavel = agenciaResponsavel;
	}
	@Override
	public String toString() {
		return "Gerente [agenciaResponsavel=" + agenciaResponsavel + ", cargo=" + cargo + ", nome=" + nome + ", cpf="
				+ cpf + ", senha=" + senha + "]";
	}
	
	
		
}
