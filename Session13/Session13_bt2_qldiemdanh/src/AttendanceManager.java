import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {

    private ArrayList<Student> students = new ArrayList<>();
    private int autoId = 1;

    @Override
    public void add(Student item) {
        Student newStudent = new Student(autoId++, item.getName());
        students.add(newStudent);
        System.out.println("Sinh viên đã được thêm thành công.");
    }

    @Override
    public void update(int id, String newName) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                System.out.println("Sinh viên đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với ID này.");
    }

    @Override
    public void delete(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Sinh viên đã được xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với ID này.");
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }

        for (Student s : students) {
            System.out.println(
                    "ID : " + s.getId() +
                            " , Tên sinh viên : " + s.getName()
            );
        }
    }
}
