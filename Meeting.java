//Meeting contains name, extends Occasion
import java.util.Date;

public class Meeting extends Occasion{
    Contact person;

    Meeting(Date d, int t, Contact p)
    {
        super(d, t);
        this.person=p;
    }

    //returns name (variable of Meeting)
    public String getDetails()
    {
        return(person.name);
    }

    public void print()
    {
        super.print();
        System.out.println("Contact person is " + this.person.name + ".\n");
        
    }
}
