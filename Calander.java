import java.util.Date;

public class Calander extends App{

    public Date date;

    public void run()
    {

        boolean quit = false;
        while (!quit) {
            int option = Helper.option(
                "Add an occasion",
                "Delete an occasion",
                "Show all occasions in a date",
                "Show all meetings with a contact",
                "Find if there is an ocassions collision",
                "Show all occasions",
                "Exit"
            );
            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    show_date();
                    break;
                case 4:
                    show_contact();
                    break;
                case 5:
                    collision_finder();
                    break;
                case 6:
                    show_all();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void add()
    {
        //Add an occasion
        //is it an event or meeting
    }

    public void delete()
    {
        //delete an occasion
    }

    public void show_date()
    {
        //Show all occasions in a date
    }

    public void show_contact()
    {
        //"Show all meetings with a contact"
    }

    public void collision_finder()
    {
        //"find if there is an ocassions collision"
    }

    public void show_all()
    {
        //"Show all occasions"
    }

    public void print()
    {
        //TBI
    }
}
