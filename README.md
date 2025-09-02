# 📌 Jobs and Internship Portal

A comprehensive **Java Swing + MySQL desktop application** that provides a centralized platform for managing **job and internship opportunities**. The system enables students to search and apply for positions, track application status, and communicate with administrators. At the same time, admins can manage postings, handle applications, and respond to inquiries efficiently.

---

## 🚀 Features

### 👩‍🎓 User Features
- View available job and internship listings
- Apply for jobs and internships via structured forms
- Track application submissions
- Contact administrators directly via built-in form
- Simple, clean, and beginner-friendly GUI

### 🛠️ Admin Features
- Password-protected admin panel
- Add, update, or delete job and internship postings
- View and manage applications
- Read and manage user messages

---

## 🏗️ System Architecture
The application follows a **3-tier architecture**:

1. **Presentation Layer** – Java Swing GUI (JFrame, JPanel, JButton, JTextField)
2. **Business Logic Layer** – Validation, decision-making, and application logic
3. **Data Access Layer** – DAO pattern for CRUD operations with MySQL database

---

## 🖥️ Technology Stack

- **Frontend:** Java Swing (GUI)
- **Backend:** Java (OOP principles, DAO pattern)
- **Database:** MySQL
- **Connectivity:** JDBC (Java Database Connectivity)

---

## 📂 Database Design

The system uses the following primary tables:

- **jobs** – Stores job postings
- **internships** – Stores internship opportunities
- **job_applications** – Tracks job applications
- **internship_applications** – Tracks internship applications
- **contact_messages** – Stores user inquiries
- **users** – Stores user login/registration details

---

## ⚙️ System Requirements

### Software:
- Java JDK (8 or higher)
- MySQL Server
- Eclipse IDE (or any Java IDE)
- MySQL Workbench
- JDBC Connector

### Hardware:
- RAM: Minimum 2GB (4GB+ recommended)
- Storage: 100MB+
- CPU: Dual-core or higher

---

## 🔧 Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/jobs-internship-portal.git
   ```

2. **Import into Eclipse (or your preferred IDE)**

3. **Set up MySQL database:**
   - Create a new schema (e.g., `jobs_portal_db`)
   - Import the provided `.sql` script (if available) or create tables as per the documentation

4. **Configure database connection in Java (JDBC):**
   ```java
   String url = "jdbc:mysql://localhost:3306/jobs_portal_db";
   String user = "root";
   String password = "yourpassword";
   ```

5. **Run the project from your IDE**

---

## 📈 Future Enhancements
- Resume upload and download functionality
- Email/SMS notifications
- Advanced search & filtering options
- Web-based version using **Spring Boot + React**

---

## 🤝 Contributing
Contributions are welcome! Please fork the repo and submit a pull request.

---

## 📜 License
This project is licensed under the **MIT License** – feel free to use, modify, and distribute.

---

## 👨‍💻 Authors
Developed as part of an **academic/career cell project** to simplify and streamline **job & internship management**.
