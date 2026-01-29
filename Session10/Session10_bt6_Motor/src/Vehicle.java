public class Vehicle {
    private String brand;
    private int year;

    public Vehicle() {
    }

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void showInfo(){
        System.out.println("Brand: " + getBrand()+", Year: " + getYear());
    }

    public void startEngine(){
        System.out.println("Engine started!!!");
    }

    public void move(){
        System.out.println("Vehicle is moving.");
    }

    public void move(int speed){
        System.out.println("Vehicle is moving at "+speed+" km/h.");
    }
}
