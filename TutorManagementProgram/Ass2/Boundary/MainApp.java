package  Boundary;

import  Control.*;
import  Entity.*;

import java.io.*;

import  ADT.DoublyLinkedList;

public class MainApp {
    public static TutorManager manager = new TutorManager();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        readTutorsFromFile();

        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Tutor Management System");
            System.out.println("1. Add Tutor");
            System.out.println("2. Remove Tutor");
            System.out.println("3. Find Tutor");
            System.out.println("4. Amend Tutor");
            System.out.println("5. List All Tutors");
            System.out.println("6. Filter Tutors based on criteria");
            System.out.println("7. Generate Report");
            System.out.println("8. Commit Tutors to File");
            System.out.println("9. Exit");
            System.out.println("0. Course Management System");
            try{
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        addTutor();
                        break;
                    case 2:
                        removeTutor();
                        break;
                    case 3:
                        findTutor();
                        break;
                    case 4:
                        amendTutor();
                        break;
                    case 5:
                        listAllTutors();
                        break;
                    case 6:
                        filterSubMenu();
                        break;
                    case 7:
                        generateReportSubMenu();
                        break;
                    case 8:
                        commitTutorsToFile();
                    case 9:
                        continueRunning = false;
                    break;

                    case 0:
                        Main.mainCourse(args);
                        break;
                    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /***********************************************R/W Methods Start*****************************************************/
    public static void readTutorsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("tutors.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Skip the first value (ID) and start reading from the second value (Name)
                // Assuming the order is ID, Name, Experience, Qualifications, Specializations, Rating, Faculty, Salary, CancellationRate
                String name = values[1].trim();
                int experience = Integer.parseInt(values[2].trim());
                String qualifications = values[3].trim();
                String specializations = values[4].trim();
                double rating = Double.parseDouble(values[5].trim());
                String faculty = values[6].trim();
                double salary = Double.parseDouble(values[7].trim());
                int cancellationRate = Integer.parseInt(values[8].trim());
    
                Tutor tutor = new Tutor(name, experience, qualifications, specializations, rating, faculty, salary, cancellationRate);
                manager.addTutor(tutor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void commitTutorsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tutors.txt"))) {
            Iterable<Tutor> allTutors = manager.getAllTutors();  // Assuming getAllTutors() returns an Iterable<Tutor>
            for (Tutor tutor : allTutors) {
                bw.write(String.format("%d, %s, %d, %s, %s, %.2f, %s, %.2f, %d\n",
                                       tutor.getId(), tutor.getName(), tutor.getExperience(), 
                                       tutor.getQualifications(), tutor.getSpecializations(), 
                                       tutor.getRating(), tutor.getFaculty(), tutor.getSalary(), tutor.getCancellationRate()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /***********************************************R/W Methods End*****************************************************/

    private static void addTutor() throws IOException {
        System.out.print("Enter Tutor Name: ");
        String name = reader.readLine();
        System.out.print("Enter Tutor Experience: ");
        int experience = Integer.parseInt(reader.readLine());
        System.out.print("Enter Tutor Qualifications: ");
        String qualifications = reader.readLine();
        System.out.print("Enter Tutor Specializations: ");
        String specializations = reader.readLine();
        System.out.print("Enter Tutor Rating: ");
        double rating = Double.parseDouble(reader.readLine());
        System.out.print("Enter Tutor Faculty: ");
        String faculty = reader.readLine();
        System.out.print("Enter the salary of the tutor: ");
        double salary = Double.parseDouble(reader.readLine());
        System.out.print("Enter the cancellation rate of the tutor: ");
        int cancellationRate = Integer.parseInt(reader.readLine());
        manager.addTutor(new Tutor(name, experience, qualifications, specializations, rating, faculty,salary, cancellationRate));
        System.out.println("Tutor added successfully.");
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }

    private static void removeTutor() throws IOException {
        System.out.print("Enter Tutor ID to remove: ");
        int id = Integer.parseInt(reader.readLine());
        manager.removeTutorById(id);  // Call the new method
        System.out.println("Tutor removed successfully.");
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }
 
    private static void findTutor() throws IOException {
        // Prompt the user to enter a Tutor ID
        System.out.print("Enter Tutor ID to find: ");
        int id = Integer.parseInt(reader.readLine());
    
        // Add another horizontal line for visual separation
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        // Display table headers
        System.out.printf("| %-4s | %-15s | %-11s | %-20s | %-20s | %-7s | %-10s | %-10s | %-18s |\n",
                          "ID", "Name", "Experience", "Qualifications", "Specializations", "Rating", "Faculty", "Salary", "Cancellation Rate");
    
        // Add another horizontal line for visual separation
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        Tutor tutor = manager.findTutorById(id);
        if (tutor != null) {
            // Display details of the found tutor
            System.out.printf("| %-4d | %-15s | %-11d | %-20s | %-20s | %-7.2f | %-10s | %-10.2f | %-18d |\n",
                              tutor.getId(), tutor.getName(), tutor.getExperience(),
                              tutor.getQualifications(), tutor.getSpecializations(),
                              tutor.getRating(), tutor.getFaculty(), tutor.getSalary(), tutor.getCancellationRate());
        } else {
            System.out.println("Tutor not found.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }

    private static void amendTutor() throws IOException {
        System.out.print("Enter Tutor ID to amend: ");
        int id = Integer.parseInt(reader.readLine());
        System.out.print("Enter new name: ");
        String newName = reader.readLine();
        System.out.print("Enter new experience: ");
        int newExperience = Integer.parseInt(reader.readLine());
        System.out.print("Enter new qualifications: ");
        String newQualifications = reader.readLine();
        System.out.print("Enter new specializations: ");
        String newSpecializations = reader.readLine();
        System.out.print("Enter new rating: ");
        double newRating = Double.parseDouble(reader.readLine());
        System.out.print("Enter new faculty: ");
        String newFaculty = reader.readLine();
        System.out.print("Enter new salary: ");
        double newSalary = Double.parseDouble(reader.readLine());
        System.out.print("Enter new cancellation rate: ");
        int newCancellationRate = Integer.parseInt(reader.readLine());
    
        manager.amendTutor(id, newName, newExperience, newQualifications, newSpecializations, newRating, newFaculty, newSalary, newCancellationRate);
        System.out.println("Tutor details amended successfully.");
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }

    public static void listAllTutors() throws IOException {
        // Extend the line to fit the new columns
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        
        // Update the header to include new columns and remove 'Subject'
        System.out.printf("| %-4s | %-15s | %-11s | %-20s | %-20s | %-7s | %-10s | %-10s | %-18s |\n", 
                          "ID", "Name", "Experience", "Qualifications", "Specializations", "Rating", "Faculty", "Salary", "Cancellation Rate");
        
        // Extend the line to fit the new columns
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        // Using the iterable feature of DoublyLinkedList
        for (Tutor tutor : manager.getAllTutors()) {
            // Update the format string to include new columns and remove 'Subject'
            System.out.printf("| %-4d | %-15s | %-11d | %-20s | %-20s | %-7.2f | %-10s | %-10.2f | %-18d |\n", 
                              tutor.getId(), tutor.getName(), tutor.getExperience(), 
                              tutor.getQualifications(), tutor.getSpecializations(), 
                              tutor.getRating(), tutor.getFaculty(), tutor.getSalary(), tutor.getCancellationRate());
        }
        
        // Extend the line to fit the new columns
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }
    
    /***********************************************Filtering Methods Start*****************************************************/

    private static void printFilteredTutors(DoublyLinkedList<Tutor> filteredTutors) {
        if (filteredTutors.isEmpty()) {
            System.out.println("No tutors found based on the filter criteria.");
            return;
        }
    
        // Table header
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-15s | %-11s | %-20s | %-20s | %-7s | %-10s | %-10s | %-18s |\n", 
                          "ID", "Name", "Experience", "Qualifications", "Specializations", "Rating", "Faculty", "Salary", "Cancellation Rate");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        for (Tutor tutor : filteredTutors) {
            System.out.printf("| %-4d | %-15s | %-11d | %-20s | %-20s | %-7.2f | %-10s | %-10.2f | %-18d |\n", 
                              tutor.getId(), tutor.getName(), tutor.getExperience(), 
                              tutor.getQualifications(), tutor.getSpecializations(), 
                              tutor.getRating(), tutor.getFaculty(), tutor.getSalary(), tutor.getCancellationRate());
        }
    
        // Table footer
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    private static void filterTutorsByRating() throws IOException {
    System.out.print("\tEnter the minimum rating for tutors (e.g. 4.5): ");
    double minRating = Double.parseDouble(reader.readLine());

    FilterCriteriaInterface<Tutor> criteria = new RatingFilterCriteria(minRating);
    DoublyLinkedList<Tutor> filteredTutors = manager.filterTutors(criteria);
    
    printFilteredTutors(filteredTutors);
    
    System.out.println("Press Enter to continue................");
    reader.readLine();
    System.out.print("\033[H\033[2J");
}

    private static void filterTutorsByFaculty() throws IOException {
        System.out.print("\t\tEnter the faculty to filter tutors by (e.g. FOCS): ");
        String faculty = reader.readLine();

        FilterCriteriaInterface<Tutor> criteria = new FacultyFilterCriteria(faculty);
        DoublyLinkedList<Tutor> filteredTutors = manager.filterTutors(criteria);

        printFilteredTutors(filteredTutors);
        
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }

    private static void filterSubMenu() throws IOException {
        System.out.println("\tFilter Tutors By:");
        System.out.println("\t1. Minimum Rating");
        System.out.println("\t2. Faculty");
        try {
            System.out.print("\tPlease enter your choice: ");

            int filterChoice = Integer.parseInt(reader.readLine());

            switch (filterChoice) {
                case 1:
                    filterTutorsByRating();
                    break;
                case 2:
                    filterTutorsByFaculty();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Please try again.");
        }
    }
    /***********************************************Filtering Methods End*****************************************************/
    private static void generateReportSubMenu() throws IOException {
        System.out.println("\tChoose a Report Type:");
        System.out.println("\t1. Sort Tutors By Rating");
        System.out.println("\t2. Faculty Summary");
        try{
            System.out.print("\tPlease enter your choice: ");
        
            int reportChoice = Integer.parseInt(reader.readLine());
        
            switch (reportChoice) {
                case 1:
                    generateSortByRatingReport();
                    break;
                case 2:
                    generateFacultySummaryReport();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }         
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void generateSortByRatingReport() throws IOException {
        SortByRatingReport sortByRatingReport = new SortByRatingReport();
        String report = manager.generateReport(sortByRatingReport);
    
        // Extend the line to fit the new columns
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        // Print the title of the report
        System.out.println("|                                                          Top 5 Highest Rated Tutors                                                         |");
    
        // Extend the line to fit the new columns
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        // Update the header to include new columns
        System.out.printf("| %-4s | %-15s | %-11s | %-20s | %-20s | %-7s | %-10s | %-10s | %-18s |\n",
                          "ID", "Name", "Experience", "Qualifications", "Specializations", "Rating", "Faculty", "Salary", "Cancellation Rate");
    
        // Extend the line to fit the new columns
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        // Print the body of the table
        System.out.print(report);
    
        // Extend the line to fit the new columns
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    
        // Wait for user to press Enter to continue
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }
    
    private static void generateFacultySummaryReport() throws IOException {
        FacultyReportCriteria facultyReportCriteria = new FacultyReportCriteria();
        String report = manager.generateReport(facultyReportCriteria);
    
        // Extend the line to fit the new columns
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                                 Faculty Summary                                   |");
        System.out.println("-------------------------------------------------------------------------------------");
    
        // Update the header to include new columns
        System.out.printf("| %-10s | %-13s | %-18s | %-14s | %-12s |\n", 
                          "Faculty", "Total Tutors", "Average Experience", "Average Rating", "Average Salary");
    
        // Extend the line to fit the new columns
        System.out.println("-------------------------------------------------------------------------------------");
    
        // Print the body of the table
        System.out.print(report);
    
        // Extend the line to fit the new columns
        System.out.println("------------------------------------------------------------------------------------");
    
        // Wait for the user to press Enter to continue
        System.out.println("Press Enter to continue................");
        reader.readLine();
        System.out.print("\033[H\033[2J");
    }
    
}
