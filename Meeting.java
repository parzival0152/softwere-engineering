import java.util.Date;

public class Meeting{
    Date date;
    int time;
    Contact person;

    Meeting(Date d, int t, Contact p)
    {
        this.date=d;
        this.time=t;
        this.person=p;
    }
}
