import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Phonebook extends App
{
    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        int option;
        boolean exit = false;
        String name;
        String number;
        String filename;
        ArrayList<Contact> contactList = new ArrayList<>();
        while (!exit)
        {
            //get user choice from menu
            option = Helper.option(
                "Add new contact",
                "Remove a contact by name",
                "Print all contacts",
                "Find contact by name",
                "Sort contact list by name",
                "Sort contact list by number",
                "Remove duplicates",
                "Sort in reverse",
                "Save to file",
                "Load from file",
                "Exit"
                );
            //cls
            clearScreen();
            //switch based on the option that they chose
            switch (option) {
                case 1:
                    //add new contact;
                    System.out.print("Enter contact name: ");
                    name = input.nextLine();
                    System.out.print("Enter contact number: ");
                    number = input.nextLine();
                    contactList.add(new Contact(name, number));
                    set(contactList);
                    break;


                    
                    //removing d
                    //
                    // Collections.sort(contactList, new NameComperator());
                    // for(int i = 0; i < contactList.size()-1; i++)
                    // {
                    //     if (contactList.get(i).name.equals(contactList.get(i+1).name) && contactList.get(i).number.equals(contactList.get(i+1).number))
                    //     {
                    //         contactList.remove(i+1);
                    //         i--;
                    //     }
                    // }
                    // 

                case 2:
                    //remove by name
                    System.out.print("Enter contact name: ");
                    name = input.nextLine();
                    for (int i = 0; i < contactList.size(); i++) {
                        if(name.equals(contactList.get(i).name))
                        {
                            contactList.remove(i);
                            break;
                        }
                    }
                    set(contactList);
                    break;

                case 3:
                    //print all contacts
                    for(Contact c: contactList)
                    {
                        System.out.println(c);
                    }
                    input.nextLine();
                    break;

                case 4:
                    //find contact by name
                    boolean exist=false;
                    System.out.print("Enter contact name: ");
                    name = input.nextLine();
                    for (int i = 0; i < contactList.size(); i++) {
                        if(name.equals(contactList.get(i).name))
                        {
                            System.out.println(contactList.get(i));
                            exist=true;
                        }
                    }
                    if(!exist)
                        System.out.println("Contact not found.");
                    input.nextLine();
                    break;

                case 5:
                    //sort contact list by name
                    Collections.sort(contactList, new NameComperator());
                    break;

                case 6:
                    //sort contact list by number
                    Collections.sort(contactList, new NumberComperator());
                    break;

                case 8:
                    //reverse the exsisting list
                    for(int i = 0; i < contactList.size()/2; i++)
                    {
                        Contact temp = contactList.get(i);
                        contactList.set(i,contactList.get(contactList.size()-(i+1)));
                        contactList.set(contactList.size()-(i+1),temp);
                    }
                    System.out.println("Reversed list order");
                    break;

                case 9:
                    //save to file
                    System.out.print("Enter file name: ");
                    filename = input.nextLine();
                    try {
                        File f = new File(filename);
                        if (f.createNewFile()) {
                          System.out.println("File created: " + f.getName());
                        } 
                        //in case file already exists
                        else {
                          System.out.println("File already exists.");
                        }
                        FileWriter fWriter = new FileWriter(f);
                        //copy all contact list to txt file
                        for(Contact c : contactList){
                            fWriter.write(c.toString() + "\n");
                        }
                        fWriter.close();
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }
                    break;

                case 10:
                    //read from file
                    System.out.print("Enter file name: ");
                    filename = input.nextLine();
                    File f = new File(filename);
                    try {
                        Scanner filereader = new Scanner(f);
                        //as long as file isn't finished
                        while (filereader.hasNextLine()) 
                        {
                            String data = filereader.nextLine();
                            String[] splitdata = data.split(",");
                            contactList.add(new Contact(splitdata[0], splitdata[1]));
                        }
                        filereader.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                 
                case 11:
                    //quit
                    System.out.println("Bye.");
                    exit = true;
                    break;

                default:
                    //default in case non of the oprtions chosen
                    System.out.println("Error: not an option");
                    break;
            }
        }
    }

    //function clear screen
    public static void clearScreen() {  
        System.out.print("\n\n\n");  
        System.out.flush();
    } 

    public Phonebook() {
        //create instance of class
    }

    public void print()
    {
        //TBI
    }
}

