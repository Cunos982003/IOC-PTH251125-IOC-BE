package ra.edu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectManager <T extends Subject>{

    private final List<T> subjectList = new ArrayList<>();

    public void add(T subject){
        subjectList.add(subject);
    }

    public void displayAll(){
        if(subjectList.isEmpty()){
            System.out.println("Danh sách môn học trống");
            return;
        }
        subjectList.forEach(System.out::println);
    }

    public void deleteByCode(String code) {
        boolean removed = subjectList.removeIf(
                s -> s.getCode().equalsIgnoreCase(code)
        );

        if (!removed) {
            System.out.println("❌ Không tìm thấy môn học với code: " + code);
        } else {
            System.out.println("✅ Xóa môn học thành công!");
        }
    }

    public void searchByName(String name) {
        Optional<T> result = subjectList.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();

        result.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Không có môn học phù hợp")
        );
    }

    public void filterByCredits() {
        List<T> result = subjectList.stream()
                .filter(s -> s.getCredits() > 3)
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không có môn học nào có tín chỉ > 3");
        } else {
            result.forEach(System.out::println);
        }
    }
}
