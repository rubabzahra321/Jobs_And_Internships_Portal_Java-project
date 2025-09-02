
public class JobApplication {
    private int id;
    private String userName;
    private String userEmail;
    private int jobId;
    private String coverLetter;
    private String appliedAt; // You can change this to a Date type if you prefer

    // Constructor
    public JobApplication(String userName, String userEmail, int jobId, String coverLetter) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.jobId = jobId;
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

    public int getJobId() {
        return jobId;
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

