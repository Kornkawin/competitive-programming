import java.util.*;

public class SubsetGeneratorRecursive {
    static int n; // จำนวนสมาชิกในเซต
    static List<Integer> subset = new ArrayList<>();

    public static void generateSubsets(int k) {
        if (k == n) {
            // เมื่อถึงสมาชิกตัวสุดท้าย แสดง subset ปัจจุบัน
            System.out.println(subset);
        } else {
            // กรณีไม่ใส่ k ลงใน subset
            generateSubsets(k + 1);

            // กรณีใส่ k ลงใน subset
            subset.add(k);
            generateSubsets(k + 1);

            // ย้อนกลับ (backtrack) เอา k ออก
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        n = 3; // ตัวอย่าง: สร้าง subsets ของ {0,1,2}
        generateSubsets(0);
    }
}
