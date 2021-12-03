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
	
	ContactDetails contactDetails = new ContactDetails();
	
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
		contactDetails.contactList.add(contacts);
	}
	
	public List<Contacts> getList() {
		return contactDetails.contactList;
	}
	
	public void printAllContacts() {
		for (int i = 0; i < contactDetails.contactList.size(); i++) {
			System.out.println("Contact" + (i+1) + " " + contactDetails.contactList.get(i));		
		
		}
	}
	
	public Contacts editContact() {
		System.out.println("Enter first name of contact to Edit");
		String name = sc.nextLine();
		for(Contacts contacts :contactDetails.contactList) {
			if(contacts.firstName.equals(name)) {
				System.out.println(contacts);
				System.out.println("Enter what you want to edit \n1.Firstname \n2.Lastname"
						+ " \n3.Address \n4.City \n5.State \n6.Email \n7.Zip \n8.Phone");
				int choice = sc.nextInt();
				
				switch (choice) {
				case 1:
						System.out.println("Enter the new Firstname");
						String newFirstName = sc.next();
						contacts.firstName = newFirstName;
					break;
				
				case 2:
					System.out.println("Enter the new Lastname");
					String newLastName = sc.next();
					contacts.lastName = newLastName;	
					break;
					
				case 3:
					System.out.println("Enter the new Address");
					String newAddress = sc.next();
					contacts.address = newAddress;
					break;
					
				case 4:
					System.out.println("Enter the new City");
					String newCity = sc.next();
					contacts.city = newCity;
					break;
					
				case 5:
					System.out.println("Enter the new State");
					String newState = sc.next();
					contacts.state = newState;
					break;
					
				case 6:
					System.out.println("Enter the new Email");
					String newEmail = sc.next();
					contacts.email = newEmail;
					break;
					
				case 7:
					System.out.println("Enter the new Zip");
					String newZip = sc.next();
					contacts.zip = newZip;
					break;
					
				case 8:
					System.out.println("Enter the new Phone");
					String newPhone = sc.next();
					contacts.phone = newPhone;
					break;

				default:
					break;
				}
			return null;	
			}
		}
		return null;
	}

}
