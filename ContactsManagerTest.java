import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class ContactsManagerTest {
    public static void main(String[] args) {
        ContactsManager contactList = new ContactsManager("contacts.txt", "data");
        ArrayList<ContactsManager> files = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);


        System.out.println("Would you like to access contactApp yes or no?");
        String userContinue = userInput.nextLine();

        while(userContinue.equalsIgnoreCase("yes")) {

            contactList.mainScreen();

            String userChoice = userInput.nextLine();

            if (userChoice.equals("1")) {
                contactList.printLines();
                System.out.println("Would you like to continue? yes or no.");
            } else if (userChoice.equals("2")) {
                contactList.addContactInfo();
                System.out.println("Would you like to continue? yes or no.");
            } else if (userChoice.equals("3")) {
                contactList.searchContact();
                System.out.println("Would you like to continue? yes or no.");
            } else if (userChoice.equals("4")) {
                contactList.deleteContact();
                System.out.println("Would you like to continue? yes or no.");
            } else if (userChoice.equals("5")) {
                System.out.println("Have a good day!");
            }
            userContinue = userInput.nextLine();
        }

        System.out.println("Have a good day!");
    }
}
