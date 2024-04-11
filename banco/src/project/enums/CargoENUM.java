package project.enums;

public enum CargoENUM {
	GERENTE("Gerente"),
	DIRETOR("Diretor"),
	PRESIDENTE("Presidente");
	private String cargo;
	
	private CargoENUM(String cargo) {
		this.cargo=cargo;
	}
}
