package edu.ifrs.poa.controller;

import java.util.List;

import edu.ifrs.poa.entity.CurrentAccount;

public class AccountController {
	private List<CurrentAccount> accountsBank;

	public AccountController(List<CurrentAccount> accountsBank) {
		this.accountsBank = accountsBank;
	}

	public List<CurrentAccount> getAccountsBank() {
		return accountsBank;
	}

	public CurrentAccount searchAccount(int idAccount) {

		for (CurrentAccount currentAccount : accountsBank) {
			if (currentAccount.getId() == idAccount)
				return currentAccount;
		}
		return null;
	}

	public void addAccount(CurrentAccount newAccount) {
		this.accountsBank.add(newAccount);
	}

	public boolean removeAccount(int idAccount) {

		boolean removeAccount = false;

		for (int i = 0; i < accountsBank.size(); i++) {
			CurrentAccount account = accountsBank.get(i);
			if (account.getId() == idAccount) {
				accountsBank.remove(i);
				break;
			}
		}

		return removeAccount;
	}

	public boolean accountActive(int idAccount) {

		boolean accountActive = false;

		for (int i = 0; i < accountsBank.size(); i++) {
			CurrentAccount account = accountsBank.get(i);
			if (account.getId() == idAccount)
				if (account.isActive()) {
					accountActive = true;
					break;
				}
		}

		return accountActive;
	}

	public boolean transferValue(int idAccountSrc, double value, int idAccountDest) {

		boolean sucess = false;

		CurrentAccount accountSource = searchAccount(idAccountSrc);
		CurrentAccount accountDestiny = searchAccount(idAccountDest);

		if (accountSource.getBalance() >= value) {
			accountSource.setBalance(accountSource.getBalance() + value);
			accountDestiny.setBalance(accountDestiny.getBalance() - value);

			sucess = true;
		}
		return sucess;
	}
}
