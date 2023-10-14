import java.util.ArrayList;
import java.util.Calendar;

public class Manager {

  ArrayList<Candidate> candidates = new ArrayList<>();
  Validate validate = new Validate();

  public void createCandidate(int type) {
    while (true) {
      String id;
      while (true) {
        id = validate.inputString("Enter your ID: ", "[A-Za-z0-9\\s]+");
        if (validate.checkIdExist(candidates, id)) {
          break;
        } else {
          System.out.println("ID is existed");
        }
      }
      String firstName = validate.inputString("Enter first name:", "[A-Za-z\\s]+");
      String lastName = validate.inputString("Enter last name:", "[A-Za-z\\s]+");
      String birthDate = validate.inputDate("Enter birthdate:");
      String address = validate.inputString("Enter address:", ".+");
      String phone = validate.inputString("Enter phone:", "(0[3|5|7|8|9])+([0-9]{8})");
      String email = validate.inputString("Enter email:", "[A-Za-z]\\w+@\\w+(\\.\\w+){1,3}$");
      switch (type) {
        case 0:
          int yearExperience = validate.inputInt("Enter year of experience:", 0, 100);
          String professionalSkill = validate.inputString("Enter professional skill:", ".+");
          candidates.add(
              new Experience(yearExperience, professionalSkill, id, firstName, lastName, birthDate,
                  address, phone, email, type));
          break;
        case 1:
          String graduationDate = validate.inputDate("Enter graduation date:");
          System.out.print("Enter graduation rank: ");
          String graduationRank = validate.checkInputGraduationRank();
          candidates.add(
              new Fresher(graduationDate, graduationRank, id, firstName, lastName, birthDate,
                  address, phone, email, type));
          break;
        case 2:
          String major = validate.inputString("Enter major:", ".+");
          String semester = validate.inputString("Enter major:", ".+");
          String university = validate.inputString("Enter university:", ".+");
          candidates.add(
              new Internship(major, semester, university, id, firstName, lastName, birthDate,
                  address, phone, email, type));
          break;
      }
      System.out.print("Do you want to continue (Y/N): ");
      if (!validate.checkInputYN()) {
        return;
      }
    }
  }

  public void searchCandidate() {
    printListNameCandidate();
    String nameSearch = validate.inputString("Enter candidate name (First name or Last name): ",
        ".+");
    int typeCandidate = validate.inputInt("Enter type of candidate", 0, 2);
    int count = 0;
    for (Candidate candidate : candidates) {
      if (candidate.getTypeCandidate() == typeCandidate
          && candidate.getFirstName().contains(nameSearch)
          || candidate.getLastName().contains(nameSearch)) {
        System.out.println(candidate.toString());
        count++;
      }
    }
    if (count == 0) {
      System.out.println("not found");
    }
  }

  public void printListNameCandidate() {
    int countExperience = 0;
    int countFresher = 0;
    int countIntern = 0;
    for (Candidate candidate : candidates) {
      if (candidate instanceof Experience) {
        countExperience++;
        if (countExperience == 1) {
          System.out.println("Experience Candidate");
        }
        System.out.println(candidate.getFirstName() + " "
            + candidate.getLastName());
      }
      if (candidate instanceof Fresher) {
        countFresher++;
        if (countFresher == 1) {
          System.out.println("Fresher Candidate");
        }
        System.out.println(candidate.getFirstName() + " "
            + candidate.getLastName());
      }
      if (candidate instanceof Internship) {
        countIntern++;
        if (countIntern == 1) {
          System.out.println("Internship Candidate");
        }
        System.out.println(candidate.getFirstName() + " "
            + candidate.getLastName());
      }
    }
  }

  public void createCertForCandidate() {
    String id = validate.inputString("Enter ID", "[A-Za-z0-9\\s]+");
    Candidate candidateToUpdate = null;
    for (Candidate candidate : candidates) {
      if (candidate.getId().equalsIgnoreCase(id)) {
        candidateToUpdate = candidate;
        break;
      }
    }

    if (candidateToUpdate != null) {
      String certId = validate.inputString("Enter ID:", "[A-Za-z0-9\\s]+");
      String certType = validate.inputString("Enter type of certificate:", "[A-Za-z\\s]+");
      String certName = validate.inputString("Enter certificate name:", "[A-Za-z\\s]+");
      String placeOfIssue = validate.inputString("Enter place of issue:", "[A-Za-z0-9\\s]+");
      String issueDate = validate.inputDate("Enter issue date:");

      Calendar sixYearsAgo = Calendar.getInstance();
      sixYearsAgo.setTime(validate.parseDate(candidateToUpdate.getBirthDate()));
      sixYearsAgo.add(Calendar.YEAR, 6);

      Calendar twoYearsAgo = Calendar.getInstance();
      twoYearsAgo.add(Calendar.YEAR, -2);

      Calendar date = Calendar.getInstance();
      date.setTime(validate.parseDate(issueDate));

      if (date.before(sixYearsAgo) || date.after(twoYearsAgo)) {
        System.err.println("Invalid issue date!");
        return;
      }
      Certificate certificate = new Certificate(certId, certType, certName, placeOfIssue, issueDate);
      candidateToUpdate.addCertificate(certificate);

      System.out.println("Certificate added successfully.");
    } else {
      System.err.println("Candidate with ID "+ id + " not found!");
    }
  }
}
