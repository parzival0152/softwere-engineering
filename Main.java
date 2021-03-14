import java.util.Scanner;
import java.util.ArrayList;
// import java.util.Collections;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        boolean exit = false;
        String name;
        String number;
        ArrayList<Contact> contactList = new ArrayList<>();
        while (!exit)
        {
            
            //print out the start menu
            System.out.println("Please choose one of the following options: ");
            System.out.println("1. Add new contact");
            System.out.println("2. Remove a contact by name");
            System.out.println("3. Print all contacts");
            System.out.println("4. Find contact by name");
            System.out.println("5. Sort contact list by name");
            System.out.println("6. Sort contact list by number");
            System.out.println("7. Remove duplicates");
            System.out.println("8. Sort in reverse");
            System.out.println("9. Save to file");
            System.out.println("10. Load from file");
            System.out.println("11. exit");
            //get choice
            System.out.print("Your choice: ");
            option = Integer.parseInt(input.nextLine());
            //cls
            clearScreen();
            //switch based on the option that they chose
            switch (option) {
                case 1:
                    //add new contact;
                    System.out.print("Enter contact name: ");
                    name = input.nextLine();
                    System.out.print("Enter contact number: ");
                    number = input.nextLine();
                    contactList.add(new Contact(name, number));
                    break;

                case 2:
                    //remove by name
                    System.out.print("Enter contact name: ");
                    name = input.nextLine();
                    for (int i = 0; i < contactList.size(); i++) {
                        if(name.equals(contactList.get(i).name))
                        {
                            contactList.remove(i);
                            break;
                        }
                    }
                    break;

                case 3:
                    //print all contacts
                    for(Contact c: contactList)
                    {
                        System.out.println(c);
                    }
                    input.nextLine();
                    break;

                case 4:
                    //find contact by name
                    System.out.print("Enter contact name: ");
                    name = input.nextLine();
                    for (int i = 0; i < contactList.size(); i++) {
                        if(name.equals(contactList.get(i).name))
                        {
                            System.out.println(contactList.get(i));
                        }
                    }
                    input.nextLine();
                    break;

                case 5:
                    //sort contact list by name
                    break;

                case 6:
                    //sort contact list by number
                    break;

                case 7:
                    //remove dups
                    break;

                case 8:
                    //sort in reverse
                    break;

                case 9:
                    //save to file
                    break;

                case 10:
                    //read from file
                    break;
                 
                case 11:
                    //quit
                    exit = true;
                    break;

                default:
                    //default cause we have to have one
                    System.out.println("Error: not an option");
                    break;
            }
        }
        input.close();
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    } 
}

class Contact{
    String name;
    String number;
    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString()
    {
        return this.name + " : "+this.number;
    }
}