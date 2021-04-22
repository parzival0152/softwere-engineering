import java.util.ArrayList;
import java.util.HashMap;

public class SMS extends App{
    
    ArrayList<Contact> contactList;
    HashMap<String, String> conversations;
   
    public void run()
    {
        contactList = get();
        conversations = new HashMap<String, String>();
        boolean exit = false;
        int option;
        String name,msg;
        while (!exit)
        {
            //get user choice from menu
            option = Helper.option(
                "Start/continue conversation",
                "Remove a conversation",
                "Print converstion with contact",
                "Find in all conversations",
                "Print all conversations",
                "Exit"
                );
            //cls
            clearScreen();
            switch (option)
            {
                case 1: //start/continue converstion
                    {
                        System.out.println("Who would you like to talk with?");
                        name = Input.nextLine();
                        //find if contact already exists
                         if(findName(name)==-1) //if it doesn't
                            {
                                System.out.print("Type your message to "+name+" here: ");
                                msg = Input.nextLine();
                                conversations.put(name,msg);
                                break;
                            }
                            else //if it does
                            {
                                System.out.print("Type your message to "+name+" here: ");
                                msg = Input.nextLine();
                                //uses ; to differentiate between messages
                                conversations.merge(name,conversations.get(name), (oldValue, newValue) -> oldValue + ";" + newValue); 
                            }
                        break;
                    }
                case 2: //remove conversation
                {
                    System.out.println("Which conversation would you like to remove?");
                    name = Input.nextLine();
                    conversations.remove(name);
                    break;
                }
                case 3: //print conversation
                {
                    System.out.println("Which conversation would you like to see?");
                    name = Input.nextLine();
                    print(name);
                    break;
                }
                case 4: //find in all conversations
                {
                    System.out.println("Enter searching term: ");
                    msg = Input.nextLine();
                    for (String i:conversations.keySet()) //go through all conversations if contains searched string output name
                    {
                        if (conversations.get(i).contains(msg))
                        {
                           System.out.println(i);
                        }
                    }
                    break;
                }
                case 5: //print all conversations
                {
                    print();
                    break;
                }
                case 6:
                {
                    //quit
                    System.out.println("Exiting messages.");
                    exit = true;
                    break;
                }
                default:
                    //default in case non of the oprtions chosen
                    System.out.println("Error: not an option");
                    break;
            }
        }
       
    }    
    
    //function clear screen
    public static void clearScreen() 
    {  
        System.out.print("\n\n\n");  
        System.out.flush();
    }

    public int findName(String name)
    {
        int found=-1;
        //goes over keys (contact names) and if found returns 1
        for (String i : conversations.keySet()) {
            if(name.equals(i))
            {
                found=1;
                break;
            }
        }
        return found;
    }

    public void print(String name)
    {
        System.out.println(conversations.get(name));
    }

    public void print()
    {
        for(String i:conversations.keySet())
        {
            System.out.print(i+": ");
            System.out.println(conversations.get(i));
        }
    }

    public void printContacts()
    {
        //try to print contacts to see if we can get access to ContactList
        ArrayList<Contact> contacts = get();
        System.out.println("Printing Contact List:");
        for(Contact c: contacts)
        {
            System.out.println(c);
        }
        System.out.println();

    }
    
}
