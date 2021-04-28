import java.util.Date;
import java.util.Calendar;

public class BetterDate extends Date{
    
    public BetterDate(int year, int month, int day, int hour, int minute)
    {
        super();
        Calendar c=Calendar.getInstance();
        c.set(year, month, day, hour, minute);
        Date temp = c.getTime();
        this.setDate(temp.getDate());
    }

    @Override
    public String toString()
    {
        String string1 = "test";
        return string1;
    }
}
