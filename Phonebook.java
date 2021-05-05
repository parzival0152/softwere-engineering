import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Comparator;


public class Phonebook extends App {
    Phone p1;

    public Phonebook(Phone p) 
    {
        p1 = p;
    }

    ArrayList<Contact> contactList = new ArrayList<>();

    @Override
    public void run() {
        int option;
        boolean exit = false;
        String name;
        String number;
        String filename;

        while (!exit) {
            // get user choice from menu
            option = Helper.option("Add new contact", "Remove a contact by name", "Print all contacts",
                    "Find contact by name", "Sort contact list by name", "Sort contact list by number",
                    "Sort in reverse", "Save to file", "Load from file", "Exit");
            // cls
            clearScreen();
            // switch based on the option that they chose
            switch (option) {
                case 1:
                    // add new contact;
                    System.out.print("Enter contact name: ");
                    name = Input.nextLine();
                    System.out.print("Enter contact number: ");
                    number = Input.nextLine();
                    addContact(name, number);
                    break;

                case 2:
                    // remove by name
                    System.out.print("Enter contact name: ");
                    name = Input.nextLine();
                    removeContact(name);
                    break;

                case 3:
                    print();
                    break;

                case 4:
                    // find contact by name
                    System.out.print("Enter contact name: ");
                    name = Input.nextLine();
                    findContactByName(name);
                    break;

                case 5:
                    // sort contact list by name
                    sortByName();
                    break;

                case 6:
                    // sort contact list by number
                    sortByNumber();
                    break;

                case 7:
                    reverseList();
                    System.out.println("Reversed list order");
                    break;

                case 8:
                    // save to file
                    System.out.print("Enter file name: ");
                    filename = Input.nextLine();
                    writeToFile(filename);
                    break;

                case 9:
                    // read from file
                    System.out.print("Enter file name: ");
                    filename = Input.nextLine();
                    readFromFile(filename);
                    break;

                case 10:
                    // quit
                    exit = true;
                    break;

                default:
                    // default in case non of the oprtions chosen
                    System.out.println("Error: not an option");
                    break;
            }
        }
    }

    public Phonebook() {
        // create an instance of class
    }

    public void removeDup() {
        Collections.sort(contactList, new NameComperator());
        for (int i = 0; i < contactList.size() - 1; i++) 
        {
            if (contactList.get(i).name.equals(contactList.get(i + 1).name)) 
            {
                contactList.remove(i + 1);
                i--;
            }
        }
    }

    public void update(String name) 
    {
        p1.update(name);
    }

    public void addContact(String name, String number) {
        // find if contact already exists
        if (contactList != null) 
        {
            if (findContact(name) != -1) 
            {
                System.out.print("Contact already exists.");
            } 
            else
            {
                contactList.add(new Contact(name, number));
                set(contactList);
            }
        }
    }

    public void removeContact(String name) {
        int found;
        found = findContact(name);
        if (found != -1) {
            contactList.remove(found);
            set(contactList);
            update(name);
        }
    }

    public void findContactByName(String name) {
        int exist;
        exist = findContact(name);
        if (exist == -1)
            System.out.println("Name not found.");
        else
            System.out.println(contactList.get(exist));
    }

    public void sortByNumber() {
        Collections.sort(contactList, new NumberComperator());
        reverseList();
        set(contactList);
    }

    public void sortByName() {
        Collections.sort(contactList, new NameComperator());
        set(contactList);
    }

    public void reverseList() {
        // reverse the exsisting list
        for (int i = 0; i < contactList.size() / 2; i++) {
            Contact temp = contactList.get(i);
            contactList.set(i, contactList.get(contactList.size() - (i + 1)));
            contactList.set(contactList.size() - (i + 1), temp);
        }
        set(contactList);

    }

    public void writeToFile(String filename) {

        try {
            Iterator<Contact> it = contactList.iterator();

            File f = new File(filename);
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            }
            // in case file already exists
            else {
                System.out.println("File already exists.");
            }
            FileWriter fWriter = new FileWriter(f);
            // copy all contact list to txt file
            while (it.hasNext())
            {
                fWriter.write(it.next().toString() + "\n");
            }
            fWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void readFromFile(String filename) {
        File f = new File(filename);
        try {
            Scanner filereader = new Scanner(f);
            // as long as file isn't finished
            while (filereader.hasNextLine()) {
                String data = filereader.nextLine();
                String[] splitdata = data.split(",");
                contactList.add(new Contact(splitdata[0], splitdata[1]));
            }
            filereader.close();
            set(contactList);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        removeDup();
    }

    public void print() {
        // print all contacts
        Iterator<Contact> it = contactList.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
