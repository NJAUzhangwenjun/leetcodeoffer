package fuxi.io;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 3835451822570819898L;
	private String username;
	private String password;
	private Integer age;
	private transient String hobby;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "User{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", age=" + age
				+ ", hobby='" + hobby + '\'' + '}';
	}
}
