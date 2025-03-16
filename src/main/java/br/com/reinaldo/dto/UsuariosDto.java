package br.com.reinaldo.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import br.com.reinaldo.entities.Cidade;
import br.com.reinaldo.enums.StatusUsuario;
import br.com.reinaldo.enums.TipoEmitenteEnum;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class UsuariosDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private StatusUsuario statusUsuario;
	private Cidade cidade;
	private String cpf;
	private String rg;
	private Date momentoRegistro;
	private Date updateRegistro;
	private TipoEmitenteEnum tipoEmitente;
	
	public UsuariosDto() {
	}

	public UsuariosDto(Long id, String nome, String sobrenome, StatusUsuario statusUsuario, Cidade cidade, String cpf,
					   String rg, Date momentoRegistro, Date updateRegistro ,TipoEmitenteEnum tipoEmitente) {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getMomentoRegistro() {
		return momentoRegistro;
	}

	public void setMomentoRegistro(Date momentoRegistro) {
		this.momentoRegistro = momentoRegistro;
	}

	public Date getUpdateRegistro() {
		return updateRegistro = momentoRegistro;
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
		UsuariosDto other = (UsuariosDto) obj;
		return Objects.equals(id, other.id);
	}
}
