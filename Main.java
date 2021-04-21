

public class Main {
    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            int option = Helper.option(
                "Phonebook",
                "SMS",
                "Calander",
                "Media",
                "Exit"
            );
            switch (option) {
                case 1:
                    Phonebook a = new Phonebook();
                    a.run();
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("Not implemented");
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
    }

}
