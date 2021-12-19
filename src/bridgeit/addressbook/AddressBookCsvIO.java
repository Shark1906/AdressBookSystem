package bridgeit.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AddressBookCsvIO implements BookIO {
	
	private static final String Location = "D:\\project\\training\\bridgelabz_rpf\\AdressBookSystem\\src";

	@Override
	public void writeAddressBook(List<Contacts> contactList, String bookName) throws IOException {
		String fileName = Location+"\\" + bookName + ".csv";
		
		File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < contactList.size(); i++) {
			bw.write(contactList.get(i).firstName + "," + contactList.get(i).lastName  
					+ "," + contactList.get(i).address  + "," + contactList.get(i).city  + "," 
					+ contactList.get(i).state  + "," + contactList.get(i).email  + "," 
					+ contactList.get(i).zip  + "," + contactList.get(i).phone);
			bw.newLine();
		}
        bw.close();
        fw.close();
	}

	@Override
	public void readAddressBook(String name) throws IOException {
		String fileName = Location+"\\" + name + ".csv";
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader(fileName));
		String row;
		while (( row = csvReader.readLine()) != null) {
		String[] data = row.split(",");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println();
		}} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} 

	}

}
