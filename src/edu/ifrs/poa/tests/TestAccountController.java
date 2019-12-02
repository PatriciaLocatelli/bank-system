package edu.ifrs.poa.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.ifrs.poa.controller.AccountController;
import edu.ifrs.poa.entity.CurrentAccount;
import junit.framework.TestCase;

public class TestAccountController extends TestCase {

	private AccountController accountController;

	@Test
	public void testTransferValue() {

		int idAccount01 = 1;
		int idAccount02 = 2;
		CurrentAccount account01 = new CurrentAccount(idAccount01, 200, true);
		CurrentAccount account02 = new CurrentAccount(idAccount02, 0, true);

		List<CurrentAccount> accountBank = new ArrayList<>();
		accountBank.add(account01);
		accountBank.add(account02);

		accountController = new AccountController(accountBank);

		boolean sucess = accountController.transferValue(idAccount01, 100, idAccount02);

		assertTrue(sucess);
		assertThat(account02.getBalance(), is(100.0));
		assertThat(account01.getBalance(), is(100.0));
	}

	@Test
	public void testTransferValueInsufficientBalance() {

		int idAccount01 = 1;
		int idAccount02 = 2;
		CurrentAccount account01 = new CurrentAccount(idAccount01, 100, true);
		CurrentAccount account02 = new CurrentAccount(idAccount02, 0, true);

		List<CurrentAccount> accountBank = new ArrayList<>();
		accountBank.add(account01);
		accountBank.add(account02);

		accountController = new AccountController(accountBank);

		boolean sucess = accountController.transferValue(idAccount01, 200, idAccount02);

		assertTrue(sucess);
		assertThat(account01.getBalance(), is(-100.0));
		assertThat(account02.getBalance(), is(200.0));
	}

}
