import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;;
public class Main {
     enum Roman {
        I(1),II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
        private final int value;
        private Roman(int value) {
            this.value = value;
        }
        int toInt() {
            return value;
        }
    }


    static String arabian (int var){
         String rome = "";
         switch (var){
             case 1:
                 rome = "I";
                 break;
             case 2:
                 rome = "II";
                 break;
             case 3:
                 rome = "III";
                 break;
             case 4:
                 rome = "IV";
                 break;
             case 5:
                 rome = "V";
                 break;
             case 6:
                 rome = "VI";
                 break;
             case 7:
                 rome = "VII";
                 break;
             case 8:
                 rome = "VIII";
                 break;
             case 9:
                 rome = "IX";
                 break;
             case 10:
                 rome = "X";
                 break;
             case 11:
                 rome = "XI";
                 break;
             case 12:
                 rome = "XII";
                 break;
             case 13:
                 rome = "XIII";
                 break;
             case 14:
                 rome = "XIV";
                 break;
             case 15:
                 rome = "XV";
                 break;
             case 16:
                 rome = "XVI";
                 break;
             case 17:
                 rome = "XVII";
                 break;
             case 18:
                 rome = "XVIII";
                 break;
             case 19:
                 rome = "XIX";
                 break;
             case 20:
                 rome = "XX";
                 break;
         }

         return rome;
    }


    static int plus(int var_1, int var_2){
        int result = var_1 + var_2;
        return result;
    }


    static int minus(int var_1, int var_2){
        int result = var_1 - var_2;
        return result;
    }


    static int multiply(int var_1, int var_2){
        int result = var_1 * var_2;
        return result;
    }


    static int division(int var_1, int var_2){
        int result = var_1 / var_2;
        return result;
    }


    public static void main(String[] input) throws IOException, NumberFormatException{
        Scanner console = new Scanner(System.in);
        String expression = console.nextLine();
        String[] arguments  = expression.split(" ");
        int chek = 0;
        String cuant_arg_error = "Неверное количество аргументов";


        if (arguments.length != 3) {
            throw new IOException(cuant_arg_error);
        }

        int arg1 = 0;
        int arg2 = 0;
        try {
            arg1 = Integer.valueOf(arguments[0]);
        }
        catch (NumberFormatException e){
            chek = chek + 1;
        }
        try {
            arg2 = Integer.valueOf(arguments[2]);
        }
        catch (NumberFormatException e){
            chek = chek + 1;
        }


        if (chek == 2) {
            try {
                Double arg = Double.valueOf(arguments[0]);
            } catch (NumberFormatException e) {
                chek = chek +1;
            }
            try {
                Double arg = Double.valueOf(arguments[2]);
            } catch (NumberFormatException e) {
                chek = chek +1;
            }
        }
        String error1 = "Используются разные системы счета";
        String error2 = "Ошибка при вводе";
        switch (chek) {
            case 0:
                break;
            case 1:
                throw new IOException(error1);
            case 2:
                arg1 = Roman.valueOf(arguments[0]).toInt();
                arg2 = Roman.valueOf(arguments[2]).toInt();
                break;
            case 3, 4:
                throw new IOException(error2);
            }


        String invalid_value = "Значение не входит в промежуток от 1 до 10";
        if (arg1>10 || arg1<1 || arg2>10 || arg2<1){
            throw new IOException(invalid_value);
        }

        int oper = 0;
        String operator_error = "Неверный оператор";
        if (arguments[1].equals("+")){
            oper = 1;
        }
        if (arguments[1].equals("-")){
            oper = 2;
        }
        if (arguments[1].equals("*")){
            oper = 3;
        }
        if (arguments[1].equals("/")){
            oper = 4;
        }

        int operation_result = 0;
        switch (oper) {
            case 0:
                throw new IOException(error1);
            case 1:
                operation_result = (plus(arg1, arg2));
                break;
            case 2:
                operation_result = minus(arg1, arg2);
                break;
            case 3:
                operation_result = multiply(arg1, arg2);
                break;
            case 4:
                operation_result = division(arg1, arg2);
                break;
        }


        String zero_rome = "В риме небыло нуля и отрицательных чисел";
        if (chek == 2 && (operation_result == 0 || operation_result <0)){
            throw new IOException(zero_rome);
        }


        String result = String.valueOf(operation_result);
        if (chek == 2){
            result = arabian(operation_result);
        }
    System.out.println(result);
    }
}


