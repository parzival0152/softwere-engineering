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
        System.out.println("Time is: " + this.date.getHours() + ":" + this.date.getMinutes());

    }

    abstract String getDetails();

    public void print()
    {
        System.out.println("Date is day:" + this.date.getDay() + "\nTime is: " + this.date.getHours() + 
        ":" + this.date.getMinutes() + " and time length is " + this.time + "\n");
    }
    
}
