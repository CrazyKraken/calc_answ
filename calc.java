import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;;

public class Main {
    static String int_to_roman(int val) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (val >= values[i]) {
                val = val - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }


    enum Roman {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
        private final int value;

        private Roman(int value) {
            this.value = value;
        }

        int toInt() {
            return value;
        }
    }

    public static String calc(String expression) throws IOException, NumberFormatException {
        String[] arguments = expression.split(" ");
        int chek = 0;
        String cuant_arg_error = "Неверное количество аргументов";


        if (arguments.length != 3) {
            throw new IOException(cuant_arg_error);
        }

        int arg1 = 0;
        int arg2 = 0;
        try {
            arg1 = Integer.valueOf(arguments[0]);
        } catch (NumberFormatException e) {
            chek = chek + 1;
        }
        try {
            arg2 = Integer.valueOf(arguments[2]);
        } catch (NumberFormatException e) {
            chek = chek + 1;
        }

        boolean dob1 = true;
        boolean dob2 = true;
        if (chek == 2) {

            try {
                Double arg = Double.valueOf(arguments[0]);
            } catch (NumberFormatException e) {
                dob1 = false;
            }
            try {
                Double arg = Double.valueOf(arguments[2]);
            } catch (NumberFormatException e) {
                dob2 = false;
            }
        } else {
            dob1 = false;
            dob2 = false;
        }

        String error2 = "Ошибка при вводе";
        if (dob1 || dob2) {
            throw new IOException(error2);
        }


        String error1 = "Используются разные системы счета";
        switch (chek) {
            case 0:
                break;
            case 1:
                throw new IOException(error1);
            case 2:
                try {
                    arg1 = Roman.valueOf(arguments[0]).toInt();
                    arg2 = Roman.valueOf(arguments[2]).toInt();
                    break;
                } catch (IllegalArgumentException e) {
                    throw new IOException(error2);
                }


        }


        String invalid_value = "Значение не входит в промежуток от 1 до 10";
        if (arg1 > 10 || arg1 < 1 || arg2 > 10 || arg2 < 1) {
            throw new IOException(invalid_value);
        }

        int oper = 0;
        String operator_error = "Неверный оператор";
        if (arguments[1].equals("+")) {
            oper = 1;
        }
        if (arguments[1].equals("-")) {
            oper = 2;
        }
        if (arguments[1].equals("*")) {
            oper = 3;
        }
        if (arguments[1].equals("/")) {
            oper = 4;
        }

        int operation_result = 0;
        switch (oper) {
            case 0:
                throw new IOException(error1);
            case 1:
                operation_result = arg1 + arg2;
                break;
            case 2:
                operation_result = arg1 - arg2;
                break;
            case 3:
                operation_result = arg1 * arg2;
                break;
            case 4:
                operation_result = arg1 / arg2;
                break;
        }


        String zero_rome = "В риме небыло нуля и отрицательных чисел";
        if (chek == 2 && (operation_result == 0 || operation_result < 0)) {
            throw new IOException(zero_rome);
        }


        String result = String.valueOf(operation_result);
        if (chek == 2) {
            result = int_to_roman(operation_result);
        }

        return result;
    }

    public static void main(String[] input) throws IOException {
        Scanner console = new Scanner(System.in);
        String expression = console.nextLine();
        System.out.println(calc(expression));
    }
}
