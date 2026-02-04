import java.util.ArrayList;

public class InvoiceManage implements Manage<Invoice> {
    ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    @Override
    public void add(Invoice item) {
        invoices.add(item);
        System.out.println("Hóa đơn đã được thêm thành công.");
    }
    @Override
    public void update(int index, Invoice invoice) {
        int realIndex = index - 1;

        if (realIndex < 0 || realIndex >= invoices.size()) {
            System.out.println("Vị trí không hợp lệ!");
            return;
        }

        invoices.set(realIndex, invoice);
        System.out.println("Hóa đơn đã được sửa thành công.");
    }



    @Override
    public void delete(int index) {
        int realIndex = index - 1;
        if(realIndex < 0 || realIndex >= invoices.size()){
            System.out.println("Vị trí không hợp lệ! ");
            return;
        }
        invoices.remove(realIndex);
        System.out.println("Hóa đơn đã xóa thành công.");
    }

    @Override
    public void display() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
            return;
        }

        System.out.println("----- DANH SÁCH HÓA ĐƠN -----");
        for (int i = 0; i < invoices.size(); i++) {
            System.out.println(
                    (i + 1) + ". ID = " + (i + 1) +
                            " , Mã hóa đơn: " + invoices.get(i).getInvoiceCode() +
                            " | Số tiền: " + invoices.get(i).getAmount()
            );
        }
    }


}
