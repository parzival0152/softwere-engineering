import java.util.ArrayList;
import java.util.HashMap;

public class SMS extends App{
    
    ArrayList<Contact> contactList;
    HashMap<String, String> conversations;
    String name,msg;

    public void run()
    {
        contactList = get();
        conversations = new HashMap<String, String>();
        boolean exit = false;
        int option;
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
                    System.out.println("Enter name of contact you want to message:");
                    name = Input.nextLine();
                    System.out.println("Enter your message:");
                    msg = Input.nextLine();
                    newConv(name,msg);
                    break;
                }
                case 2: //remove conversation
                {
                    System.out.println("Enter name of contact you want to message:");
                    name = Input.nextLine();
                    System.out.println("Enter your message:");
                    msg = Input.nextLine();
                    remove(name);
                    break;
                }
                case 3: //print conversation
                {
                    System.out.println("Enter contact to see your messages:");
                    name = Input.nextLine();
                    printConv(name);
                    break;
                }
                case 4: //find in all conversations
                {
                    System.out.println("Enter phrase to search:");
                    msg = Input.nextLine();
                    findInAll(msg);
                    break;
                }
                case 5: //print all conversations
                {
                    printAll();
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
            clearScreen();
        }
       
    }    
    
    //start/continue converstion
    public void newConv(String name, String msg)
    {
        //check if name is in contact list
        if(!findName(name))
        {
            System.out.println(contactList);
            System.out.println("Sorry, this name is not in your contact list.");
            return;
        }
        //find if contact already exists
        if(!findConversation(name)) //if it doesn't
        {
            conversations.put(name,msg);
            return;
        }
        else //if it does
        {
            //uses /n to differentiate between messages
            conversations.merge(name,msg, (oldValue, newValue) -> oldValue + "\n" + newValue); 
        }
    }

    //remove conversation
    public void remove(String name)
    {   
        if(!conversations.isEmpty())
        {
            if(!findName(name)) //if contact entered does exist
            {
                System.out.println("Sorry, this name isn't in your contact list.");
                return;
            }
            if(!findConversation(name))
            {
                System.out.println("Sorry, you don't have a conversation with this contact.");
                return;
            }
            conversations.remove(name);
        }
        else
            System.out.println("Sorry, you have no conversations");
    }

     //print conversation with specific contact
    public void printConv(String name)
    {
        if(!findName(name))
        {
            System.out.println("Sorry, this name isn't in your contact list.");
            return;
        }
        if(!findConversation(name))
        {
            System.out.println("Sorry, you don't have a conversation with this contact.");
            return;
        }
        print(name);
    }

    //finds all conversations containing chosen string
    public void findInAll(String msg)
    {   
        if(conversations.isEmpty())
        {
            System.out.println("Sorry, you have no conversations.");
            return;
        }
        System.out.println("The term you searched was found in the conversations with:");
        for (String i:conversations.keySet()) //go through all conversations if contains searched string output name
        {
            if (conversations.get(i).contains(msg))
                System.out.println(i);
        }
    }

    //print all conversations
    public void printAll()
    {
        if(conversations.isEmpty())
            return;
        print();
    }

    //checks if name entered is in contact list
    public boolean findName(String name)
    {
        for (Contact i : contactList)
        {
            if(name.equals(i.name))
                return true;
        }
        return false;
    }

    //checks if there is a conversation with contact of entered name
    public boolean findConversation(String name)
    {
        //goes over keys (contact names) and if found returns true
        for (String i : conversations.keySet()) {
            if(name.equals(i))
                return true;
        }
        return false;
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