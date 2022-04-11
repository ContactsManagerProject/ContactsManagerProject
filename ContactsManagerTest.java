import java.util.ArrayList;
import java.util.logging.FileHandler;

public class ContactsManagerTest {
    public static void main(String[] args) {
        ContactsManager contactList = new ContactsManager("contacts.txt", "data");

        ArrayList<ContactsManager> files = new ArrayList<>();

//        contactList.getUserInput();

        files.add(new ContactsManager("contacts.txt", "data"));

        contactList.printLines();

//        contactList.deleteContact();
        contactList.searchContact();

    }
}
