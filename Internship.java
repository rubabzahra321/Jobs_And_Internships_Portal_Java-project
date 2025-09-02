public class Internship {
    private int id;
    private String title;
    private String stipend;
    private String location;

    // Constructor, getters, and setters
    public Internship(int id, String title, String stipend, String location) {
        this.id = id;
        this.title = title;
        this.stipend = stipend;
        this.location = location;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getStipend() { return stipend; }
    public String getLocation() { return location; }
}