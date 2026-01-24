import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private double gpa;
    private final double SCORE_FACTOR = 0.25;


    private static int countStudent = 0;
    public Student(){
        countStudent++;
    }
    public Student(int id, String name, double gpa) {
        this();
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        name = sc.nextLine();
        System.out.print("Nhập GPA: ");
        gpa = Double.parseDouble(sc.nextLine());
    }

    public void print() {
        System.out.printf("ID: %d, Name: %s, GPA: %.2f, SCORE_FACTOR: %.2f\n", id, name, gpa, SCORE_FACTOR);
    }

    public double getGpa() {
        return gpa;
    }

    public static int getTotalStudent() {
        return countStudent;
    }
}

