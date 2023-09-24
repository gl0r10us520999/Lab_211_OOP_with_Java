package managerworker;

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
                    System.out.print("Please input between " + min + " and " + max + ":");
                    continue;
                }
                return number;
            }catch (Exception e){
                System.out.print("Please input an integer number:");
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
                    System.out.print("Please input between " + min +" and " + max + ":");
                    continue;
                }
                return number;
            }catch (Exception e){
                System.out.print("Please input an double number:");
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
                System.out.print("Please input an non-empty string");
                continue;
            }return input;
        }
    }

    public String inputYesNo(String msg){
        System.out.print(msg);
        //Make sure that input is a non-empty string
        while (true){
            String input = sc.nextLine();
            if (input.isEmpty()){
                System.out.print("Please input an non-empty string");
                continue;
            }if (!input.equalsIgnoreCase("Y") & !input.equalsIgnoreCase("N")) {
                System.out.print("Please enter Y/y or N/n:");
                continue;
            }return input;
        }
    }

//    public String inputDate(String mess) {
//        System.out.print(mess);
//        //set format of date
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dateFormat.setLenient(false);
//        //force user input exectly a date
//        while(true) {
//            String input = sc.nextLine();
//            try {
//                Date date = dateFormat.parse(input);
//                //get current date
//                Date curDate = Calendar.getInstance().getTime();
//                //check range of date
//                if (curDate.compareTo(date) < 0) {
//                    System.out.print("Please input date that before current date: ");
//                    continue;
//                }
//                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                return dateFormat.format(date);
//            } catch (Exception e) {
//                System.out.print("Please input valid date (dd/MM/yyyy): ");
//            }
//        }
//    }
}
