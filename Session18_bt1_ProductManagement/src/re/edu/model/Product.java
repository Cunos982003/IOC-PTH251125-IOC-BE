package re.edu.model;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private double price;
    private String title;
    private LocalDate created;
    private String catalog;
    private boolean status;

    public Product() {}

    public Product(int id, String name, double price, String title,
                   LocalDate created, String catalog, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
        this.created = created;
        this.catalog = catalog;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getCreated() { return created; }
    public void setCreated(LocalDate created) { this.created = created; }

    public String getCatalog() { return catalog; }
    public void setCatalog(String catalog) { this.catalog = catalog; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}
