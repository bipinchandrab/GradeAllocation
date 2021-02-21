package gradeallocation.view;

public class StudentDetails {

    private String id;
    private int ass1;
    private int ass2;
    private int exam;
    private int tot;
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAss1() {
        return ass1;
    }

    public void setAss1(int ass1) {
        this.ass1 = ass1;
    }

    public int getAss2() {
        return ass2;
    }

    public void setAss2(int ass2) {
        this.ass2 = ass2;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public StudentDetails(String id, int ass1, int ass2, int exam, int tot, String grade) {
        this.id = id;
        this.ass1 = ass1;
        this.ass2 = ass2;
        this.exam = exam;
        this.tot = tot;
        this.grade = grade;
    }
}
