//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Employee[] employees = new Employee[3];
    employees[0] = new FullTimeEmployee(1, "Nguyen Van A", 1000);
    employees[1] = new PartTimeEmployee(2, "Tran Thi B", 50, 40);
    employees[2] = new FullTimeEmployee(3, "Le Van C", 1200);

        for (Employee emp : employees) {
        emp.showInfo();
        System.out.println("Lương: " + emp.calculateSalary());

        if (emp instanceof BonusEligible) {
            double bonus = ((BonusEligible) emp).calculateBonus();
            System.out.println("Thưởng: " + bonus);
        }

        System.out.println("-------------------");
    }
   }
}