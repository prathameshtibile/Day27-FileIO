/**
 * @author PRATHAMESH TIBILE
 * @since 11-7-21
 * 
 */
package AdressBookController;

import AddressBookFileOperations.FileReaderWriter;
import AddressBookModel.ContactDetails;
import AddressBookServices.AddressBookServices;
import Util.UserInputOutput;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import AdressBookServices.AddressBookServices;

public class AddressBookMain {
	 static AddressBookServices addressBookServices = new AddressBookServices();
	    static Scanner input = new Scanner(System.in);

	    /**
	     * Purpose : Main Method perform all address book operations
	     */
	    public static void main(String args[]) {
	        Hashtable<String, ArrayList<ContactDetails>> contactInfo = new Hashtable<>();
	        FileReaderWriter fileReaderWriter = new FileReaderWriter();

	        String filePath = "C:\\Users\\Kunal\\IdeaProjects\\AddressBookSystem\\src\\Files\\AddressBookData";

	        boolean flag = true;
	        int option;
	        while (flag) {
	            option = UserInputOutput.userChoice();
	            switch (option) {
	                case 1:
	                    System.out.println("\n" + "Add a new Address Book\n");
	                    contactInfo = addressBookServices.addContactDetails();
	                    fileReaderWriter.writeData(filePath, contactInfo);
	                    break;
	                case 2:
	                    System.out.print("\n" + "Enter the name of the Address Book that you want to replace: \n");
	                    String companyName = input.next();
	                    addressBookServices.editContactDetails(companyName, contactInfo);
	                    break;
	                case 3:
	                    System.out.print("\n" + "Enter the name of the Address Book that you want to delete: \n");
	                    String deletedName = input.next();
	                    addressBookServices.deleteContactDetails(deletedName, contactInfo);
	                    break;
	                case 4:
	                    System.out.println("\n" + "Display all contacts in the Address Book\n");
	                    //addressBookServices.display(contactInfo);
	                    fileReaderWriter.readData(filePath);
	                    break;
	                case 5:
	                    System.out.println("\n" + "Search Address Book based on City\n");
	                    addressBookServices.searchPersons();
	                    flag = true;
	                    break;
	                case 6:
	                    System.out.println("\n" + "Sort Data in Address Book\n");
	                    AddressBookServices.sortPersonsData();
	                    break;

	                case 7:
	                    flag = false;
	                    System.out.println("\n" + "Thank you for referring the address book.");
	                    break;
	            }
	        }
	    }

}
