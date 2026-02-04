import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void add(Order order) {
        orders.add(order);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    private int findIndexByCode(String code) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderID().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void update(String code, Order newOrder) {
        int index = findIndexByCode(code);

        if (index == -1) {
            System.out.println("Không tìm thấy đơn hàng!");
            return;
        }

        orders.set(index, newOrder);
        System.out.println("Đơn hàng đã được sửa thành công.");
    }

    public void delete(String code) {
        int index = findIndexByCode(code);

        if (index == -1) {
            System.out.println("Không tìm thấy đơn hàng!");
            return;
        }

        orders.remove(index);
        System.out.println("Đơn hàng đã được xóa thành công.");
    }


    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách Đơn hàng trống.");
            return;
        }

        System.out.println("----- DANH SÁCH ĐƠN HÀNG -----");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(
                    (i + 1) +
                            ". Mã Đơn hàng: " + orders.get(i).getOrderID() +
                            " , Tên khách hàng: " + orders.get(i).getCustomerName()
            );
        }
    }

}
