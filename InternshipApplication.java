
public class InternshipApplication {
    private int id;
    private String userName;
    private String userEmail;
    private int internshipId;
    private String coverLetter;
    private String appliedAt; // You can change this to a Date type if you prefer

    // Constructor
    public InternshipApplication(String userName, String userEmail, int internshipId, String coverLetter) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.internshipId = internshipId;
        this.coverLetter = coverLetter;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getInternshipId() {
        return internshipId;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public String getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(String appliedAt) {
        this.appliedAt = appliedAt;
    }
}
