import java.util.Comparator;

//the class contact contains name and number
class Contact{
    String name;
    String number;
    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }
    @Override
    //split name and number by ","
    public String toString()
    {
        return this.name + "," + this.number;
    }
    
}

class NameComperator implements Comparator<Contact>{

    @Override
    //change base comperator to compare by contact name
    public int compare(Contact o1, Contact o2) {
        return o1.name.compareTo(o2.name);
    }

}

class NumberComperator implements Comparator<Contact>{

    @Override
    //change base comperator to compare by contact number.
    public int compare(Contact o1, Contact o2)
    {
        return o1.number.compareTo(o2.number);
    }

}