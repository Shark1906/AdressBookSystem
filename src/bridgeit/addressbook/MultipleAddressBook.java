package bridgeit.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleAddressBook {
	
	static int input;
	
	
	public static void main(String[] args) {
		ContactOperations contactOperations = new ContactOperations();
		AddressBook addressBook = AddressBook.getInstance();
		ContactDetails contactDetails = ContactDetails.getInstance();
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("What do you want to do:\n1. Create AddressBook\n2. View AddressBook\n3. Exit");
				input = sc.nextInt();
				switch (input) {
				case 1: {
					contactDetails.contactList = new ArrayList<>();
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to create");
					String addressBookName = sc1.nextLine();
					addressBook.addressBookOperations();
					contactDetails.addressBookMap.put(addressBookName, contactOperations.getList());
					break;
				}
			
				case 2: {
					System.out.println(contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to view");
					String addressBookName = sc2.nextLine();
					for (int i = 0; i < contactDetails.addressBookMap.get(addressBookName).size(); i++) {
						System.out.println(contactDetails.addressBookMap.get(addressBookName).get(i));
					}
					break;
				}
				}
		}while(input != 3);
	}
}
