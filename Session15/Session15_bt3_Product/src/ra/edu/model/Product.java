package ra.edu.model;

import ra.edu.exception.MyUncheckedException;

import java.util.Scanner;

public class Product implements IBaseModel {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        if (price <= 0){
            throw new MyUncheckedException("Giá sản phẩm phải >0 !!!");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void inputData(Scanner sc) {

        while (true) {
            try {
                System.out.print("Nhập id: ");
                this.id = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Id phải là số!");
            }
        }

        System.out.print("Nhập tên sản phẩm: ");
        this.name = sc.nextLine();

        while (true) {
            try {
                System.out.print("Nhập giá: ");
                double value = Double.parseDouble(sc.nextLine());
                if (value <= 0) {
                    throw new MyUncheckedException("Giá phải > 0");
                }
                this.price = value;
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Giá phải là số!");
            } catch (MyUncheckedException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Price: " + price;
    }

    @Override
    public void displayData() {
        System.out.println(this);
    }
}
