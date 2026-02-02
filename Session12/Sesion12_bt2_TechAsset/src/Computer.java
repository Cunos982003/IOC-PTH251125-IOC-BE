public class Computer extends Asset{
    private int ram;
    private String cpu;

    public Computer() {
    }

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue(int years) {
        return purchasePrice * Math.pow(0.8, years);
    }

    @Override
    public String toString() {
        return "Computer [Code=" + assetCode + ", Name=" + name + ", Price=" + purchasePrice +
                ", RAM=" + ram + "GB, CPU=" + cpu + "]";
    }


}
