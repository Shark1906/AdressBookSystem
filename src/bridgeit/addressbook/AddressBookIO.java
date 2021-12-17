package bridgeit.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class AddressBookIO {
	
	private static final String Location = "D:\\project\\training\\bridgelabz_rpf\\AdressBookSystem\\src";

	public static void writeAddressBook(List<Contacts> contactList, String bookName) throws IOException {
		try {
		String url = Location+"\\" + bookName;
		Path bookPath = Paths.get(url);
		Files.createDirectories(bookPath);
		String bookFileWrite = url + "\\" + bookName + ".txt";
		Path bookFile = Paths.get(bookFileWrite);
		Files.createFile(bookFile);
		
		FileWriter output = new FileWriter(bookFileWrite);
		StringBuffer addressBuffer = new StringBuffer();
		contactList.forEach(contact -> {
			String employeeDataString = contact.toString().concat("\n");
			addressBuffer.append(employeeDataString);
			});
			
			output.write(addressBuffer.toString());
			System.out.println("Data added in file.");
			output.close();
		}catch(FileAlreadyExistsException ex) {
			System.out.println("File Already Exist");
		}
		
	}
	
	public static void readAddressBook(String name) {
		try {
		File file = new File(Location + "\\" +name+ "\\" +name+ ".txt");
		Scanner sc = new Scanner(file);
		if(file.exists()) {
		while(sc.hasNextLine())
		System.out.println(sc.nextLine());
		sc.close();
		}}catch(FileNotFoundException ex) {
			System.out.println("File not Found");
		}
	}

}
