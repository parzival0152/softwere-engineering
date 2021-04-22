import java.util.ArrayList;
import java.util.Date;

public class Calander extends App{

    public Date date;
    ArrayList<Contact> contacts;

    public void run()
    {
        contacts = get();
        boolean quit = false;
        while (!quit) {
            int option = Helper.option(
                "Add an occasion",
                "Delete an occasion",
                "Show all occasions in a date",
                "Show all meetings with a contact",
                "Find if there is an ocassions collision",
                "Show all occasions",
                "Exit"
            );
            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    show_date();
                    break;
                case 4:
                    show_contact();
                    break;
                case 5:
                    collision_finder();
                    break;
                case 6:
                    show_all();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void add()
    {
        //Add an occasion
        int choice;
        boolean valid = false;
        String name;
        while(!valid)
        {
            System.out.println("Would you like to add an event or a meeting?");
            System.out.println("1. Event \n2. Meeting \n");
            choice = Integer.parseInt(Input.nextLine());
            if (choice == 1)
            {
                valid=true;
                //event
            }
            else if (choice == 2)
            {
                valid=true;
                System.out.println("Enter a contact's name:");
                name = Input.nextLine();
                
                //meeting
            }
            else
            {
                System.out.println("Please choose an option between 1 or 2. \n");
            }
        }
    }

    public void delete()
    {
        //delete an occasion
    }

    public void show_date()
    {
        //Show all occasions in a date
    }

    public void show_contact()
    {
        //"Show all meetings with a contact"
    }

    public void collision_finder()
    {
        //"find if there is an ocassions collision"
    }

    public void show_all()
    {
        //"Show all occasions"
    }

    public void print()
    {
        //TBI
    }
}
