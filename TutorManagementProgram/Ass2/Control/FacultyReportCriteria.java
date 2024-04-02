package Control;
import ADT.DoublyLinkedList;
import Entity.Tutor;

public class FacultyReportCriteria implements ReportCriteriaInterface<Tutor> {

    @Override
    public String generateReport(DoublyLinkedList<Tutor> list) {
        StringBuilder report = new StringBuilder();
        DoublyLinkedList<FacultyData> facultyDataList = new DoublyLinkedList<>();
        
        int n = list.getSize();
        for (int i = 0; i < n; i++) {
            Tutor tutor = list.get(i);
            String faculty = tutor.getFaculty();
            
            FacultyData facultyData = findOrCreateFacultyData(facultyDataList, faculty);
            
            facultyData.totalTutors++;
            facultyData.totalExperience += tutor.getExperience();
            facultyData.totalRating += tutor.getRating();
            facultyData.totalSalary += tutor.getSalary();
        }

        // Generate the report data
        int facultyCount = facultyDataList.getSize();
        for (int i = 0; i < facultyCount; i++) {
            FacultyData facultyData = facultyDataList.get(i);
            
            double avgExperience = facultyData.totalExperience / (double) facultyData.totalTutors;
            double avgRating = facultyData.totalRating / (double) facultyData.totalTutors;
            double avgSalary = facultyData.totalSalary / (double) facultyData.totalTutors;
            
            report.append(String.format("| %-10s | %-13d | %-18.2f | %-14.2f | %-13.2f |\n", 
                                        facultyData.faculty, facultyData.totalTutors, avgExperience, avgRating, avgSalary));
        }
        return report.toString();
    }
    
    private FacultyData findOrCreateFacultyData(DoublyLinkedList<FacultyData> list, String faculty) {
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            FacultyData existingData = list.get(i);
            if (existingData.faculty.equals(faculty)) {
                return existingData;
            }
        }
        
        FacultyData newData = new FacultyData(faculty);
        list.addLast(newData);
        return newData;
    }
    
    private static class FacultyData {
        String faculty;
        int totalTutors = 0;
        int totalExperience = 0;
        double totalRating = 0;
        double totalSalary = 0;
        
        FacultyData(String faculty) {
            this.faculty = faculty;
        }
    }
}
