import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
                    sort(contactList, 0, contactList.size()-1,false);
                    break;

                case 6:
                    //sort contact list by number
                    sort(contactList, 0, contactList.size()-1,true);
                    break;

                case 7:
                    //remove dups
                    sort(contactList, 0, contactList.size()-1,false);
                    for(int i = 0; i < contactList.size()-1; i++)
                    {
                        if (contactList.get(i).name.equals(contactList.get(i+1).name) && contactList.get(i).number.equals(contactList.get(i+1).number))
                        {
                            contactList.remove(i+1);
                            i--;
                        }
                    }
                    System.out.println("Dupes removed");
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
                    exit = true;
                    break;

                default:
                    //default in case non of the oprtions chosen
                    System.out.println("Error: not an option");
                    break;
            }
        }
        input.close();
    }

    //function clear screen
    public static void clearScreen() {  
        System.out.print("\n\n\n");  
        System.out.flush();
    } 


    public static void merge(ArrayList<Contact> arr,int l, int m, int r,boolean choice)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        ArrayList<Contact> L = new ArrayList<Contact>();
        ArrayList<Contact> R = new ArrayList<Contact>();
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; i++)
            L.add(arr.get(l+i));
        for (int j = 0; j < n2; j++)
            R.add(arr.get(m + 1 + j));
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        NumberComperator numberComperator = new NumberComperator();
        NameComperator nameComperator = new NameComperator();
        if(choice)
        {
            while (i < n1 && j < n2) {
                if (numberComperator.compare(L.get(i),R.get(j))>=0) {
                    arr.set(k,L.get(i));
                    i++;
                }
                else {
                    arr.set(k,R.get(j));
                    j++;
                }
                k++;
            }
        }
        else
        {
            while (i < n1 && j < n2) {
                if (nameComperator.compare(L.get(i),R.get(j))<=0) {
                    arr.set(k,L.get(i));
                    i++;
                }
                else {
                    arr.set(k,R.get(j));
                    j++;
                }
                k++;
            }
        }
 
        /* Copy remaining elements of L if any */
        while (i < n1) {
            arr.set(k,L.get(i));
            i++;
            k++;
        }
 
        /* Copy remaining elements of R if any */
        while (j < n2) {
            arr.set(k,R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr using
    // merge()
    public static void  sort(ArrayList<Contact> arr,int l, int r,boolean choice)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(arr, l, m,choice);
            sort(arr, m + 1, r,choice);
 
            // Merge the sorted halves
            merge(arr, l, m, r,choice);
        }
    }
}

//the class contact contains name and number
class Contact{
    String name;
    String number;
    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }
    @Override
    //split name and number by ","
    public String toString()
    {
        return this.name + "," + this.number;
    }
    
}

class NameComperator implements Comparator<Contact>{

    @Override
    //change base comperator to compare by contact name
    public int compare(Contact o1, Contact o2) {
        return o1.name.compareTo(o2.name);
    }

}

class NumberComperator implements Comparator<Contact>{

    @Override
    //change base comperator to compare by contact number
    public int compare(Contact o1, Contact o2)
    {
        return o1.number.compareTo(o2.number);
    }

}