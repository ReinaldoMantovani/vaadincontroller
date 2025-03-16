package br.com.reinaldo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "td_cidade")
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
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@CreationTimestamp
	private Date momentoRegistro;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@UpdateTimestamp
	private Date updateRegistro;
	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Usuarios> usuarios;

	@PrePersist
	protected  void onCreate(){
		this.momentoRegistro = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updateRegistro = new Date();
	}
	
	public Cidade() {
	}
	


	public Cidade(Long id, String nome, int codigoIbge, String uf, Date momentoRegistro,Date updateRegistro, List<Usuarios> usuarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoIbge = codigoIbge;
		this.uf = uf;
		this.momentoRegistro = momentoRegistro;
		this.updateRegistro = updateRegistro;
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
	
	public Date getMomentoRegistro() {
		return momentoRegistro;
	}
	
	public void setMomentoRegistro(Date momentoRegistro) {
		this.momentoRegistro = momentoRegistro;
	}

	public Date getUpdateRegistro() {
		return updateRegistro;
	}

	public void setUpdateRegistro(Date updateRegistro) {
		this.updateRegistro = updateRegistro;
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
