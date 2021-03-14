import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args) {
        ArrayList<Integer> numlist = new ArrayList<Integer>();
        numlist.add(5);
        numlist.add(4);
        numlist.add(3);
        numlist.add(2);
        numlist.add(1);
        Collections.sort(numlist);
        for(int i:numlist)
        {
            System.out.println(i*i);
        }
    }
}