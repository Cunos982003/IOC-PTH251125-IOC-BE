import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Asset> assets = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static Asset searchAsset(String assetCode) {
        for (Asset a : assets) {
            if (a.getAssetCode().equalsIgnoreCase(assetCode)) {
                return a;
            }
        }
        return null;
    }

    public static ArrayList<Asset> searchAsset(double price) {
        ArrayList<Asset> result = new ArrayList<>();
        for (Asset a : assets) {
            if (a.getPurchasePrice() > price) {
                result.add(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("""
            ===== Tech Asset menu =====
            1. Nhập tài sản
            2. Xuất báo cáo
            3. Tìm kiếm tài sản
            4. Sửa giá mua
            5. Thoát
            ===========================
            """);
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập (1: Máy tính, 2: Thiết bị mạng): ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mã tài sản: ");
                    String code = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Giá mua: ");
                    double price = sc.nextDouble();

                    if (type == 1) {
                        System.out.print("RAM (GB): ");
                        int ram = sc.nextInt();
                        sc.nextLine();
                        System.out.print("CPU: ");
                        String cpu = sc.nextLine();
                        assets.add(new Computer(code, name, price, ram, cpu));
                    } else {
                        System.out.print("Số cổng: ");
                        int ports = sc.nextInt();
                        assets.add(new NetworkDevice(code, name, price, ports));
                    }
                    break;

                case 2:
                    System.out.print("Nhập số năm khấu hao: ");
                    int years = sc.nextInt();
                    for (Asset a : assets) {
                        AssetUtil.showValue(a, years);
                    }
                    break;

                case 3:
                    System.out.println("Tìm kiếm theo (1: Mã, 2: Giá mua): ");
                    int searchType = sc.nextInt();
                    sc.nextLine();
                    if (searchType == 1) {
                        System.out.print("Nhập mã: ");
                        String searchCode = sc.nextLine();
                        Asset found = searchAsset(searchCode);
                        if (found != null) System.out.println(found);
                        else System.out.println("Không tìm thấy!");
                    } else {
                        System.out.print("Nhập giá: ");
                        double searchPrice = sc.nextDouble();
                        ArrayList<Asset> list = searchAsset(searchPrice);
                        if (list.isEmpty()) System.out.println("Không có tài sản nào!");
                        else list.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã cần sửa: ");
                    String updateCode = sc.nextLine();
                    Asset updateAsset = searchAsset(updateCode);
                    if (updateAsset != null) {
                        System.out.print("Nhập giá mới: ");
                        double newPrice = sc.nextDouble();
                        updateAsset.setPurchasePrice(newPrice);
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

}