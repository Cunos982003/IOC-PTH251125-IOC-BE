abstract class Shape {
    protected String name;
    abstract double getArea();
    abstract double getPerimeter();

    public Shape(String name) {
        this.name = name;
    }

    public void displayInfo(){
        System.out.println("Ten hinh : " + name);
    };
}

