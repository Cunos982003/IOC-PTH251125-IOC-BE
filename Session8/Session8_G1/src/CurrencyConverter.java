import java.text.DecimalFormat;

public class CurrencyConverter {
    private static double rate = 0.0;

    public static void setRate(double r) {
        if (r <= 0.0) {
        System.out.println("Ti gia phai lon hon 0");
        }
        rate = r;
    }
    public static double getRate() {
        return rate;
    }

    public static double toUSD(int vnd){
        if (vnd < 0){
            System.out.println("So tien VND khong duoc am");
        }
        if (rate <= 0){
            System.out.println("Chua xac lap ti gia hop le");
        }
        return vnd/rate;
    }

    public static String formatUSD(double usd, int demicalPlaces){
        StringBuilder sb = new StringBuilder("#,###");
        if (demicalPlaces > 0){
            sb.append(".");
            for (int i = 0; i < demicalPlaces; i++){
                sb.append("0");
            }
        }
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(usd);
    }


}
