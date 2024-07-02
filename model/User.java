package model;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private char[] password,tel;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, char[] password, char[] tel) {
		super();
		this.name = name;
		this.password = password;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public char[] getTel() {
		return tel;
	}

	public void setTel(char[] tel) {
		this.tel = tel;
	}




	
}
