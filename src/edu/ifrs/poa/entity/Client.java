package edu.ifrs.poa.entity;

public class Client {

	private int id;

	private String name;

	private int age;

	private String email;

	private boolean active;

	private int idCurrentAccount;

	public Client(int id, String name, int age, String email, boolean active, int idCurrentAccount) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.active = active;
		this.idCurrentAccount = idCurrentAccount;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getIdCurrentAccount() {
		return idCurrentAccount;
	}

	public void setIdCurrentAccount(int idCurrentAccount) {
		this.idCurrentAccount = idCurrentAccount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID : ").append(this.id).append("\n");
		sb.append("Name : ").append(this.name).append("\n");
		sb.append("Email : ").append(this.email).append("\n");
		sb.append("Status : ").append(active ? sb.append("Active") : sb.append("Desactive"));
		return sb.toString();
	}

}
