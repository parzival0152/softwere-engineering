import java.util.Scanner;

public class Helper {
    
    public static int option(String... options)
    {
        Scanner input2 = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("Please choose one of the following options: ");
            for (int i = 0; i < options.length; i++) {
                System.out.println(i+1 + ") " +options[i]);
            }
            System.out.print("Your choice: ");
            try {

                if (input2.hasNext())
                {
                    choice = Integer.parseInt(input2.nextLine());
                }
                    

            } catch (Exception e) {
                choice = -1;
            }
            if(!(choice>0 && choice<= options.length))
            {
                System.out.println("Error: not an option");
            }
            if(choice==5)
            {
                input2.close();
            }
        } while (!(choice>0 && choice<= options.length));
        return choice;
    }
}
