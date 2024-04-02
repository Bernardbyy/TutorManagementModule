package Entity;

public class Tutor {
    private static int idCounter = 1000; 
    public int id;
    private String name;
    private int experience; // years of experience
    private String qualifications; // academic degrees or certifications
    private String specializations; // specific areas within the subject
    private double rating;  // feedback and testimonials
    private String faculty; // faculty the tutor teaches in
    private double salary; 
    private int cancellationRate; 

    public Tutor() {
        this.id = ++idCounter;
        this.name = "John Doe";
        this.experience = 0;
        this.qualifications = "[null]";
        this.specializations = "[null]";
        this.rating = 0.0;
        this.faculty = "";
        this.salary = 3000;
        this.cancellationRate = 0;
    }

    public Tutor(String name, int experience, String qualifications, String specializations, double rating, String faculty,double salary, int cancellationRate) {
        this.id = ++idCounter;
        this.name = name;
        this.experience = experience;
        this.qualifications = qualifications;
        this.specializations = specializations;
        this.rating = rating;
        this.faculty = faculty;
        this.salary = salary;
        this.cancellationRate = cancellationRate;
    }    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }
    
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public String getQualifications() {
        return qualifications;
    }
    
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
    
    public String getSpecializations() {
        return specializations;
    }
    
    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }
    
    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCancellationRate() {
        return cancellationRate;
    }

    public void setCancellationRate(int cancellationRate) {
        this.cancellationRate = cancellationRate;
    }
    
    @Override
    public String toString() {
        return String.format("Tutor{id=%d, name='%s', experience=%d, qualifications='%s', specializations='%s', rating=%.2f, faculty='%s', salary=%.2f, cancellation=%d}",
                         id, name, experience, qualifications, specializations, rating, faculty,salary, cancellationRate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tutor otherTutor = (Tutor) obj;
        return this.id == otherTutor.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

