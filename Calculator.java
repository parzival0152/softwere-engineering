import java.lang.Math;
import java.util.ArrayList;

public class Calculator extends App {
    public ArrayList<String> history = new ArrayList<>();
    void run()
    {
        System.out.println("Enter calculation:");
        String calc = Input.nextLine();
        history.add(calc + " = ");

        char[] charCalc = calc.toCharArray();
        ArrayList<Integer> open = new ArrayList<>(),close = new ArrayList<>();
        open.add(0);
        //finding index of all parentheses
        try
        {
            parenthesesFinder(open, close, charCalc);
        }
        //---------------------maybe +1 isn't needed
        close.add(calc.length()+1); 

        //calculating all parentheses
        while(!open.isEmpty())
        {
            partition(open.get(open.size())+1,close.get(0),calc);
            open.remove(open.size());
            close.remove(0);
        }
        System.out.println(calc);
        history.add(calc+ "\n");
    }

    //calculates part within parentheses. uses calculation.
    private void partition(Integer open, Integer close, String calc)
    {   
        String part = calc.substring(open,close);
        String[] splited = part.split(" ");

        //finds location of exponents, multiplication and division
        ArrayList<Integer> exp = new ArrayList<>(),multdiv = new ArrayList<>();
        for (int i = 1; i < splited.length; i = i + 2)
        {
            if(splited[i] == "^")
                exp.add(i);
            if(splited[i] == "/" || splited[i] == "*")
                multdiv.add(i);
        }

        Double answer;
        String change;
        Double num1,num2;
        //calculating exponents
        for (int i = 0; i < exp.size(); i++)
        {
            num1  = Double.parseDouble(splited[i-1]);
            num2 = Double.parseDouble(splited[i+1]);
            try
            {
                answer = calculation(num1,splited[i],num2);
            }
            change.concat(splited[i-1]+" * "+splited[i+1]);
            part.replaceAll(change,answer.toString());
            change = "";
        }

        //calculating mult and div
        for (int i = 0; i < multdiv.size(); i++)
        {
            num1  = Double.parseDouble(splited[i-1]);
            num2 = Double.parseDouble(splited[i+1]);
            try
            {
                answer = calculation(num1,splited[i],num2);
            }
            change.concat(splited[i-1] + " " + splited[i] + " " + splited[i+1]);
            part.replaceAll(change,answer.toString());
            change = "";
        }

        //calculating the addition and subtraction
        for(int i = 0; i < part.length(); i = i + 3)
        {
            num1  = Double.parseDouble(splited[i]);
            num2 = Double.parseDouble(splited[i+2]);
            try
            {
                answer = calculation(num1,splited[i],num2);
            }
            change.concat(splited[i] + " " + splited[i+1] + " " + splited[i+2]);
            part.replaceAll(change,answer.toString());
            change = "";
        }

        //replacing parenthesis with answer
        String product = "(";
        part.concat(")");
        product.concat(part);
        calc.replace(product, answer.toString());
    }

    private Double calculation(Double num1, String action, Double num2)
    {
        switch(action)
        {
            case("+"):
                return (num1+num2);
            case("-"):
                return (num1-num2);
            case("*"):
                return (num1*num2);
            case("/"):
                return (num1/num2);
            case("^"):
                return (Math.pow(num1,num2));
            default:
                throw("REEE");
                break;
        }
    }

    //finds parentheses in user input, makes sure they are valid and returns their indexes
    private void parenthesesFinder(ArrayList<Integer> open, ArrayList<Integer> close, char[] str)
    {
        Integer countO = 0;
        for(int i =0; i< str.length; i++)
        {
            if(str[i] == '(')
            {
                open.add(i);
                countO++;
            }
            if(str[i] == ')')
            {
                if(countO == 0)
                    throw("Bad");
                close.add(i);
                countO--;
            }
        }
        if (countO != 0)
            throw("Wrong");
        
    }


    void print()
    {
        System.out.println("Calculator History\n"+history);
    }
    

}
