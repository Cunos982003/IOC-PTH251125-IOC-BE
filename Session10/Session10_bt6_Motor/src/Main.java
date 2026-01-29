import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choose;
        Scanner sc = new Scanner(System.in);

        Vehicle[] list;
        int maxVehicle;
        do {
            System.out.println("Nhập số lượng xe tối đa cần quản lý: ");
            maxVehicle = sc.nextInt();
            if (maxVehicle < 1) {
                System.out.println("Số xe cần quản lý phải >0");
            }
        } while (maxVehicle < 1);

        list = new Vehicle[maxVehicle];

        int totalVihicle = 0;


        while (true) {
            System.out.println("================= VEHICLE MANAGEMENT MENU ==============");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra overriding: startEngine()");
            System.out.println("3. Kiểm tra overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime (mảng Ve" + "hicle[]");
            System.out.println("5. Gọi các hành vi đặc trưng theo loại");
            System.out.println("6. Thêm phương tiện mới (Car/Motorcycle/Truck");
            System.out.println("7. Thoát");
            System.out.println("=======================================================");
            System.out.println("Lựa chọn của bạn: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("--- THÔNG TIN PHƯƠNG TIỆN ---");
                    for(int i =0;i<totalVihicle;i++){
                        Vehicle v = list[i];
                        if(v instanceof Car){
                            Car car = (Car) v;
                            car.showInfo();
                        }else if(v instanceof Motorcycle){
                            Motorcycle motorcycle = (Motorcycle) v;
                            motorcycle.showInfo();
                        }else if(v instanceof Truck){
                            Truck truck = (Truck) v;
                            truck.showInfo();
                        }
                        System.out.println("------------------------");
                    }
                    break;
                case 2:
                    System.out.println("--- OVERRIDING: startEngine() ---");
                    for(int i =0;i<totalVihicle;i++){
                        Vehicle v = list[i];
                        if(v instanceof Car){
                            Car car = (Car) v;
                            car.startEngine();
                        }else if(v instanceof Motorcycle){
                            Motorcycle motorcycle = (Motorcycle) v;
                            motorcycle.startEngine();
                        }else if(v instanceof Truck){
                            Truck truck = (Truck) v;
                            truck.startEngine();
                        }
                    }
                    break;
                case 3:
                    for(int i =0;i<totalVihicle;i++){
                        Vehicle v = list[i];
                        if(v instanceof Car){
                            Car car = (Car) v;
                            car.move();
                            car.move(80);
                        }else if(v instanceof Motorcycle){
                            Motorcycle motorcycle = (Motorcycle) v;
                            motorcycle.move();
                            motorcycle.move(40);
                        }else if(v instanceof Truck){
                            Truck truck = (Truck) v;
                            truck.move();
                            truck.move(60);
                        }
                        System.out.println("------------------------");
                    }
                    break;
                case 4:
                    System.out.println("--- POLYMOPHISM RUNTIME ---");
                    for(int i =0;i<totalVihicle;i++){
                        Vehicle v = list[i];
                        v.startEngine();
                    }
                    break;
                case 5:
                    System.out.println("--- HÀNH VI ĐẶC TRƯNG CỦA TỪNG LOẠI ---");
                    for(int i =0;i<totalVihicle;i++){
                        Vehicle v = list[i];
                        if(v instanceof Car){
                            Car car = (Car) v;
                            car.openTrunk();
                        }else if(v instanceof Motorcycle){
                            Motorcycle motorcycle = (Motorcycle) v;
                            motorcycle.doWheelie();
                        }else if(v instanceof Truck){
                            Truck truck = (Truck) v;
                            truck.loadCargo();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Bạn muốn thêm loại phương tiện nào (1-Car, 2-Motorcycle, 3-Truck)? ");
                    int vehicleType = sc.nextInt();
                    switch (vehicleType) {
                        case 1:
                            Car car = new Car();
                            System.out.println("Nhập vào hãng: ");
                            sc.nextLine();//Xử lý bỏ qua không cho nhập chữ
                            car.setBrand(sc.nextLine());
                            System.out.println("Nhập năm sản xuất: ");
                            car.setYear(Integer.parseInt(sc.nextLine()));
                            System.out.println("Nhập kiểu nguyên liệu: ");
                            car.setFuelType(sc.nextLine());
                            list[totalVihicle++] = car;
                            break;
                        case 2:
                            Motorcycle motorcycle = new Motorcycle();
                            System.out.println("Nhập vào hãng: ");
                            sc.nextLine();//Xử lý bỏ qua không cho nhập chữ
                            motorcycle.setBrand(sc.nextLine());
                            System.out.println("Nhập năm sản xuất: ");
                            motorcycle.setYear(Integer.parseInt(sc.nextLine()));
                            System.out.println("Nhập kiểu nguyên liệu: ");
                            motorcycle.setFuelType(sc.nextLine());
                            list[totalVihicle++] = motorcycle;
                            break;
                        case 3:
                            Truck truck = new Truck();
                            System.out.println("Nhập vào hãng: ");
                            sc.nextLine();//Xử lý bỏ qua không cho nhập chữ
                            truck.setBrand(sc.nextLine());
                            System.out.println("Nhập năm sản xuất: ");
                            truck.setYear(Integer.parseInt(sc.nextLine()));
                            System.out.println("Nhập kiểu nguyên liệu: ");
                            truck.setFuelType(sc.nextLine());
                            list[totalVihicle++] = truck;
                            break;
                        default:
                            System.out.println("Nhập không đúng loại phương tiện");
                    }
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}