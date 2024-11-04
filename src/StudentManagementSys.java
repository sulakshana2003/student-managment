import srcPackage.StudentDetail;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StudentDetail> students = new ArrayList<>();
        StudentManagementSys sms  = new StudentManagementSys();
        String answer;
        int studcount = 1;
        do {
            int choice;

            try {

                System.out.println("1: add Student Details");
                System.out.println("2: check Student details");
                System.out.println("3:exit");
                System.out.print("Enter ur choice(1,2,3): ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println();
                        System.out.println("------Student "+studcount+" ----------");
                        sms.getStudentDetail(scanner, students);
                        System.out.println();
                        break;
                    case 2:
                        if (students.isEmpty()) {
                            System.out.println("there is no records!");
                            System.out.println();
                        } else {
                            int count = 1;
                            for (StudentDetail stud : students) {
                                System.out.println("------------"+"student "+count+" " + stud.getName()+"-------------");
                                stud.printDetails();
                                System.out.println(stud.AvgMarks());
                                System.out.println();
                                count++;
                            }

                        }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("wrong choice!");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("error ur had a wrong choice "+e);
                scanner.nextLine();
            }
            System.out.println("Do you want to continue? (YES or N0) ");
            answer = scanner.nextLine();
            studcount++;
            if (answer.equalsIgnoreCase("no"))break;
        }while (answer.equalsIgnoreCase("yes"));
        scanner.close();
    }//main method


    public void getStudentDetail(Scanner scanner , List<StudentDetail>students){
        String name ;
        int age;
        double[] Marks = new double[3];
        try {
            System.out.print("Enter ur Name: ");
            name = scanner.nextLine();
            
            System.out.print("Enter ur age: ");
            age = scanner.nextInt();
            ageErr(age);
            scanner.nextLine();
            for (int i = 0; i < Marks.length; i++) {
                String subjectName = switch (i) {
                    case 0 -> "Maths";
                    case 1 -> "It";
                    case 2 -> "Scinece";
                    default -> "default";
                };
                boolean validinput = false;
                while(!validinput) {
                    try {
                        System.out.print("Enter " + subjectName + " marks: ");
                        Marks[i] = scanner.nextDouble();
                        marksErr(Marks[i]);
                        validinput = true;
                    } catch (marksError e) {
                        System.out.println("Error: " + e.getMessage());
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println();
                    }
                }
            }
            scanner.nextLine();
            students.add(new StudentDetail(name,age,Marks));
        } catch (InputMismatchException e) {
            System.out.println("Error: "+e.getMessage());
        }catch (ageError e){
            System.out.println("Error: "+e.getMessage());
            scanner.nextLine();
        }

    }// get input

    public void ageErr(int age) throws ageError{
        if (age <=5 || age >= 100 ){
            throw new ageError("ur age is not valid!");
        }
    }// age err Exception

    public void marksErr(double marks) throws marksError{
        if (marks <=0 || marks >= 100 ){
            throw new marksError("ur marks are invalid!");
        }
    }// marks exception

}//main class

