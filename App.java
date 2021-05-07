/**
 * App
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

abstract class App {

    //scanner for every class that extends App so there will only be one instance of scanner
    static Scanner Input =new Scanner(System.in);
    //contactList is sent to all classes that extends app
    private static ArrayList<Contact> contactList;
    ArrayList<Contact> copy1 = new ArrayList<Contact>();

    abstract void run();
    abstract void print();

    //sets the contact list when there are changes in phonebook
    public void set(ArrayList<Contact> update)
    {
        contactList=update;
    }

    //sending the contact list copy to requesting extending classes
    public ArrayList<Contact> get()
    {
        if(contactList != null)
        {
            copy1.addAll(contactList);
        }
        return copy1;
    }

    //finds name in contact list and returns index
    public int findContact(String name)
    {
        int exist=-1;
        if(contactList==null)
            return exist;
        for (int i = 0; i < contactList.size(); i++) {
            if(name.equals(contactList.get(i).name))
            {
                exist=i;
                break;
            }
        }
        return exist;
    }
    
    //return contact list in place of index
    public Contact getContact(int index)
    {
        return (new Contact(contactList.get(index).name, contactList.get(index).number));
    }


    //function clear screen
    public static void clearScreen() 
    {  
        System.out.print("\n\n\n");  
        System.out.flush();
    }
}
