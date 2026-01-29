import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dog dog = new Dog("Buddy", 3, true);
        Cat cat = new Cat("Kitty", 2, true);
        Elephant elephant = new Elephant("Dumbo", 10, false);

        Animal[] animals = {dog, cat, elephant};

        int choice;
        do {
            System.out.println("\n===== ZooApp Menu =====");
            System.out.println("1. Tạo đối tượng và thể hiện thông tin");
            System.out.println("2. Kiểm tra Overriding (makeSound())");
            System.out.println("3. Kiểm tra Overriding (eat())");
            System.out.println("4. Kiểm tra đa hình runtime (Animal array)");
            System.out.println("5. Gọi phương thức đặc trưng từng loài");
            System.out.println("0. Thoát");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dog.showInfo();
                    cat.showInfo();
                    elephant.showInfo();
                    break;
                case 2:
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;
                case 3:
                    dog.eat();
                    cat.eat("fish");
                    elephant.eat("grass");
                    break;
                case 4:
                    System.out.println("Runtime Polymorphism Demo:");
                    for (Animal a : animals) {
                        a.makeSound();
                    }
                    break;
                case 5:
                    dog.fetchBall();
                    cat.climbTree();
                    elephant.sprayWater();
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();
    }

}