package Assignment;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        try (BufferedReader studentFile = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = studentFile.readLine()) != null) {
                String[] tokens = line.split(" ");
                String name = tokens[0];
                String surname = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                boolean gender = Boolean.parseBoolean(tokens[3]);
                Student student = new Student(name, surname, age, gender);

                for (int i = 4; i < tokens.length; i++) {
                    student.addGrade(Integer.parseInt(tokens[i]));
                }
                school.addMember(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }

        try (BufferedReader teacherFile = new BufferedReader(new FileReader("teachers.txt"))) {
            String line;
            while ((line = teacherFile.readLine()) != null) {
                String[] tokens = line.split(" ");
                String name = tokens[0];
                String surname = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                boolean gender = Boolean.parseBoolean(tokens[3]);
                String subject = tokens[4];
                int yearsOfExperience = Integer.parseInt(tokens[5]);
                int salary = Integer.parseInt(tokens[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                school.addMember(teacher);

                if (yearsOfExperience > 10) {
                    teacher.giveRaise(10);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading teachers file: " + e.getMessage());
        }

        System.out.println(school.toString());

        for (Person p : school.getMembers()) {
            if (p instanceof Student) {
                Student student = (Student) p;
                System.out.println("GPA of " + student.toString() + ": " + student.calculateGPA());
            }

            if (p instanceof Teacher) {
                Teacher teacher = (Teacher) p;
                System.out.println(teacher.toString() + " Salary: " + teacher.getSalary());
            }
        }
    }
}
//.