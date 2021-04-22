/**
 * App
 */
import java.util.ArrayList;
import java.util.Scanner;

abstract class App {
    abstract void run();
    //abstract App[] get();
    static Scanner Input =new Scanner(System.in);
    abstract void print();
    private static ArrayList<Contact> contactList;
    ArrayList<Contact> copy1 = new ArrayList<Contact>();
    
    public void set(ArrayList<Contact> update)
    {
        contactList=update;
    }

    public ArrayList<Contact> get()
    {
        if(contactList != null)
        {
            copy1.addAll(contactList);
        }
        
        return copy1;
    }

    public boolean findContact()
    {
        boolean exist = false;

        return exist;
    }
    
}
