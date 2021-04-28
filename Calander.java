import java.util.ArrayList;
import java.util.Date;

public class Calander extends App{

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

            int y, m, d, h, mn;
            int time;
            String description;
            valid=true;
            Date date1= new Date();

            if (choice == 1)
            {
                valid=true;
                System.out.println("Please enter year (yyyy), month(mm), day(dd), hour(hh) and minute(mm) seperated with space:\n");
                y= Integer.parseInt(Input.next());
                m= Integer.parseInt(Input.next());
                d= Integer.parseInt(Input.next());
                h= Integer.parseInt(Input.next());
                mn= Integer.parseInt(Input.nextLine());
                /*
                big problem!!!!!!!
                can't create date
                */
                System.out.println("Please enter the time the event takes (0-60)\n");
                time= Integer.parseInt(Input.nextLine());
                while(time<0||time>60)
                {
                    System.out.println("Please enter a valid time (0-60)\n");
                    time= Integer.parseInt(Input.nextLine());
                }
                System.out.println("Please enter description for the event\n");
                description=Input.nextLine();
                Event e= new Event(date1, time, description);

            }
            else if (choice == 2)
            {
                valid=true;
                System.out.println("Please enter year (yyyy), month(mm), day(dd), hour(hh) and minute(mm) seperated with space:\n");
                y= Integer.parseInt(Input.next());
                m= Integer.parseInt(Input.next());
                d= Integer.parseInt(Input.next());
                h= Integer.parseInt(Input.next());
                mn= Integer.parseInt(Input.nextLine());
                System.out.println("Please enter the time the event takes (0-60)\n");
                time= Integer.parseInt(Input.nextLine());
                while(time<0||time>60)
                {
                    System.out.println("Please enter a valid time (0-60)\n");
                    time= Integer.parseInt(Input.nextLine());
                }
                System.out.println("Enter a contact's name:");
                name = Input.nextLine();
                int place=findContact(name);
                

                if(place == -1)
                    System.out.println("This contact does not exist.");
                else
                    System.out.println("");
                    //adding the print to fix a weird problem
                    Meeting meet1=new Meeting(date1, time, contacts.get(place));
            }
            else
            {
                System.out.println("Please choose an option between 1 or 2. \n");
            }
        }
    }

    public void delete()
    {
        int choice;
        boolean valid = false;
        String name;
        while(!valid)
        {
            System.out.println("Would you like to delete a meeting or an occasion?");
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
                if(findContact(name) != -1);
                    //add meeting with name
                else
                    System.out.println("This contact does not exist.");
            }
            else
            {
                System.out.println("Please choose an option between 1 or 2. \n");
            }
        }
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
