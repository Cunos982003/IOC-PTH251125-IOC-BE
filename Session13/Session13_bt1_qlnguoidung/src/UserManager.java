import java.util.LinkedList;

public class UserManager {
    private LinkedList<Person> users = new LinkedList<>();

    public void addUser(Person person) {
        users.add(person);
        System.out.println("Người dùng đã được thêm thành công! ");
    }

    public void deleteUserByEmail(String email) {
        boolean removed = users.removeIf(person -> person.getEmail().equalsIgnoreCase(email));
        if (removed) {
            System.out.println("🗑️ Người dùng có email đã được xóa thành công.");
        } else {
            System.out.println("⚠️ Không tìm thấy người dùng với email: " + email);
        }
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("📭 Danh sách người dùng trống.");
        } else {
            System.out.println("📋 Danh sách người dùng:");
            for (Person p : users) {
                System.out.println(p);
            }
        }
    }
}
