package ra.edu.model;

import java.util.ArrayList;
import java.util.List;

public class MovieManager<T extends Movie> {
    private final List<T> movieList = new ArrayList<>();

    public void addMovie(T movie) {
        movieList.add(movie);
        System.out.println("Phim đã được thêm thành công");
    }

    public void displayAll() {
        if (movieList.isEmpty()) {
            System.out.println("Danh sách phim trống!");
            return;
        }
        movieList.forEach(Movie::displayData);
    }

    public T findById(int id) {
        for (T movie : movieList) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        T movie = findById(id);
        if (movie != null) {
            movieList.remove(movie);
            return true;
        }
        return false;
    }


    public T findMovieById(int id) {
        for (T movie : movieList) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public boolean update(int id, T newMovie) {
        T oldMovie = findById(id);
        if (oldMovie != null) {
            movieList.set(movieList.indexOf(oldMovie), newMovie);
            return true;
        }
        return false;
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (T movie : movieList) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                movie.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phim");
        }
    }

    public void filterByRating() {
        boolean found = false;
        for (T movie : movieList) {
            if (movie.getRating() > 8.0) {
                movie.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có phim nào rating > 8.0");
        }
    }
}

