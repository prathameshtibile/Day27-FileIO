package AdressBookServices;

import AddressBookModel.ContactDetails;
import DAO.AddressBook;

import java.util.ArrayList;
import java.util.Hashtable;

public class AddressBookServices {
	public class AddressBookServices implements AddressBookInterfaceService {

	    AddressBook addressBook = new AddressBook();

	    @Override
	    public Hashtable<String, ArrayList<ContactDetails>> addContactDetails() {
	        return addressBook.addContactDetails();
	    }

	    @Override
	    public void editContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>> contactInfo) {
	        addressBook.editContactDetails(addressBookName,contactInfo);
	    }

	    @Override
	    public void deleteContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>>contactInfo) {
	        addressBook.deleteContactDetails(addressBookName,contactInfo);
	    }

	    @Override
	    public void display(Hashtable<String,ArrayList<ContactDetails>>contactInfo) {
	        addressBook.display(contactInfo);
	    }

	    @Override
	    public void searchPersons(){
	        addressBook.searchPersons();
	    }

	    @Override
	    public void sortPersonsData(){
	        addressBook.sortPersonsData();
	    }


}
