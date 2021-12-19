package bridgeit.addressbook;

import java.io.IOException;
import java.util.List;

public interface BookIO {
	void writeAddressBook(List<Contacts> contactList, String bookName) throws IOException;

	void readAddressBook(String name) throws IOException;
}
