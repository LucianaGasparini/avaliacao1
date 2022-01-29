package com.neki.projeto_avaliacao.VO;

import java.time.LocalDate;

import com.neki.projeto_avaliacao.entity.User;

public class UserAdd {
	private String login;
	private String password;
	private LocalDate lastDateLogin;

	
	
	public UserAdd() {
		super();
	}



	public UserAdd(User user) {
		super();
		this.login = user.getLogin();	
		this.password = user.getPassword();
		this.lastDateLogin = user.getLastDateLogin();
		
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
