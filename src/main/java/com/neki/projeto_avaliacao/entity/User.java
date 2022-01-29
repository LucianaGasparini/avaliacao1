package com.neki.projeto_avaliacao.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;



@Entity
@Table (name = "user")
public class User {
	
	@Id
	@ApiModelProperty(value = "Identificado único da Skill")
	@GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ApiModelProperty(value = "Login até 12 caracteres")
	@NotNull (message = "O Login do usuário deverá ser preenchido.")
	@Column (name = "login", length = 12, nullable = false)
	private String login;
	
	@ApiModelProperty(value = "Senha até 100 caracteres")
	@NotNull(message = "A senha deverá ser informada, campo obrigatório.")
	@Column (name = "password", length = 100, nullable = false)
	private String password;
	
	@ApiModelProperty(value = "Data")
	@Column (name = "last_login_date", nullable = true)
	private LocalDate lastDateLogin;
	
	

	public User() {
		super();
	}

	public User(Long id, @NotNull(message = "O nome do usuário deverá ser preenchido.") String login,
			@NotNull(message = "A senha deverá ser informada, campo obrigatório.") String password,
			LocalDate lastDateLogin) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastDateLogin = lastDateLogin;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getLastDateLogin() {
		return lastDateLogin;
	}

	public void setLastDateLogin(LocalDate lastDateLogin) {
		this.lastDateLogin = lastDateLogin;
	}

		

	@Override
	public int hashCode() {
		return Objects.hash(id, lastDateLogin, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(lastDateLogin, other.lastDateLogin)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}
	
	
}
