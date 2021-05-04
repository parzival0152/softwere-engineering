import java.util.ArrayList;

public class Media extends App{
    public String title;
    public double length;
    public Boolean video;
    public ArrayList<MV> mediaList= new ArrayList<>();

    public Media()
    {
        //TBI
    }

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
            switch (option) {
                case 1:
                    String name;
                    double time;
                    boolean type;
                    System.out.print("Enter Media's title: \n");
                    name = Input.nextLine();
                    System.out.print("Enter Media's length: \n");
                    time = Double.parseDouble(Input.nextLine());
                    System.out.print("Please enter 0 is music or 1 for video.\n");
                    type = Boolean.parseBoolean(Input.nextLine());
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
            clearScreen();
        }
    }

    public void addMedia(String name,Double time,Boolean type)
    {
        mediaList.add(new MV(name, time, type));
    }

    public void playByName(String name)
    {
       int exist;
        exist=findMV(name);
        if(exist==-1)
            System.out.println("Name not found.");
        else
            play(exist);
    }

    public void play(int place)
    {
        if (mediaList.get(place).video)
            System.out.println("The video " + mediaList.get(place).name + " is now playing for " + mediaList.get(place).length + " minutes");
        else
            System.out.println("The song " + mediaList.get(place).name + " is now playing for " + mediaList.get(place).length + " minutes");
    }

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

    public void playAll()
    {
        for(int i=0; i<mediaList.size(); i++)
        {
            play(i);
        }
    }

    public void print()
    {
        playAll();
    }

}
