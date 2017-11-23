package day08Request;

import java.util.Arrays;

public class Student {
	private int id;//BeanUtil对于基本类型自动转换
	private String name;
	private String password;
	private String gender;
	private boolean married;
	private String[] hobby;
	private String province;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password="
				+ password + ", gender=" + gender + ", married=" + married
				+ ", hobby=" + Arrays.toString(hobby) + ", province="
				+ province + ", description=" + description + "]";
	}
	
}
