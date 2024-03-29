package bridgeit.addressbook;

import java.util.List;
import java.util.Scanner;

public class ContactOperations {
	private static ContactOperations instance;
	Scanner sc = new Scanner(System.in);
	
	private ContactOperations() {}
	
	public static ContactOperations getInstance() {
		if(instance == null) {
			instance = new ContactOperations();
		}
		return instance;
	}
	
	ContactDetails contactDetails = ContactDetails.getInstance();
	
	public void addNewContact() {
		
		System.out.println("Enter the details to Add :");
		System.out.println("Enter Firstname");
		String firstName = sc.nextLine();
		System.out.println("Enter Lastname");
		String lastName = sc.nextLine();
		System.out.println("Enter Address");
		String address = sc.nextLine();
		System.out.println("Enter City");
		String city = sc.nextLine();
		System.out.println("Enter State");
		String state = sc.nextLine();
		System.out.println("Enter Email");
		String email = sc.nextLine();
		System.out.println("Enter Zip");
		String zip = sc.nextLine();
		System.out.println("Enter Phone");
		String phone = sc.nextLine();
	
		Contacts contacts = new Contacts(firstName, lastName, address, city, state, email, zip, phone);
		if(isDuplicate(firstName, lastName) == false) {
		contactDetails.contactList.add(contacts);
		}else {
			System.out.println("Contact already exists");
		}
		//getList();
	}
	
	public List getList() {
		return contactDetails.contactList;
	}
	
	public void printAllContacts() {
		if(contactDetails.contactList.size() != 0) {
			for (int i = 0; i < contactDetails.contactList.size(); i++) {
				System.out.println("Contact" + (i+1) + " " + contactDetails.contactList.get(i));		
		
			}
		}else {
			System.out.println("AddressBook is Empty");
		}
	}
	
	public void editContact() {
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		int isFound = 0;
		if(contactDetails.contactList.size() != 0) {
		System.out.println("Enter first name of contact to Edit");
		String name = sc2.nextLine();
		for(Contacts contacts :contactDetails.contactList) {
			if(contacts.firstName.equals(name)) {
				isFound++;
				System.out.println(contacts);
				System.out.println("Enter what you want to edit \n1.Firstname \n2.Lastname"
						+ " \n3.Address \n4.City \n5.State \n6.Email \n7.Zip \n8.Phone");
				int choice = sc3.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("Enter the new Firstname");
					String newFirstName = sc3.next();
					contacts.firstName = newFirstName;
					break;
				
				case 2:
					System.out.println("Enter the new Lastname");
					String newLastName = sc3.next();
					contacts.lastName = newLastName;	
					break;
					
				case 3:
					System.out.println("Enter the new Address");
					String newAddress = sc3.next();
					contacts.address = newAddress;
					break;
					
				case 4:
					System.out.println("Enter the new City");
					String newCity = sc3.next();
					contacts.city = newCity;
					break;
					
				case 5:
					System.out.println("Enter the new State");
					String newState = sc3.next();
					contacts.state = newState;
					break;
					
				case 6:
					System.out.println("Enter the new Email");
					String newEmail = sc3.next();
					contacts.email = newEmail;
					break;
					
				case 7:
					System.out.println("Enter the new Zip");
					String newZip = sc3.next();
					contacts.zip = newZip;
					break;
					
				case 8:
					System.out.println("Enter the new Phone");
					String newPhone = sc3.next();
					contacts.phone = newPhone;
					break;

				default:
					break;
				}	
			}
		}
		
		}else {
			System.out.println("Address Book is empty");
		}
		if(isFound == 0 ) {
			System.out.println("Contact not found");
		}
	}
	
	public Contacts removeContactByName() {
		ContactDetails contactDetails = ContactDetails.getInstance();
		if(contactDetails.contactList.size() != 0) {
		System.out.println("Enter Firstname of Contact to delete");
		String name = sc.nextLine();
			for(Contacts contacts :contactDetails.contactList) {
				if(contacts.firstName.equals(name)) {
					contactDetails.contactList.remove(contacts);
					return null;
				}
			}
			System.out.println("Contact Not found");
		}else {
			System.out.println("Address book is empty");
		}
		return null;
	}
	
	public boolean isDuplicate(String firstName, String lastName) {
		boolean isDuplicate = false;
		for (int i = 0; i < contactDetails.contactList.size(); i++) {
			if(contactDetails.contactList.get(i).firstName.equals(firstName)&&contactDetails.contactList.get(i).lastName.equals(lastName)) {
				isDuplicate = true;
			}
		}
		return isDuplicate;
	}

}
