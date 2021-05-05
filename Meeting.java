import java.util.Date;

public class Meeting extends Occasion{
    Contact person;

    Meeting(Date d, int t, Contact p)
    {
        super(d, t);
        this.person=p;
    }

    public String getDetails()
    {
        return(person.name);
    }

    public void print()
    {
        System.out.println("Contact person is " + this.person.name + ".");
        super.print();
    }
}
