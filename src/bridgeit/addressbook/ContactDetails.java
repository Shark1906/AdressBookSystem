package bridgeit.addressbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDetails {
	private static ContactDetails instance;
	
	private ContactDetails() {}
	
	public static ContactDetails getInstance() {
		if(instance == null) {
			instance = new ContactDetails();
		}
		return instance;
	}
	
	
	
	List<Contacts> contactList;
	Map<String, List> addressBookMap = new HashMap<>();
}
