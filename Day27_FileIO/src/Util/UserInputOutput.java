package Util;

import java.util.Scanner;

public class UserInputOutput {
	private static Scanner scanner = new Scanner(System.in);

    public static String getCustomerFirstName(){
        System.out.println("Enter the First Name : ");
        return scanner.next();
    }

    public static String getCustomerLastName(){
        System.out.println("Enter the Last Name : ");
        return scanner.next();
    }

    public static String getCustomerEmailAddress(){
        System.out.println("Enter the Email Address : ");
        return scanner.next();
    }

    public static String getCustomerHomeAddress(){
        scanner.nextLine();
        System.out.println("Enter the Home Address : ");
        return scanner.nextLine();
    }

    public static String getCustomerCityName(){
        System.out.println("Enter the City Name : ");
        return scanner.next();
    }

    public static String getCustomerStateName(){
        System.out.println("Enter the State Name : ");
        return scanner.next();
    }

    public static String getCustomerMobileNumber(){
        System.out.println("Enter the Mobile Number : ");
        return scanner.next();
    }

    public static String getCustomerPinCode(){
        System.out.println("Enter the Pin Code : ");
        return scanner.next();
    }
    public static int userChoice(){
        System.out.println("Press 1 - Add Contact Details ");
        System.out.println("Press 2 - Edit Contact Details ");
        System.out.println("Press 3 - Delete Contact Details ");
        System.out.println("Press 4 - Display Contact Details ");
        System.out.println("Press 5 - Search Persons by City or State Name ");
        System.out.println("Press 6 - Sort Person Data ");
        System.out.println("Press 7 - Exit !!! ");

        return scanner.nextInt();
    }

}
