package com.ecobike.util;

import java.util.List;
import java.util.Scanner;

public class OutputUtil {
    public static void soutListWithPages(List<String> list) {
        if (list.size() < 11) {
            list.forEach(System.out::println);
            return;
        }
        String command = null;
        int page = 1;
        while (command == null || !command.equals("3")) {
            list.stream().skip((page - 1) * 10).limit(10).forEach(System.out::println);
            System.out.println("\n[page: " + page + " of "
                    + (list.size() / 10 + (list.size() % 10 == 0 ? 0 : 1))
                    + "]\n[1 - next page; 2 - prev page; 3 - exit]");
            command = new Scanner(System.in).nextLine();
            if (command.equals("1")) {
                page++;
            }
            if (command.equals("2")) {
                page--;
            }
        }
    }
}
