import java.util.ArrayList;
import java.util.HashMap;

//import jdk.internal.util.xml.impl.Input;

public class Calander extends App{
   
    HashMap<String, ArrayList<Integer>> contactMap;
    ArrayList<Occasion>[] dateArr;

    Calander()
    {
        //this constructor creates a hash map to see which contact has meetings in which days
        //it also creates an array with 30 different arrays of occasion
        contactMap = new HashMap<String, ArrayList<Integer>>();
        dateArr = new ArrayList[30];
        //initializing all 30 arrays
        for(int i=0; i<30; i++)
        {
            dateArr[i] = new ArrayList<Occasion>();
        }
    }

    //run function creates a visual menu for the user with switch case
    //user can choose whichever function they want to use
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
                    showDate(day);
                    break;
                case 4:
                    System.out.println("What is the name of the contact you want to see meetings with?\n");
                    String name = Input.nextLine();
                    showContact(name);
                    break;
                case 5:
                    collisionFinder();
                    break;
                case 6:
                    showAll();
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

    //function that creates an occasion according to user's input
    //uses getDate which gets from the user the needed input
    //uses addOccasion that creates the occasion
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
            String description;
            ArrayList<Integer> arr;

            //event
            if (choice == 1)
            {
                valid=true;
                arr = getDate();
                System.out.println("Please enter description for the event\n");
                description=Input.nextLine();
                addOccasion( 1, arr.get(0), arr.get(1), arr.get(2), arr.get(3), description);
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
                    arr = getDate();
                    addOccasion(2, arr.get(0), arr.get(1), arr.get(2), arr.get(3), name);
                }
            }
            else
            {
                System.out.println("Please choose an option between 1 or 2.\n");
            }
        }
    }

    //delete function gets input from user and deletes the occasion
    //uses function deleteOccasion
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
            //event
            if (choice == 1)
            {
                valid=true;
                System.out.println("Please enter the day, hour and minute of event you want to delete:");
                d= Integer.parseInt(Input.nextLine());
                h= Integer.parseInt(Input.nextLine());
                mn= Integer.parseInt(Input.nextLine());
                System.out.println("Please enter the description of event you want to delete:");
                name = Input.nextLine();
                deleteOccasion(choice, d, h, mn, name);
            }
            //meeting
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

    //showDate function shows all the occasion in a date
    public void showDate(int day)
    {
        //Show all occasions in a date
        for (Occasion meet:dateArr[day-1])
            meet.print();
    }

    //showContact function shows all meeting with a contact
    public void showContact(String name)
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

    /*collisionFinder function checks if there is a collision in the whole calander
    uses checkOverlap which checks if there is a collision in one specific day*/
    public void collisionFinder()
    {
        for(int i=0; i<30; i++)
        {
            checkOverlap(i+1);
        }
            
    }

    /*showAll function shows all of the occasions in the whole calander
    uses showDate function which shows all the occasions in one day*/
    public void showAll()
    {
        for(int i=0; i<30; i++)
        {
            showDate(i+1);
        }
    }

    //print function calls showAll function to show all occasions
    public void print()
    {
        showAll();
    }

    //function findContactMap looks for a name in the contactMap and if found returns true
    public boolean findContactMap(String name)
    {
        //goes over keys (contact names)
        for (String i : contactMap.keySet()) {
            if(name.equals(i))
                return true;
        }
        return false;
    }

    //function insertSorted inserts an occasion and sorts by time
    static void insertSorted(ArrayList<Occasion> arr, int length, double key, Occasion meet)
    {
        int i;
        //adds one more place in array
        arr.add(length, meet);
        //checks to see when is the earlier occasion
        for (i = length - 1; (i >= 0 && arr.get(i).startTime > key); i--)
        {
            arr.set(i+1,arr.get(i));
        }
        arr.set(i + 1,meet);

    }

    //function deleteOccasion recieves input from user and deletes occasion accordingly
    public void deleteOccasion(int choice ,int day, int hour, int minute, String details)
    {
        //if event
        if(choice == 1)
        {
            for(int i=0; i<dateArr[day-1].size(); i++)
            {
                if((dateArr[day-1].get(i).date.getHours()==hour)&&(dateArr[day-1].get(i).date.getMinutes()==minute)&&(dateArr[day-1].get(i) instanceof Event)&&dateArr[day-1].get(i).getDetails().equals(details))
                {
                    dateArr[day-1].remove(i);
                    break;
                }
            }
        }

        //if meeting
        else
        {
            if(contactMap.containsKey(details))
            {
                for(int i=0; i<dateArr[day-1].size(); i++)
                {
                    if((dateArr[day-1].get(i).date.getHours()==hour)&&(dateArr[day-1].get(i).date.getMinutes()==minute)&&dateArr[day-1].get(i) instanceof Meeting)
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

    //function checkOverlap checks for overlap in a specific day
    public void checkOverlap(int day)
    {
        
        for(int i=0; i<dateArr[day-1].size()-1; i++)
        {
            //if time of one occasion overlaps with another deleter the later occasion
            if((dateArr[day-1].get(i).startTime+(double)dateArr[day-1].get(i).time/60)>dateArr[day-1].get(i+1).startTime)
            {
                dateArr[day-1].remove(i+1);
                i--;
                
            }
        }
        
    }

    //function addOccasion gets input and creates an occasion
    public void addOccasion(int choice, int day, int hour, int minute, int time, String details)
    {
        
        //event
        if (choice==1)
        {
            BetterDate date1= new BetterDate();
            date1.setDay(day);
            date1.setHours(hour);
            date1.setMinutes(minute);
            Event e= new Event(date1, time, details);
            insertSorted(dateArr[day-1],dateArr[day-1].size(),e.startTime,e);
          
           
             
        }
        //meeting
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
                insertSorted(dateArr[day-1],dateArr[day-1].size(),meet1.startTime,meet1);
                

            }
            else
            {
                //checks if in hashmap of key has already the added day
                if(!contactMap.get(details).contains(day))
                    contactMap.get(details).add(day);

                // adding a meeting with contact to certain day
                insertSorted(dateArr[day-1],dateArr[day-1].size(),meet1.startTime,meet1);
          
            }
        }


    }

    //function update updates the contacts according to phonebook
    //function is called when phonebook deletes a contact
    public void update(String name)
    {
        //remove contact from contactMap
        int day;
        //used the showContact function
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
        showAll();

    }

    //function getDate prints to user instructions on how to put input
    //also checks that input is okay
    public ArrayList<Integer> getDate()
    {
        int d, h, mn;
        int time;
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Please enter day(dd) (1-30):\n");
        d= Integer.parseInt(Input.nextLine());
        while(d<1||d>30)
        {
            System.out.println("Please enter a valid day (1-30)\n");
            d= Integer.parseInt(Input.nextLine());
        }
        System.out.println("Please enter hour(hh) (0-23):\n");
        h= Integer.parseInt(Input.nextLine());
        while(h<0||h>23)
        {
            System.out.println("Please enter a valid hour (0-23)\n");
            h= Integer.parseInt(Input.nextLine());
        }
        System.out.println("Please enter minute(mm) (0-59):\n");
        mn= Integer.parseInt(Input.nextLine());
        while(mn<0||mn>59)
        {
            System.out.println("Please enter a valid minute (0-59)\n");
            mn= Integer.parseInt(Input.nextLine());
        }
        System.out.println("Please enter the time the event takes (0-60)\n");
        time= Integer.parseInt(Input.nextLine());
        while(time<0||time>60)
        {
            System.out.println("Please enter a valid time (0-60)\n");
            time= Integer.parseInt(Input.nextLine());
        }

        arr.add(d);
        arr.add(h);
        arr.add(mn);
        arr.add(time);

        return arr;
    }

}
