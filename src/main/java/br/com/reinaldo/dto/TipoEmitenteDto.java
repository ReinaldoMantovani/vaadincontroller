package br.com.reinaldo.dto;


import java.time.Instant;
import java.util.Objects;


public class TipoEmitenteDto {
	 private Long id;
	 private String nome;
	 private Instant momentoRegistro;
	 
	 public TipoEmitenteDto() {	 
	 }

	
	public TipoEmitenteDto(Long id, String nome, Instant momentoRegistro) {
		super();
		this.id = id;
		this.nome = nome;
		this.momentoRegistro = momentoRegistro;
	}
	
	

	@Override
	public String toString() {
		return nome;
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

	

	public Instant getMomentoRegistro() {
		return momentoRegistro;
	}


	public void setMomentoRegistro(Instant momentoRegistro) {
		this.momentoRegistro = Instant.now();
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoEmitenteDto other = (TipoEmitenteDto) obj;
		return id == other.id;
	}
	 
	 
}
