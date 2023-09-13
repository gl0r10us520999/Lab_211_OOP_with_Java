package managestudent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Validate {
    private Scanner sc = new Scanner(System.in);

    //Get an integer number between min and max from user as input
    public int inputInt(String msg, int min, int max){
        System.out.print(msg);
        //Make sure that input is integer
        while (true){
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check the range of input
                if (number < min || number > max){
                    System.out.println("Please input between " + min + " and " + max + ":");
                    continue;
                }
                return number;
            }catch (Exception e){
                System.out.println("Please input an integer number:");
            }
        }
    }

    //Get an double number between min and max from user as input
    public double inputDouble(String msg, double min, double max){
        System.out.print(msg);
        //Make sure that input is double
        while (true){
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                //check the range of input
                if (number < min || number > max){
                    System.out.println("Please input between " + min +" and " + max + ":");
                    continue;
                }
                return number;
            }catch (Exception e){
                System.out.println("Please input an double number:");
            }
        }
    }

    //Get an non-emty string from user as input
    public String inputString(String msg){
        System.out.print(msg);
        //Make sure that input is a non-empty string
        while (true){
            String input = sc.nextLine();
            if (input.isEmpty()){
                System.out.println("Please input an non-empty string");
                continue;
            }return input;
        }
    }

    //Get valid date
    public String inputDate(String msg){
        System.out.print(msg);
        //Set date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        //Make sure user input a valid date
        while (true){
            String input = sc.nextLine();
            try {
                Date date = dateFormat.parse(input);
                //Get current date
                Date currentDate = Calendar.getInstance().getTime();
                //check valid date
                if (currentDate.compareTo(date) < 0 ){
                    System.out.println("Please input date that before current date");
                    continue;
                }return dateFormat.format(date);
            }catch (Exception e){
                System.out.println("Please input valid date (dd/MM/yyyy)");
            }
        }
    }

    public boolean checkYesNo(String msg){
        System.out.printf("msg");
        while (true){
            String result = sc.nextLine();
            if (!result.equalsIgnoreCase("Y") & !result.equalsIgnoreCase("N") ){
                System.out.print("Please enter Y/y or N/n");
                continue;
            }
            if(result.equalsIgnoreCase("Y")){
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }
}
