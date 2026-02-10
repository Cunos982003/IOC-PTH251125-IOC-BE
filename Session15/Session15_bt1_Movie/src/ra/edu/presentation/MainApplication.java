package ra.edu.presentation;

import ra.edu.model.Movie;
import ra.edu.model.MovieManager;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManager<Movie> manager = new MovieManager<>();

        while (true) {
            System.out.println("====== QUẢN LÝ PHIM ======");
            System.out.println("1. Thêm phim mới");
            System.out.println("2. Sửa phim theo id");
            System.out.println("3. Xóa phim theo id");
            System.out.println("4. Hiển thị danh sách phim");
            System.out.println("5. Tìm kiếm phim theo tên");
            System.out.println("6. Lọc phim rating > 8.0");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        Movie movie = new Movie();
                        movie.inputData(sc);
                        manager.addMovie(movie);
                        break;

                    case 2:
                        System.out.print("Nhập id phim cần sửa: ");
                        int updateId = Integer.parseInt(sc.nextLine());
                        Movie newMovie = new Movie();
                        newMovie.inputData(sc);
                        if (manager.update(updateId, newMovie)) {
                            System.out.println("✅ Sửa phim thành công!");
                        } else {
                            System.out.println("❌ Không tìm thấy phim!");
                        }
                        break;

                    case 3:
                        System.out.print("Nhập id phim cần xóa: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        if (manager.deleteById(deleteId)) {
                            System.out.println("✅ Xóa phim thành công!");
                        } else {
                            System.out.println("❌ Không tìm thấy phim!");
                        }
                        break;

                    case 4:
                        manager.displayAll();
                        break;

                    case 5:
                        System.out.print("Nhập tên phim cần tìm: ");
                        manager.searchByTitle(sc.nextLine());
                        break;

                    case 6:
                        manager.filterByRating();
                        break;

                    case 0:
                        System.out.println("👋 Thoát chương trình!");
                        return;

                    default:
                        System.out.println("❌ Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số!");
            }
        }
    }
}
