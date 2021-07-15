package DAO;

import AddressBookModel.ContactDetails;
import Util.UserInputOutput;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class AddressBook {
	Scanner input = new Scanner(System.in);
    Hashtable<String,ArrayList<ContactDetails>> contactInfo= new Hashtable<>();
    ContactDetails c = null;
    ArrayList<ContactDetails> cList = new ArrayList<>();

    /**
     * getting data from user and stores in object and returns the object
     *
     * @return
     */
    public ContactDetails readDataFromConsole() {
        ContactDetails contactDetails = new ContactDetails();

        String fName = UserInputOutput.getCustomerFirstName();
        contactDetails.setFirstName(fName);

        String lName = UserInputOutput.getCustomerLastName();
        contactDetails.setLastName(lName);

        String eMail = UserInputOutput.getCustomerEmailAddress();
        contactDetails.setEmailAddress(eMail);

        String hAddress = UserInputOutput.getCustomerHomeAddress();
        contactDetails.setHomeAddress(hAddress);

        String cName = UserInputOutput.getCustomerCityName();
        contactDetails.setCity(cName);

        String sName = UserInputOutput.getCustomerStateName();
        contactDetails.setState(sName);

        String mNUmber = UserInputOutput.getCustomerMobileNumber();
        contactDetails.setMobileNumber(mNUmber);

        String pCode = UserInputOutput.getCustomerPinCode();
        contactDetails.setPinCode(pCode);

        return contactDetails;
    }


    /**
     * Purpose : To add contact details in address book
     *           - ask user address book name
     *           - search for that particular company as its key
     *           - then add info to that address book arraylist if already present
     *           - creates new address book and then adds details in arraylist
     *
     * @return
     */
    public Hashtable<String,ArrayList<ContactDetails>> addContactDetails() {
        boolean found = false;
        System.out.print("\nEnter the Address Book Name: ");
        String addressBookName = input.next();
        c = readDataFromConsole();

        if (contactInfo.containsKey(addressBookName)) {
            ArrayList<ContactDetails> value = contactInfo.get(addressBookName);
            for (int j = 0; j < value.size(); j++) {

               /*Purpose : Using Java Streams to search for duplicate contacts.
                          If duplicate contact exist, then do not insert the contact details.
                Dated : 03.07.2021
               */

                List<String> names = value.stream().map(ContactDetails::getFirstName).collect(Collectors.toList());

                for ( int k = 0; k < names.size(); k++)  {
                    if(names.get(j).equals(c.getFirstName())) {
                        found = true;
                        break;
                    }
                }
            }
            if (found == true)
                System.out.println("\nDuplicate First Name in Address Book!\n");
            else {
                value.add(c);
                contactInfo.put(addressBookName, value);
            }
        }
        else {
            cList = new ArrayList<>();
            cList.add(c);
            contactInfo.put(addressBookName, cList);
        }

        return contactInfo;
    }

    /**
     * Purpose : To edit contact details of person from address book
     *           - ask user to enter address book name
     *           - if present then edit details else not
     *
     * @param addressBookName input from user
     * @param contactInfo Hashtable of Address Book
     */
    public void editContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>> contactInfo) {
        boolean flag = findContact(addressBookName,contactInfo);
        if(flag){
            updateContactDetails(addressBookName,contactInfo);
        } else {
            System.out.println("\nNo such Address Book Found To Edit");
        }
    }

    /**
     * Purpose : To update details in address book
     *           - ask user to enter to first name to edit
     *           - if first name present then edit details else not
     *
     * @param addressBookName
     * @param contactInfo
     */
    public void updateContactDetails(String addressBookName, Hashtable<String, ArrayList<ContactDetails>> contactInfo) {
        System.out.print("\nEnter the first name you want to edit the details for : ");
        String fName = input.next();

        ArrayList<ContactDetails> value = contactInfo.get(addressBookName);
        for (int j = 0; j < value.size(); j++) {
            if(value.get(j).getFirstName().equals(fName)) {
                System.out.println("Choose your edit option: ");
                System.out.println("1. Last Name");
                System.out.println("2. Address");
                System.out.println("3. City");
                System.out.println("4. State");
                System.out.println("5. Zip");
                System.out.println("6. Phone Number");
                System.out.println("7. Email");
                int editOption = input.nextInt();

                switch (editOption) {
                    case 1:
                        System.out.println("Enter new Last Name: ");
                        value.get(j).setLastName(input.next());
                        break;
                    case 2:
                        System.out.println("Enter new Address: ");
                        value.get(j).setHomeAddress(input.next());
                        break;
                    case 3:
                        System.out.println("Enter new City: ");
                        value.get(j).setCity(input.next());
                        break;
                    case 4:
                        System.out.println("Enter new State: ");
                        value.get(j).setState(input.next());
                        break;
                    case 5:
                        System.out.println("Enter new Pin Code: ");
                        value.get(j).setPinCode(input.next());
                        break;
                    case 6:
                        System.out.println("Enter new Phone Number: ");
                        value.get(j).setMobileNumber(input.next());
                        break;
                    case 7:
                        System.out.println("Enter new Email: ");
                        value.get(j).setEmailAddress(input.next());
                        break;
                }
                System.out.println("\nUpdated successfully!\n");
                break;
            }
            else
                System.out.println("\nNo First Name Found!\n");
        }
    }

    /**
     * Purpose : to delete details from address book
     *           - checks company name present or not
     *           - if present then ask user to enter name
     *           - if name is present then deletes from list
     *
     * @param addressBookName
     * @param contactInfo
     */
    public void deleteContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>>contactInfo) {
        boolean found = false;
        boolean flag = findContact(addressBookName, contactInfo);

        if (flag == true) {
            System.out.print("\nEnter the first name you want to delete : ");
            String fName = input.next();

            ArrayList<ContactDetails> value = contactInfo.get(addressBookName);
            for (int j = 0; j < value.size(); j++) {
                if(value.get(j).getFirstName().equals(fName)) {
                    value.remove(j);
                    found = true;
                    break;
                }
            }
            if( found == true) {
                System.out.println("\nContact in Address Book Deleted.\n");
            }
            else
                System.out.println("\nNo such First Name found in the Address Book.\n");
        }
        else
            System.out.println("\nNo contacts found in the Address Book.\n");
    }

    /**
     * Purpose : To check whether Address Book Company is present in Hashtable or not
     *
     * @param addressBookName
     * @param contactInfo
     * @return
     */
    public boolean findContact(String addressBookName, Hashtable<String,ArrayList<ContactDetails>>contactInfo) {
        for (int i = 0; i < contactInfo.size(); i++){
            if(contactInfo.containsKey(addressBookName))
                return true;
        }
        return false;
    }

    /**
     * Purpose : Displays the addressBook details
     *
     * @param contactInfo
     */
    public void display(Hashtable<String,ArrayList<ContactDetails>>contactInfo) {
        contactInfo.keySet().forEach(entry -> {
            System.out.println(entry + "->" + contactInfo.get(entry)+ "\n");
        });
    }


    /**
     * Purpose : To get person details of same city or state ,multiple persons can be in same city or state
     *
     * @Since 05-07-2021
     */
    public void searchPersons() {
        Hashtable<String, Hashtable<String, ArrayList<String>>> hSearch = new Hashtable<>();
        AtomicInteger count = new AtomicInteger();

        System.out.println("Press 1 to search person by city");
        System.out.println("Press 2 to search person by state");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("\nEnter the city name to search: ");
                String cityName = input.next();

                contactInfo.keySet().forEach(entry -> {
                    ArrayList<ContactDetails> value = contactInfo.get(entry);
                    List<String> city = value.stream().map(ContactDetails::getCity).collect(Collectors.toList());
                    Hashtable<String, ArrayList<String>> person = new Hashtable<>();
                    ArrayList<String> firstName = new ArrayList<>();
                    for ( int k = 0; k < city.size(); k++)  {
                        if (city.get(k).equals(cityName)) {
                            firstName.add(value.get(k).getFirstName());
                            count.getAndIncrement();
                        }
                        person.put(cityName , firstName);
                    }
                    hSearch.put(entry , person);
                });

                break;
            case 2:
                System.out.print("\nEnter the state name to search: ");
                String stateName = input.next();

                contactInfo.keySet().forEach(entry -> {
                    ArrayList<ContactDetails> value = contactInfo.get(entry);
                    List<String> city = value.stream().map(ContactDetails::getState).collect(Collectors.toList());
                    Hashtable<String, ArrayList<String>> person = new Hashtable<>();
                    ArrayList<String> firstName = new ArrayList<>();
                    for ( int k = 0; k < city.size(); k++)  {
                        if (city.get(k).equals(stateName)) {
                            firstName.add(value.get(k).getFirstName());
                            count.getAndIncrement();
                        }
                        person.put(stateName , firstName);
                    }
                    hSearch.put(entry , person);
                });

                break;
        }
        System.out.println("\nViewing Persons by City or State\n" +hSearch);
        System.out.println("\nNumber of contact persons i.e. count by City or State is : " +count +"\n");
    }

    /**
     * Purpose : Ability to sort the entries in the address book alphabetically by
     *           - Person’s name
     *           - City Name
     *           - State Name
     *           - Pin Code
     *
     * @Since 06-07-2021
     */
    public void sortPersonsData(){
        System.out.println("Press 1 to sort person by First Name");
        System.out.println("Press 2 to sort person by City");
        System.out.println("Press 3 to sort person by State");
        System.out.println("Press 4 to sort person by Pin Code");
        int choice = input.nextInt();

        switch(choice) {
            case 1:
                System.out.println("\nSorting Address Book based on First Name");
                contactInfo.keySet().forEach(entry -> {
                    List<ContactDetails> data = contactInfo.get(entry).stream().sorted(Comparator.comparing(ContactDetails::getFirstName)).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
            case 2:
                System.out.println("\nSorting Address Book based on City");
                contactInfo.keySet().forEach(entry -> {
                    List<ContactDetails> data = contactInfo.get(entry).stream().sorted(Comparator.comparing(ContactDetails::getCity)).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
            case 3:
                System.out.println("\nSorting Address Book based on State");
                contactInfo.keySet().forEach(entry -> {
                    List<ContactDetails> data = contactInfo.get(entry).stream().sorted(Comparator.comparing(ContactDetails::getState)).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
            case 4:
                System.out.println("\nSorting Address Book based on PinCode");
                contactInfo.keySet().forEach(entry -> {
                    List<ContactDetails> data = contactInfo.get(entry).stream().sorted(Comparator.comparing(ContactDetails::getPinCode)).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
        }
    }

}
