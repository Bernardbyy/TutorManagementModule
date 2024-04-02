package Entity;

import ADT.*;
import Control.CourseManager;

public class Programme {
    
    private String programmeId;
    private String programmeName;
    private CourseManager course;

    public Programme() {
        this("", "", null);
    }

    public Programme(String programmeId, String programmeName, CourseManager course) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.course = course;
    }

    //setter
    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public void setCourse(CourseManager course) {
        this.course = course;
    }

    //getter
    public String getProgrammeId() {
        return programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public CourseManager getCourse() {
        return course;
    }



    //toString
    @Override
    public String toString() {
        return "Programme{" + "programmeId=" + programmeId + ", programmeName=" + programmeName + course.displayCourse() + "   " + "}\n";
    }



}
