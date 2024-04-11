package project.entities.agencia;

public class Agencia {
	private String nome;
	private int numeroAgencia;
	
	
	public Agencia(String nome, int numeroAgencia) {
		super();
		this.nome = nome;
		this.numeroAgencia = numeroAgencia;
	}
	
	@Override
	public String toString() {
		return "Agencia [nome=" + nome + ", numeroAgencia=" + numeroAgencia + "]";
	}
	
	
	
}
