package edu.ifrs.poa.entity;

public class CurrentAccount {
	private int id;

	private double balance;

	private boolean active;

	public CurrentAccount(int id, double balance, boolean active) {
		this.id = id;
		this.balance = balance;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID : ").append(this.id).append("\n");
		sb.append("Balance : ").append(this.balance).append("\n");
		sb.append("Status : ").append(active ? sb.append("Active") : sb.append("Desactive"));
		return sb.toString();
	}

}
