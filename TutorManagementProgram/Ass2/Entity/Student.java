package Entity;

import ADT.*;

public class Student {
    
    private String stdName;
    private String stdId;
    private TutorialGroup stdTutGroup; //RDS2G1 RDS2G2 RSD2G1
    private Course stdCourse; //IS111 IS112 IS113

    public static int stdCount = 0;

    public Student() {
        this("", "", null, null);
        stdCount++;
    }

    public Student(String stdName, String stdId, TutorialGroup stdTutGroup, Course stdCourse) {
        this.stdName = stdName;
        this.stdId = stdId;
        this.stdTutGroup = stdTutGroup;
        this.stdCourse = stdCourse;
        stdCount++;
    }

    //settger 
    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public void setStdTutGroup(TutorialGroup stdTutGroup) {
        this.stdTutGroup = stdTutGroup;
    }

    public void setStdCourse(Course stdCourse) {
        this.stdCourse = stdCourse;
    }

    //getter

    public String getStdName() {
        return stdName;
    }

    public String getStdId() {
        return stdId;
    }

    public TutorialGroup getStdTutGroup() {
        return stdTutGroup;
    }

    public Course getStdCourse() {
        return stdCourse;
    }


    @Override
    public String toString() {
        return "Student{" + "stdName=" + stdName + ", stdId=" + stdId + ", stdTutGroup=" + stdTutGroup + ", stdCourse=" + stdCourse + "}\n";
    }

}
