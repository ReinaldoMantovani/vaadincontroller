package br.com.reinaldo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import br.com.reinaldo.enums.StatusUsuario;
import br.com.reinaldo.enums.TipoEmitenteEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

	@NotNull(message = "Username deve ser informado.")
	private String username;

	@Email(message = "Coloque um email valido!")
	@Column(unique = true)
	private String email;

	@NotNull(message = "A senha ´´e obrigatória")
	@Column(unique = true)
	private String password;

	@NotNull(message = "O status do usuário deve ser informado.")
	@Column
	private StatusUsuario statusUsuario;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST) // ou CascadeType.ALL
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;

	@NotNull
	@Column(unique = true)
	private String cpf;

	@NotNull
	@Column(unique = true)
	private String rg;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@CreationTimestamp
	private Date momentoRegistro;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@UpdateTimestamp
	private Date updateRegistro;

	@Enumerated(EnumType.STRING)
	private TipoEmitenteEnum tipoEmitente;

	@Column
	private String profileImageUrl;

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

	public Usuarios(Long id, String profileImageUrl, TipoEmitenteEnum tipoEmitente, Date updateRegistro, Date momentoRegistro, String rg,
					String cpf, Cidade cidade, StatusUsuario statusUsuario, String password, String email, String username, String sobrenome, String nome) {
		this.id = id;
		this.profileImageUrl = profileImageUrl;
		this.tipoEmitente = tipoEmitente;
		this.updateRegistro = updateRegistro;
		this.momentoRegistro = momentoRegistro;
		this.rg = rg;
		this.cpf = cpf;
		this.cidade = cidade;
		this.statusUsuario = statusUsuario;
		this.password = password;
		this.email = email;
		this.username = username;
		this.sobrenome = sobrenome;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public TipoEmitenteEnum getTipoEmitente() {
		return tipoEmitente;
	}

	public void setTipoEmitente(TipoEmitenteEnum tipoEmitente) {
		this.tipoEmitente = tipoEmitente;
	}

	public Date getUpdateRegistro() {
		return updateRegistro;
	}

	public void setUpdateRegistro(Date updateRegistro) {
		this.updateRegistro = updateRegistro;
	}

	public Date getMomentoRegistro() {
		return momentoRegistro;
	}

	public void setMomentoRegistro(Date momentoRegistro) {
		this.momentoRegistro = momentoRegistro;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StatusUsuario getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(StatusUsuario statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return tipoEmitente.toString();
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
