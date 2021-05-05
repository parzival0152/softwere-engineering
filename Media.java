import java.util.ArrayList;
import java.util.Iterator;

public class Media extends App{
    public String title;
    public double length;
    //video=1 represents video, video=0 represents music
    public Boolean video;
    public ArrayList<MV> mediaList= new ArrayList<>();

    public Media(){} // empty constructor

    public void run()
    {

        boolean quit = false;
        while (!quit) {
            int option = Helper.option(
                "Add media",
                "Play by name",
                "Play all",
                "Exit"
            );
            clearScreen();
            switch (option) {
                case 1:
                    boolean type;
                    System.out.print("Enter Media's title: \n");
                    String name = Input.nextLine();
                    System.out.print("Enter Media's length: \n");
                    double time = Double.parseDouble(Input.nextLine());
                    System.out.print("Please enter 0 is music or 1 for video.\n");
                    int tmp = Integer.parseInt(Input.nextLine());
                    if(tmp == 1)
                        type = true;
                    else
                        type = false;
                    System.out.println("type: "+type);
                    addMedia(name,time,type);
                    break;
                case 2:
                    System.out.print("Enter Media's title: ");
                    name = Input.nextLine();
                    playByName(name);
                    break;
                case 3:
                    playAll();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void addMedia(String name,Double time,Boolean type)
    {
        mediaList.add(new MV(name, time, type));
    }

    //finds index if exists and prints media
    public void playByName(String name)
    {
        int exist;
        exist=findMV(name);
        if(exist==-1)
            System.out.println("Name not found.");
        else
            play(mediaList.get(exist));
    }

    //gets MV and prints out details
    public void play(MV media)
    {
        if (media.video)
            System.out.println("The video " + media.name + " is now playing for " + media.length + " minutes");
        else
            System.out.println("The song " + media.name + " is now playing for " + media.length + " minutes");
    }

    //searches media according to name
    public int findMV(String name)
    {
        int exist=-1;
        for (int i = 0; i < mediaList.size(); i++) {
            if(name.equals(mediaList.get(i).name))
            {
                exist=i;
                break;
            }
        }
        return exist;
    }

    //prints out all the media
    public void playAll()
    {
        Iterator<MV> it = mediaList.iterator();
        while(it.hasNext())
        {
            play(it.next());
        }
    }

    public void print()
    {
        playAll();
    }

}
