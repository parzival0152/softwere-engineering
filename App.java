/**
 * App
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

abstract class App extends Phone {
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
    
    //function clear screen
    public static void clearScreen() 
    {  
        System.out.print("\n\n\n");  
        System.out.flush();
    }

    public void update()
    {
        System.out.println("this is app update.");
        super.update();
    }
    
}
