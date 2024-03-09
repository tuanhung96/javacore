package Model;

import java.util.*;

public class MainDictionany {
    public Map<String,Dictionary> input() {
        Scanner sc = new Scanner(System.in);
        Map<String,Dictionary> map = new HashMap<>();
        while(true) {
            System.out.println("0. Exit");
            System.out.print("Nhap so luong Dictionary: ");
            try{
                int n = sc.nextInt();
                sc.nextLine();
                if(n == 0) break;
                for(int i=0; i<n; i++) {
                    System.out.print("Keyword: ");
                    String keyword = sc.nextLine();
                    System.out.print("description: ");
                    String description = sc.nextLine();
                    System.out.print("word_type: ");
                    String word_type = sc.nextLine();
                    map.put(keyword, new Dictionary(keyword, description, word_type));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public void info(Map<String, Dictionary> map) {
        for (Map.Entry<String,Dictionary> entry : map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    public void filter(Map<String, Dictionary> map) {
        boolean hasKeyword = false;
        System.out.print("Nhap keyword: ");
        Scanner sc = new Scanner(System.in);
        String keyword = sc.nextLine();
        for (Map.Entry<String,Dictionary> entry : map.entrySet()) {
            if(entry.getValue().getKeyword().contains(keyword)) {
                hasKeyword = true;
                System.out.println(entry.getValue().toString());
            };
        }
        if (!hasKeyword) System.out.println("Khong tim thay");
    }

    public void delete(Map<String, Dictionary> map) {
        System.out.print("Nhap keyword: ");
        Scanner sc = new Scanner(System.in);
        String keyword = sc.nextLine();

        for (Map.Entry<String,Dictionary> entry : map.entrySet()) {
            if(entry.getValue().getKeyword().contains(keyword)) {
                map.remove(keyword);
            };
        }
    }
}
