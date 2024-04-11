package project.enums;

public enum TipoContaENUM {
	CONTACORRENTE("ContaCorrente"),
	CONTAPOUPANCA("ContaPoupanca");
	
	private String tipoConta;
	
	private TipoContaENUM(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
}
