package Entity;

import Control.*;

public class Course {
    
    private String courseId;
    private String courseName;
    private Tutor tutor;

    public static int courseCount = 0;

    public Course() {
        this("", "");
    }

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.tutor = null;

        courseCount++;
    }


    public Course(String courseId, String courseName, Tutor tutor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.tutor = tutor;

        courseCount++;
    }

    //setter
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }



    //getter
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Tutor getTutor() {
        return tutor;
    }

    //toString

    public String toString() {
        if(tutor != null)
            return courseId + " -" + courseName + ", tutor=" + tutor.getName()+ "}\n";
        else
            return courseId + " -" + courseName + ", tutor=" + "No tutor assigned" + "}\n";
    }
}
