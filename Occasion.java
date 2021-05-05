//class that represents both Event and Meeting
import java.util.Date;
abstract class Occasion {
    Date date;
    int time;
    double startTime;

    Occasion(Date d, int t)
    {
        this.date=d;
        this.time=t;
        //represnts time with both hours and minutes
        this.startTime = (double)d.getHours() + (double)(d.getMinutes()/60.0);
    }

    //sends back name or description according to type of class
    abstract String getDetails();

    public void print()
    {
        System.out.print("Date is day:" + this.date.getDay() + "\nTime is: ");
        if (this.date.getHours()<10)
        {
            System.out.print("0" + this.date.getHours());
        }
        else
        {
            System.out.print(this.date.getHours());
        }

        System.out.print(":");

        if (this.date.getMinutes()<10)
        {
            System.out.print("0" + this.date.getMinutes());
        }
        else
        {
            System.out.print(this.date.getMinutes());
        }

        System.out.println(" and time length is " + this.time);
    }
    
}
