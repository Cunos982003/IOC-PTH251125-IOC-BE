abstract class Device {
    protected int id;
    protected String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract public void turnOn();
    abstract public void turnOff();

    public void showInfo() {
        System.out.println("ID: " + id + ", Tên thiết bị: " + name);
    }

}
