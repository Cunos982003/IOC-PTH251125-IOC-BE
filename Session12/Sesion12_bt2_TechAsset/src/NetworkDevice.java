public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue(int years) {
        return purchasePrice * Math.pow(0.9, years);
    }

    @Override
    public String toString() {
        return "NetworkDevice [Code=" + assetCode + ", Name=" + name + ", Price=" + purchasePrice +
                ", Ports=" + numberOfPorts + "]";
    }

}
