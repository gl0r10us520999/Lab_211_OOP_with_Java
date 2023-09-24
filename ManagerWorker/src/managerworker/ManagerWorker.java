/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerworker;

public class ManagerWorker {


    public static void main(String[] args) {
        Manager manager = new Manager();
        Validate validate = new Validate();
        while (true) {
            System.out.println("1. Add worker.");
            System.out.println("2. Up salary.");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exist");
            int choice = validate.inputInt("Enter choice:", 1, 5);
            switch (choice) {
                case 1:
                    manager.addWorker();
                    break;
                case 2:
                    manager.changeSalary("UP");
                    break;
                case 3:
                    manager.changeSalary("DOWN");
                    break;
                case 4:
                    manager.getInformationSalary(); 
                    break;
                case 5:
                    return;
            }
        }
    }
}
