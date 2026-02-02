public class AdminStaff extends Staff {
    private double bonus;

    public AdminStaff() {}

    public AdminStaff(double bonus) {
        this.bonus = bonus;
    }

    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }
    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }
    @Override
    public void checkPerformance() {
        System.out.println("Nhân viên hành chính " + name + " có thưởng " + bonus);
    }
}
