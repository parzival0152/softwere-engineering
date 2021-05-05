import java.util.Date;

public class Event extends Occasion{
    String description;

    Event(Date d, int t, String s)
    {
        super(d, t);
        this.description=s;
    }
    
    public String getDetails()
    {
        return(description);
    }

    public void print()
    {
        System.out.println("Description is " + this.description + ".");
        super.print();
    }
}
