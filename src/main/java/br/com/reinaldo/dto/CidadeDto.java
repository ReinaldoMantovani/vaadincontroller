package br.com.reinaldo.dto;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import br.com.reinaldo.entities.Usuarios;

public class CidadeDto {
	private Long id;
	private String nome;
	private int codigoIbge;
	private String uf;
	private Instant momentoRegistro;
	private List<Usuarios> usuarios;
	public CidadeDto() {
	}

	public CidadeDto(Long id, String nome, int codigoIbge, String uf, Instant momentoRegistro, List<Usuarios> usuarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoIbge = codigoIbge;
		this.uf = uf;
		this.momentoRegistro = momentoRegistro;
		this.usuarios = usuarios;
	}
	
	

	

	@Override
	public String toString() {
		return nome ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Instant getMomentoRegistro() {
		return momentoRegistro;
	}
	
	public void setMomentoRegistro(Instant momentoRegistro) {
		this.momentoRegistro = Instant.now();
	}
	
	public List<Usuarios> getUsuarios() {
		return usuarios;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoIbge, id, nome, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeDto other = (CidadeDto) obj;
		return codigoIbge == other.codigoIbge && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(uf, other.uf);
	}
	
	
}
