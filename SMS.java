import java.util.ArrayList;

public class SMS extends App{

    public void run()
    {
        //to be implemented by omri
    }    
    
    public void print()
    {
        //TBI
    }

    public void printContacts()
    {
        //try to print contacts to see if we can get access to ContactList
        ArrayList<Contact> contacts = get();
        for(Contact c: contacts)
        {
            System.out.println(c);
        }

    }
    
}
