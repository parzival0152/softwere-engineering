
public class Phone 
{
    public Phonebook pb;
    public Calander c;
    public SMS s;

    public Phone()
    {
        this.pb = new Phonebook();
        this.c = new Calander();
        this.s= new SMS();
    } 
    public void update()
    {
        //updating SMS and Calander according to changed Phonebook
    }
    public void runp()
    {
        boolean quit = false;
        while (!quit) {
            int option = Helper.option(
                "Phonebook",
                "SMS",
                "Calander",
                "Media",
                "Exit"
            );
            switch (option) {
                case 1:
                    pb.run();
                    update();
                    break;
                case 2:
                    s.run();
                    update();
                    break;
                case 3:
                    c.run();
                    break;
                case 4:
                    System.out.println("Not implemented");
                    break;
                case 5:
                    quit = true;
                    //close scanner
                    break;
                default:
                    break;
            }
        }
    }

}