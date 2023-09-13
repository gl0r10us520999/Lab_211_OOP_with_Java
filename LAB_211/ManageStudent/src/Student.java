public class Student {
    private String id;
    private String sutdentName;
    private String semester;
    private String courseName;

    public Student(String id, String sutdentName, String semester, String courseName) {
        this.id = id;
        this.sutdentName = sutdentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSutdentName() {
        return sutdentName;
    }

    public void setSutdentName(String sutdentName) {
        this.sutdentName = sutdentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
