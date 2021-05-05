
public class Phone {
    public Phonebook pb;
    public Calander c;
    public SMS s;
    public Media m;


    //constructor:creating the Apps:phonebook,SMS,Media,Calander
    //we send "this" to phonebook so we cn call to update from phonebook
    public Phone() {
        this.pb = new Phonebook(this);
        this.c = new Calander();
        this.s = new SMS();
        this.m = new Media();
    }


    /*update get the name of the removed contact and call the update 
    functions of SMS and Calander
    */
    public void update(String name) {
        
        // updating SMS and Calander according to changed Phonebook
        s.update(name);
        c.update(name);
    }

    //printing the entire phone contact

    public void printAll()
    {
        System.out.println("This is Phonebook:");
        pb.print();
        System.out.println("This is SMS:");
        s.print();
        System.out.println("This is Calander:");
        c.print();
        System.out.println("This is Media:");
        m.print();
    }

    //closing the scanner before exiting
    private void quit()
    {
        App.Input.close();
    }



    /*
      getting input from user in helper and send to the right app
    
    */ 


    public void runp() {
        boolean quit = false;
        while (!quit) {
            int option = Helper.option("Phonebook", "SMS", "Calander", "Media", "Print all", "Exit");
            switch (option) {
                case 1:
                    //phonebook
                    pb.run();
                    break;
                case 2:
                    //SMS
                    s.run();
                    break;
                case 3:
                    //Calander
                    c.run();
                    break;
                case 4:
                    //Media
                    m.run();
                    break;
                case 5:
                    //print all the phone content
                    printAll();
                    break;
                case 6:
                    //exit
                    quit = true;
                    quit();
                    break;
                default:
                    break;
            }
        }
    }

}