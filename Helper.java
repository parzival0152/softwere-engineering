
public class Helper {
    
    public static int option(String... options)
    {
        int choice = -1;
        do {
            System.out.println("Please choose one of the following options: ");
            for (int i = 0; i < options.length; i++) {
                System.out.println(i+1 + ") " +options[i]);
            }
            System.out.print("Your choice: ");
            try {

                if (App.Input.hasNext())
                {
                    choice = Integer.parseInt(App.Input.nextLine());
                }
                    

            } catch (Exception e) {
                choice = -1;
            }
            if(!(choice>0 && choice<= options.length))
            {
                System.out.println("Error: not an option");
            }
        } while (!(choice>0 && choice<= options.length));
        return choice;
    }
}