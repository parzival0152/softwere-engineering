public class Media {
    public String name;
    public int length;
    public Boolean video;

    public Media(String name, int length, Boolean type)
    {
        this.name = name;
        this.length = length;
        this.video = type;

    }

    public void start()
    {
        if (this.video)
            System.out.println("The video " + this.name + "is now playing for " + this.length + " minutes");
        else
            System.out.println("The song " + this.name + "is now playing for " + this.length + " minutes");
    }

}
