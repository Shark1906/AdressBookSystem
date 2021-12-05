package bridgeit.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleAddressBook {

	static int input;

	public static void main(String[] args) {
		ContactOperations contactOperations = new ContactOperations();
		AddressBook addressBook = AddressBook.getInstance();
		ContactDetails contactDetails = ContactDetails.getInstance();
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"What do you want to do:\n1. Create AddressBook\n2. View AddressBook\n3. Search AddressBook\n4. Exit");
			input = sc.nextInt();
			switch (input) {
			case 1: {
				contactDetails.contactList = new ArrayList<>();
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the Address Book Name you want to create");
				String addressBookName = sc1.nextLine();
				if(addressBookName.length() > 0) {
				addressBook.addressBookOperations();
				contactDetails.addressBookMap.put(addressBookName, contactOperations.getList());
				}else {
					System.out.println("AddressBook Name should not be empty");
					}
				break;
			}

			case 2: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println(contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to view");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
					if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
						for (int i = 0; i < contactDetails.addressBookMap.get(addressBookName).size(); i++) {
							System.out.println(contactDetails.addressBookMap.get(addressBookName).get(i));
						}
					} else {
						System.out.println("Address Book is empty");
					}
					}
				}
				break;
			}

			case 3: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println(contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to search");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							List<Contacts> list = contactDetails.addressBookMap.get(addressBookName);
							System.out.println("Enter the city you want to search");
							String city = sc3.nextLine();
							for (int i = 0; i < list.size(); i++) {
								String fname = list.get(i).city;
								if (fname.equals(city)) {
									System.out.println(list.get(i));
								}
							}
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			}
		} while (input != 4);
	}
}
