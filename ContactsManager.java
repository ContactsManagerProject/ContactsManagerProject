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
    public static void main(String[] args) {
        String directory = "data";
        String fileName = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path datafile = Paths.get(directory,fileName);

        //Create directory data & file named contacts.txt within
        try{
            if (Files.notExists(dataDirectory)){
                Files.createDirectories(dataDirectory);
            }
        }
        catch(IOException e){
            System.out.println("Exception caught at " + e);
            e.printStackTrace();
        }

        try{
            if(Files.notExists(datafile)){
                Files.createDirectories(datafile);
            }
        }
        catch (IOException e){
            System.out.println("Exception caught at " + e);
            e.printStackTrace();
        }
        //Create directory data & file named contacts.txt within

        //Ask user for username and phone number
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a user name");
        String userContact = userInput.nextLine();
        System.out.println("Enter their phone number");
        String userPhoneNumber = userInput.nextLine();
        //Ask user for username and phone number

        //Write a list of strings to a file
        Path Files.write();

        //Creat list & write contents to file
        try{
            List<String> contactList = Arrays.asList(userContact,userPhoneNumber);
            Path filePath = Paths.get("data","contacts.txt");
            Files.write(filePath,contactList);}
        catch(IOException e){
            System.out.println("Exception caught at " + e);
            e.printStackTrace();
        }
        //Create list & write contents to file


        try{Files.write(Paths.get("data","contacts.txt"),
                Arrays.asList(userContact), StandardOpenOption.APPEND);}
        catch(IOException e){
            System.out.println("IOException caught at " + e);
            e.printStackTrace();
        }



    }
}
