//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(5, 2);
        Rectangle r3 = new Rectangle(4.5, 3.5);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        double maxArea = Math.max(r1.getArea(), Math.max(r2.getArea(), r3.getArea()));

        System.out.print("Largest area = " + maxArea + " ");

        if (r1.getArea() == maxArea) {
                System.out.println("(Rectangle 1: width=" + r1.getWidth() + ", height=" + r1.getHeight() + ")");
            } else if (r2.getArea() == maxArea) {
                System.out.println("(Rectangle 2: width=" + r2.getWidth() + ", height=" + r2.getHeight() + ")");
            } else {
                System.out.println("(Rectangle 3: width=" + r3.getWidth() + ", height=" + r3.getHeight() + ")");
            }
        }
    }