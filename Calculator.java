import java.util.Scanner;

public class Calculator {
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();
       

        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();

        System.out.println("Enter the operation (+, -, *,/,>>,<<):");
        String operator = scanner.next();

        Operation op;
        switch (operator) 
        {
            case "+":
                op = new Addition();
                break;
            case "-":
                op = new Subtraction();
                break;
            case "*":
                op = new Multiplication();
                break;
            case "/":
                op = new Division();
                break;
           case "<<":
                System.out.print("Enter the shift amount: ");
                int shift = scanner.nextInt();
                op = new BitwiseShiftOperator(shift);
                break;
            case ">>":
                System.out.print("Enter the shift amount: ");
                shift = scanner.nextInt();
                op = new BitwiseShiftOperator(shift);
                break;
            default:
                System.out.println("Error: Invalid operator!");
                return;
        }

        int result = op.calculate(num1, num2);

        System.out.println("Result (Decimal): " 
        + result);
        System.out.println("Result (Binary): " 
        + Integer.toBinaryString(result));
        System.out.println("Result (Octal): " 
        + Integer.toOctalString(result));
        System.out.println("Result (HexaDecimal): "
         + Integer.toHexString(result));
        scanner.close();
    }
}

abstract class Operation {
    public abstract int calculate(int num1, int num2);
   
}

class Addition extends Operation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtraction extends Operation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class Multiplication extends Operation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
class Division extends Operation {
    @Override
    public int calculate(int num1, int num2) {
         if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Error: Cannot divide by zero!");
        }
    }
}
class BitwiseShiftOperator extends Operation {
    private int shift;

    public BitwiseShiftOperator(int shift) {
        this.shift = shift;
    }

    @Override
    public int calculate(int num1, int num2) {
        return num1 << shift;
    }
    
   
}
