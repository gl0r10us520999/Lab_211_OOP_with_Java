public class Main {
    public static void main(String[] args) {
      Manager manager = new Manager();
      Validate validate= new Validate();
      while (true) {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Add certificate");
        System.out.println("6. Exit");
        int choice = validate.inputInt("Enter your choice: ",1, 6);
        switch (choice) {
          case 1:
            manager.createCandidate(0);
            break;
          case 2:
            manager.createCandidate(1);
            break;
          case 3:
            manager.createCandidate(2);
            break;
          case 4:
            manager.searchCandidate();
            break;
          case 5:
            manager.createCertForCandidate();
            break;
          case 6:
            return;
        }
      }
    }
}