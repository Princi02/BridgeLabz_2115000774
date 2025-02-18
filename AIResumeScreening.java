import java.util.ArrayList;
import java.util.List;

// Abstract class representing different job roles
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getJobRole();

    @Override
    public String toString() {
        return candidateName + " - " + getJobRole();
    }
}

// Different job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getJobRole() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getJobRole() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getJobRole() {
        return "Product Manager";
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Resume: " + jobRole.toString();
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public void displayResumes() {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(resume);
        }
    }

    // Generic method to process resumes
    public static <T extends JobRole> void processResume(T jobRole) {
        System.out.println("Processing Resume for: " + jobRole.getCandidateName() + " - " + jobRole.getJobRole());
    }
}

// Main class to test the implementation
public class AIResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));

        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();
        screeningSystem.addResume(seResume);
        screeningSystem.addResume(dsResume);
        screeningSystem.addResume(pmResume);

        System.out.println("Resumes in Screening System:");
        screeningSystem.displayResumes();

        System.out.println("\nProcessing Individual Resumes:");
        ResumeScreeningSystem.processResume(new SoftwareEngineer("David"));
    }
}
