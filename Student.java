package homeWorkLesson9;

import java.util.List;

public class Student {
    private String studentName;
    private String studentSurname;
    private String email;
    private List<Course> allCourses;

    public Student(String studentName, String studentSurname, String email, List<Course> allCourses) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.email = email;
        this.allCourses = allCourses;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(List<Course> allCourses) {
        this.allCourses = allCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", email='" + email + '\'' +
                ", allCourses=" + allCourses +
                '}';
    }
}