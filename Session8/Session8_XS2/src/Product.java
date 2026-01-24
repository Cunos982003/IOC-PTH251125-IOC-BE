import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;
    private final String WAREHOUSE_CODE = "KHO-01";


    private static int AUTO_ID = 1;
    public Product() {
    }

    public Product(String name, double price) {
        this();
        this.id = AUTO_ID;
        AUTO_ID++;
        this.name = name;
        this.price = price;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên sản phẩm: ");
        this.name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        this.price = Double.parseDouble(sc.nextLine());
    }


    public void print() {
        System.out.printf("ID: %d, Name: %s, Price: %.2f, Warehouse: %s\n",
                id, name, price, WAREHOUSE_CODE);
    }

    public double getPrice() {
        return price;
    }

}

