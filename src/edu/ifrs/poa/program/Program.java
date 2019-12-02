package edu.ifrs.poa.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ifrs.poa.controller.AccountController;
import edu.ifrs.poa.controller.ClientsController;
import edu.ifrs.poa.entity.Client;
import edu.ifrs.poa.entity.CurrentAccount;

public class Program {

	static ClientsController clientsController;
	static AccountController accountController;

	public static void main(String[] args) {

		initializeBankSystem();

		Scanner sc = new Scanner(System.in);

		boolean continueSystem = true;
		while (continueSystem) {

			printMenu();

			int option = sc.nextInt();

			switch (option) {

			case 1:
				System.out.print("Enter client ID : ");
				int idClient = sc.nextInt();
				Client client = clientsController.searchClient(idClient);

				if (client != null)
					System.out.println(client.toString());
				else
					System.out.println("Client not found!");

				breakLine();
				break;

			case 2:
				System.out.print("Enter account ID : ");
				int idAccount = sc.nextInt();
				CurrentAccount account = accountController.searchAccount(idAccount);

				if (account != null)
					System.out.println(account.toString());
				else
					System.out.println("Account not found!");

				breakLine();
				break;

			case 3:

				System.out.print("Enter client ID: ");
				int idClient2 = sc.nextInt();
				Client client2 = clientsController.searchClient(idClient2);

				if (client2 != null) {
					client2.setActive(true);
					System.out.println("Client successfully activated!");
				} else
					System.out.println("Client not found!");

				breakLine();
				break;

			case 4:

				System.out.print("Enter client ID: ");
				int idClient3 = sc.nextInt();
				Client client3 = clientsController.searchClient(idClient3);

				if (client3 != null) {
					client3.setActive(false);
					System.out.println("Client successfully deactivated!");
				} else
					System.out.println("Client not found!");

				breakLine();
				break;

			case 5:
				continueSystem = false;
				break;

			default:
				System.out.println("Error, restart menu");
				break;

			}

		}
	}

	private static void breakLine() {
		System.out.println("\n");
	}

	private static void printMenu() {

		System.out.println("What do you want to do? \n");
		System.out.println("1) Search Client");
		System.out.println("2) Search Current Account");
		System.out.println("3) Active Client");
		System.out.println("4) Desactive Account");
		System.out.println("5) Exit");
		System.out.println();

	}

	private static void initializeBankSystem() {

		List<CurrentAccount> currentBank = new ArrayList<>();
		List<Client> clientsBank = new ArrayList<>();

		CurrentAccount account01 = new CurrentAccount(1, 0, true);
		CurrentAccount account02 = new CurrentAccount(2, 0, true);
		currentBank.add(account01);
		currentBank.add(account02);

		Client client01 = new Client(1, "Alex Green", 31, "alex@gmail.com", true, account01.getId());
		Client client02 = new Client(2, "Maria Brown", 25, "maria@gmail.com", true, account02.getId());

		clientsBank.add(client01);
		clientsBank.add(client02);

		clientsController = new ClientsController(clientsBank);
		accountController = new AccountController(currentBank);

	}
}
