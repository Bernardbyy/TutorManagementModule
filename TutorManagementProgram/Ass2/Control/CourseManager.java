package Control;

import ADT.*;
import Entity.*;
import java.util.Iterator;

public class CourseManager {

    LinkedList<Course> courses;
    public static int totalCourse = 0;
    
    public CourseManager() {
        courses = new LinkedList<>(); 
    }

    //Get All
    // Add all courses from a source list to the courseList
    // public void addAll(ListInterface<Course> sourceList) {

    //    Iterator<Course> sourceListIte = sourceList.getIterator();

    //     for (Course course : sourceListIte) {
    //         courses.add(sourceListIte);
    //     }
    // }

    public void addAll(ListInterface<Course> sourceList) {
        Iterator<Course> sourceListIte = sourceList.getIterator();
        
        while (sourceListIte.hasNext()) {
            Course course = sourceListIte.next();
            courses.add(course); // Add the individual course to the courses list

            totalCourse++;
        }
    }
    

    public void addCourse(Course course){
        courses.add(course);

        totalCourse++;
    }

    public void removeCourse(Course course) {
        courses.remove(course);

        totalCourse--;
    }

    public void amendCourse2(Course course, Tutor tutor) {
        // Find the course by its ID
        Course existingCourse = getCourseById(course.getCourseId());
        
    
        if (existingCourse != null) {
            // Assign the tutor to the course
            existingCourse.setTutor(tutor);
            System.out.println("Tutor " + tutor.getName() + " has been assigned to " + course.getCourseName());
        } else {
            System.out.println("Course " + course.getCourseId() + " not found. Tutor assignment failed.");
        }
    }

    public void amendCourseTutor(Course course, Tutor tutor) {
        // Find the course by its ID
        Course existingCourse = getCourseById(course.getCourseId());

    
        if (existingCourse != null) {
            // Assign the tutor to the course
            existingCourse.setTutor(tutor);
            System.out.println("Tutor " + tutor.getName() + " has been assigned to " + course.getCourseName());
        } else {
            System.out.println("Course (" + course.getCourseId() + ") " + course.getCourseName() + " not found. Tutor assignment failed.");
        }
    }

    public String displayCourse() {
        return courses.toString(); 
    }

    public void ammendCourseName(Course course, String newCourseName) {
        Course existingCourse = getCourseById(course.getCourseId());
        if (existingCourse != null) {
            existingCourse.setCourseName(newCourseName);
            System.out.println("Course name has been changed to " + newCourseName);
        } else {
            System.out.println("Course " + course.getCourseId() + " not found. Course name change failed.");
        }
    }

        public void amendCourse(Course course, Tutor tutor) {
        // Find the course by its ID
        Course existingCourse = getCourseById(course.getCourseId());
    
        if (existingCourse != null) {
            // Assign the tutor to the course
            existingCourse.setTutor(tutor);
            System.out.println("Tutor " + tutor.getName() + " has been assigned to " + course.getCourseName());
        } else {
            System.out.println("Course " + course.getCourseId() + " not found. Tutor assignment failed.");
        }
    }

    // public void displayCourseByTutor() {
        
    // }

    // public void displayCourseByProgramme() {

        
    // }

    public Course getCourseById(String courseId) {
        // Get an iterator for the courses
        Iterator<Course> iterator = courses.getIterator();
        
        // Iterate through the courses using the iterator
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getCourseId().equals(courseId)) {
                // If the course's ID matches the specified courseId, return the course
                return course;
            }
        }
        
        // If no matching course is found, return null
        return null;
    }

    public Course getCourseByName(String courseName) {
        // Get an iterator for the courses
        Iterator<Course> iterator = courses.getIterator();
        
        // Iterate through the courses using the iterator
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getCourseName().equals(courseName)) {
                // If the course's name matches the specified courseName, return the course
                return course;
            }
        }
        
        // If no matching course is found, return null
        return null;
    }


}
