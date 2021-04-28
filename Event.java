import java.util.Date;

public class Event{
    Date date;
    int time;
    String description;

    Event()
    {
        
    }
    Event(Date d, int t, String s)
    {
        this.date=d;
        this.time=t;
        this.description=s;
    }
}
