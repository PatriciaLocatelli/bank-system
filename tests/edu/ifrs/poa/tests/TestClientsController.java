package edu.ifrs.poa.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ifrs.poa.controller.ClientsController;
import edu.ifrs.poa.entity.Client;
import edu.ifrs.poa.exception.AgeException;

public class TestClientsController {

	private ClientsController clientsController;
	private int idClient01 = 1;
	private int idClient02 = 2;

	@Before
	public void setUp() {

		Client client01 = new Client(idClient01, "Alex Green", 31, "alex@gmail.com", true, 1);
		Client client02 = new Client(idClient02, "Maria Brown", 25, "maria@gmail.com", true, 1);

		List<Client> clientsBank = new ArrayList<>();
		clientsBank.add(client01);
		clientsBank.add(client02);

		clientsController = new ClientsController(clientsBank);
	}

	@After
	public void tearDown() {
		clientsController.clean();
	}

	@Test
	public void testSearchClient() {

		Client client = clientsController.searchClient(idClient01);

		assertThat(client.getId(), is(idClient01));

	}

	@Test
	public void testSearchClientNonExistent() {

		Client client = clientsController.searchClient(1221);

		assertNull(client);

	}

	@Test
	public void testRemoveClient() {

		boolean clientRemove = clientsController.removeClient(idClient02);

		assertThat(clientRemove, is(true));
		assertThat(clientsController.getClientsBank().size(), is(1));
		assertNull(clientsController.searchClient(idClient02));

	}

	@Test
	public void testRemoveClientNonExistent() {

		boolean clientRemove = clientsController.removeClient(1221);

		assertThat(clientRemove, is(false));
		assertThat(clientsController.getClientsBank().size(), is(2));

	}

	@Test
	public void testClienteAgeAcceptable() throws AgeException {

		Client client = new Client(1, "Alex Green", 29, "alex@gmail.com", true, 1);

		boolean ageValidate = clientsController.validateAge(client.getAge());

		assertTrue(ageValidate);
	}

	@Test
	public void testClienteAgeNotAcceptable() throws AgeException {

		Client client = new Client(1, "Alex Green", 17, "alex@gmail.com", true, 1);

		try {
			clientsController.validateAge(client.getAge());
			fail();
		} catch (Exception e) {

			assertThat(e.getMessage(), is(AgeException.MSG_AGE_INVALID));
		}
	}
}
