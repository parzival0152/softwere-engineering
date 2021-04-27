import java.util.ArrayList;

public class MediaApp extends App{

    //to be implemented by omri
    ArrayList<Media> mediaList;

    public void run()
    {
        int option;
        boolean exit = false;
        while (!exit)
        {
            //get user choice from menu
            option = Helper.option(
                "Add new media",
                "Start media by name",
                "Start all media",
                "Exit"
                );
            //cls
            clearScreen();
            switch (option)
                {
                    case 1: // add new media
                    {
                        System.out.println("If your media is a video enter 1 else 0.");
                        String type = Input.nextLine();
                        boolean btype = (type == "1");
                        System.out.println("Enter the name of your media:");
                        String name = Input.nextLine();
                        System.out.println("Enter media length in minutes:");
                        String ilen = Input.nextLine();
                        int len = Integer.parseInt(ilen); 
                        
                        Media newMed = new Media(name,len,btype);
                        mediaList.add(newMed);
                        break;
                    }
                    case 2: //play media
                    {
                        System.out.println("Enter the name of the media you want to play:");
                        String name = Input.nextLine();
                        int index = findName(name);
                        if (index == -1)
                        {
                            System.out.println("Media not in data base, please add media first.");
                            break;
                        }
                        mediaList.get(index).start();
                        break;
                    }
                    case 3: //start all media
                    {
                        for (Media i : mediaList)
                            i.start();
                        break;
                    }
                    case 4:
                    {
                        //quit
                        System.out.println("Exiting messages.");
                        exit = true;
                        break;
                    }
                    default:
                    //default in case non of the oprtions chosen
                    System.out.println("Error: not an option");
                    break;
                }
        }
    }    
    
    //function clear screen
    public static void clearScreen() 
    {  
        System.out.print("\n\n\n");  
        System.out.flush();
    }

    //checks if name entered is in contact list
    public int findName(String name)
    {
        for (Media i : mediaList)
        {
            if(name.equals(i.name))
                return mediaList.indexOf(i);
        }
        return -1;
    }

    public void print()
    {
        //TBI
    }
}
