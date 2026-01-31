//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Device[] devices = new Device[3];
        devices[0] = new SmartPhone(1, "iPhone");
        devices[1] = new Laptop(2, "Dell Laptop");
        devices[2] = new Television(3, "Samsung TV");

        for (Device device : devices) {
            device.showInfo();
            device.turnOn();

            if (device instanceof Connectable) {
                ((Connectable) device).connectWifi();
            }

            if (device instanceof Chargeable) {
                ((Chargeable) device).charge();
            }

            device.turnOff();
            System.out.println("-------------------");
        }
    }
}