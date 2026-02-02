public abstract class Staff implements ICapability {
    protected String id;
    protected String name;
    protected double baseSalary ;

    public Staff() {
    }

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateTotalSalary();

    @Override
    public void checkPerformance() {
        System.out.println(name + " Đang được đánh giá hiệu suất");
    }
}
