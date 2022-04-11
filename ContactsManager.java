import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {
        String directory;
        String fileName;
        Path dataDirectory;
        Path datafile;
        List<String> fileData;

        //Declare data
        public ContactsManager(String fileName, String directory) {
            this.fileName = fileName;
            this.directory = directory;

            this.dataDirectory = Paths.get(directory);
            this.datafile = Paths.get(directory, fileName);

            this.fileData = getFile();
        }
        //Declare data

        //Create directory data & file named contacts.txt within
            public List<String> getFile() {

                try {
                    if (Files.notExists(dataDirectory))
                        Files.createDirectories(dataDirectory);
                } catch (IOException e) {
                    System.out.println("Exception caught at " + e);
                    e.printStackTrace();
                }

                try {
                    if (Files.notExists(datafile)) {
                        Files.createFile(datafile);
                    }
                } catch (IOException e) {
                    System.out.println("Exception caught at " + e);
                    e.printStackTrace();
                }
                List<String> data = null;

                try {
                    data = Files.readAllLines(datafile);
                } catch (IOException iox) {
                    System.out.println("Error reading files " + iox);
                    iox.printStackTrace();
                }
                return data;
            }
        //Create directory data & file named contacts.txt within

        //Ask user for username and phone number and add to list
    public void addContactInfo() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a user name");
        String userContact = userInput.nextLine() + "  |  ";
        System.out.println("Enter their phone number");
        String userPhoneNumber = userInput.nextLine();

        if (userPhoneNumber.length() == 10){
            String formattedPhoneNumber = String.format("(%s) %s-%s", userPhoneNumber.substring(0, 3), userPhoneNumber.substring(3, 6),
                    userPhoneNumber.substring(6, 10));

            try {
                Files.write(Paths.get("data", "contacts.txt"),
                        Arrays.asList(userContact + " " + formattedPhoneNumber), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("IOException caught at " + e);
                e.printStackTrace();
            }
        }

        else if (userPhoneNumber.length() == 7) {
            String formattedPhoneNumber = String.format("%s-%s", userPhoneNumber.substring(0, 3), userPhoneNumber.substring(3, 7));

            try {
                Files.write(Paths.get("data", "contacts.txt"),
                        Arrays.asList(userContact + " " + formattedPhoneNumber), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("IOException caught at " + e);
                e.printStackTrace();
            }

        }
            else {
                System.out.println("You have entered an incorrect phone #.");
            }

//        printLines();
    }
        //Ask user for username and phoneNumber and add to list

    //Print user data
    public void printLines() {
        System.out.println("Name  |  Phone number");
        System.out.println("--------------------");
        for (String line : fileData) {
            System.out.println(line);
        }
    }
    //Print user data

    //Delete user function
    public void deleteContact() {
            try{
            List<String> lines = Files.readAllLines(Paths.get("data","contacts.txt"));
            List<String> newList = new ArrayList<>();

            Scanner userInput = new Scanner(System.in);
        System.out.println("Type a contact to delete");
        String contactToDelete = userInput.nextLine();

            for (String line : lines){
                if (line.contains(contactToDelete)){
                    newList.add("USER DELETED");
                    continue;
                }
                newList.add(line);
            }
            Files.write(Paths.get("data","contacts.txt"), newList);}

            catch(IOException iox){
                System.out.println("Exception caught at " + iox);
                iox.printStackTrace();
            }
        }
    //Delete user content

    //Search for user info by name or number
    public void searchContact(){
        System.out.println("Enter name to search for");
        Scanner userInput = new Scanner(System.in);
        String userSearch = userInput.nextLine();
        try {
            List<String> lines = Files.readAllLines(Paths.get("data", "contacts.txt"));

            for (String line : lines) {
                if (line.contains(userSearch)) {
                    System.out.println(line);
                }
            }
        }
        catch(IOException iox){
            System.out.println("Exception caught at " + iox);
            iox.printStackTrace();
        }
    };

    public void mainScreen(){
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
    };
    //Search for user info by name or number


    //Creat list & write contents to file
//        try{
//            List<String> contactList = Arrays.asList(userContact,userPhoneNumber);
//            Path filePath = Paths.get("data","contacts.txt");//filePath = data/contacts.txt
//            Files.write(filePath,contactList);}
//        catch(IOException e){
//            System.out.println("Exception caught at " + e);
//            e.printStackTrace();
//        }

        //Create list & write contents to file


//        System.out.println("Enter a user name");
//        String userAddContact = userInput.nextLine();
//        System.out.println("Enter their phone number");

//        String userAddPhoneNumber = userInput.nextLine();


        //Adds Contact name and number to list

        //Adds contact name and number to list
//        Path contactsPath = Paths.get("data","contacts.txt");
//        List<String> contactsList = new ArrayList<>();
//        contactsList
    }

