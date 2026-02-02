public class AssetUtil {
    public static void showValue(Asset a, int years) {
        System.out.println(a.toString() + " => Giá trị hiện tại sau " + years + " năm: " + a.getMarketValue(years));
    }
}
