
import java.util.ArrayList;
import java.util.Scanner;

abstract class App {
    abstract void run();
    //abstract App[] get();
    public static Scanner Input =new Scanner(System.in);
    abstract void print();
    private static ArrayList<Contact> contactList;
    
    public static void set(ArrayList<Contact> update)
    {
        contactList=update;
    }

    public ArrayList<Contact> get()
    {
        ArrayList<Contact> copy1 = new ArrayList<>();
        copy1.addAll(contactList);
        return copy1;
    }
    
}
