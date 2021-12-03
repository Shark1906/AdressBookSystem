package bridgeit.addressbook;

import java.util.Scanner;

public class AddressBookMain {
	static int input;
	
	public static void main(String[] args) {
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("What do you want to do:\n1. Add Contact\n2. View Contact\n3. Edit Contact\n4. Delete Contact\n5. Exit");
			input = sc.nextInt();
		
		
				switch (input) {
					case 1: {
						ContactOperations contactOperations = ContactOperations.getInstance();
						contactOperations.addNewContact();
						break;
					}
		
					case 2: {
						ContactOperations contactOperations = ContactOperations.getInstance();
						contactOperations.printAllContacts();
						break;
					}
					
					case 3: {
						ContactOperations contactOperations = ContactOperations.getInstance();
						contactOperations.editContact();
						break;
					}
					
					case 4: {
						ContactOperations contactOperations = ContactOperations.getInstance();
						contactOperations.removeContactByName();
						break;
					}
				}
			}while(input != 5);
	}

}
