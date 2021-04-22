
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
                    break;
                case 2:
                    s.printContacts();
                    break;
                case 3:
                case 4:
                    System.out.println("Not implemented");
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
    }

}