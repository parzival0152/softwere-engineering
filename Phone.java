//class Phone contains apps and updates SMS and calendar according to Phonebook
public class Phone {
    public Phonebook pb;
    public Calendar c;
    public SMS s;
    public Media m;
    public Calculator cal;


    //constructor:creating the Apps:phonebook,SMS,Media,calendar
    //we send "this" to phonebook so we cn call to update from phonebook
    public Phone() {
        this.pb = new Phonebook(this);
        this.c = new Calendar();
        this.s = new SMS();
        this.m = new Media();
        this.cal = new Calculator();
    }


    /*update get the name of the removed contact and call the update 
    functions of SMS and calendar
    */
    public void update(String name) {
        
        // updating SMS and calendar according to changed Phonebook
        s.update(name);
        c.update(name);
    }

    //printing the entire phone contact

    public void printAll()
    {
        System.out.println("Printing all:\n********************************************");
        System.out.println("This is Phonebook:");
        pb.print();
        System.out.println();
        System.out.println("This is SMS:");
        s.print();
        System.out.println();
        System.out.println("This is calendar:");
        c.print();
        System.out.println();
        System.out.println("This is Media:");
        m.print();
        System.out.println();
        System.out.println("This is Calculator:");
        cal.print();
        System.out.println("\n********************************************");
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
            int option = Helper.option("Phonebook", "SMS", "calendar", "Media", "Calculator", "Print all", "Exit");
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
                    //calendar
                    c.run();
                    break;
                case 4:
                    //Media
                    m.run();
                    break;
                case 5:
                    //Calculator
                    cal.run();
                    break;
                case 6:
                    //print all the phone content
                    printAll();
                    break;
                case 7:
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