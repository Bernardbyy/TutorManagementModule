package Control;
import ADT.DoublyLinkedList;
import Entity.Tutor;

public class SortByRatingReport implements ReportCriteriaInterface<Tutor> {

    @Override
    public String generateReport(DoublyLinkedList<Tutor> list) {
        StringBuilder report = new StringBuilder();
        
        // Get the size of the list
        int n = list.getSize();
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // To optimize, if the inner loop didn't do any swap, then break
            
            for (int j = 0; j < n - i - 1; j++) {
                Tutor tutor1 = list.get(j);
                Tutor tutor2 = list.get(j + 1);
                
                // Sort the tutors by rating in descending order
                if (tutor1.getRating() < tutor2.getRating()) {
                    // Swap tutor1 and tutor2
                    list.set(j, tutor2);
                    list.set(j + 1, tutor1);
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, then break
            if (!swapped) {
                break;
            }
        }

        //Generate the report
        // Limit to top 5 highest rated
        int x = Math.min(5, list.getSize());
        for (int i = 0; i < x; i++) {
            Tutor tutor = list.get(i);
            report.append(String.format("| %-4d | %-15s | %-11d | %-20s | %-20s | %-7.2f | %-10s | %-10.2f | %-18d |\n", 
                                        tutor.getId(), tutor.getName(), tutor.getExperience(), 
                                        tutor.getQualifications(), tutor.getSpecializations(), 
                                        tutor.getRating(), tutor.getFaculty(), tutor.getSalary(), tutor.getCancellationRate()));
        }
    
        return report.toString();
    }
}
