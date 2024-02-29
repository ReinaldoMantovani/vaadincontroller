package br.com.reinaldo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cidade  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private int codigoIbge;
	@Column
	private String uf;
	@Column
	private Instant momentoRegistro;
	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Usuarios> usuarios;
	
	public Cidade() {
	}
	


	public Cidade(Long id, String nome, int codigoIbge, String uf, Instant momentoRegistro, List<Usuarios> usuarios) {
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
		return  nome ;
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
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
	
	
}
