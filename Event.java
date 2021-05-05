//Event contains description, extends Occasion
import java.util.Date;

public class Event extends Occasion{
    String description;

    Event(Date d, int t, String s)
    {
        super(d, t);
        this.description=s;
    }
    
    //returns description (variable of Event)
    public String getDetails()
    {
        return(description);
    }

    public void print()
    {
        super.print();
        System.out.println("Description is " + this.description + ".\n");
    }
}
