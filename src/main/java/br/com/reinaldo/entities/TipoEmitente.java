package br.com.reinaldo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class TipoEmitente implements Serializable {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id; 
	 @NotEmpty
	 @Column
	 private String nome;
	 @NotEmpty
	 @Column
	 private Instant momentoRegistro; 
	 
	 public TipoEmitente() {
	 }
	 
	
	public TipoEmitente(Long id, String nome, Instant momentoRegistro) {
		super();
		this.id = id;
		this.nome = nome;
		this.momentoRegistro = momentoRegistro;
	}
	
	@Override
	public String toString() {
		return  nome.toString() ;
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
		TipoEmitente other = (TipoEmitente) obj;
		return id == other.id;
	}
	 
	 
	
}
