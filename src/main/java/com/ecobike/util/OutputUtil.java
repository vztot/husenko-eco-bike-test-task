package com.ecobike.util;

import dnl.utils.text.table.TextTable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OutputUtil {
    public static void soutListWithPages(List<String> list) {
        String command = null;
        int page = 1;
        int totalPages = list.size() / 10 + (list.size() % 10 == 0 ? 0 : 1);
        while (command == null || !command.equals("3")) {
            List<String> result = list.stream()
                    .skip((page - 1) * 10)
                    .limit(10)
                    .collect(Collectors.toList());

            Object[][] data = new Object[result.size()][1];
            for (int i = 0; i < result.size(); i++) {
                data[i][0] = result.get(i);
            }

            TextTable table = new TextTable(new String[]{"Product(s)"}, data);

            table.setAddRowNumbering(true);
            table.printTable();

            System.out.println("\n[page: " + page + " of " + (totalPages) + "]\n"
                    + "[1 - next page; 2 - prev page; 3 - exit]");
            command = new Scanner(System.in).nextLine();
            if (command.equals("1")) {
                if (page < totalPages) {
                    page++;
                }
            }
            if (command.equals("2")) {
                if (page > 1) {
                    page--;
                }
            }
        }
    }
}
