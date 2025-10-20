import java.util.InputMismatchException;
import java.util.Scanner;

public class Java_Console_Calculator{
    
    //Addition
    public static double add(double x, double y){
        return x + y;
    }

    //Substraction
    public static double Sub(double x, double y){
        return x - y;
    }

    //Multiplication
    public static double Multi(double x, double y){
        return x * y;
    }

    //Division with divide-by-zero handling
    public static Double Div(Double x, double y){
        if(y == 0.0){
            return null;
        }
        return x / y;
    }

    //print 
    public static void printMenu(){
        System.out.println("\n===== Java Console Calculator =====");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    //read a double val safely
    public static double readDouble(Scanner scanner, String prompt){
        while (true) {
            try{
                System.out.println(prompt);
                return scanner.nextDouble();
            }
           catch (InputMismatchException e) {
                // TODO: handle exception
                System.out.println("Sorry! your input is Invalid. Please enter a numeric value.");
                scanner.next(); //clear invalid token
            }
        }
    }

    //main method
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while(keepRunning){
            printMenu();
            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
              // TODO: handle exception
              System.out.println("Sorry! your Choice is Invalid. Please enter a number between 1 and 5.");
               scanner.next();
               continue;
            }
            switch (choice) {
                case 1: //Addition
                case 2: //Substraction
                case 3: //Multiplication
                case 4:{ //Division
                    double num1 = readDouble(scanner, "Enter first number: ");
                    double num2 = readDouble(scanner, "Enter second number: ");
                    double result;

                    if(choice == 1){
                        result = add(num1, num2);
                        System.out.println("Result: " + result);
                    }
                    else if (choice == 2) {
                        result = Sub(num1,num2);
                        System.out.println("Result: " + result);
                    }
                    else if(choice == 3){
                        result = Multi(num1, num2);
                        System.out.println("Result: " + result);
                    }
                    else{
                          Double divResult = Div(num1, num2);
                          if(divResult == null){
                            System.out.println("ERROR: Division by zero is not allowed!");
                          }
                          else{
                            System.out.println("Result: " + divResult);
                          }
                    }

                    //Ask if user wants another Calculation
                    System.out.println("Hey! Do you want to perform another Calculation? (yes/no): ");
                    String again = scanner.next();
                    if(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("y")){
                        keepRunning = false;
                        System.out.println("Exiting Calculator. Good Bye! ");
                    }
                    break;
                }
                case 5:
                keepRunning = false;
               System.out.println("Exiting Calculator. So Good Bye! ");
               break;
               default:
                  System.out.println("Please Enter a valid option (1 - 5): ");
            }
        }
        scanner.close();
    }
}
    
