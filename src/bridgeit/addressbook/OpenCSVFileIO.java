package bridgeit.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class OpenCSVFileIO implements BookIO {
	
	private static final String Location = "D:\\project\\training\\bridgelabz_rpf\\AdressBookSystem\\src";
	
	@SuppressWarnings("resource")
	@Override
	public void writeAddressBook(List<Contacts> contactList, String bookName) throws IOException
	{
		String fileName = Location+"\\" + bookName + ".csv";
		try {
			if(new CSVReader(new FileReader(fileName)) != null) {
				System.out.println("File Already exists");
			}
		}catch(FileNotFoundException ex) {
			File file = new File(fileName);
	        FileWriter outputfile = new FileWriter(file);
	        CSVWriter writer = new CSVWriter(outputfile);
	  
	        for (int i = 0; i < contactList.size(); i++) {
				String[] data = {contactList.get(i).firstName, contactList.get(i).lastName,
						contactList.get(i).address, contactList.get(i).city, 
						contactList.get(i).state, contactList.get(i).email, 
						contactList.get(i).zip, contactList.get(i).phone};
				writer.writeNext(data);
			}
	        writer.close();
		}
	}

	@Override
	public void readAddressBook(String name) throws IOException {
		try {
			
			String fileName = Location+"\\" + name + ".csv";
	        CSVReader csvReader = new CSVReader(new FileReader(fileName));
	        String[] nextRecord;
	        
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        	 for (String cell : nextRecord) {
	                 System.out.print(cell + ", ");
	             }
	             System.out.println();
	        }
	    }
	    catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
