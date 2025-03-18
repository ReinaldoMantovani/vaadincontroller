package br.com.reinaldo.dto;

import java.util.Date;
import java.util.Objects;

import br.com.reinaldo.entities.Cidade;
import br.com.reinaldo.enums.StatusUsuario;
import br.com.reinaldo.enums.TipoEmitenteEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UsuariosDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private String username;
	private String email;
	private String password;
	private StatusUsuario statusUsuario;
	private Cidade cidade;
	private String cpf;
	private String rg;
	private Date momentoRegistro;
	private Date updateRegistro;
	private TipoEmitenteEnum tipoEmitente;
	private MultipartFile profileImageUrl;
	
	public UsuariosDto() {
	}

	public UsuariosDto(Long id, MultipartFile profileImageUrl, TipoEmitenteEnum tipoEmitente, Date updateRegistro, Date momentoRegistro, String rg, String cpf,
					   StatusUsuario statusUsuario, Cidade cidade, String password, String email, String username, String nome, String sobrenome) {
		this.id = id;
		this.profileImageUrl = profileImageUrl;
		this.tipoEmitente = tipoEmitente;
		this.updateRegistro = updateRegistro;
		this.momentoRegistro = momentoRegistro;
		this.rg = rg;
		this.cpf = cpf;
		this.statusUsuario = statusUsuario;
		this.cidade = cidade;
		this.password = password;
		this.email = email;
		this.username = username;
		this.nome = nome;
		this.sobrenome = sobrenome;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public MultipartFile getProfileImageUrl() {
		return profileImageUrl;
	}

	public MultipartFile setProfileImageUrl(MultipartFile profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
        return profileImageUrl;
    }

	@Override
	public String toString() {
		return "UsuariosDto{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", statusUsuario=" + statusUsuario +
				", cidade=" + cidade +
				", cpf='" + cpf + '\'' +
				", rg='" + rg + '\'' +
				", momentoRegistro=" + momentoRegistro +
				", updateRegistro=" + updateRegistro +
				", tipoEmitente=" + tipoEmitente +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		UsuariosDto that = (UsuariosDto) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}


}
