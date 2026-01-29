public class Car extends MotorVehicle{
    @Override
    public void startEngine() {
        System.out.println(super.getBrand()+" (Car) engine starts: Vroom Vroom!");
    }

    public void openTrunk(){
        System.out.println(super.getBrand()+" trunk is opening...");
    }
}