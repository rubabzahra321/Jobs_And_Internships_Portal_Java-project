
// Job.java
public class Job {
    private int id;
    private String title;
    private String salary;
    private String location;
    
    // Constructor, getters, and setters
    public Job(int id, String title, String salary, String location) {
        this.id = id;
        this.title = title;
        this.salary = salary;
        this.location = location;
    }
    
    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getSalary() { return salary; }
    public String getLocation() { return location; }
}