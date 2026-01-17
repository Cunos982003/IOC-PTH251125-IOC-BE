public class bt2 {
    public static void main(String[] args) {
        int soLan = 1_000_000; // số lần nối chuỗi
        String text = "Hello";

        // --- String ---
        long startString = System.currentTimeMillis();
        String str = text;
        for (int i = 0; i < soLan; i++) {
            str = str + " World";
        }
        long endString = System.currentTimeMillis();
        System.out.println("Thời gian với String: " + (endString - startString) + " ms");
        System.out.println("Độ dài chuỗi cuối cùng (String): " + str.length());

        // --- StringBuilder ---
        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < soLan; i++) {
            sb.append(" World");
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("Thời gian với StringBuilder: " + (endBuilder - startBuilder) + " ms");
        System.out.println("Độ dài chuỗi cuối cùng (StringBuilder): " + sb.length());

        // --- StringBuffer ---
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer(text);
        for (int i = 0; i < soLan; i++) {
            sbf.append(" World");
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("Thời gian với StringBuffer: " + (endBuffer - startBuffer) + " ms");
        System.out.println("Độ dài chuỗi cuối cùng (StringBuffer): " + sbf.length());
    }
}