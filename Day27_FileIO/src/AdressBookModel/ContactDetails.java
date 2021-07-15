package AdressBookModel;

public class ContactDetails {
	 String firstName;
	    String lastName;
	    String emailAddress;
	    String homeAddress;
	    String city;
	    String state;
	    String mobileNumber;
	    String pinCode;

	    public ContactDetails() {
	    }

	    @Override
	    public String toString() {
	        return "AddressBook{" +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", emailAddress='" + emailAddress + '\'' +
	                ", homeAddress='" + homeAddress + '\'' +
	                ", city='" + city + '\'' +
	                ", state='" + state + '\'' +
	                ", mobileNumber='" + mobileNumber + '\'' +
	                ", pinCode='" + pinCode + '\'' +
	                '}';
	    }

	    public ContactDetails(String firstName, String lastName, String emailAddress, String homeAddress, String city, String state, String mobileNumber, String pinCode) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.emailAddress = emailAddress;
	        this.homeAddress = homeAddress;
	        this.city = city;
	        this.state = state;
	        this.mobileNumber = mobileNumber;
	        this.pinCode = pinCode;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmailAddress() {
	        return emailAddress;
	    }

	    public void setEmailAddress(String emailAddress) {
	        this.emailAddress = emailAddress;
	    }

	    public String getHomeAddress() {
	        return homeAddress;
	    }

	    public void setHomeAddress(String homeAddress) {
	        this.homeAddress = homeAddress;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getMobileNumber() {
	        return mobileNumber;
	    }

	    public void setMobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	    }

	    public String getPinCode() {
	        return pinCode;
	    }

	    public void setPinCode(String pinCode) {
	        this.pinCode = pinCode;
	    }

}
