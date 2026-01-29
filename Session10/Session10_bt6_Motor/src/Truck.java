public class Truck extends MotorVehicle {
    @Override
    public void startEngine() {
        System.out.println(super.getBrand()+" (Truck) engine stats: RRRRRR!");
    }

    public void loadCargo(){
        System.out.println(super.getBrand()+" is loading a cargo...");
    }
}
