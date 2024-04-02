package Control;
import Entity.Tutor;

public class FacultyFilterCriteria implements FilterCriteriaInterface<Tutor> {
    private String faculty;

    public FacultyFilterCriteria(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean filter(Tutor tutor) {
        return tutor.getFaculty().equalsIgnoreCase(faculty);
    }
}

