package ra.edu.model;

public class Student {
    private static int AUTO_ID = 1;

    private final int id;
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.id = AUTO_ID++;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getRank() {
        if (gpa >= 8.5) return "Xuất sắc";
        if (gpa >= 7.0) return "Giỏi";
        if (gpa >= 5.5) return "Khá";
        return "Trung bình / Yếu";
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Tên: %s | GPA: %.2f | Xếp loại: %s",
                id, name, gpa, getRank()
        );
    }
}
