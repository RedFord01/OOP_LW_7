import java.util.Scanner;
class School {
    private int schoolNumber;
    private int numberOfStudents;
    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }
    public int getSchoolNumber() {
        return schoolNumber;
    }
    public void setNumberOfStudents(int numberOfStudents) {

        this.numberOfStudents = numberOfStudents;
    }
    public int getNumberOfStudents() {

        return numberOfStudents;
    }
    enum Seasons {
        Winter("We don`t study at winter"),
        Spring("We are studying at spring"),
        Summer("We don`t study at summer"),
        Autumn("We are studying at autumn");
        private final String code;
        Seasons(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }
    public void getResults(String userInput) {
        System.out.println("The school number " + getSchoolNumber() + " has " + getNumberOfStudents() + " students");
        switch (userInput) {
            case "Winter" -> System.out.println(Seasons.Winter.getCode());
            case "Spring" -> System.out.println(Seasons.Spring.getCode());
            case "Summer" -> System.out.println(Seasons.Summer.getCode());
            case "Autumn" -> System.out.println(Seasons.Autumn.getCode());
            default -> System.out.println("Enter season correctly!");
        }
    }
}

public class NewSchool {
    public static void main(String [] args) {
        School school = new School();
        Scanner in = new Scanner(System.in);
        System.out.println("/*Enter information about school*/\n".toUpperCase());
        System.out.println("Enter the school number: ");
        school.setSchoolNumber(in.nextInt());
        System.out.println("Enter the number of students: ");
        school.setNumberOfStudents(in.nextInt());
        System.out.println("Enter the current season: ");
        school.getResults(in.next());
        in.close();
    }
}