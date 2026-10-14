import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập kích thước mảng
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        // 2. Kiểm tra mảng rỗng hoặc không hợp lệ
        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            scanner.close();
            return;
        }

        // 3. Nhập các phần tử cho mảng
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 4. Xác định tần suất xuất hiện của từng phần tử bằng LinkedHashMap (để giữ nguyên thứ tự)
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        // 5. Lọc ra các phần tử xuất hiện đúng 1 lần
        StringBuilder result = new StringBuilder();
        int countUnique = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                if (countUnique > 0) {
                    result.append(", ");
                }
                result.append(entry.getKey());
                countUnique++;
            }
        }

        // 6. In kết quả theo đúng yêu cầu
        if (countUnique == 0) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
        } else {
            System.out.println("Mảng sau khi loại bỏ các phần tử trùng lặp: [" + result.toString() + "]");
        }

        scanner.close();
    }
}