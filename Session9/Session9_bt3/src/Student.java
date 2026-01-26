public class Student {
    private int id;
    private String fullName;
    private int age;
    private double gpa;
    private static int count = 0;
    private final double MIN_GPA = 0.0;
    private final double MAX_GPA = 4.0;

    public Student(int id,String name, int age, double gpa) {
        this.id = id;
        this.fullName = name;
        this.age = age;
        if (gpa < MIN_GPA) {
            this.gpa = MIN_GPA;
        } else if (gpa > MAX_GPA) {
            this.gpa = MAX_GPA;
        } else {
            this.gpa = gpa;
        }
        count++;
    }

    public static int getCount() {
        return count;
    }
    public void printInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Full Name: " + fullName);
        System.out.println("Student Age: " + age);
        System.out.println("Student GPA: " + gpa);
    }
}
