package project.excecoes;

public class ExcecaoTransferencias extends Exception{

	private static final long serialVersionUID = 1L;
	
	public  ExcecaoTransferencias() {
		super("Não é possivel fazer uma transação com o valor negativo.");
	}

}
