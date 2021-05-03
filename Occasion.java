import java.util.Date;
abstract class Occasion {
    Date date;
    int time;
    double startTime;

    Occasion(Date d, int t)
    {
        this.date=d;
        this.time=t;
        this.startTime = (double)d.getHours() + (double)(d.getMinutes()/60.0);
        System.out.println("Hours are:" + this.date.getHours() + " and Minutes are: " + this.date.getMinutes());

    }

    abstract String getDetails();

    public void print()
    {
        System.out.println("date is day:" + this.date.getDay() + " hours are:" + this.date.getHours() + 
        " minutes are:" + this.date.getMinutes() + " and time is " + this.time + "\n");
    }
    
}
