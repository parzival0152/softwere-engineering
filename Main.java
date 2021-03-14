import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.Collections;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        boolean exit = false;
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
                    System.out.println("you choose 1");
                    break;

                case 2:
                    //remove by name
                    System.out.println("you choose 2");
                    break;

                case 11:
                    exit = true;
                    break;
                default:
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