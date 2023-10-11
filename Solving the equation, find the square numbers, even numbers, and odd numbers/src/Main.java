 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quann
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = manager.inutInt("Enter choice",1, 3);
        switch (choice) {
                case 1:
                    manager.calcSuperlativeEquation();
                    break;
                case 2:
                    manager.calcQuadraticEquation();
                    break;
                case 3:
                    return;
            }
    }
    
}
