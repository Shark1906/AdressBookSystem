package bridgeit.addressbook;

import java.util.List;
import java.util.Scanner;

public class ContactOperations {
	private static ContactOperations instance;
	
	private ContactOperations() {}
	
	public static ContactOperations getInstance() {
		if(instance == null) {
			instance = new ContactOperations();
		}
		return instance;
	}
	
	ContactDetails contactDetails = new ContactDetails();
	
	public void addNewContact() {
		Scanner sc = new Scanner(System.in);
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

}
