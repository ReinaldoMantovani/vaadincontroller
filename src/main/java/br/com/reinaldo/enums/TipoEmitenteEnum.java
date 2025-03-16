package br.com.reinaldo.enums;

public enum TipoEmitenteEnum {
	ADMINISTRADOR(1, "Administrador"),
	GERENTE(2, "Gerente"),
	ALMOXARIFADO(3, "Almoxarifado"),
	FINANCEIRO(4, "Financeiro"),
	FATURAMENTO(5, "Faturamento"),
	CONSULTAS(6, "Consultas");

	private final int codigo;
	private final String nome;

	// Construtor da enumeração

	TipoEmitenteEnum(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	// Método para obter o código
	public int getCodigo() {
		return codigo;
	}

	// Método para obter o nome
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return nome; // Retorna o nome quando a enumeração é convertida para String
	}
}