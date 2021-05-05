import java.util.Date;

public class BetterDate extends Date{

    public BetterDate()
    {
        super();
        Date temp = new Date(2021, 05, 0, 0, 0);
        this.setDate(temp.getDate());
    }
    
    public BetterDate(int day, int hour, int minute)
    {
        super();
        Date temp = new Date(2021, 05, day, hour, minute);
        this.setDate(temp.getDate());
    }

    @Override
    public String toString()
    {
        return String.valueOf(getDate());
    }

    @Override
    public int getDay()
    {
        return super.getDate();
    }

    public void setDay(int day)
    {
        super.setDate(day);
    }

    @Override
    public int getHours()
    {
        return super.getHours();
    }

    @Override
    public void setHours(int hours)
    {
        super.setHours(hours);
    }

}
