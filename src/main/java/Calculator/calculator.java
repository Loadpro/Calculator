package Calculator;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {

        Conversion conversion = new Conversion();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }
        String[] data = exp.split(regexActions[actionIndex]);
        if(conversion.isCalulator(data[0]) == conversion.isCalulator(data[1])){
            int a,b;

            boolean isCalulator = conversion.isCalulator(data[0]);
            if(isCalulator){

                a = conversion.rimeToInt(data[0]);
                b = conversion.rimeToInt(data[1]);

            }else {


                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);

            }


            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }

            if(isCalulator){
                System.out.println(conversion.intToRim(result));
            }
            else {
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }


    }
}
