package br.com.reinaldo.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import br.com.reinaldo.entities.Cidade;
import br.com.reinaldo.entities.TipoEmitente;

public class UsuariosDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private Boolean statusUsuario;
	private Cidade cidade;
	private BigDecimal cpf;
	private BigDecimal rg;
	private Instant momentoRegistro;
	private TipoEmitente tipoEmitente;
	
	public UsuariosDto() {
	}

	public UsuariosDto(Long id, String nome, String sobrenome, Boolean statusUsuario, Cidade cidade, BigDecimal cpf,
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
		UsuariosDto other = (UsuariosDto) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
