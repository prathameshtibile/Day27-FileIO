package AdressBookServices;

import AddressBookModel.ContactDetails;

import java.util.ArrayList;
import java.util.Hashtable;


public class AddressBookInterfaceService {
	 Hashtable<String, ArrayList<ContactDetails>> addContactDetails();

	    void editContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>> contactInfo);

	    void deleteContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>>contactInfo);

	    void display(Hashtable<String,ArrayList<ContactDetails>>contactInfo);

	    void searchPersons();

	    public void sortPersonsData();
	}

}
