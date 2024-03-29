package bridgeit.addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBook {

	static int input;

	public static void main(String[] args) throws IOException {
		ContactOperations contactOperations = ContactOperations.getInstance();
		AddressBook addressBook = AddressBook.getInstance();
		ContactDetails contactDetails = ContactDetails.getInstance();
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"What do you want to do:\n1. \sCreate AddressBook\n2. \sView AddressBook\n3. \sSearch a AddressBook"+
					"\n4.\s Search all AddressBook\n5.\s Sort AddressBook by Contact Name\n6.\s Sort AddressBook by Contact City" +
					"\n7.\s Write AddressBook\n8.\s Read AddressBook\n9.\s Create AddressBook CSV File\n10. Read AddressBook CSV File"+
					"\n11. Create AddressBook Json File\n12. Read AddressBook Json File\n13. Exit");
			input = sc.nextInt();
			switch (input) {
			case 1: {
				contactDetails.contactList = new ArrayList<>();
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the Address Book Name you want to create");
				String addressBookName = sc1.nextLine();
				if(addressBookName.length() > 0) {
				addressBook.addressBookOperations();
				contactDetails.addressBookMap.put(addressBookName, contactOperations.getList());
				}else {
					System.out.println("AddressBook Name should not be empty");
					}
				break;
			}

			case 2: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to view");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
					if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
						for (int i = 0; i < contactDetails.addressBookMap.get(addressBookName).size(); i++) {
							System.out.println(contactDetails.addressBookMap.get(addressBookName).get(i));
						}
					} else {
						System.out.println("Address Book is empty");
					}
					}
				}
				break;
			}

			case 3: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to search");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							List<Contacts> list = contactDetails.addressBookMap.get(addressBookName);
							System.out.println("Enter the city you want to search");
							String city = sc3.nextLine();
							for (int i = 0; i < list.size(); i++) {
								String fname = list.get(i).city;
								if (fname.equals(city)) {
									System.out.println(list.get(i));
								}
							}
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 4: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
				Scanner sc4 = new Scanner(System.in);
				System.out.println("Enter the city to get details of persons");
				String city = sc4.nextLine();
				List<Contacts> searchList = new ArrayList<>();
				
				for (String key: contactDetails.addressBookMap.keySet()) {
				    List<Contacts> list = contactDetails.addressBookMap.get(key);
				    for (int i = 0; i < list.size(); i++) {
				    	if(list.get(i).city.equals(city) ) {
				    		searchList.add(list.get(i));
				    	}
					}
				}
				
				if(searchList.size() > 0) {
					System.out.println("Number of Person in " + city + " : " + searchList.size());
				for (int i = 0; i < searchList.size(); i++) {
					System.out.println((i+1)+". "+searchList.get(i));
				}
				}else {
					System.out.println("No persons in this city");
				}
				}
				break;
			}
			
			case 5: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to sort");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							List<Contacts> list = contactDetails.addressBookMap.get(addressBookName);
							List<Contacts> sortedList = list.stream()
							.sorted(Comparator.comparing(Contacts::getFirstName))
							.collect(Collectors.toList());
							sortedList.forEach(System.out::println);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 6: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to sort");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							List<Contacts> list = contactDetails.addressBookMap.get(addressBookName);
							List<Contacts> sortedList = list.stream()
							.sorted(Comparator.comparing(Contacts::getCity))
							.collect(Collectors.toList());
							
							sortedList.forEach(System.out::println);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 7: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to write");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							List<Contacts> list = contactDetails.addressBookMap.get(addressBookName);
							new AddressBookFileIO().writeAddressBook(list, addressBookName);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 8: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to read");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							new AddressBookFileIO().readAddressBook(addressBookName);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 9: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to create CSV File");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							List<Contacts> list = contactDetails.addressBookMap.get(addressBookName);
							new OpenCSVFileIO().writeAddressBook(list, addressBookName);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 10: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to view CSV File");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							new OpenCSVFileIO().readAddressBook(addressBookName);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 11: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to create Json File");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							List<Contacts> list = contactDetails.addressBookMap.get(addressBookName);
							new AddressBookJson().writeAddressBook(list, addressBookName);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			
			case 12: {
				if (contactDetails.addressBookMap.isEmpty() == true) {
					System.out.println("Address book is empty");
				} else {
					System.out.println("Address Books Name : " + contactDetails.addressBookMap.keySet());
					Scanner sc2 = new Scanner(System.in);
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter the Address Book Name you want to view File");
					String addressBookName = sc2.nextLine();
					if (contactDetails.addressBookMap.get(addressBookName) == null) {
						System.out.println("Address Book Not found with this name");
					} else {
						if (contactDetails.addressBookMap.get(addressBookName).size() > 0) {
							new AddressBookJson().readAddressBook(addressBookName);
						} else {
							System.out.println("Address Book is empty");
						}
					}
				}
				break;
			}
			}
		} while (input != 13);
	}
}
