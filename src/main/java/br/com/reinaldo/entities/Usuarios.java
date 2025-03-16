package br.com.reinaldo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import br.com.reinaldo.enums.StatusUsuario;
import br.com.reinaldo.enums.TipoEmitenteEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column
	private String nome;
	@NotNull
	@Column
	private String sobrenome;
	@NotNull(message = "O status do usuário deve ser informado.")
	@Column
	private StatusUsuario statusUsuario;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST) // ou CascadeType.ALL
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	@NotNull
	@Column(unique = true)
	private BigDecimal cpf;
	@NotNull
	@Column(unique = true)
	private BigDecimal rg;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@CreationTimestamp
	private Date momentoRegistro;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@UpdateTimestamp
	private Date updateRegistro;

	@Enumerated(EnumType.STRING)
	private TipoEmitenteEnum tipoEmitente;

	@PrePersist
	protected  void onCreate(){
		this.momentoRegistro = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updateRegistro = new Date();
	}
	
	public Usuarios() {
	}

	public Usuarios(Long id, String nome, String sobrenome, StatusUsuario statusUsuario, Cidade cidade, BigDecimal cpf,
			BigDecimal rg, Date momentoRegistro, Date updateRegistro ,TipoEmitenteEnum tipoEmitente) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.statusUsuario = statusUsuario;
		this.cidade = cidade;
		this.cpf = cpf;
		this.rg = rg;
		this.momentoRegistro = momentoRegistro;
		this.updateRegistro = updateRegistro;
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

	public StatusUsuario getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(StatusUsuario statusUsuario) {
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

	public TipoEmitenteEnum getTipoEmitente() {
		return tipoEmitente;
	}

	public void setTipoEmitente(TipoEmitenteEnum tipoEmitente) {
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
