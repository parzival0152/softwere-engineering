import java.util.ArrayList;
import java.util.HashMap;

//import jdk.internal.util.xml.impl.Input;

public class Calander extends App{
   
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
                    System.out.println("What day are the meetings you're looking for? (1-30)\n");
                    int day = Integer.parseInt(Input.nextLine());
                    show_date(day);
                    break;
                case 4:
                    System.out.println("What is the name of the contact you want to see meetings with?\n");
                    String name = Input.nextLine();
                    show_contact(name);
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
                addOccasion( 1, d, h, mn, time, description);
                //this print is for checking

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
                    addOccasion(2, d, h, mn, time, name);
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
        String name= null;
        int d, h, mn;
        while(!valid)
        {
            System.out.println("Would you like to delete a meeting or an event?");
            System.out.println("1. Event \n2. Meeting \n");
            choice = Integer.parseInt(Input.nextLine());
            if (choice == 1)
            {
                valid=true;
                System.out.println("Please enter the day, hour and minute of event you want to delete:");
                d= Integer.parseInt(Input.nextLine());
                h= Integer.parseInt(Input.nextLine());
                mn= Integer.parseInt(Input.nextLine());
                deleteOccasion(choice, d, h, mn, name);
            }
            else if (choice == 2)
            {
                valid=true;
                System.out.println("Please enter the day, hour and minute of event you want to delete:");
                d= Integer.parseInt(Input.nextLine());
                h= Integer.parseInt(Input.nextLine());
                mn= Integer.parseInt(Input.nextLine());
                System.out.println("Enter a contact's name:");
                name = Input.nextLine();
                deleteOccasion(choice, d, h, mn, name);
            }
            else
            {
                System.out.println("Please choose an option between 1 or 2. \n");
            }
        }
    }

    public void show_date(int day)
    {
        //Show all occasions in a date
        for (Occasion meet:dateArr[day-1])
            meet.print();
    }

    public void show_contact(String name)
    {
        //"Show all meetings with a contact"
        int day;
        for(int i=0; i<contactMap.get(name).size();i++)
        {
            day = contactMap.get(name).get(i);
            for(int j=0; j<dateArr[day-1].size(); j++)
            {
                if((dateArr[day-1].get(j) instanceof Meeting) && (dateArr[day-1].get(j).getDetails().equals(name)))
                {
                    dateArr[day-1].get(j).print();
                }
            }
            
        }
        
    }

    public void collision_finder()
    {
        for(int i=0; i<30; i++)
        {
            checkOverlap(i+1);
        }
            
    }

    public void show_all()
    {
        for(int i=0; i<30; i++)
        {
            show_date(i+1);
        }
    }

    public void print()
    {
        show_all();
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
        System.out.println("Checking insertedSorted******" );
        System.out.println("The occasions on this day are: " );
        arr.add(length, meet);
        for (i = length - 1; (i >= 0 && arr.get(i).startTime > key); i--)
        {
            arr.set(i+1,arr.get(i));
        }
        arr.set(i + 1,meet);
        for(int j=0; j<arr.size(); j++)
            System.out.println("Time of occasion is: " + arr.get(j).startTime + "And placement is " + j);
        
        System.out.println("End of hecking insertedSorted******" );

    }

    public void deleteOccasion(int choice ,int day, int hour, int minute, String name)
    {
        if(choice == 1)
        {
            for(int i=0; i<dateArr[day-1].size(); i++)
            {
                if((dateArr[day-1].get(i).date.getHours()==hour)&&(dateArr[day-1].get(i).date.getMinutes()==minute))
                {
                    dateArr[day-1].remove(i);
                    break;
                }
            }
        }
        else
        {
            if(contactMap.containsKey(name))
            {
                for(int i=0; i<dateArr[day-1].size(); i++)
                {
                    if((dateArr[day-1].get(i).date.getHours()==hour)&&(dateArr[day-1].get(i).date.getMinutes()==minute))
                    {
                        dateArr[day-1].remove(i);
                        break;
                    }
                }
            }
            else
                System.out.println("There are no events with this contact.");
        }
    }

    public void checkOverlap(int day)
    {
        for(int i=0; i<dateArr[day-1].size()-1; i++)
        {
            if((dateArr[day-1].get(i).startTime+(double)dateArr[day-1].get(i).time/60)>dateArr[day-1].get(i+1).startTime)
            {
                dateArr[day-1].remove(i+1);
                System.out.println("removed meeting in place" + i+1);
                i--;
            }
        }
        
    }

    public void addOccasion(int choice, int day, int hour, int minute, int time, String details)
    {
        if (choice==1)
        {
            BetterDate date1= new BetterDate();
            date1.setDay(day);
            date1.setHours(hour);
            date1.setMinutes(minute);
            Event e= new Event(date1, time, details);
            insertSorted(dateArr[day-1],dateArr[day-1].size(),e.startTime,e);
            System.out.println("The Event is in day " + e.date.getDay() + " and time " + e.date.getHours() + ":" + e.date.getMinutes());
            System.out.println("The description is " + e.description );
            System.out.println("The occasions on day " + day + " are: ");
            for( int i=0; i<dateArr[day-1].size(); i++)
            {
                dateArr[day-1].get(i).print();
            }
        }
        else
        {
            BetterDate date1= new BetterDate();
            date1.setDay(day);
            date1.setHours(hour);
            date1.setMinutes(minute);
            int place=findContact(details);
            Meeting meet1 = new Meeting(date1, time, getContact(place));
            //check if contact doesn't exist in map
            ArrayList<Integer> intList = new ArrayList<>();
            if(!findContactMap(details))
            {
                intList.add(day);
                contactMap.put(details, intList);
                System.out.println("Contact " + details + " has meetings in days " + contactMap.get(details));
                insertSorted(dateArr[day-1],dateArr[day-1].size(),meet1.startTime,meet1);
                System.out.println("The occasions on day " + day + "are: ");
                for( int i=0; i<dateArr[day-1].size(); i++)
                {
                    dateArr[day-1].get(i).print();
                }
            }
            else
            {
                if(!contactMap.get(details).contains(day))
                    contactMap.get(details).add(day);

                System.out.println("Contact " + details + " has meetings in days " + contactMap.get(details));
                // adding a meeting with contact to certain day
                insertSorted(dateArr[day-1],dateArr[day-1].size(),meet1.startTime,meet1);
                System.out.println("The Meeting is in day " + meet1.date.getDay() + " and time " + meet1.date.getHours() + ":" + meet1.date.getMinutes());
            }
        }


    }

    public void update(String name)
    {
        System.out.println("This calander update.");
        //remove contact from contactMap
        int day;
        
        //used the show_contact function
        for(int i=0; i<contactMap.get(name).size();i++)
        {
            day = contactMap.get(name).get(i);
            for(int j=0; j<dateArr[day-1].size(); j++)
            {
                if((dateArr[day-1].get(j) instanceof Meeting) && (dateArr[day-1].get(j).getDetails().equals(name)))
                {
                    dateArr[day-1].remove(j);
                }
            }        
        }
        //remove all meeting with contact
        contactMap.remove(name);
        contactMap.keySet().stream().forEach(System.out::println);
        show_all();

    }



}
