import java.util.ArrayList;
import java.util.HashMap;

//import jdk.internal.util.xml.impl.Input;

public class Calander extends App{

    ArrayList<Contact> contacts;
    HashMap<String, ArrayList<Integer>> contactMap;
    ArrayList<Occasion>[] dateArr;

    Calander()
    {
        contactMap = new HashMap<String, ArrayList<Integer>>();
        dateArr = new ArrayList[30];
        for(int i=0; i<30; i++)
        {
            dateArr[i] = new ArrayList<Occasion>();
        }
    }

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
            clearScreen();
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

            int d, h, mn;
            int time;
            String description;
            valid=true;
            BetterDate date1= new BetterDate();

            //event
            if (choice == 1)
            {
                valid=true;
                System.out.println("Please enter day(dd), hour(hh) and minute(mm) seperated with enter:\n");
                d= Integer.parseInt(Input.nextLine());
                h= Integer.parseInt(Input.nextLine());
                mn= Integer.parseInt(Input.nextLine());
                System.out.println("Please enter the time the event takes (0-60)\n");
                time= Integer.parseInt(Input.nextLine());
                while(time<0||time>60)
                {
                    System.out.println("Please enter a valid time (0-60)\n");
                    time= Integer.parseInt(Input.nextLine());
                }
                System.out.println("Please enter description for the event\n");
                description=Input.nextLine();
                date1.setDay(d);
                date1.setHours(h);
                date1.setMinutes(mn);
                Event e= new Event(date1, time, description);
                //this print is for checking
                System.out.println("The Event is in day " + e.date.getDay() + " and hour " + e.date.getHours() + " and minute " + e.date.getMinutes() + "\n");
                System.out.println("The description is " + e.description );
                dateArr[d-1].add(e);
                System.out.println("The occasions on day " + d + "are: ");
                for( int i=0; i<dateArr[d-1].size(); i++)
                {
                    dateArr[d-1].get(i).print();
                }
            }

            //meeting
            else if (choice == 2)
            {
                valid=true;
                System.out.println("Enter a contact's name:");
                name = Input.nextLine();
                int place=findContact(name);
                //check if contact exists
                if(place == -1)
                    System.out.println("This contact does not exist.");
                //if it does exist
                else
                {
                    System.out.println("Please enter day(dd), hour(hh) and minute(mm) seperated with enter:\n");
                    d= Integer.parseInt(Input.nextLine());
                    h= Integer.parseInt(Input.nextLine());
                    mn= Integer.parseInt(Input.nextLine());
                    System.out.println("Please enter the time the event takes (0-60)\n");
                    time= Integer.parseInt(Input.nextLine());
                    while(time<0||time>60)
                    {
                        System.out.println("Please enter a valid time (0-60)\n");
                        time = Integer.parseInt(Input.nextLine());
                        if(time<0||time>60)
                            System.out.println("The time entered is invalid.");
                    }
                    System.out.println("");
                    //adding the print to fix a weird problem
                    date1.setDay(d);
                    date1.setHours(h);
                    date1.setMinutes(mn);
                    Meeting meet1=new Meeting(date1, time, contacts.get(place));
                    System.out.println("The Event is in day " + meet1.date.getDay() + " and hour " + meet1.date.getHours() + " and minute " + meet1.date.getMinutes() + "\n");
                    
                    //check if contact doesn't exist in map
                    ArrayList<Integer> intList = new ArrayList<>();

                    if(!findContactMap(name))
                    {
                        intList.add(d);
                        contactMap.put(name, intList);
                        System.out.println("Contact " + name + " has meetings in days " + contactMap.get(name));

                        dateArr[d-1].add(meet1);
                        System.out.println("The occasions on day " + d + "are: ");
                        for( int i=0; i<dateArr[d-1].size(); i++)
                        {
                            dateArr[d-1].get(i).print();
                        }
                    }
                    else
                    {
                        contactMap.get(name).add(d);
                        System.out.println("Contact " + name + "has meetings in days " + contactMap.get(name));
                        // adding a meeting with contact to certain day
                        insertSorted(dateArr[d-1],dateArr[d-1].size(),meet1.startTime,meet1);
                    }

                }
            }
            else
            {
                System.out.println("Please choose an option between 1 or 2.\n");
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
        System.out.println("What day are the meetings you're looking for? (1-30)\n");
        int day = Integer.parseInt(Input.nextLine());
        for (Occasion meet:dateArr[day-1])
            meet.print();
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

    public boolean findContactMap(String name)
    {
        //goes over keys (contact names) and if found returns true
        for (String i : contactMap.keySet()) {
            if(name.equals(i))
                return true;
        }
        return false;
    }

    static void insertSorted(ArrayList<Occasion> arr, int length, double key, Occasion meet)
    {
        int i;
        for (i = length - 1; (i >= 0 && arr.get(i).startTime > key); i--)
            arr.set(i+1,arr.get(i));
 
        arr.set(i + 1,meet);
    }
}
