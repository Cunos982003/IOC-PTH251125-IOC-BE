public class Motorcycle extends MotorVehicle{
    @Override
    public void startEngine() {
        System.out.println(super.getBrand()+" (Motorcycle) engine stats: Brum Brum!");
    }

    public void doWheelie(){
        System.out.println(super.getBrand()+" is doing a wheelie!");
    }
}