package ra.edu.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Movie {
    private int id;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private double rating;

    public Movie() {
    }

    public Movie(int id, String title, String director, LocalDate releaseDate, double rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void inputData(Scanner sc) {
        try {
            System.out.print("Nhập id: ");
            this.id = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tên phim: ");
            this.title = sc.nextLine();

            System.out.print("Nhập đạo diễn: ");
            this.director = sc.nextLine();

            System.out.print("Nhập ngày phát hành (dd-MM-yyyy): ");
            this.releaseDate = LocalDate.parse(
                    sc.nextLine(),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")
            );

            System.out.print("Nhập rating: ");
            this.rating = Double.parseDouble(sc.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Sai định dạng số!");
        } catch (Exception e) {
            System.out.println("❌ Lỗi: Sai định dạng ngày (dd-MM-yyyy)");
        }
    }

    public void displayData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String dateStr = (releaseDate != null)
                ? releaseDate.format(formatter)
                : "N/A";
        System.out.printf(
                "ID: %d | Tên: %s | Đạo diễn: %s | Ngày: %s | Rating: %.1f%n",
                id, title, director, dateStr, rating
        );
    }
}
