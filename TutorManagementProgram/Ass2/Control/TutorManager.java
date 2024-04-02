package Control;

import Entity.Tutor;
// import adt.ListInterface;
import ADT.DoublyLinkedList;
import java.util.Iterator;

public class TutorManager {
    public  DoublyLinkedList<Tutor> tutors;
    public int cancer;

    public TutorManager() {
        this.tutors = new DoublyLinkedList<>();
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public void removeTutorById(int id) {
        if (tutors.isEmpty()) {
            System.out.println("No tutors available to remove.");
            return;
        }
        Tutor toRemove = null;
        Iterator<Tutor> iterator = tutors.iterator();
        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if (tutor.getId() == id) {
                toRemove = tutor;
                break;
            }
        }
        if (toRemove != null) {
            tutors.remove(toRemove);
            System.out.println("Successfully removed tutor with ID " + id);
        } else {
            System.out.println("Tutor with ID " + id + " not found.");
        }
    }
    
    
    public Tutor findTutorById(int id) {
        if (tutors.isEmpty()) {
            System.out.println("No tutors available to find.");
            return null;
        }
        // Create a 'prototype' Tutor object with the ID you're searching for
        Tutor prototypeTutor = new Tutor();
        prototypeTutor.setId(id);
        
        // Use the find method from the DoublyLinkedList class
        return tutors.find(prototypeTutor);
    }
    
    public void amendTutor(int id, String newName, int newExperience, String newQualifications, String newSpecializations, double newRating, String newFaculty, double newSalary, int newCancellationRate) {
        Tutor oldTutor = findTutorById(id);
        if (oldTutor != null) {
            Tutor newTutor = new Tutor(newName, newExperience, newQualifications, newSpecializations, newRating, newFaculty, newSalary, newCancellationRate);
            tutors.amend(oldTutor, newTutor);
        }
    }
  
    
    public Iterable<Tutor> getAllTutors() {
        return tutors;  // Assuming 'tutors' is now an Iterable
    }

    public DoublyLinkedList<Tutor> filterTutors(FilterCriteriaInterface<Tutor> criteria) {
        DoublyLinkedList<Tutor> filteredTutors = new DoublyLinkedList<>();
        if (tutors.isEmpty()) {
            return filteredTutors;  // return empty list
        }
    
        // Use for-each loop to iterate over all tutors
        for (Tutor tutor : tutors) {  // Assuming 'tutors' is now Iterable
            if (criteria.filter(tutor)) {
                filteredTutors.add(tutor);
            }
        }
        
        return filteredTutors;
    }
    
    public String generateReport(ReportCriteriaInterface<Tutor> criteria) {
        // Create a deep copy of the original list
        DoublyLinkedList<Tutor> copiedList = tutors.deepCopy();
        
        // Generate the report based on the copied list
        String report = criteria.generateReport(copiedList);
        
        return report;
    }

    @Override
    public String toString() {
       return tutors.toString();
    }
}

