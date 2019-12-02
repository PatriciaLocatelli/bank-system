package edu.ifrs.poa.controller;

import java.util.List;

import edu.ifrs.poa.entity.Client;
import edu.ifrs.poa.exception.AgeException;

public class ClientsController {

	private List<Client> clientsBank;

	public ClientsController(List<Client> clientsBank) {
		this.clientsBank = clientsBank;
	}

	public List<Client> getClientsBank() {
		return clientsBank;
	}

	public Client searchClient(int idClient) {

		for (Client client : clientsBank) {
			if (client.getId() == idClient)
				return client;
		}
		return null;
	}

	public void addClient(Client newClient) {
		clientsBank.add(newClient);
	}

	public boolean removeClient(int idClient) {
		boolean clientRemove = false;

		for (int i = 0; i < clientsBank.size(); i++) {
			Client client = clientsBank.get(i);
			if (client.getId() == idClient) {
				clientsBank.remove(i);
				clientRemove = true;
				break;
			}
		}

		return clientRemove;
	}

	public boolean clientActive(int idClient) {
		boolean clientActive = false;

		for (int i = 0; i < clientsBank.size(); i++) {
			Client client = clientsBank.get(i);
			if (client.getId() == idClient)
				if (client.isActive()) {
					clientActive = true;
					break;
				}
		}

		return clientActive;
	}

	public void clean() {
		this.clientsBank.clear();
	}
	
	public boolean validateAge(int age) throws AgeException {
		
		if(age < 18 || age > 65)
			throw new AgeException(AgeException.MSG_AGE_INVALID);
		
		return true;
	}
}
