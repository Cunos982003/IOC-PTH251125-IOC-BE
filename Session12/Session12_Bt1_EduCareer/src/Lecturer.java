public class Lecturer extends Staff {
    private int teachingHours;

    public Lecturer() {}

    public Lecturer(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return  baseSalary + (teachingHours * 200.000);
    }

    @Override
    public void checkPerformance() {
        System.out.println("Giảng viên " + name + " có " + teachingHours + " giờ giảng dạy.");
    }
}
