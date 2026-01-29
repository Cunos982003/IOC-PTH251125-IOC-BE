//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(2,3);
        Shape s2 = new Circle(1);

        System.out.println("Diện tích hình chữ nhật: " + s1.area());
        System.out.println("Diện tích hình tròn: " + s2.area());

    }
}