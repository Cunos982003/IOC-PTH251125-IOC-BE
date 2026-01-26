import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Le Tuan Cuong",22,5.0);
        Student s2 = new Student(2,"Hoang Thi Thu Thuy",28,6.0);
        Student s3 = new Student(3,"Le Long Vu",19,8.0);

        Student[] students = {s1,s2,s3};
        System.out.println("Tổng số sinh viên được tạo: "+ Student.getCount());
        System.out.println("--LIST OF STUDENTS--");
        for (Student s : students) {
            s.printInfo();
            System.out.println();
        }

    }
}