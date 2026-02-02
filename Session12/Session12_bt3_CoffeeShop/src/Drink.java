public abstract class Drink implements IPromotion {
    protected String id;
    protected String name;
    protected double price;
    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public abstract void prepare();

    @Override
    public void applyDiscount(double percentage) {
        this.price = this.price - (this.price * percentage / 100);
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Giá: " + price;
    }
}
