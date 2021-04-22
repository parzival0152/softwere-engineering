/**
 * App
 */
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;

abstract class App {
    abstract void run();
    //abstract App[] get();
    static Scanner Input =new Scanner(System.in);
    abstract void print();
    private static ArrayList<Contact> contactList;
    
    public void set(ArrayList<Contact> update)
    {
        contactList=update;
    }

    public ArrayList<Contact> get()
    {
        ArrayList<Contact> copy1 = new ArrayList<Contact>();
        copy1.addAll(contactList);
        return copy1;
    }
    
}
