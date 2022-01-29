package com.neki.projeto_avaliacao.VO;

import java.time.LocalDate;

import com.neki.projeto_avaliacao.entity.User;

public class UserDisplay {

	private Long id;
	private String login;
	private String password;
	private LocalDate lastDateLogin;
	
	
	
	
	public UserDisplay() {
		super();
	}

	public UserDisplay(User user) {
		super();
		this.id = user.getId();
		this.login = user.getLogin();	
		this.password = user.getPassword();
		this.lastDateLogin = user.getLastDateLogin();
	
		
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
	
	
}
