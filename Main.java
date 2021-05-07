public class Main {
    public static void main(String[] args) 
    {
        Phone p = new Phone();
        //p.runp();


        //all details are being input by the user through the menu in runp()
        //load txt
        p.pb.readFromFile("test.txt");
        //print all contacts
        p.pb.print();
        //add contact
        p.pb.addContact("lala", "111");
        //start conversation with contact
        p.s.newConv("lala", "hi");
        //countinue conversation
        p.s.newConv("lala", "what's up");
        //start conversation with contact
        p.s.newConv("or", "hellooo good morning");
        //look for a specific phrase in all conversations
        p.s.findInAll("hi");
        //show all conversations with this contact
        p.s.printConv("or");
        //add event on day 1 10:00
        //first number is 1-event and 2-meeting
        p.c.addOccasion(1, 1, 10, 0, 45, "java course");
        //add meeting on day 2 10:00 with eliya
        p.c.addOccasion(2, 2, 10, 0, 30, "eliya");
        //adding overlap
        p.c.addOccasion(1, 1, 10, 20, 10, "test");
        p.c.print();
        //remove collisions
        p.c.collisionFinder();
        p.c.print();
        //add meeting with lala on 13:23
        p.c.addOccasion(2, 13, 23, 1, 10, "lala");
        //add song, type is false for song and true for video
        p.m.addMedia("Beyonce", 3.2, false);
        //add video
        p.m.addMedia("Titanic", 120.3, true);
        //show all
        p.printAll();
        //remove contact
        p.pb.removeContact("lala");
        //show that all text with removed contacts are gone
        p.printAll();
    }

}
