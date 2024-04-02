package Boundary;

import ADT.*;
import Control.CourseManager;
import Entity.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static Boundary.MainApp.*;

public class Main {
    
    public static CourseManager cmFOCS = new CourseManager();
    public static CourseManager cmFAFB = new CourseManager();

    private static Scanner input = new Scanner(System.in);
    public static void mainCourse(String[] args)  throws IOException{

        ListInterface<Course> courseListFOCS = new LinkedList<>();
        ListInterface<Course> courseListFAFB = new LinkedList<>();
        ListInterface<Programme> progList = new LinkedList<>();

        readTutorsFromFile();
        //listAllTutors();

        //create course
        Course c1 = new Course("CS001", "Object-Oriented Programming");
        Course c2 = new Course("CS002", "Data Structure and Algorithm");
        Course c3 = new Course("CS003", "Database");
        Course c4 = new Course("AB004", "Economics");
        Course c5 = new Course("AB005", "Marketing");
        Course c6 = new Course("AB006", "Accounting");
        courseListFOCS.add(c1);
        courseListFOCS.add(c2);
        courseListFOCS.add(c3);

        cmFOCS.addAll(courseListFOCS);

        courseListFAFB.add(c4);
        courseListFAFB.add(c5);
        courseListFAFB.add(c6);

        cmFAFB.addAll(courseListFAFB);

        //cmRDS
        ListInterface<Course> courseListRDS = new LinkedList<>();
        courseListRDS.add(c1);
        courseListRDS.add(c2);
        courseListRDS.add(c3);

        CourseManager cmRDS = new CourseManager();
        cmRDS.addAll(courseListRDS);

        //cmRIB
        ListInterface<Course> courseListRIB = new LinkedList<>();
        courseListRIB.add(c4);
        courseListRIB.add(c5);
        courseListRIB.add(c6);

        CourseManager cmRIB = new CourseManager();
        cmRIB.addAll(courseListRIB);

        //cmFRCS
        ListInterface<Course> courseListRCS = new LinkedList<>();
        courseListRCS.add(c1);
        courseListRCS.add(c3);

        CourseManager cmRCS = new CourseManager();
        cmRCS.addAll(courseListRCS);



       // System.out.println("Poop\n"+cmFAFB.displayCourse());

        //System.out.println(courseListFAFB.toString());

        //create programme
       //Programme p1 = new Programme("RDS", "Degree in Data Science", courseListFOCS);
        //Programme p2 = new Programme("RIB", "Degree in International Business", courseListFAFB);

        Programme p1 = new Programme("RDS", "Degree in Data Science", cmFOCS);
        Programme p2 = new Programme("RIB", "Degree in International Business", cmFAFB);
        Programme p3 = new Programme("RAF", "Degree in Accounting and Finance", cmFAFB);
        Programme p4 = new Programme("RCS", "Degree in Computer Science", cmFOCS);
        progList.add(p1);
        progList.add(p2);
        progList.add(p3);
        progList.add(p4);

        
        
        //System.out.println(MainApp.manager.toString());

        // cmFOCS.removeCourse(c3);
        // System.out.println("Removed c3\n"+cmFOCS.displayCourse());

        // cmFOCS.addCourse(c3);
        // System.out.println("Added c3\n"+cmFOCS.displayCourse());

        int choice = 999;
        
        while(choice > 0){
            System.out.print("\033[H\033[2J");
            System.out.println("Welcome to Course Management System");
            System.out.println("1. Add Course w/o tutor assigned");
            System.out.println("2. Assign Tutor to a Course");
            System.out.println("3. Display Course");
            System.out.println("4. Display Proggrame Courses");
            System.out.println("5. Remove Course");
            System.out.println("0. BACK TO TUTOR MANAGEMENT SYSTEM");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();       
            
            input.nextLine(); // Consume the newline character left in the input buffer
            System.out.print("\033[H\033[2J");

            switch(choice){
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Add Course");
                        System.out.println("1. FOCS Course");
                        System.out.println("2. FAFB Course");
                        try{
                            System.out.print("Enter your choice: ");
                            int choice1 = input.nextInt();
                            input.nextLine();

                            switch(choice1){
                                case 1:
                                    addCourseFOCS();
                                    break;
                                case 2:
                                    addCourseFAFB();
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                        }catch(InputMismatchException e){
                            input.nextLine(); // Clear the invalid input from the buffer
                            System.out.println("Invalid input. Please enter a valid choice (1 or 2).");
                        }

                        break;

                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Assign Tutor to Course");
                        System.out.println("1. FOCS Course");
                        System.out.println("2. FAFB Course");
                        
                        try {
                            System.out.print("Enter your choice: ");
                            int choice2 = input.nextInt();
                            input.nextLine(); // Consume the newline character left in the input buffer

                            switch (choice2) {
                                case 1:
                                    assignTutorCourseFOCS();
                                    // System.out.println("Press Enter to continue................");
                                    // reader.readLine();
                                    // System.out.print("\033[H\033[2J");
                                    break;
                                case 2:
                                    assignTutorCourseFAFB();
                                    // System.out.println("Press Enter to continue................");
                                    // reader.readLine();
                                    // System.out.print("\033[H\033[2J");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            input.nextLine(); // Clear the invalid input from the buffer
                            System.out.println("Invalid input. Please enter a valid choice (1 or 2).");
                        }

                    case 3:
                        // System.out.print("\033[H\033[2J");
                        System.out.println("Display Course");
                        System.out.println("1. FOCS Course");
                        System.out.println("2. FAFB Course");
                        System.out.println("3. All Course");

                        try{
                            System.out.print("Enter your choice: ");
                            int choice3 = input.nextInt();
                            input.nextLine();

                            switch(choice3){
                                case 1:
                                    displayCourseFOCS();
                                    System.out.println("Press Enter to continue................");
                                    reader.readLine();
                                    System.out.print("\033[H\033[2J");
                                    break;
                                case 2:
                                    displayCourseFAFB();
                                    System.out.println("Press Enter to continue................");
                                    reader.readLine();
                                    System.out.print("\033[H\033[2J");
                                    break;

                                case 3:
                                    System.out.println("Display Course");
                                    System.out.println("FOCS Course");
                                    System.out.println(cmFOCS.displayCourse());
                                    System.out.println("FAFB Course");
                                    System.out.println(cmFAFB.displayCourse());
                                    System.out.println("Press Enter to continue................");
                                    reader.readLine();
                                    System.out.print("\033[H\033[2J");
                                    break;

                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                            break;

                        } catch (InputMismatchException e) {
                            input.nextLine(); // Clear the invalid input from the buffer
                            System.out.println("Invalid input. Please enter a valid choice (1, 2 or 3).");
                        }


                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Display Programmes");
                        System.out.println(progList.toString());
                        System.out.println("Press Enter to continue................");
                        reader.readLine();
                        System.out.print("\033[H\033[2J");
                        break;

                    case 5:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Remove Course");
                        System.out.println("1. FOCS Course");
                        System.out.println("2. FAFB Course");
                    
                        try{
                            System.out.print("Enter your choice: ");
                            int choice5 = input.nextInt();
                            input.nextLine();

                            switch(choice5){
                                case 1:
                                    System.out.print("Enter Course ID: ");
                                    String courseId = input.nextLine().toUpperCase();

                                    cmFOCS.removeCourse(cmFOCS.getCourseById(courseId));
                                    System.out.println("Removed course\n"+cmFOCS.displayCourse());
                                    System.out.println("Press Enter to continue................");
                                    reader.readLine();
                                    System.out.print("\033[H\033[2J");
                                    break;
                                case 2:
                                    System.out.print("Enter Course ID: ");
                                    String courseId1 = input.nextLine().toUpperCase();

                                    cmFAFB.removeCourse(cmFAFB.getCourseById(courseId1));
                                    System.out.println("Removed course\n"+cmFAFB.displayCourse());
                                    System.out.println("Press Enter to continue................");
                                    reader.readLine();
                                    System.out.print("\033[H\033[2J");
                                    break;
                                default:
                                try{
                                    System.out.println("Invalid choice");
                                    TimeUnit.SECONDS.sleep(2);
                                    System.out.print("\033[H\033[2J");
                                    break;
                                }catch(InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        break;
                        }
                        catch (InputMismatchException e) {
                            input.nextLine(); // Clear the invalid input from the buffer
                            System.out.println("Invalid input. Please enter a valid choice (1 or 2).");
                            System.out.println("Press Enter to continue................");
                            reader.readLine();
                            System.out.print("\033[H\033[2J");
                        }

                    case 0:
                        try{
                            System.out.println("Exiting...");
                            TimeUnit.SECONDS.sleep(2);
                            System.out.print("\033[H\033[2J");
                            MainApp.main(args);
                            break;
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }

                    default:
                        try{
                            System.out.println("invalid Choice.");
                            TimeUnit.MILLISECONDS.sleep(100);
                            System.out.print("\033[H\033[2J");
                            break;
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
            }

        }


    }

    private static void addCourseFOCS() throws IOException{
        System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();
        String courseId = "CS" + String.format("%03d", Course.courseCount + 1);

        cmFOCS.addCourse(new Course(courseId, courseName));
        System.out.println("Added new course\n"+cmFOCS.displayCourse());
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");

    }
     

    private static void addCourseFAFB() throws IOException{
        System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();
        String courseId = "AB" + String.format("%03d", Course.courseCount + 1);

        cmFAFB.addCourse(new Course(courseId, courseName));
        System.out.println("Added new course\n"+cmFAFB.displayCourse());
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");

    }

    private static void assignTutorCourseFAFB() throws IOException {
        System.out.print("Enter Course ID: ");
        // Consume the newline character left in the input buffer
        String courseId = input.next().toUpperCase();

        //if course id is not found, print error message
        if(cmFAFB.getCourseById(courseId) == null){
            System.out.println("Course ID not found");
            return;
        }
        //print courseId
        System.out.println("Course ID: " + courseId);

        // Find the course by name
        Course course = cmFAFB.getCourseById(courseId);
        System.out.println("Course: " + course.getCourseName() + " (" + course.getCourseId() + ")" );

        //get tutor
        System.out.println();
        System.out.println("Assign Tutor to Course");
        System.out.print("Enter Tutor ID: ");
        int tutorId = input.nextInt();
        Tutor tutor = manager.findTutorById(tutorId);

        //Assign
        cmFAFB.amendCourseTutor(course, tutor);
        System.out.println("=================================");
    }

    private static void assignTutorCourseFOCS() throws IOException{
        System.out.print("Enter Course ID: ");
        // Consume the newline character left in the input buffer
        String courseId = input.next().toUpperCase();
        input.nextLine(); 

        //if course id is not found, print error message
        if(cmFOCS.getCourseById(courseId) == null){
            System.out.println("Course ID not found");
            return;
        }

        //print courseId
        System.out.println("Course ID: " + courseId);

        // Find the course by name
        Course course = cmFOCS.getCourseById(courseId);
        System.out.println("Course: " + course.getCourseName() + " (" + course.getCourseId() + ")" );

        //get tutor
        System.out.println();
        System.out.println("Assign Tutor to Course");
        System.out.print("Enter Tutor ID: ");
        int tutorId = input.nextInt();
        Tutor tutor = manager.findTutorById(tutorId);

        //Assign
        cmFOCS.amendCourseTutor(course, tutor);
        System.out.println("=================================");        
    }

    private static void displayCourseFOCS() throws IOException{
        System.out.println("Display Course");
        System.out.println(cmFOCS.displayCourse());
    }

    private static void displayCourseFAFB() throws IOException{
        System.out.println("Display Course");
        System.out.println(cmFAFB.displayCourse());
    }


    
}

