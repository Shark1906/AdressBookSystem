package bridgeit.addressbook;

import java.util.Scanner;

public class AddressBook {
	static int input;
	private static AddressBook instance;
	
	private AddressBook() {}
	
	public static AddressBook getInstance() {
		if(instance == null) {
			instance = new AddressBook();
		}
		return instance;
	}
	
	public void addressBookOperations() {
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("What do you want to do:\n1. Add Contact\n2. View Contact\n3. Edit Contact\n4. Delete Contact\n5. Exit");
			input = sc.nextInt();
		
			ContactOperations contactOperations = new ContactOperations();
				switch (input) {
					case 1: {
						contactOperations.addNewContact();
						break;
					}
		
					case 2: {
						contactOperations.printAllContacts();
						break;
					}
					
					case 3: {
						contactOperations.editContact();
						break;
					}
					
					case 4: {
						contactOperations.removeContactByName();
						break;
					}
				}
			}while(input != 5);
	}

}
