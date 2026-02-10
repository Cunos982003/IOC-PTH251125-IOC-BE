package ra.edu.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Subject implements IBaseModel{
    private String code;
    private String name;
    private int credits;
    private LocalDate startDate;

    public Subject() {}

    public Subject(String code, String name, int credits, LocalDate startDate) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.startDate = startDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Code: " + code +
                " | Name: " + name +
                " | Credits: " + credits +
                " | Start Date: " + startDate.format(formatter);
    }

    @Override
    public void inputData(Scanner sc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Nhập code: ");
        this.code = sc.nextLine();

        System.out.print("Nhập tên môn học: ");
        this.name = sc.nextLine();

        while (true) {
            try {
                System.out.print("Nhập số tín chỉ (1–10): ");
                int value = Integer.parseInt(sc.nextLine());
                if (value <= 0 || value > 10) {
                    throw new IllegalArgumentException();
                }
                this.credits = value;
                break;
            } catch (Exception e) {
                System.out.println("❌ Tín chỉ phải từ 1 đến 10!");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu (dd-MM-yyyy): ");
                this.startDate = LocalDate.parse(sc.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("❌ Sai định dạng ngày, vui lòng nhập lại!");
            }
        }
    }
    @Override
    public void displayData() {
        System.out.println(this);
    }

}
