package bridgeit.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class AddressBookJson implements BookIO {
	
private static final String Location = "D:\\project\\training\\bridgelabz_rpf\\AdressBookSystem\\src";
	
	@SuppressWarnings("resource")
	@Override
	public void writeAddressBook(List<Contacts> contactList, String bookName) throws IOException
	{
		String fileName = Location+"\\" + bookName + ".json";
		try {
			if(new JsonReader(new FileReader(fileName)) != null) {
				System.out.println("File Already exists");
			}
		}catch(FileNotFoundException ex) {
			File file = new File(fileName);
	        FileWriter outputfile = new FileWriter(file);
	        Gson gson = new Gson();
	  
	        for (int i = 0; i < contactList.size(); i++) {
	        	gson.toJson(contactList.get(i), outputfile);
				
			}
	        outputfile.close();
		}
	}

	@Override
	public void readAddressBook(String name) throws IOException {
		try {
			
			String fileName = Location+"\\" + name + ".json";
			Gson gson = new Gson();
	        JsonReader jsonReader = new JsonReader(new FileReader(fileName));
	        jsonReader.setLenient(true);
	        while(jsonReader.hasNext()) {
	        Contacts contacts = gson.fromJson(jsonReader, Contacts.class);
	        
	        	System.out.println(contacts);
	        }
	        jsonReader.close();
	        
	    }
	    catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		catch (IllegalStateException|JsonSyntaxException e) {
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
