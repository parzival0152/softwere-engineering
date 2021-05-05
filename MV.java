//class MV is used to create an ArrayList of this type
import java.util.Comparator;

public class MV {
    public String name;
    public double length;
    public Boolean video;
    
    public MV(String name, double length, Boolean video) {
        this.name = name;
        this.length = length;
        this.video=video;
    }
}

class NameComperator implements Comparator<MV>{

    @Override
    //change base comperator to compare by contact name
    public int compare(MV o1, MV o2) {
        return o1.name.compareTo(o2.name);
    }

}
