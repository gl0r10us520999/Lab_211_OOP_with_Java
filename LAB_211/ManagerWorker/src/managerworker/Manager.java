package managerworker;



import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;


public class Manager {
    ArrayList<Worker> workers = new ArrayList<>();
    ArrayList<History> history = new ArrayList<>();
    ArrayList<History> salaryHistory = new ArrayList<>();
    Validate validate = new Validate();

    public Worker getWorkerByCode(String id){
        for (Worker worker : workers){
            if (id.equalsIgnoreCase(worker.getId())){
                return worker;
            }
        }return null;
    }

    public void addWorker() {
        while (true) {
            String id;
            while (true) {
                id = validate.inputString("Enter ID:");
                Worker worker = getWorkerByCode(id);
                if (worker == null) {
                    break;
                } else {
                    System.out.println("Id had already exist!");
                }
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
            Calendar calendar = Calendar.getInstance();
            String date = dateFormat.format(calendar.getTime());
            String name = validate.inputString("Enter name:");
            int age = validate.inputInt("Enter age:", 18, 50);
            double salary = validate.inputDouble("Enter salary:", 1, Double.MAX_VALUE);
            String workLocation = validate.inputString("Enter work location:");
            workers.add(new Worker(id, name, age, salary, workLocation));
            history.add(new History(id, name, age, salary, workLocation, "UP", date));
            //Chức năng gvien yêu cầu thêm, tuỳ tình huống có thể sử dụng
            String addMore = validate.inputYesNo("Do you want to continue?(Y/N):");
            if (!addMore.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    public void changeSalary(String status) {
        while (true) {
            String id;
            while (true) {
                id = validate.inputString("Enter ID:");
                Worker worker = getWorkerByCode(id);
                if (worker == null) {
                    System.out.println("ID doesn't exist in database!");
                    continue;
                } else {
                    if (worker.getSalary() == 1 && status.equals("DOWN")) {
                        System.out.println("Can't decrease this worker's salary anymore!");
                    } else if (worker.getSalary() == Double.MAX_VALUE && status.equals("UP")) {
                        System.out.println("Can't increase this worker's salary anymore!");
                    } else {
                        double salary;
                        double currentSalary = worker.getSalary();
                        while (true) {
                            double changeSalary = validate.inputDouble("Enter salary change:", 1, Double.MAX_VALUE);
                            if (status.equals("UP")) {
                                salary = currentSalary + changeSalary;
                                break;
                            } else if (currentSalary < changeSalary) {
                                System.out.println("The reduced salary must be less than the current salary (" + currentSalary + ")");
                            } else {
                                salary = currentSalary - changeSalary;
                                break;
                            }
                        }
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
                        Calendar calendar = Calendar.getInstance();
                        String date = dateFormat.format(calendar.getTime());
                        salaryHistory.add(new History(worker.getId(), worker.getName(), worker.getAge(), salary, worker.getWorkLocation(), status, date));
                        worker.setSalary(salary);
                    }
                }
                break;
            }
            //Chức năng gvien yêu cầu thêm, tuỳ tình huống có thể sử dụng
            String addMore = validate.inputYesNo("Do you want to continue?(Y/N):");
            if (!addMore.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    public void getInformationSalary(){
        if (history.isEmpty()){
            System.out.println("No history!");
        }
        //Chức năng gvien yêu cầu thêm, tuỳ tình huống có thể sử dụng
        Collections.sort(salaryHistory, Comparator.comparing(History::getId));
        
        System.out.printf("%-10s%-20s%-5s%-20s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (History salaryHistory : salaryHistory ){
            System.out.printf("%-10s%-20s%-5d%-20.0f%-10s%-20s\n", salaryHistory.getId(), salaryHistory.getName(), salaryHistory.getAge(), salaryHistory.getSalary(), salaryHistory.getStatus(), salaryHistory.getDate());
        }
    }
}
