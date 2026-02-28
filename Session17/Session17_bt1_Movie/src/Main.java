import ra.edu.business.MovieManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieManagement manager = new MovieManagement();
        int choice = -1;

        do {
            System.out.println("\n===== MOVIE MANAGEMENT =====");
            System.out.println("1. Thêm phim");
            System.out.println("2. Liệt kê phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Xóa phim");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Director: ");
                        String director = sc.nextLine();

                        System.out.print("Year: ");
                        int year = Integer.parseInt(sc.nextLine());

                        manager.addMovie(title, director, year);
                        break;

                    case 2:
                        manager.listMovies();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int idUpdate = Integer.parseInt(sc.nextLine());

                        System.out.print("Title mới: ");
                        String newTitle = sc.nextLine();

                        System.out.print("Director mới: ");
                        String newDirector = sc.nextLine();

                        System.out.print("Year mới: ");
                        int newYear = Integer.parseInt(sc.nextLine());

                        manager.updateMovie(idUpdate, newTitle, newDirector, newYear);
                        break;

                    case 4:
                        System.out.print("ID cần xóa: ");
                        int idDelete = Integer.parseInt(sc.nextLine());
                        manager.deleteMovie(idDelete);
                        break;

                    case 0:
                        System.out.println("Thoát chương trình!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập đúng kiểu số!");
            }

        } while (choice != 0);
    }
}