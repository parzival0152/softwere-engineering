
public class Phone
{
    public Phonebook pb;
    public Calander c;
    public SMS s;
    public Media m;

    public Phone()
    {
        this.pb = new Phonebook(this);
        this.c = new Calander();
        this.s= new SMS();
        this.m= new Media();
    } 
    public void update(String name)
    {
        System.out.println("this is phone update.");
        
        //updating SMS and Calander according to changed Phonebook
        s.update(name);


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
                "Print all",
                "Exit"
            );
            switch (option) {
                case 1:
                    pb.run();
                    
                    break;
                case 2:
                    s.run();
                   
                    break;
                case 3:
                    c.run();
                    break;
                case 4:
                    m.run();
                    break;
                case 5:
                    System.out.println("This is Phonebook:\n");
                    pb.print();
                    System.out.println("This is SMS:\n");
                    s.print();
                    System.out.println("This is Calander:\n");
                    c.print();
                    System.out.println("This is Media:\n");
                    m.print();
                    break;
                case 6:
                    quit = true;
                    App.Input.close();
                    break;
                default:
                    break;
            }
        }
    }

}