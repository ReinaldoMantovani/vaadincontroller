package br.com.reinaldo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Column
	private String nome;
	@NotEmpty
	@Column
	private String sobrenome;
	@NotEmpty
	@Column
	private Boolean statusUsuario;
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "cidade_id")
	private Cidade cidade;
	@NotEmpty
	@Column
	private BigDecimal cpf;
	@NotEmpty
	@Column
	private BigDecimal rg;
	@NotEmpty
	@Column
	private Instant momentoRegistro;
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "tipo_emitente_id")
	private TipoEmitente tipoEmitente;
	
	public Usuarios() {
	}

	public Usuarios(Long id, String nome, String sobrenome, Boolean statusUsuario, Cidade cidade, BigDecimal cpf,
			BigDecimal rg, Instant momentoRegistro, TipoEmitente tipoEmitente) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.statusUsuario = statusUsuario;
		this.cidade = cidade;
		this.cpf = cpf;
		this.rg = rg;
		this.momentoRegistro = momentoRegistro;
		this.tipoEmitente = tipoEmitente;
	}
	
	

	@Override
	public String toString() {
		return tipoEmitente.toString();
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Boolean getStatusUsuario() {
		return statusUsuario;
	}


	public void setStatusUsuario(Boolean statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public BigDecimal getCpf() {
		return cpf;
	}

	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getRg() {
		return rg;
	}

	public void setRg(BigDecimal rg) {
		this.rg = rg;
	}

	public Instant getMomentoRegistro() {
		return momentoRegistro;
	}

	public void setMomentoRegistro(Instant momentoRegistro) {
		this.momentoRegistro = Instant.now();
	}
	
	public TipoEmitente getTipoEmitente() {
		return tipoEmitente;
	}
	
	public void setTipoEmitente(TipoEmitente tipoEmitente) {
		this.tipoEmitente = tipoEmitente;
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
		Usuarios other = (Usuarios) obj;
		return Objects.equals(id, other.id);
	}

	
}
