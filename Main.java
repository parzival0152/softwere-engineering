import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        boolean exit = false;
        String name;
        String number;
        String filename;
        ArrayList<Contact> contactList = new ArrayList<>();
        while (!exit)
        {
            
            //print out the start menu
            System.out.println("Please choose one of the following options: ");
            System.out.println("1. Add new contact");
            System.out.println("2. Remove a contact by name");
            System.out.println("3. Print all contacts");
            System.out.println("4. Find contact by name");
            System.out.println("5. Sort contact list by name");
            System.out.println("6. Sort contact list by number");
            System.out.println("7. Remove duplicates");
            System.out.println("8. Sort in reverse");
            System.out.println("9. Save to file");
            System.out.println("10. Load from file");
            System.out.println("11. exit");
            //get choice
            System.out.print("Your choice: ");
            option = Integer.parseInt(input.nextLine());
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
                    break;

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
                    System.out.print("Enter contact name: ");
                    name = input.nextLine();
                    for (int i = 0; i < contactList.size(); i++) {
                        if(name.equals(contactList.get(i).name))
                        {
                            System.out.println(contactList.get(i));
                        }
                    }
                    input.nextLine();
                    break;

                case 5:
                    //sort contact list by name
                    Collections.sort(contactList, new NameComperator());
                    System.out.println("sorted the list by name");
                    break;

                case 6:
                    //sort contact list by number
                    Collections.sort(contactList, new NumberComperator());
                    System.out.println("sorted the list by number");
                    break;

                case 7:
                    //remove dups doesn't work completely
                    for(int i = 0; i < contactList.size(); i++)
                    {
                        for(int j = i+1; j < contactList.size(); j++)
                        {
                            if (contactList.get(i).name.equals(contactList.get(j).name) && contactList.get(i).number.equals(contactList.get(j).number))
                            {
                                contactList.remove(j);
                            }
                        }
                    }
                    System.out.println("dupes removed");
                    break;

                case 8:
                    //sort in reverse
                    Collections.sort(contactList, new ReverseNameComperator());
                    System.out.println("sorted the list by name in reverse order");
                    break;

                case 9:
                    //save to file
                    System.out.print("Enter file name: ");
                    filename = input.nextLine();
                    try {
                        File f = new File(filename);
                        if (f.createNewFile()) {
                          System.out.println("File created: " + f.getName());
                        } else {
                          System.out.println("File already exists.");
                        }
                        FileWriter fWriter = new FileWriter(f);
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
                    exit = true;
                    break;

                default:
                    //default cause we have to have one
                    System.out.println("Error: not an option");
                    break;
            }
        }
        input.close();
    }

    public static void clearScreen() {  
        System.out.print("\n\n\n");  
        System.out.flush();
    } 
}

class Contact{
    String name;
    String number;
    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }
    @Override
    public String toString()
    {
        return this.name + ","+this.number;
    }
}

class NameComperator implements Comparator<Contact>{

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.name.compareTo(o2.name);
    }

}

class NumberComperator implements Comparator<Contact>{

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.number.compareTo(o2.number);
    }

}

class ReverseNameComperator implements Comparator<Contact>{


    @Override
    public int compare(Contact o1, Contact o2) {
        return o2.name.compareTo(o1.name);
    }

}