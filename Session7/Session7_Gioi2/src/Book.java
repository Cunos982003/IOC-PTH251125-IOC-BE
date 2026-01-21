public class Book {
    private String title;
    private String author;
    private Double price;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter và Setter cho price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   public void printInfo(){
       System.out.println("Book Title: " + title);
       System.out.println("Book Author: " + author);
       System.out.println("Book Price: " + price);
   }



}
