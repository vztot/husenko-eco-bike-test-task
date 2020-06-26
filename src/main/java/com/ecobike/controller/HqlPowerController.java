package com.ecobike.controller;

import com.ecobike.context.AppContext;
import com.ecobike.service.SearchService;
import com.ecobike.util.OutputUtil;
import dnl.utils.text.table.TextTable;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HqlPowerController {
    private SearchService searchService =
            (SearchService) AppContext.getInstance().getService(SearchService.class);

    public HqlPowerController() {
        String ans = "";
        while (!ans.equalsIgnoreCase("exit")) {
            drawMenu();
            ans = new Scanner(System.in).nextLine();
            if (!ans.isEmpty()) {
                try {
                    OutputUtil.soutListWithPages(searchService.executeHql(ans).stream()
                            .map(e -> e.toString())
                            .collect(Collectors.toList()));
                } catch (Exception e) {
                    System.out.println("Cant execute query.");
                }
            }
        }
    }

    private void drawMenu() {
        System.out.println("Enter HQL query. Results will be in \"raw\" format (\"exit\" for " +
                "exit)");
        TextTable table = new TextTable(new String[]{"Examples:"}, new String[][]
                {
                        {"FROM FoldingBike WHERE price>1000"},
                        {"FROM Speedelec WHERE color='black'"},
                        {"FROM Ebike WHERE brand='Xiaomi' and price<1000"},
                        {"FROM FoldingBike ORDER BY -price"},
                });
        table.printTable();
        System.out.println();
    }
}
