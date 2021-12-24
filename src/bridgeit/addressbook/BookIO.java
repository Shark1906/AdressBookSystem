package bridgeit.addressbook;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;

public interface BookIO {
	void writeAddressBook(List<Contacts> contactList, String bookName) throws IOException;

	void readAddressBook(String name) throws IOException, ClassNotFoundException;
}
